package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class Makankosappo extends Ataque {
	
	public void Masenko (){
		costo = 10;
	}
	
	protected int da�oParcial() {
		return ((da�oBase*120)/100);
	
	}

	@Override
	protected void efectosColaterales(int da�oRealizado) {
	}

}
