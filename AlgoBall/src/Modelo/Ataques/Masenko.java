package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class Masenko extends Ataque {
	
	public Masenko (){
		costo = 10;
		modificadorDaño = 125;
	}

	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) {
	}
	
}
