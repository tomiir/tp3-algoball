package Modelo.Personajes;

import Modelo.Estado;
import Modelo.Vida;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.GohanSS2;
import Modelo.Transformaciones.TransformacionPorKi;

public class Gohan extends Personaje {

	public Gohan(){
			
		nombre = "Gohan";
		vida = new Vida(300);
		estado = new Estado("Normal", 15,2,2);
		ataqueEspecial = Ataque.Masenko();
		
		TransformacionPorKi superSaiyan1 = new TransformacionPorKi("Super Sayajin 1", 10,2,2,30 );
		GohanSS2 superSaiyan2 = new GohanSS2();
		
		transformaciones.add(superSaiyan1);
		transformaciones.add(superSaiyan2);
	}
	
}
