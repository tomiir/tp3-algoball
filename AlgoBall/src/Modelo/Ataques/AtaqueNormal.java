package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class AtaqueNormal extends Ataque {
	int daño;
	
	public AtaqueNormal(int puntosDaño){
		daño=puntosDaño;
	}

	@Override
	public int costo() {
		return 0;
	}

	@Override
	protected int daño(Personaje destinatario) {
		return daño;
	}

	@Override
	protected void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible {
		return;
	}

}
