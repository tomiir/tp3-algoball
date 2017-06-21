package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Estado;
import Modelo.Personajes.Personaje;

public class TransformacionPorKi extends Transformacion {
	
	
	public TransformacionPorKi(String str, int costo, int rango, int velocidad, int poder){
		nombre=str;
		this.costo=costo;		
		this.estado = new Estado(str, poder, rango, velocidad);
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		return (personaje.ki()>=this.costo);
	}

}
