package Vista;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Personajes.Personaje;
import Vista.eventos.BotonPasarDeTurnoEvento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class VistaLateral extends BorderPane{
	Juego juego;
	
	public VistaLateral(Juego juego){
		this.setPadding(new Insets(5));
		this.juego = juego;
		
		this.getStyleClass().add("vista-lateral");
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		
		Button botonPasarDeTurno = new Button();
		botonPasarDeTurno.setText("Pasar de turno");
		botonPasarDeTurno.setOnAction(new BotonPasarDeTurnoEvento(this.juego, juego.partida()));
		botonPasarDeTurno.getStyleClass().add("boton-menu");
		this.setBottom(botonPasarDeTurno);
		this.setAlignment(getBottom(), Pos.CENTER);
		
		update();		
	}
	
	 public void update() {
		if(juego.partida().jugadorYaAtacoOTransformo(juego.partida().esTurnoDelJugador()) && juego.partida().jugadorYaMovio(juego.partida().esTurnoDelJugador())){
			try {
				juego.partida().avanzarTurno();
			} catch (ExcHayGanador e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setCenter(null);
		this.setTop(null);
		Label turnoDelJugador = new Label();
		turnoDelJugador.getStyleClass().add("turnoDelJugador");
		turnoDelJugador.setTextAlignment(TextAlignment.CENTER);
		Jugador jugador = juego.partida().esTurnoDelJugador();
		turnoDelJugador.setText("Le toca jugar a :\n" + jugador.nombre());
		this.setTop(turnoDelJugador);
	}
	 
	 public void personajeClickeado(Personaje personaje){
		 juego.update();
		 juego.vistaTablero().remarcarPersonaje(personaje);
		 this.setCenter(new MenuPersonaje(personaje, juego, juego.partida()));
		 
	 } 
	
}
