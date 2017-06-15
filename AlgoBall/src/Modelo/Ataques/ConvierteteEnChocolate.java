package Modelo.Ataques;

import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Personajes.Personaje;

public class ConvierteteEnChocolate extends Ataque {
	
	public ConvierteteEnChocolate() {
		costo = 30;
		modificadorDaņo = 0;
	}
	
	private void efectosColaterales(Personaje remitente, Personaje destinatario, int daņoRealizado) throws ExcEsChocolate {
		destinatario.convertirEnChocolate(3);
	}
}
