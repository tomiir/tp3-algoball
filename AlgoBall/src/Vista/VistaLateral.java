package Vista;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Personajes.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class VistaLateral extends BorderPane{
	Partida partida;
	Juego juego;
	
	public VistaLateral(Partida partida, Juego juego){
		this.setPadding(new Insets(5));
		this.partida = partida;
		this.juego = juego;
		
		this.getStyleClass().add("vista-lateral");
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		
		Button botonPasarDeTurno = new Button();
		botonPasarDeTurno.setText("Pasar de turno");
		botonPasarDeTurno.setOnAction(new BotonPasarDeTurnoControlador(this.juego, this.partida));
		botonPasarDeTurno.getStyleClass().add("boton-menu");
		this.setBottom(botonPasarDeTurno);
		
		update();		
	}
	
	 public void update(){
		this.setCenter(null);
		this.setTop(null);
		Label turnoDelJugador = new Label();
		turnoDelJugador.getStyleClass().add("turnoDelJugador");
		turnoDelJugador.setTextAlignment(TextAlignment.CENTER);
		Jugador jugador = partida.esTurnoDelJugador();
		turnoDelJugador.setText("Le toca jugar a :\n" + jugador.nombre());
		this.setTop(turnoDelJugador);
	}
	 
	 public void personajeClickeado(Personaje personaje){
		 juego.update();
		 juego.vistaTablero().remarcarPersonaje(personaje);
		 this.setCenter(new MenuPersonaje(personaje, juego.vistaTablero));
		 
	 } 
	
}
