package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.Ataque;

public class PersonajeDePrueba extends Personaje {
	
	
	public PersonajeDePrueba(Tablero mundo, String Inombre, int IpuntosDeVida, int IrangoDeAtaque, int Ivelocidad, int IpoderDePelea){
		
		nombre = Inombre;
		puntosDeVida = IpuntosDeVida;
		rangoDeAtaque = IrangoDeAtaque;
		velocidad = Ivelocidad;
		tablero = mundo;
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
}