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

public class BotonPasarDeTurnoEvento implements EventHandler<ActionEvent> {
	Partida partida;
	Juego juego;
	
	public BotonPasarDeTurnoEvento(Juego juego, Partida partida){
		this.partida = partida;
		this.juego = juego;
	}
		
	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Pasar turno");
    	alert.setHeaderText("");
    	alert.setContentText("¿Seguro que desea saltear su turno? Aún puede realizar acciones");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		try {
				this.partida.avanzarTurno();
				juego.update();
			} catch (ExcHayGanador e) {
				Alert ganador = new Alert(AlertType.INFORMATION);
		    	ganador.setTitle("Partida terminada");
		    	ganador.setHeaderText("Hay ganador");
		    	ganador.setContentText("Gano el jugador:"+e.ganador().nombre());
		    	ganador.showAndWait();
		    	System.exit(0);
			}  		
    		
    	}
	}
	
}
