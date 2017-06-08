package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Personajes.Personaje;

public class Protector extends Transformacion {

	public Protector(Partida partida){
		this.nombre = "Protector";
		this.partida = partida;
		this.rangoDeAtaque =6;
		this.costo = 0;
		this.velocidad = 4;
		this.poderDePelea = 60;
		
	}
	
	@Override
	public boolean esPosible(Personaje personaje) {
		
		Personaje personaje = partida.obtenerPersonaje("Gohan");
		
		return personaje.vidaPorcentual() < 20;
		
		
	}
	
	

}
