package Modelo.Ataques;

import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int costo = 0;
	
	int modificadorDaño=100;
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcEsChocolate, ExcNumeroNegativo{
		
		int dañoActual = calcularDaño(remitente, destinatario, bonificacionPorcentual);
		int dañoRecibido;
		dañoRecibido = destinatario.recibirDaño(dañoActual);
		this.efectosColaterales(remitente, destinatario, dañoRecibido);
	}
	
	protected int calcularDaño(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		
		int daño = remitente.poderDePelea() * modificadorDaño / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			daño = daño*8/10;
		}
		return (daño*(100+bonificacionPorcentual))/100;
		
	}
	
	public int costo() {
		return this.costo;
	}
	
	private void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) throws ExcEsChocolate{
		
	}
}
