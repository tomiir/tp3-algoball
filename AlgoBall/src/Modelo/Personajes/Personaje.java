package Modelo.Personajes;

import java.util.LinkedList;
import java.util.Queue;

import Modelo.Equipo;
import Modelo.Partida;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Interfaces.Atacable;
import Modelo.Transformaciones.Transformacion;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcPersonajeInmovilizado;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;

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
	AtaqueNormal ataqueNormal = new AtaqueNormal();
	Posicion posicion;
	Tablero tablero;
	Queue <Transformacion> transformaciones = new LinkedList<Transformacion>();
	
	
	public int recibirDaño(int dañoRecibido) throws ExcDañoNegativo{
		if(dañoRecibido < 0) throw new ExcDañoNegativo();
		
		
		if(dañoRecibido <= puntosDeVida) this.puntosDeVida -= dañoRecibido;
		else{
			dañoRecibido = puntosDeVida;
			puntosDeVida = 0;
		}
		
		return  dañoRecibido;
		
	}
	
	public void incrementarKi(int cantidad){
		this.ki += cantidad;
	}
	
	public void mover(Posicion posicion) throws ExcPosicionOcupada, ExcFueraDeTablero {
		this.tablero.posicionarPersonaje(this, posicion);
	}
	
	public void atacar(Personaje personajeObjetivo, boolean esEspecial) throws ExcPersonajeMurio, ExcKiInsuficiente, ExcFueraDeRango, ExcDañoNegativo, ExcPersonajeInmovilizado{
		if(esChocolate()) throw new ExcPersonajeInmovilizado();
		if(personajeObjetivo.estaMuerto()) throw new ExcPersonajeMurio();
		if(estaEnRangoDeAtaque(personajeObjetivo.posicion())){
			if(ki < ataqueElegido(esEspecial).costo()) throw new ExcKiInsuficiente();
			try {
				ataqueElegido(esEspecial).enviar(this, personajeObjetivo, bonificacionDeAtaquePorcentual());
			} catch (ExcDañoNegativo e) {
				throw e;
			}
			ki -= ataqueElegido(esEspecial).costo();
		} else {
			throw new ExcFueraDeRango();
		}
		tablero.removerSiEstaMuerto(personajeObjetivo);
	}
	
	public void pasoDeTurno(int aumentoKi){
		ki+=aumentoKi;
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
		if(esChocolate()) return null;
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
	
	public void transformar (Equipo equipoPropio) throws ExcNoEsPosibleTransformarse {
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
	
	public void convertirEnChocolate(int turnos){
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
		} catch (ExcPosicionNegativa | ExcDireccionInvalida e) {
			return false;
		}
		return true;
	}
	
	protected void inicializar(){
		vidaInicial=puntosDeVida;
	}
	
	
	
}
