package Modelo;

public class AtaqueNormal extends Ataque {
	int dato;
	
	public AtaqueNormal(int puntosDato){
		dato=puntosDato;
	}

	@Override
	protected int costo() {
		return 0;
	}

	@Override
	protected int dato(Personaje destinatario) {
		return dato;
	}

	@Override
	protected void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible {
		return;
	}

}
