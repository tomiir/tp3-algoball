package Modelo.Transformaciones;

import Modelo.Ataques.AtaqueNormal;
import Modelo.Personajes.Personaje;

public abstract class Transformacion {
	String nombre;
	public abstract boolean esPosible(Personaje personaje);
	public abstract int rangoDeAtaque();
	public abstract int poderDePelea();
	public abstract int velocidad();
	public abstract AtaqueNormal ataqueNormal();
	public abstract int costo();
}
