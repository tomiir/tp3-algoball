package Modelo.Ataques;

import Modelo.Personajes.Personaje;

public class AtaqueNormal extends Ataque {
	
	public AtaqueNormal(){
		costo=0;
		modificadorDa�o=100;
	}

	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int da�oRealizado) {
	}

}
