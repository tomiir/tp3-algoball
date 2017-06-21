package Modelo.Personajes;

import Modelo.Estado;
import Modelo.Vida;
import Modelo.Ataques.Absorcion;
import Modelo.Transformaciones.Perfecto;
import Modelo.Transformaciones.SemiPerfecto;

public class Cell extends Personaje {
	
	int absorciones=0;
	
	public Cell(){
		
		nombre = "Cell";
		vida = new Vida(500);
		estado = new Estado("Normal",20,3,2);
		ataqueEspecial = new Absorcion(this);
		
		SemiPerfecto semiPerfecto = new SemiPerfecto();
		Perfecto perfecto = new Perfecto();
		
		transformaciones.add(semiPerfecto);
		transformaciones.add(perfecto);

	}
	
	
	public int cantidadDeAbsorciones(){
		return absorciones;
	}
	
	public void aumentarVidaPorAbsorcion(int aumento){
		
		absorciones++;
		vida.aumentar(aumento);
	}
	
	public int bonificacionDeAtaquePorcentual(){
		return 0;
	}
}
