package Modelo.Transformaciones;

import java.util.function.BiConsumer;

import Modelo.Equipo;
import Modelo.Partida;
import Modelo.Personajes.Personaje;

public class GohanSS2 extends Transformacion {
	Partida partida;
	
	public GohanSS2(Partida partida){
		this.nombre = "Gohan SS2";
		this.partida = partida;
		this.rangoDeAtaque =4;
		this.costo = 30;
		this.velocidad = 3;
		this.poderDePelea = 100;
		
	}
	
	
	//Funcionara?
	@Override
	public boolean esPosible(Personaje personaje) {
		
		boolean ok = personaje.ki() >= this.costo;
		
		Equipo equipo = this.partida.obtenerEquipoAliado(personaje);
				
		equipo.forEach((k,v)->(actualizarBool(ok,this.comprobarCondicion(personaje,v))));
		
		return ok;
		
	}
	public void actualizarBool(boolean var, boolean value){
		var &= value;
	}
	
	public boolean comprobarCondicion(Personaje personaje, Personaje aliado){
		if(aliado.nombre() != personaje.nombre()){
			return (personaje.vidaPorcentual() <= 30);
		}
		return true;
	}


}
