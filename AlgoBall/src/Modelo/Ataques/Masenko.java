package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class Masenko extends Ataque {
	
	public Masenko (){
		costo = 10;
	}
	
	protected int da�oParcial() {
		return ((da�oBase*125)/100);
	
	}

	@Override
	protected void efectosColaterales(int da�oRealizado) {
	}
	
}
