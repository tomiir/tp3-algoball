package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Estado;
import Modelo.Personajes.Personaje;

public class SemiPerfecto extends Transformacion {
	
	public SemiPerfecto(){
		this.nombre = "Semi Perfecto";
		this.costo = 0;
		this.estado = new Estado("Semi perfecto", 40, 4, 3);
		
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		return (personaje.cantidadDeAbsorciones()>=4);
	}

}
