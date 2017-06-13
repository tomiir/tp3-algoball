package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Partida;
import Modelo.Personajes.Personaje;

public class Perfecto extends Transformacion {
	
	public Perfecto(){
		this.nombre = "Perfecto";
		this.rangoDeAtaque =4;
		this.costo = 0;
		this.velocidad = 4;
		this.poderDePelea = 80;
		
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		if(personaje.cantidadDeAbsorciones()>=8) return true;
		return false;
	}

}
