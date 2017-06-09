package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Personajes.Personaje;

public abstract class Ataque {

	int costo = 0;
	
	int modificadorDaño=100;
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcAtaqueImposible{
		
		int dañoActual = calcularDaño(remitente, destinatario, bonificacionPorcentual);
		
		try {
			destinatario.recibirDaño(dañoActual);
		} catch (ExcDañoNegativo e) {
			throw new ExcAtaqueImposible("No se pueden hacer daños negativos");
		}
		this.efectosColaterales(remitente, destinatario, dañoActual);
	}
	
	protected int calcularDaño(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		
		int daño = remitente.poderDePelea() * modificadorDaño / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			daño = daño*8/10;
		}
		return daño*((100+bonificacionPorcentual)/100);
		
	}
	
	public int modificadorDaño (){
		return this.modificadorDaño;
	}
	
	public int costo() {
		return this.costo;
	}
	
	protected abstract void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado);
}
