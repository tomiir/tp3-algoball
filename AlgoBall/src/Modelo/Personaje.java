package Modelo;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Personaje implements Posicionable{
	
	String nombre;
	int puntosDeVida;
	int rangoDeAtaque;
	int velocidad;
	int ki = 0;
	int poderDePelea;
	Ataque ataqueEspecial;
	Ataque ataqueNormal;
	Casillero posicion;
	Tablero tablero;
	Queue <Transformacion> transformaciones = new LinkedList();
	
	public void recibirDaño(int cantidad){
		puntosDeVida -= cantidad;
	}
	
	public void mover(Casillero nuevoCasillero){
		
	}
	
	public void atacar(Personaje personajeObjetivo, Ataque ataqueElegido) throws ExcFueraDeRango, ExcAtaqueImposible{
		if(estaEnRangoDeAtaque(personajeObjetivo.posicion)){
			try{
				ataqueElegido.enviar(this, personajeObjetivo);
				ki -= ataqueElegido.costo();
			} catch (ExcAtaqueImposible e){
				throw e;
			}
		} else {
			throw new ExcFueraDeRango();
		}
	}
	
	public Casillero posicion(){
		return posicion;
	}
	
	public int velocidad(){
		return velocidad;
	}
	
	public int ki(){
		return ki;
	}
	
	public void transformar () {
		Transformacion transformacion = transformaciones.peek();
		if(transformacion.esPosible(this) && transformacion!=null){
			transformaciones.remove();
			this.rangoDeAtaque = transformacion.getRangoDeAtaque();
			this.velocidad = transformacion.getVelocidad();
			this.ataqueNormal = transformacion.getAtaqueNormal();
		} else {
			throw new ExcNoEsPosibleTransformarse();
		}
	}
	
	private boolean estaEnRangoDeAtaque(Casillero objetivo){
		if(.distancia(objetivo)>rangoDeAtaque){
			return false;
		}
		return true;
	}
	
	public boolean estaMuerto(){
		return (puntosDeVida<0);
	}
}
