package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Transformaciones.TransformacionPorKi;

public class MajinBoo extends Personaje {
	public MajinBoo(Tablero mundo){
		
		nombre = "Majin Boo";
		puntosDeVida = 300;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueNormal = new AtaqueNormal(30);
		ataqueEspecial = null;
		tablero = mundo;
		
		TransformacionPorKi booMalo = new TransformacionPorKi("Boo Malo", 20, 2,3,50 );
		
		transformaciones.add(booMalo);
	}
}
