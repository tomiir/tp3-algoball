package Vista.eventos;

import Modelo.Personajes.Personaje;
import Vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarEvento implements EventHandler<ActionEvent> {
	Personaje personaje;
	VistaTablero vistaTablero;
	boolean esEspecial;
		
	public BotonAtacarEvento(Personaje personaje, VistaTablero vistaTablero, boolean esEspecial) {
		this.personaje = personaje;
		this.vistaTablero = vistaTablero;
		this.esEspecial = esEspecial;
	}

	@Override
	public void handle(ActionEvent event) {
		this.vistaTablero.update();
		vistaTablero.remarcarPersonaje(personaje);
		this.vistaTablero.ofrecerAtaque(personaje, esEspecial);
		
	}
	
	

}
