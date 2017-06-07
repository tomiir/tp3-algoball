package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int da�o = 50;
	
	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
		} catch(ExcAtaqueImposible e){
			throw e;
		}
		destinatario.recibirDa�o(this.da�o(remitente, destinatario));
	}
	
	protected int da�o(Personaje remitente, Personaje destinatario) {
		if(remitente.poderDePelea()<destinatario.poderDePelea()) return (da�o*8)/10;
		return da�o;
	}
	
	public abstract int costo();	
	
	
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
