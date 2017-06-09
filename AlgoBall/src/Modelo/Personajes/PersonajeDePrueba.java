package Modelo.Personajes;

import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.Transformacion;

public class PersonajeDePrueba extends Personaje {
	
	int cantidadAbsorciones;
	public PersonajeDePrueba(Partida par, String Inombre, int IpuntosDeVida, int IrangoDeAtaque, int Ivelocidad, int IpoderDePelea){
		
		nombre = Inombre;
		puntosDeVida = IpuntosDeVida;
		rangoDeAtaque = IrangoDeAtaque;
		velocidad = Ivelocidad;
		partida = par;
		poderDePelea=IpoderDePelea;
		ataqueEspecial = null;
		inicializar();
		
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
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