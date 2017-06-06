package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class AtaqueNormal extends Ataque {
	int da�o;
	
	public AtaqueNormal(int puntosDa�o){
		da�o=puntosDa�o;
	}

	@Override
	public int costo() {
		return 0;
	}

	@Override
	protected int da�o(Personaje destinatario) {
		return da�o;
	}

	@Override
	protected void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible {
		return;
	}

}
