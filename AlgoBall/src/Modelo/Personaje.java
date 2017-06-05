package Modelo;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Personaje implements Posicionable{
	
	String nombre;
	int puntosDeVida;
	int rangoDeAtaque;
	int velocidad;
	int ki = 0;
	Ataque ataqueEspecial;
	AtaqueNormal ataqueNormal;
	Casillero posicion;
	Tablero tablero;
	Queue <Transformacion> transformaciones = new LinkedList();
	
	public void recibirDato(int cantidad){
		puntosDeVida -= cantidad;
	}
	
	public void mover(Casillero nuevoCasillero) throws ExcMovimientoImposible{
		if(sePuedeMoverA(nuevoCasillero)){
			try{
				nuevoCasillero.posicionar(this);
			} catch (ExcCasilleroOcupado e){
				throw new ExcMovimientoImposible();
			}
			posicion.desocupar();
			posicion=nuevoCasillero;
		} else {
			throw new ExcMovimientoImposible();
		}
	}
	
	public void atacar(Personaje personajeObjetivo, boolean esEspecial) throws ExcFueraDeRango, ExcAtaqueImposible{
		if(estaEnRangoDeAtaque(personajeObjetivo.posicion)){
			try{
				ataqueElegido(esEspecial).enviar(this, personajeObjetivo);
			} catch (ExcAtaqueImposible e){
				throw e;
			}
			ki -= ataqueElegido(esEspecial).costo();
		} else {
			throw new ExcFueraDeRango();
		}
	}
	
	public void posicionar(Casillero casillero){
		
		this.posicion = casillero;
		
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
	
	public void transformar () throws ExcNoEsPosibleTransformarse {
		Transformacion transformacion = transformaciones.peek();
		if(transformacion.esPosible(this) && transformacion!=null){
			transformaciones.remove();
			rangoDeAtaque = transformacion.rangoDeAtaque();
			velocidad = transformacion.velocidad();
			ataqueNormal = transformacion.ataqueNormal();		
		} else {
			throw new ExcNoEsPosibleTransformarse();
		}
	}
	
	private Ataque ataqueElegido(boolean esEspecial){
		if(esEspecial){
			return ataqueEspecial;
		} else {
			return ataqueNormal;
		}
	}
	
	private boolean estaEnRangoDeAtaque(Casillero objetivo){
		if(posicion.distanciaA(objetivo)<=rangoDeAtaque){
			return false;
		}
		return true;
	}
	//logica similar al metodo estaEnRangoDeAtaque, merece la separacion?
	private boolean sePuedeMoverA(Casillero objetivo){
		if(posicion.distanciaA(objetivo)<=velocidad){
			return false;
		}
		return true;
	}
	
	public boolean estaMuerto(){
		return (puntosDeVida<0);
	}
}
