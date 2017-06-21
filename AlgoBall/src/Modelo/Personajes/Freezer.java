package Modelo.Personajes;


import Modelo.Estado;
import Modelo.Vida;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.TransformacionPorKi;

public class Freezer extends Personaje {
	
	public Freezer(){
		
		nombre = "Freezer";
		vida = new Vida(400);
		estado = new Estado("Normal",20,2,4);
		ataqueEspecial = Ataque.RayoMortal();
		
		TransformacionPorKi segundaForma = new TransformacionPorKi("Segunda Forma", 20,3,4,40 );
		TransformacionPorKi formaFinal = new TransformacionPorKi("Definitiva",50,3,6,50);
		
		transformaciones.add(segundaForma);
		transformaciones.add(formaFinal);
	}

}
