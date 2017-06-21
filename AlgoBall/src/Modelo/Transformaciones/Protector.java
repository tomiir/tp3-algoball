package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Estado;
import Modelo.Excepciones.ExcNoHayPersonaje;
import Modelo.Personajes.Personaje;

public class Protector extends Transformacion {
	public Protector(){
		this.nombre = "Protector";
		this.costo = 0;
		this.estado = new Estado("Protector", 60, 6, 4);		
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
