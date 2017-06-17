package Vista;

import Modelo.Personajes.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverControlador implements EventHandler<ActionEvent> {
	VistaTablero vistaTablero;
	Personaje personaje;
	
	public BotonMoverControlador(Personaje personaje, VistaTablero vistaTablero) {
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
