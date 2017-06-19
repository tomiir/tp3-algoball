package Vista.eventos;

import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcDestinatarioEnEquipoPropio;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcJugadorNoAutorizado;
import Modelo.Excepciones.ExcJugadorYaAtacoOTransformo;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Personajes.Personaje;
import Vista.Juego;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AtacarEvento implements EventHandler<MouseEvent> {
	Personaje personaje;
	Posicion posicion;
	Partida partida;
	Juego juego;
	boolean esEspecial;
	
	public AtacarEvento(Juego juego, Personaje personaje,Posicion posicion,Partida partida, boolean esEspecial){
		this.personaje = personaje;
		this.posicion = posicion;
		this.partida = partida;
		this.juego = juego;
		this.esEspecial = esEspecial;
	}
	public void handle(MouseEvent event) {
		try {
			partida.realizarAtaque(partida.esTurnoDelJugador(),personaje, posicion, esEspecial);
			if(!juego.sonidoMuteado()){
				String path = getClass().getResource("../mp3/efectos/atacar.mp3").toString();
				if(esEspecial){
					path = getClass().getResource("../mp3/efectos/"+personaje.getAtaqueEspecial().nombre()+".mp3").toString();
				}
				
		        Media media = new Media(path);
		        MediaPlayer mediaPlayer = new MediaPlayer(media);
		        mediaPlayer.play();
		        mediaPlayer.setVolume(0.3);
			}
			juego.update();
		} catch (ExcJugadorNoAutorizado e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El jugador no esta autorizado a manejar ese personaje");
	    	alert.showAndWait();
		} catch (ExcJugadorYaAtacoOTransformo e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El jugador ya ataco o transformo.");
	    	alert.showAndWait();
		} catch (ExcFueraDeRango e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("La posicion a la que intenta atacar no esta en rango");
	    	alert.showAndWait();
		} catch (ExcFueraDeTablero e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("La posicion a la que se intenta mover no existe en el tablero");
	    	alert.showAndWait();
		} catch (ExcPersonajeMurio e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El personaje esta muerto");
	    	alert.showAndWait();
		} catch (ExcKiInsuficiente e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El ki es insuficiente");
	    	alert.showAndWait();
		} catch (ExcEsChocolate e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El personaje con el que se intenta atacar es chocolate");
	    	alert.showAndWait();
		} catch (ExcNumeroNegativo e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("No se puede realizar la accion deseada (ExcNumeroNegativo)");
	    	alert.showAndWait();
		} catch (ExcDestinatarioEnEquipoPropio e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("El personaje que intenta atacar es de tu propio equipo");
	    	alert.showAndWait();
		} catch (ExcCasilleroDesocupado e) {
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	alert.setContentText("Se intenta atacar un casillero desocupado");
	    	alert.showAndWait();
		}
	}
	
}
