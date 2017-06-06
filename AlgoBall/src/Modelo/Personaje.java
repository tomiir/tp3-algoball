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
	Posicion posicion;
	Tablero tablero;
	Queue <Transformacion> transformaciones = new LinkedList();
	
	public void recibirDaño(int cantidad){
		puntosDeVida -= cantidad;
	}
	
	public void mover(Direccion direccion){
		Posicion nuevaPos = interpretarDireccion(direccion);
		
		tablero.posicionar(this, nuevaPos);
		
		
	}
	
	
	public void atacar(Personaje personajeObjetivo, boolean esEspecial) throws ExcFueraDeRango, ExcAtaqueImposible{
		if(estaEnRangoDeAtaque(personajeObjetivo.posicion())){
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
	
	public void setPosicion(Posicion casillero) throws ExcCasilleroOcupado{
		this.posicion = casillero;
	}
	
	public int velocidad(){
		return velocidad;
	}
	
	public Posicion posicion(){
		return posicion;
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
	
	private boolean estaEnRangoDeAtaque(Posicion objetivo){
		if(posicion.distanciaA(objetivo)<=rangoDeAtaque){
			return false;
		}
		return true;
	}
	
	private Posicion interpretarDireccion(Direccion direccion){
		
	}
	
	public boolean estaMuerto(){
		return (puntosDeVida<0);
	}
}
