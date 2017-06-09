package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDa�oNegativo;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int costo = 0;
	
	int modificadorDa�o=100;
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcAtaqueImposible{
		
		int da�oActual = calcularDa�o(remitente, destinatario, bonificacionPorcentual);
		
		try {
			destinatario.recibirDa�o(da�oActual);
		} catch (ExcDa�oNegativo e) {
			throw new ExcAtaqueImposible("No se pueden hacer da�os negativos");
		}
		this.efectosColaterales(remitente, destinatario, da�oActual);
	}
	
	protected int calcularDa�o(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		
		int da�o = remitente.poderDePelea() * modificadorDa�o / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			da�o = da�o*8/10;
		}
		return da�o*((100+bonificacionPorcentual)/100);
		
	}
	
	public int modificadorDa�o (){
		return this.modificadorDa�o;
	}
	
	public int costo() {
		return this.costo;
	}
	
	protected abstract void efectosColaterales(Personaje remitente, Personaje destinatario, int da�oRealizado);
}
