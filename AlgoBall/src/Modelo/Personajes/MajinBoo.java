package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.ConvierteteEnChocolate;
import Modelo.Transformaciones.TransformacionPorKi;

public class MajinBoo extends Personaje {
	public MajinBoo(Tablero tablero){
		
		nombre = "Majin Boo";
		puntosDeVida = 300;
		poderDePelea = 30;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueEspecial = new ConvierteteEnChocolate();
		this.tablero = tablero;
		inicializar();
		
		TransformacionPorKi booMalo = new TransformacionPorKi("Boo Malo", 20,2,3,50);
		TransformacionPorKi booOriginal = new TransformacionPorKi("Boo Original", 50,3,4,60);
		
		
		transformaciones.add(booMalo);
		transformaciones.add(booOriginal);
		
	}
}
