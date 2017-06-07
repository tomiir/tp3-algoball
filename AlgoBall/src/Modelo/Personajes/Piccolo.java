package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Transformaciones.TransformacionPorKi;

public class Piccolo extends Personaje {
	
	public Piccolo(Tablero mundo){
		
		nombre = "Piccolo";
		puntosDeVida = 500;
		rangoDeAtaque = 2;
		velocidad = 3;
		ataqueEspecial = null;
		tablero = mundo;
		
		TransformacionPorKi fortalecido = new TransformacionPorKi("Fortalecido", 20, 4,3,40 );
		
		transformaciones.add(fortalecido);
	}

}
