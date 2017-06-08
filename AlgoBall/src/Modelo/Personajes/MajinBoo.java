package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Transformaciones.TransformacionPorKi;

public class MajinBoo extends Personaje {
	public MajinBoo(Tablero mundo){
		
		nombre = "Majin Boo";
		puntosDeVida = 300;
		poderDePelea = 30;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueEspecial = null;
		tablero = mundo;
		inicializar();
		
		TransformacionPorKi booMalo = new TransformacionPorKi("Boo Malo", 20, 2,3,50);
		
		transformaciones.add(booMalo);
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
}
