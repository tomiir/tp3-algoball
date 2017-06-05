package Modelo;

public class AtaqueNormal extends Ataque {
	int daño;
	
	public AtaqueNormal(int puntosDaño){
		daño=puntosDaño;
	}

	@Override
	protected int costo() {
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
