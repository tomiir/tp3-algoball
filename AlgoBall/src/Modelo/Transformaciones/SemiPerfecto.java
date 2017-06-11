package Modelo.Transformaciones;

import Modelo.Partida;
import Modelo.Personajes.Personaje;

public class SemiPerfecto extends Transformacion {
	
	public SemiPerfecto(){
		this.nombre = "Semi-Perfecto";
		this.rangoDeAtaque =4;
		this.costo = 0;
		this.velocidad = 3;
		this.poderDePelea = 40;
		
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Partida partida) {
		return (personaje.cantidadDeAbsorciones()>=4);
	}

}
