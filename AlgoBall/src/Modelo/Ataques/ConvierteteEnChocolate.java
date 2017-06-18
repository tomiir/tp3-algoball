package Modelo.Ataques;

import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Interfaces.Atacable;
import Modelo.Personajes.Personaje;

public class ConvierteteEnChocolate extends Ataque {
	
	public ConvierteteEnChocolate() {
		costo = 30;
		modificadorDaņo = 0;
		nombre = "Conviertete en Chocolate";
	}
	
	protected void efectosColaterales(Personaje remitente, Atacable destinatario, int daņoRealizado) throws ExcEsChocolate {
		destinatario.convertirEnChocolate(3);
	}
}
