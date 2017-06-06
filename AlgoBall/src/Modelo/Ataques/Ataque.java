package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
		} catch(ExcAtaqueImposible e){
			throw e;
		}
		destinatario.recibirDaño(this.daño(destinatario));
	}
	
	public abstract int costo();
	protected abstract int daño(Personaje destinatario);
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
