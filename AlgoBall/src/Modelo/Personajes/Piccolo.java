package Modelo.Personajes;

import Modelo.Estado;
import Modelo.Vida;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.Protector;
import Modelo.Transformaciones.TransformacionPorKi;

public class Piccolo extends Personaje {
	
	public Piccolo(){
		
		nombre = "Piccolo";
		vida = new Vida(500);
		estado = new Estado("Normal", 20, 2, 2);
		ataqueEspecial = Ataque.Makankosappo();
		
		TransformacionPorKi fortalecido = new TransformacionPorKi("Fortalecido", 20,4,3,40 );
		
		transformaciones.add(fortalecido);
		
		Protector protector = new Protector();
		
		transformaciones.add(protector);	
	}
}
