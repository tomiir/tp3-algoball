package Vista.eventos;

import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcJugadorNoAutorizado;
import Modelo.Excepciones.ExcJugadorYaMovio;
import Modelo.Personajes.Personaje;
import Vista.Juego;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MoverEvento implements EventHandler<MouseEvent> {
	Personaje personaje;
	Posicion posicion;
	Partida partida;
	Juego juego;
	
	public MoverEvento(Juego juego, Personaje personaje,Posicion posicion,Partida partida){
		this.personaje = personaje;
		this.posicion = posicion;
		this.partida = partida;
		this.juego = juego;
	}
	public void handle(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("Error");
    	alert.setHeaderText("");
    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
		try {
			partida.realizarMovimiento(partida.esTurnoDelJugador(), personaje, posicion);
			if(!juego.sonidoMuteado()){
				String path = getClass().getResource("../mp3/efectos/mover.mp3").toString();
		        Media media = new Media(path);
		        MediaPlayer mediaPlayer = new MediaPlayer(media);
		        mediaPlayer.setVolume(0.3);
		        mediaPlayer.play();
			}
			juego.update();
		} catch (ExcFueraDeTablero e) {
	    	alert.setContentText("La posicion a la que se intenta mover no existe en el tablero");
	    	alert.showAndWait();
		} catch (ExcJugadorNoAutorizado e) {
	    	alert.setContentText("El jugador no puede mover a ese personaje, no le pertenece.");
	    	alert.showAndWait();
		} catch (ExcJugadorYaMovio e) {
	    	alert.setContentText("El jugador ya gasto su movimiento");
	    	alert.showAndWait();
		} catch (ExcEsChocolate e) {
	    	alert.setContentText("El personaje es de chocolate, no se puede mover");
	    	alert.showAndWait();
		} catch (ExcCasilleroOcupado e) {
	    	alert.setContentText("El casillero al que intenta moverse esta ocupado");
	    	alert.showAndWait();
		} catch (ExcFueraDeRango e) {
	    	alert.setContentText("El personaje esta fuera del rango de ese casillero");
	    	alert.showAndWait();
		}
		event.consume();
	}
	
}
