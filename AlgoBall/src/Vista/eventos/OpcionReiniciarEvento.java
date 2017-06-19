package Vista.eventos;

import java.util.Optional;

import Modelo.Partida;
import Modelo.Excepciones.ExcHayGanador;
import Vista.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class OpcionReiniciarEvento implements EventHandler<ActionEvent> {
	Juego juego;
	
	public OpcionReiniciarEvento(Juego juego){
		this.juego = juego;
	}
		
	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Reiniciar");
    	alert.setHeaderText("");
    	alert.setContentText("¿Esta seguro que desea reiniciar el juego? Perderá todo lo jugado hasta el momento ");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    			juego.iniciarModelo();
    			juego.update();
    	}
	}
	
}