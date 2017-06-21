package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Estado;
import Modelo.Personajes.Personaje;

public abstract class Transformacion {
	String nombre;
	Estado estado;
	int costo;
	
	public abstract boolean esPosible(Personaje personaje, Equipo equipo);
	
	public Estado getNuevoEstado(){
		return estado;
	}
	
	public int costo(){
		return costo;
	}
}
