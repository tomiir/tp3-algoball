package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Transformaciones.TransformacionPorKi;

public class Goku extends Personaje {
	
	
	public Goku(Tablero mundo){
		
		nombre = "Goku";
		puntosDeVida = 500;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueNormal = new AtaqueNormal(20);
		ataqueEspecial = null;
		tablero = mundo;
		
		TransformacionPorKi kaioken = new TransformacionPorKi("Kaioken", 20, 4,3,40 );
		
		transformaciones.add(kaioken);
	}
	
	

}