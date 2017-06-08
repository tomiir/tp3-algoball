package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Personajes.Personaje;

public class AtaqueNormal extends Ataque {
	
	public AtaqueNormal(){
		costo=0;
		modificadorDaño=100;
	}

	@Override
	protected void efectosColaterales(int dañoRealizado) {
	}

}
