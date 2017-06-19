package Modelo.Personajes;


import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.TransformacionPorKi;

public class Freezer extends Personaje {
	
	public Freezer(Tablero tablero){
		
		nombre = "Freezer";
		puntosDeVida = 400;
		poderDePelea = 20;
		rangoDeAtaque = 2;
		velocidad = 4;
		ataqueEspecial = Ataque.RayoMortal();
		this.tablero = tablero;
		
		TransformacionPorKi segundaForma = new TransformacionPorKi("Segunda Forma", 20,3,4,40 );
		TransformacionPorKi formaFinal = new TransformacionPorKi("Definitiva",50,3,6,50);
		
		transformaciones.add(segundaForma);
		transformaciones.add(formaFinal);

		inicializar();
	}

}
