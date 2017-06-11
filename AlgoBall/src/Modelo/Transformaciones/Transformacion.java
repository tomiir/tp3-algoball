package Modelo.Transformaciones;

import Modelo.Partida;
import Modelo.Personajes.Personaje;

public abstract class Transformacion {
	String nombre;
	int costo;
	int rangoDeAtaque;
	int velocidad;
	int poderDePelea;
	
	public abstract boolean esPosible(Personaje personaje, Partida partida);
	
	public int rangoDeAtaque() {
		return this.rangoDeAtaque;	
	}

	public int poderDePelea() {
		return this.poderDePelea;
	}

	public int velocidad() {
		return this.velocidad;
	}

	public int costo() {
		return this.costo;
	}
	
	public String nombre(){
		return this.nombre;
	}
}
