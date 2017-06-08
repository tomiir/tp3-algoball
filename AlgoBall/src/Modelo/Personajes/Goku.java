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
		ataqueEspecial = null;
		tablero = mundo;
		inicializar();
		
		TransformacionPorKi kaioken = new TransformacionPorKi("Kaioken", 20, 4,3,40);
		
		transformaciones.add(kaioken);
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}

}
