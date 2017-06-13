package Modelo.Ataques;

import Modelo.Partida;
import Modelo.Personajes.Personaje;

public class ConvierteteEnChocolate extends Ataque {
	
	public ConvierteteEnChocolate() {
		costo = 30;
		modificadorDaño = 0;
	}
	
	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) {
		destinatario.convertirEnChocolate(3);
	}
}
