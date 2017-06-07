package Modelo.Transformaciones;

import Modelo.Personajes.Personaje;

public class TransformacionPorKi extends Transformacion {
	int ki;
	int rangoDeAtaque;
	int velocidad;
	int poderDePelea;
	
	public TransformacionPorKi(String str, int costo, int rango, int velocida, int poder){
		nombre=str;
		ki=costo;
		rangoDeAtaque=rango;
		velocidad=velocida;
		poderDePelea=poder;
	}
	
	@Override
	public boolean esPosible(Personaje personaje) {
		return (personaje.ki()>=this.ki);
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
		return this.ki;
	}
}
