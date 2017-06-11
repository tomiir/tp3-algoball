package Modelo.Personajes;

import Modelo.Partida;
import Modelo.Ataques.RayoMortal;
import Modelo.Transformaciones.TransformacionPorKi;

public class Freezer extends Personaje {
	
	public Freezer(Partida p){
		
		nombre = "Freezer";
		puntosDeVida = 400;
		poderDePelea = 20;
		rangoDeAtaque = 3;
		velocidad = 4;
		ataqueEspecial = new RayoMortal();
		partida = p;
		
		TransformacionPorKi segundaForma = new TransformacionPorKi("Segunda Forma", 20, 3,4,40 );
		TransformacionPorKi formaFinal = new TransformacionPorKi("Forma Final",50,3,6 ,50);
		
		transformaciones.add(segundaForma);
		transformaciones.add(formaFinal);

		inicializar();
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}

}
