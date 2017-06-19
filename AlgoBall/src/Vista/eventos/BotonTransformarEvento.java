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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
			Partida partida = juego.partida();
		try {
			partida.realizarTransformacion(partida.esTurnoDelJugador(), personaje);
			juego.update();
			if(!juego.sonidoMuteado()){
			String path = getClass().getResource("../mp3/efectos/transformar.wav").toString();
			    Media media = new Media(path);
			    MediaPlayer mediaPlayer = new MediaPlayer(media);
			    mediaPlayer.play();
			}
		} catch (ExcJugadorYaAtacoOTransformo e) {
			
		} catch (ExcNoEsPosibleTransformarse e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El personaje no se puede transformar");
	    	alert.showAndWait();
		} catch (ExcEsChocolate e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El personaje es chocolate");
	    	alert.showAndWait();
		}
	}

}
