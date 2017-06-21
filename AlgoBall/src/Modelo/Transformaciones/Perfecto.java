package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Estado;
import Modelo.Personajes.Personaje;

public class Perfecto extends Transformacion {
	
	public Perfecto(){
		this.nombre = "Perfecto";
		this.costo = 0;
		this.estado = new Estado("Perfecto", 80, 4, 4);
		
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		if(personaje.cantidadDeAbsorciones()>=8) return true;
		return false;
	}

}
