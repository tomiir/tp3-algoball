package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.TransformacionPorKi;

public class Goku extends Personaje {
	
	
	public Goku(Tablero tablero){
		
		nombre = "Goku";
		puntosDeVida = 500;
		poderDePelea = 20;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueEspecial = Ataque.Kamekameha();
		this.tablero = tablero;
		inicializar();
		
		TransformacionPorKi kaioken = new TransformacionPorKi("Kaio Ken", 20, 4,3,40);
		TransformacionPorKi superSaiyan = new TransformacionPorKi("Super Sayajin", 50, 4,5,60);
		
		transformaciones.add(kaioken);
		transformaciones.add(superSaiyan);
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		if(this.vidaPorcentual()<30) return 20;
		return 0;
	}

}
