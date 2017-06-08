package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;

public class Cell extends Personaje {
	
	int absorciones=0;
	
	public Cell(Tablero mundo){
		
		nombre = "Cell";
		puntosDeVida = 500;
		rangoDeAtaque = 3;
		velocidad = 2;
		ataqueEspecial = null;
		tablero = mundo;
		inicializar();
		//Transformacion especial no implementado
	}
	
	
	public int cantidadDeAbsorciones(){
		return absorciones;
	}
	
	public void aumentarVidaPorAbsorcion(int aumento){
		absorciones++;
		puntosDeVida+=aumento;
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
}
