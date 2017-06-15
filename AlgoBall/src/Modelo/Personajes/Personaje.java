package Modelo.Personajes;

import java.util.LinkedList;
import java.util.Queue;

import Modelo.Equipo;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Interfaces.Atacable;
import Modelo.Transformaciones.Transformacion;
import Modelo.Ataques.Ataque;
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
	
	
	public int recibirDaño(int dañoRecibido) throws ExcNumeroNegativo{
		if(dañoRecibido < 0) throw new ExcNumeroNegativo();
		
		
		if(dañoRecibido <= puntosDeVida) this.puntosDeVida -= dañoRecibido;
		else{
			dañoRecibido = puntosDeVida;
			puntosDeVida = 0;
		}
		
		return  dañoRecibido;
		
	}
	
	public void mover(Posicion posicion) throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcEsChocolate{
		if(esChocolate()) throw new ExcEsChocolate();
		this.tablero.posicionarPersonaje(this, posicion);
	}
	
	public void atacar(Personaje personajeObjetivo, boolean esEspecial) throws ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
		if(esChocolate()) throw new ExcEsChocolate();
		if(personajeObjetivo.estaMuerto()) throw new ExcPersonajeMurio();
		if(estaEnRangoDeAtaque(personajeObjetivo.posicion())){
			if(ki < ataqueElegido(esEspecial).costo()) throw new ExcKiInsuficiente();
			ataqueElegido(esEspecial).enviar(this, personajeObjetivo, bonificacionDeAtaquePorcentual());
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
		return velocidad;
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
	
	public int 
	rangoDeAtaque(){
		return this.rangoDeAtaque;
	}
	
	public int cantidadDeAbsorciones(){
		return 0;
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

	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
	
	private Ataque ataqueElegido(boolean esEspecial){
		if(esEspecial){
			return ataqueEspecial;
		} else {
			return ataqueNormal;
		}
	}
	
	private boolean estaEnRangoDeAtaque(Posicion objetivo){
		try {
			if(posicion.distanciaA(objetivo)>rangoDeAtaque){
				return false;
			}
		} catch (ExcPosicionNegativa e) {
			return false;
		}
		return true;
	}
	
	protected void inicializar(){
		vidaInicial=puntosDeVida;
	}
	
	
	
}
