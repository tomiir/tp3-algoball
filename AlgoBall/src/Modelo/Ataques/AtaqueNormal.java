package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDa�oNegativo;
import Modelo.Personajes.Personaje;

public class AtaqueNormal extends Ataque {
	
	public AtaqueNormal(){
		costo=0;
		
	}

	@Override
	protected void efectosColaterales(int da�oRealizado) {
	}

}
