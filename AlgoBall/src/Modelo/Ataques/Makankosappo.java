package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class Makankosappo extends Ataque {
	
	public Makankosappo (){
		costo = 10;
		modificadorDaño = 125;
	}
	
	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) {
	}

}
