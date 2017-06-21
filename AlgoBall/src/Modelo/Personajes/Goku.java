package Modelo.Personajes;

import Modelo.Estado;
import Modelo.Tablero;
import Modelo.Vida;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.TransformacionPorKi;

public class Goku extends Personaje {
	
	
	public Goku(){
		
		nombre = "Goku";
		vida = new Vida(500);
		estado = new Estado("Normal", 20, 2, 2);
		ataqueEspecial = Ataque.Kamekameha();
		
		TransformacionPorKi kaioken = new TransformacionPorKi("Kaio Ken", 20,4,3,40);
		TransformacionPorKi superSaiyan = new TransformacionPorKi("Super Sayajin", 50,4,5,60);
		
		transformaciones.add(kaioken);
		transformaciones.add(superSaiyan);
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		if(vida.vidaPorcentual()<30) return 20;
		return 0;
	}

}
