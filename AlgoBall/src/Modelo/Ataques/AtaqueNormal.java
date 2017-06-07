package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class AtaqueNormal extends Ataque {
	
	public AtaqueNormal(){
	}

	@Override
	public int costo() {
		return 0;
	}

	@Override
	protected void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible {
		return;
	}

	@Override
	protected int dañoParcial() {
		return dañoBase();
	}

}
