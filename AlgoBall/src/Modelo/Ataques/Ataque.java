package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int dañoBase = 50;
	
	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
		} catch(ExcAtaqueImposible e){
			throw e;
		}
		destinatario.recibirDaño(this.daño(remitente, destinatario));
	}
	
	protected int daño(Personaje remitente, Personaje destinatario) {
		if(remitente.poderDePelea()<destinatario.poderDePelea()) return (dañoParcial()*8)/10;
		return dañoParcial();
	}
	
	public int dañoBase(){
		return dañoBase;
	}
	
	protected abstract int dañoParcial();
	
	public abstract int costo();	
	
	
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
