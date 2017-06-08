package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Partida;
import Modelo.Personajes.Personaje;

public class Protector extends Transformacion {
	Partida partida;
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
		
		Personaje gohan = partida.obtenerPersonaje("Gohan");
		
		return gohan.vidaPorcentual() < 20;
		
		
	}
	
	

}
