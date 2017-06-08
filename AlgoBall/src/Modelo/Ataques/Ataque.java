package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	static final int dañoBase = 50;
	int costo = 0;
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcAtaqueImposible{
		try {
			destinatario.recibirDaño(this.daño(remitente, destinatario, bonificacionPorcentual));
		} catch (ExcDañoNegativo e) {
			throw new ExcAtaqueImposible("No se pueden hacer daños negativos");
		}
		this.efectosColaterales(this.daño(remitente, destinatario, bonificacionPorcentual));
	}
	
	protected int daño(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		if(remitente.poderDePelea()<destinatario.poderDePelea()) return ( ((dañoParcial()*8)/10)*(100+bonificacionPorcentual) ) /100;
		return dañoParcial();
	}
	
	public int dañoBase(){
		return dañoBase;
	}
	
	protected abstract int dañoParcial();
	
	public int costo() {
		return this.costo;
	}
	
	protected abstract void efectosColaterales(int dañoRealizado);
}
