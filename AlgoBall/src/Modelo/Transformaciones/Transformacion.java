package Modelo.Transformaciones;

import Modelo.Personajes.Personaje;

public abstract class Transformacion {
	String nombre;
	public abstract boolean esPosible(Personaje personaje);
	public abstract int rangoDeAtaque();
	public abstract int poderDePelea();
	public abstract int velocidad();
	public abstract int costo();
	
	public String nombre(){
		return nombre;
	}
}
