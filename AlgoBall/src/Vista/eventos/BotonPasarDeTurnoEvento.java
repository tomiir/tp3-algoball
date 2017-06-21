package Vista.eventos;

import java.util.Optional;

import Modelo.Excepciones.ExcHayGanador;
import Vista.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class BotonPasarDeTurnoEvento implements EventHandler<ActionEvent> {
	Juego juego;
	
	public BotonPasarDeTurnoEvento(Juego juego){
		this.juego = juego;
	}
		
	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Pasar turno");
    	alert.setHeaderText("");
    	alert.setContentText("¿Seguro que desea saltear su turno? Aún puede realizar acciones");
    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		try {
				juego.partida().avanzarTurno();
				juego.update();
			} catch (ExcHayGanador e) {
				Alert ganador = new Alert(AlertType.INFORMATION);
		    	ganador.setTitle("Partida terminada");
		    	ganador.setHeaderText("Hay ganador");
		    	Stage stage2 = (Stage) ganador.getDialogPane().getScene().getWindow();
		    	stage2.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
		    	ganador.setContentText("Gano el jugador: "+e.ganador().nombre()
		    			+"\n"
		    			+"Si desea reiniciar el juego, e iniciar una partida pulse SI, en canso contrario pulse Salir"
		    			);
		    	
		    	
		    	ButtonType botonSi = new ButtonType("Si");
		    	ButtonType botonSalir = new ButtonType("Salir");
		    	ganador.getButtonTypes().setAll(botonSalir,botonSi);
		    	Optional<ButtonType> result_2 = ganador.showAndWait();
		    	if (result_2.get() == botonSi){
		    		juego.iniciarModelo();
		    		juego.update();
		    	}else {
		    		System.exit(0);
		    	}
			}  		
    		
    	}
	}
	
}
