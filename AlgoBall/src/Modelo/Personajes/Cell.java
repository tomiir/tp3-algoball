package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.Absorcion;
import Modelo.Transformaciones.Perfecto;
import Modelo.Transformaciones.SemiPerfecto;

public class Cell extends Personaje {
	
	int absorciones=0;
	
	public Cell(Tablero tablero){
		
		nombre = "Cell";
		puntosDeVida = 500;
		poderDePelea = 20;
		rangoDeAtaque = 3;
		velocidad = 2;
		ataqueEspecial = new Absorcion(this);
		this.tablero = tablero;
		
		SemiPerfecto semiPerfecto = new SemiPerfecto();
		Perfecto perfecto = new Perfecto();
		
		transformaciones.add(semiPerfecto);
		transformaciones.add(perfecto);
		
		inicializar();
		
		//Transformacion especial no implementado
	}
	
	
	public int cantidadDeAbsorciones(){
		return absorciones;
	}
	
	public void aumentarVidaPorAbsorcion(int aumento){
		
		absorciones++;
		puntosDeVida+=aumento;
		if(puntosDeVida >= vidaInicial) puntosDeVida = vidaInicial;
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}
}
