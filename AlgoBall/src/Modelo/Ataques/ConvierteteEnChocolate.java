package Modelo.Ataques;

import Modelo.Partida;
import Modelo.Personajes.Personaje;

public class ConvierteteEnChocolate extends Ataque {
	Partida partida;
	public ConvierteteEnChocolate(Partida p) {
		costo = 30;
		modificadorDa�o = 0;
		partida = p;
	}
	
	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int da�oRealizado) {
		partida.paralizarPorTurnos(destinatario, 3);
	}
}
