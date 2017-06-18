package Vista.eventos;

import Modelo.Personajes.Personaje;
import Vista.VistaLateral;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PersonajePresionadoMouseEvent implements EventHandler<MouseEvent> {
	VistaLateral vistaLateral;
	Personaje personaje;
	
	public PersonajePresionadoMouseEvent(Personaje personaje, VistaLateral vistaLateral){
		this.vistaLateral = vistaLateral;
		this.personaje = personaje;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		vistaLateral.personajeClickeado(personaje);
	}

}
