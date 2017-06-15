package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.Makankosappo;
import Modelo.Transformaciones.TransformacionPorKi;

public class Piccolo extends Personaje {
	
	public Piccolo(Tablero tablero){
		
		nombre = "Piccolo";
		puntosDeVida = 500;
		poderDePelea = 20;
		rangoDeAtaque = 2;
		velocidad = 3;
		ataqueEspecial = new Makankosappo();
		this.tablero = tablero;
		inicializar();
		
		TransformacionPorKi fortalecido = new TransformacionPorKi("Fortalecido", 20, 4,3,40 );
		//Protector protector = new Protector(p);
		
		transformaciones.add(fortalecido);
		//transformaciones.add(protector);
	}
}
