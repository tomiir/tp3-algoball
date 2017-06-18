package Modelo.Personajes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Modelo.Casillero;
import Modelo.Equipo;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Interfaces.Atacable;
import Modelo.Transformaciones.Transformacion;
import Modelo.Ataques.Ataque;
import Modelo.Consumibles.Consumible;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;

public class Personaje implements Atacable{
	
	String nombre;
	int vidaInicial;
	int puntosDeVida;
	int poderDePelea;
	int rangoDeAtaque;
	int velocidad;
	int ki = 0;
	int tiempoComoChocolate = 0;
	Modelo.Ataques.Ataque ataqueEspecial;
	Ataque ataqueNormal = Ataque.AtaqueNormal();
	Posicion posicion;
	Tablero tablero;
	Queue <Transformacion> transformaciones = new LinkedList<Transformacion>();
	ArrayList<Consumible> consumidos = new ArrayList<Consumible>();
	
	
	public int recibirDaño(int dañoRecibido) throws ExcNumeroNegativo{
		if(dañoRecibido < 0) throw new ExcNumeroNegativo();
		
		
		if(dañoRecibido <= puntosDeVida) this.puntosDeVida -= dañoRecibido;
		else{
			dañoRecibido = puntosDeVida;
			puntosDeVida = 0;
		}
		
		return  dañoRecibido;
		
	}
	
