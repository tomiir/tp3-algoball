package Modelo;

public abstract class Transformacion {
	String nombre;
	public abstract boolean esPosible(Personaje personaje);
	public abstract int rangoDeAtaque();
	public abstract int velocidad();
	public abstract AtaqueNormal ataqueNormal();
	
}
