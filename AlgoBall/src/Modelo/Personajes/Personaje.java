package Modelo.Personajes;

import java.util.LinkedList;
import java.util.Queue;

import Modelo.Direccion;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Posicion;
import Modelo.Posicionable;
import Modelo.Tablero;
import Modelo.Transformaciones.Transformacion;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;

public abstract class Personaje implements Posicionable{
	
	String nombre;
	int puntosDeVida;
	int poderDePelea;
	int rangoDeAtaque;
	int velocidad;
	int ki = 0;
	Modelo.Ataques.Ataque ataqueEspecial;
	AtaqueNormal ataqueNormal = new AtaqueNormal();
	Posicion posicion;
	Tablero tablero;
	Queue <Transformacion> transformaciones = new LinkedList<Transformacion>();
	
	public void recibirDaño(int cantidad){
		puntosDeVida -= cantidad;
	}
	
	public void incrementarKi(int cantidad){
		this.ki += cantidad;
	}
	public void mover(Direccion direccion) throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		Posicion nuevaPos = interpretarDireccion(direccion);
		tablero.posicionar(this, nuevaPos);
	}
	
	
	public void atacar(Personaje personajeObjetivo, boolean esEspecial) throws ExcFueraDeRango, ExcAtaqueImposible, ExcPosicionNegativa, ExcDireccionInvalida{
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
	
	public void transformar () throws ExcNoEsPosibleTransformarse {
		Transformacion transformacion = transformaciones.peek();
		if(transformacion.esPosible(this) && transformacion!=null){
			transformaciones.remove();
			rangoDeAtaque = transformacion.rangoDeAtaque();
			velocidad = transformacion.velocidad();
			ataqueNormal = transformacion.ataqueNormal();
			poderDePelea = transformacion.poderDePelea();
			ki -= transformacion.costo();
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
	
	private boolean estaEnRangoDeAtaque(Posicion objetivo) throws ExcPosicionNegativa, ExcDireccionInvalida{
		if(posicion.distanciaA(objetivo)<=rangoDeAtaque){
			return false;
		}
		return true;
	}
	
	private Posicion interpretarDireccion(Direccion direccion) throws ExcPosicionNegativa{
		return new Posicion(posicion.posX()+direccion.dx(),posicion.posY()+direccion.dy());
	}
	
	public boolean estaMuerto(){
		return (puntosDeVida<0);
	}
	
	public int rangoDeAtaque(){
		return this.rangoDeAtaque;
	}
	
	public int getDmgNormal(){
		return 0;
	}
}
