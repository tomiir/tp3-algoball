package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Personajes.Personaje;

public class TransformacionPorKi extends Transformacion {
	
	
	public TransformacionPorKi(String str, int costo, int rango, int velocida, int poder){
		nombre=str;
		this.costo=costo;
		rangoDeAtaque=rango;
		velocidad=velocida;
		poderDePelea=poder;
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		return (personaje.ki()>=this.costo);
	}

	@Override
	public int rangoDeAtaque() {
		return rangoDeAtaque;
	}
	
	@Override
	public int poderDePelea() {
		return poderDePelea;
	}

	@Override
	public int velocidad() {
		return velocidad;
	}
	
	public String nombre(){
		return this.nombre;
	}
	
	public int costo(){
		return this.costo;
	}
}
