package Vista;

import Modelo.Personajes.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarControlador implements EventHandler<ActionEvent> {
	Personaje personaje;
	VistaTablero vistaTablero;
	boolean esEspecial;
		
	public BotonAtacarControlador(Personaje personaje, VistaTablero vistaTablero, boolean esEspecial) {
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
