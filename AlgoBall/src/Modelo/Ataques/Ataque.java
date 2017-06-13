package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int costo = 0;
	
	int modificadorDaño=100;
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcDañoNegativo{
		
		int dañoActual = calcularDaño(remitente, destinatario, bonificacionPorcentual);
		int dañoRecibido;
		try {
			dañoRecibido = destinatario.recibirDaño(dañoActual);
		} catch (ExcDañoNegativo e) {
			throw e;
		}
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
	
	protected abstract void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado);
}
