package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int da�oBase = 50;
	
	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
		} catch(ExcAtaqueImposible e){
			throw e;
		}
		destinatario.recibirDa�o(this.da�o(remitente, destinatario));
	}
	
	protected int da�o(Personaje remitente, Personaje destinatario) {
		if(remitente.poderDePelea()<destinatario.poderDePelea()) return (da�oParcial()*8)/10;
		return da�oParcial();
	}
	
	public int da�oBase(){
		return da�oBase;
	}
	
	protected abstract int da�oParcial();
	
	public abstract int costo();	
	
	
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
