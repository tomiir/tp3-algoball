package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDa�oNegativo;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	static final int da�oBase = 50;
	int costo = 0;
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcAtaqueImposible{
		try {
			destinatario.recibirDa�o(this.da�o(remitente, destinatario, bonificacionPorcentual));
		} catch (ExcDa�oNegativo e) {
			throw new ExcAtaqueImposible("No se pueden hacer da�os negativos");
		}
		this.efectosColaterales(this.da�o(remitente, destinatario, bonificacionPorcentual));
	}
	
	protected int da�o(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		if(remitente.poderDePelea()<destinatario.poderDePelea()) return ( ((da�oParcial()*8)/10)*(100+bonificacionPorcentual) ) /100;
		return da�oParcial();
	}
	
	public int da�oBase(){
		return da�oBase;
	}
	
	protected abstract int da�oParcial();
	
	public int costo() {
		return this.costo;
	}
	
	protected abstract void efectosColaterales(int da�oRealizado);
}
