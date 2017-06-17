package Vista;

import java.util.Optional;

import Modelo.Partida;
import Modelo.Excepciones.ExcHayGanador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class BotonPasarDeTurnoControlador implements EventHandler<ActionEvent> {
	Partida partida;
	Juego juego;
	
	public BotonPasarDeTurnoControlador(Juego juego, Partida partida){
		this.partida = partida;
		this.juego = juego;
	}
		
	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Pasar turno");
    	//alert.setHeaderText(");
    	alert.setContentText("Seguro que desea saltear su turno? Aun puede realizar acciones");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		try {
				this.partida.avanzarTurno();
				juego.update();
			} catch (ExcHayGanador e) {}  		
    		
    	}
	}
	
}
