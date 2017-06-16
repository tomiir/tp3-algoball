package Modelo.Personajes;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.Transformacion;

public class PersonajeDePrueba extends Personaje {
	
	int cantidadAbsorciones;
	public PersonajeDePrueba(Tablero tablero, String Inombre, int IpuntosDeVida, int IrangoDeAtaque, int Ivelocidad, int IpoderDePelea){
		
		nombre = Inombre;
		puntosDeVida = IpuntosDeVida;
		rangoDeAtaque = IrangoDeAtaque;
		velocidad = Ivelocidad;
		this.tablero = tablero;
		poderDePelea=IpoderDePelea;
		ataqueEspecial = null;
		inicializar();
		
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
	
	public Posicion posicion(){
		return posicion;
	}
	
	public void setAtaqueEspecial (Ataque ataque){
		this.ataqueEspecial = ataque;
	}
	
	public void agregarTransformacion(Transformacion trans){
		transformaciones.add(trans);
	}
	
	public void setKi(int nuevo){
		ki=nuevo;
	}
	
	public void setAbsorciones(int num){
		cantidadAbsorciones=num;
	}
	
	public int cantidadDeAbsorciones(){
		return cantidadAbsorciones;
	}
}