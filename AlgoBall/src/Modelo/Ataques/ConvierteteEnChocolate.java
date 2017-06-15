package Modelo.Ataques;

import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Personajes.Personaje;

public class ConvierteteEnChocolate extends Ataque {
	
	public ConvierteteEnChocolate() {
		costo = 30;
		modificadorDaño = 0;
	}
	
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) throws ExcEsChocolate {
		destinatario.convertirEnChocolate(3);
	}
}
