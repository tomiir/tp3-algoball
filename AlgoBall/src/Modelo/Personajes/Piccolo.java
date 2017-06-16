package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.Protector;
import Modelo.Transformaciones.TransformacionPorKi;

public class Piccolo extends Personaje {
	
	public Piccolo(Tablero tablero){
		
		nombre = "Piccolo";
		puntosDeVida = 500;
		poderDePelea = 20;
		rangoDeAtaque = 2;
		velocidad = 3;
		ataqueEspecial = Ataque.Makankosappo();
		this.tablero = tablero;
		inicializar();
		
		TransformacionPorKi fortalecido = new TransformacionPorKi("Fortalecido", 20, 4,3,40 );
		
		transformaciones.add(fortalecido);
		
		Protector protector = new Protector();
		
		transformaciones.add(protector);	
	}
}
