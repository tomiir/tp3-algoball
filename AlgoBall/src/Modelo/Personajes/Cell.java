package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;

public class Cell extends Personaje {
	
	public Cell(Tablero mundo){
		
		nombre = "Cell";
		puntosDeVida = 500;
		rangoDeAtaque = 3;
		velocidad = 2;
		ataqueEspecial = null;
		tablero = mundo;
		
		//Transformacion especial no implementado
	}

}
