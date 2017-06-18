package Vista;

import Modelo.Equipo;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Personajes.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonTransformarControlador implements EventHandler<ActionEvent> {
	Personaje personaje;
	Equipo equipo;
	Juego juego;
	
	public BotonTransformarControlador(Personaje personaje, Equipo equipo, Juego juego){
		this.personaje = personaje;
		this.equipo = equipo;
		this.juego = juego;
		
	}
	@Override
	public void handle(ActionEvent event) {
		try {
			personaje.transformar(this.equipo);
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