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
	protected boolean aux;
	@Override
	public boolean esPosible(Personaje personaje) {
		
		aux = (personaje.ki() >= this.costo);
		
		Equipo equipo = this.partida.obtenerEquipoAliado(personaje);
				
		equipo.forEach((k,v)->{
			aux=this.comprobarCondicion(personaje,v);
			});
		
		return aux;
		
	}
	
	public boolean comprobarCondicion(Personaje personaje, Personaje aliado){
		if(aliado.nombre() != personaje.nombre()){
			return (personaje.vidaPorcentual() <= 30);
		}
		return true;
	}


}
