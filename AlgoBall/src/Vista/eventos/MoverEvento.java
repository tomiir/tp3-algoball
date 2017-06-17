package Vista.eventos;

import java.util.Optional;

import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcJugadorNoAutorizado;
import Modelo.Excepciones.ExcJugadorYaMovio;
import Modelo.Personajes.Personaje;
import Vista.Juego;
import Vista.VistaTablero;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

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
		try {
			partida.realizarMovimiento(partida.esTurnoDelJugador(), personaje, posicion);
		} catch (ExcFueraDeTablero e) {
			
		} catch (ExcJugadorNoAutorizado e) {
			
		} catch (ExcJugadorYaMovio e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("Error");
	    	alert.setContentText("El jugador ya gasto su movimiento");
	    	alert.showAndWait();
		} catch (ExcEsChocolate e) {

		} catch (ExcCasilleroOcupado e) {

		} catch (ExcCasilleroDesocupado e) {

		} catch (ExcFueraDeRango e) {

		}
		juego.update();
		event.consume();
	}
	
}