	public void mover(Posicion posicion) throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		if(esChocolate()) throw new ExcEsChocolate();
		if(this.estaEnRango(posicion, velocidad())){
			this.tablero.posicionarPersonaje(this, posicion);
		
			if(tablero.obtenerCasillero(posicion).tieneUnConsumible()){
				Consumible consumible = this.tablero.obtenerCasillero(posicion).obtenerConsumible();
				this.consumir(consumible, posicion);
			}		
		}
		else{
			throw new ExcFueraDeRango();
		}
	}
	
	public void atacar(Atacable personajeObjetivo, boolean esEspecial) throws ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
		if(esChocolate()) throw new ExcEsChocolate();
		if(personajeObjetivo.estaMuerto()) throw new ExcPersonajeMurio();
		if(estaEnRango(personajeObjetivo.posicion(), this.rangoDeAtaque)){
			if(ki < ataqueElegido(esEspecial).costo()) throw new ExcKiInsuficiente();
			ataqueElegido(esEspecial).enviar(this, personajeObjetivo, this.bonificacionDeAtaquePorcentual() + this.bonificacionDeAtaquePorcentualPorConsumibles());
			ki -= ataqueElegido(esEspecial).costo();
		} else {
			throw new ExcFueraDeRango();
		}
		tablero.removerSiEstaMuerto(personajeObjetivo);
	}
	
	public void seAvanzoUnTurno(int aumentoKi) throws ExcNumeroNegativo{
		if(aumentoKi<0) throw new ExcNumeroNegativo();
		if(!this.esChocolate())ki+=aumentoKi;
		if(tiempoComoChocolate >0) tiempoComoChocolate--;
		this.actualizarConsumidos();
	}
	
	public boolean esChocolate (){
		return tiempoComoChocolate>0;
	}
	
	public int vidaPorcentual(){
		float porcentaje = (puntosDeVida*100)/vidaInicial;
		return (int)porcentaje;
	}
	
	public void setPosicion(Posicion casillero){
		this.posicion = casillero;
	}
	
	public int puntosDeVida(){
		return puntosDeVida;
	}
	
	public int velocidad(){
		return this.velocidad + this.bonificacionDeVelocidadPorConsumibles();
	}
	
	public Posicion posicion(){
		if(estaMuerto()) return null;
		return posicion;
	}
	
	public int ki(){
		return ki;
	}
	
	public int poderDePelea(){
		return poderDePelea;
	}
	
	public String nombre() {
		return nombre;
	}
	
	public boolean estaMuerto(){
		return (this.puntosDeVida == 0);
	}
	
	public int rangoDeAtaque(){
		return this.rangoDeAtaque;
	}
	
	public int cantidadDeAbsorciones(){
		return 0;
	}
	
	public Transformacion getTransformacion(){
		return this.transformaciones.peek();
	}
	
	public void transformar (Equipo equipoPropio) throws ExcNoEsPosibleTransformarse, ExcEsChocolate {
		if(esChocolate()) throw new ExcEsChocolate();
		Transformacion transformacion = transformaciones.peek();
		if(transformacion!=null && transformacion.esPosible(this, equipoPropio)){
			transformaciones.remove();
			rangoDeAtaque = transformacion.rangoDeAtaque();
			velocidad = transformacion.velocidad();
			poderDePelea = transformacion.poderDePelea();
			ki -= transformacion.costo();
		} else {
			throw new ExcNoEsPosibleTransformarse();
		}
	}
	
	public void convertirEnChocolate(int turnos) throws ExcEsChocolate{
		if(this.esChocolate()) throw new ExcEsChocolate();
		tiempoComoChocolate = turnos;
	}
	
	public Ataque getAtaqueEspecial(){
		return ataqueEspecial;
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}

	protected int bonificacionDeAtaquePorcentualPorConsumibles(){
		int bonificacionDeAtaquePorcentual = 0;
		
		if (this.consumidos.isEmpty() == false){
			Iterator<Consumible> iterador = consumidos.iterator();
			while(iterador.hasNext()){				
				Consumible consumible = iterador.next();
				bonificacionDeAtaquePorcentual += consumible.obtenerBonificacionAtaque();
			}			
		}
		
		return bonificacionDeAtaquePorcentual;
		
	}
	
	protected int bonificacionDeVelocidadPorConsumibles(){
		int bonificacion = 0;
		if (this.consumidos.isEmpty() == false){
			Iterator<Consumible> iterador = consumidos.iterator();
			while(iterador.hasNext()){				
				Consumible consumible = iterador.next();
				bonificacion += consumible.obtenerBonificacionVelocidad();
			}			
		}
		bonificacion = (this.velocidad * bonificacion)/100;
		return bonificacion;
		
	}
	
	
	private Ataque ataqueElegido(boolean esEspecial){
		if(esEspecial){
			return this.ataqueEspecial;
		} else {
			return this.ataqueNormal;
		}
	}
	
	
	
	private boolean estaEnRango (Posicion objetivo, int rango){
		try{
			if(this.posicion.distanciaA(objetivo) > rango){
				return false;
			}
		} catch (ExcPosicionNegativa e) {
			return false;
		}
		return true;
	}
	
	/*private boolean estaEnRangoDeAtaque(Posicion objetivo){
		try {
			if(posicion.distanciaA(objetivo)>rangoDeAtaque){
				return false;
			}
		} catch (ExcPosicionNegativa e) {
			return false;
		}
		return true;
	}*/
	
	protected void inicializar(){
		vidaInicial=puntosDeVida;
	}
	
	private void aumentarVida(int cantidad){
		
		puntosDeVida += cantidad;
		if(puntosDeVida >= vidaInicial) puntosDeVida = vidaInicial;
	}
	private void consumir(Consumible consumible, Posicion posicion) throws ExcFueraDeTablero{
		
		int vida = consumible.obtenerAumentoDeVida();
		aumentarVida(vida);
	
		if(consumible.turnosRestantes() > 0) consumidos.add(consumible);
		
		tablero.obtenerCasillero(posicion).desocuparConsumible();
		
		
		
	}
	
	private void actualizarConsumidos(){
		Iterator<Consumible> iterador = consumidos.iterator();
		ArrayList<Consumible> eliminables = new ArrayList<Consumible>();
		while(iterador.hasNext()){
			
			Consumible consumible = iterador.next();
			consumible.avanzarTurno();
			if(consumible.turnosRestantes() <= 0) eliminables.add(consumible);
		}
		
		Iterator<Consumible> iterador2 = eliminables.iterator();
		
		while(iterador2.hasNext()){					
		Consumible consumible = iterador2.next();
		consumidos.remove(consumible);
		}
	}
	
}
