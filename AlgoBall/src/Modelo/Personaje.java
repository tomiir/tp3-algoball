package Modelo;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Personaje {
	
	String nombre;
	int puntosDeVida;
	int rangoDeAtaque;
	int velocidad;
	int ki = 0;
	int poderDePelea;
	Ataque ataqueEspecial;
	Ataque ataqueNormal;
	Casillero posicion;
	Queue <Transformacion> transformaciones = new LinkedList();
	
	public abstract void atacar(Personaje personajeObjetivo, Ataque ataqueElegido);
	
	public Casillero posicion(){
		return posicion;
	}
	
	public int velocidad(){
		return velocidad;
	}
	
	public void transformar () {
		Transformacion transformacion = transformaciones.peek();
		if(transformacion.esPosible(this) && transformacion!=null){
			transformaciones.remove();
			this.rangoDeAtaque = transformacion.getRangoDeAtaque();
			this.velocidad = transformacion.getVelocidad();
			this.ataqueNormal = transformacion.getAtaqueNormal();
		} else {
			throw NoEsPosibleTransformarse;
		}
	}
	
	
	
}
