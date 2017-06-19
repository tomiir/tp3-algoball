package Vista.eventos;

import Modelo.Equipo;
import Modelo.Partida;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcJugadorYaAtacoOTransformo;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Personajes.Personaje;
import Vista.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonTransformarEvento implements EventHandler<ActionEvent> {
	Personaje personaje;
	Equipo equipo;
	Juego juego;
	
	public BotonTransformarEvento(Personaje personaje, Equipo equipo, Juego juego){
		this.personaje = personaje;
		this.equipo = equipo;
		this.juego = juego;
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		try {
			Partida partida = juego.partida();
			try {
				partida.realizarTransformacion(partida.esTurnoDelJugador(), personaje);
			} catch (ExcJugadorYaAtacoOTransformo e) {
				
			}
			juego.update();
		} catch (ExcNoEsPosibleTransformarse e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("Error");
	    	alert.setContentText("El personaje no se puede transformar");
	    	alert.showAndWait();
		} catch (ExcEsChocolate e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("Error");
	    	alert.setContentText("El personaje es chocolate");
	    	alert.showAndWait();
		}
		
		
	}
	
	
	
}
