package Modelo.Personajes;

import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Ataques.Makankosappo;
import Modelo.Transformaciones.Protector;
import Modelo.Transformaciones.TransformacionPorKi;

public class Piccolo extends Personaje {
	
	public Piccolo(Partida p){
		
		nombre = "Piccolo";
		puntosDeVida = 500;
		poderDePelea = 20;
		rangoDeAtaque = 2;
		velocidad = 3;
		ataqueEspecial = new Makankosappo();
		partida = p;
		inicializar();
		
		TransformacionPorKi fortalecido = new TransformacionPorKi("Fortalecido", 20, 4,3,40 );
		Protector protector = new Protector(p);
		
		transformaciones.add(fortalecido);
		transformaciones.add(protector);
	}
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
}
