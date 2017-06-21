package Modelo.Personajes;

import Modelo.Estado;
import Modelo.Vida;
import Modelo.Ataques.ConvierteteEnChocolate;
import Modelo.Transformaciones.TransformacionPorKi;

public class MajinBoo extends Personaje {
	public MajinBoo(){
		
		nombre = "Majin Boo";
		vida = new Vida(300);
		estado = new Estado("Normal", 30,2,2);
		ataqueEspecial = new ConvierteteEnChocolate();
		
		TransformacionPorKi booMalo = new TransformacionPorKi("Boo Malo", 20,2,3,50);
		TransformacionPorKi booOriginal = new TransformacionPorKi("Boo Original", 50,3,4,60);
		
		
		transformaciones.add(booMalo);
		transformaciones.add(booOriginal);
		
	}
}
