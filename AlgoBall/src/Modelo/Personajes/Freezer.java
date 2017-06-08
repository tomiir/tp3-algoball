package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Transformaciones.TransformacionPorKi;

public class Freezer extends Personaje {
	
	public Freezer(Tablero mundo){
		
		nombre = "Freezer";
		puntosDeVida = 400;
		poderDePelea = 20;
		rangoDeAtaque = 3;
		velocidad = 4;
		ataqueEspecial = null;
		tablero = mundo;
		inicializar();
		
		TransformacionPorKi segundaForma = new TransformacionPorKi("Segunda Forma", 20, 3,4,40 );
		
		transformaciones.add(segundaForma);
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}

}
