package Modelo.Personajes;

import Modelo.Tablero;

public class PersonajeDePrueba extends Personaje {
	
	
	public PersonajeDePrueba(Tablero mundo, String Inombre, int IpuntosDeVida, int IrangoDeAtaque, int Ivelocidad, int IpoderDePelea){
		
		nombre = Inombre;
		puntosDeVida = IpuntosDeVida;
		rangoDeAtaque = IrangoDeAtaque;
		velocidad = Ivelocidad;
		tablero = mundo;
		poderDePelea=IpoderDePelea;
		
	}
	
	

}