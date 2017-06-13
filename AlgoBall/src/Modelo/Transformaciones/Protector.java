package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Partida;
import Modelo.Excepciones.ExcNoHayPersonaje;
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
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		
		Personaje gohan;
		try {
			gohan = equipo.obtenerPersonaje("Gohan");
		} catch (ExcNoHayPersonaje e) {
			return false;
		}
		
		return gohan.vidaPorcentual() < 20;
		
		
	}
	
	

}
