package Vista.eventos;

import Modelo.Personajes.Personaje;
import Vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverEvento implements EventHandler<ActionEvent> {
	VistaTablero vistaTablero;
	Personaje personaje;
	
	public BotonMoverEvento(Personaje personaje, VistaTablero vistaTablero) {
		this.personaje = personaje;
		this.vistaTablero = vistaTablero;
	}
	
	@Override
	public void handle(ActionEvent event) {
		vistaTablero.update();
		vistaTablero.remarcarPersonaje(personaje);
		this.vistaTablero.ofrecerMovimiento(personaje);
			
	}

}
