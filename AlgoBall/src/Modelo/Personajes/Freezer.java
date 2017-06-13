package Modelo.Personajes;


import Modelo.Tablero;
import Modelo.Ataques.RayoMortal;
import Modelo.Transformaciones.TransformacionPorKi;

public class Freezer extends Personaje {
	
	public Freezer(Tablero tablero){
		
		nombre = "Freezer";
		puntosDeVida = 400;
		poderDePelea = 20;
		rangoDeAtaque = 3;
		velocidad = 4;
		ataqueEspecial = new RayoMortal();
		this.tablero = tablero;
		
		TransformacionPorKi segundaForma = new TransformacionPorKi("Segunda Forma", 20, 3,4,40 );
		TransformacionPorKi formaFinal = new TransformacionPorKi("Forma Final",50,3,6 ,50);
		
		transformaciones.add(segundaForma);
		transformaciones.add(formaFinal);

		inicializar();
	}

}
