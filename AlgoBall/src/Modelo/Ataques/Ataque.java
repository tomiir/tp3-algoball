package Modelo.Ataques;

import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int costo = 0;
	
	int modificadorDa�o=100;
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcEsChocolate, ExcNumeroNegativo{
		
		int da�oActual = calcularDa�o(remitente, destinatario, bonificacionPorcentual);
		int da�oRecibido;
		da�oRecibido = destinatario.recibirDa�o(da�oActual);
		this.efectosColaterales(remitente, destinatario, da�oRecibido);
	}
	
	protected int calcularDa�o(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		
		int da�o = remitente.poderDePelea() * modificadorDa�o / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			da�o = da�o*8/10;
		}
		return (da�o*(100+bonificacionPorcentual))/100;
		
	}
	
	public int costo() {
		return this.costo;
	}
	
	private void efectosColaterales(Personaje remitente, Personaje destinatario, int da�oRealizado) throws ExcEsChocolate{
		
	}
}
