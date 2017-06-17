package Vista;

import Modelo.Jugador;
import Modelo.Partida;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class VistaLateral extends VBox {
	Partida partida;
	VistaTablero vistaTablero;
	
	public VistaLateral(Partida partida){
		this.setPadding(new Insets(5));
		this.setSpacing(20);
		this.partida = partida;
		
		Label turnoDelJugador = new Label();
		turnoDelJugador.setText("¡Empieza el juego!");
		turnoDelJugador.getStyleClass().add("turnoDelJugador");
		turnoDelJugador.setTextAlignment(TextAlignment.CENTER);
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		
		update(turnoDelJugador);		
		
		this.getChildren().addAll(turnoDelJugador);
	}
	
	 public void update(Label turnoDelJugador){
		Jugador jugador = partida.esTurnoDelJugador();
		turnoDelJugador.setText("Le toca jugar a :\n" + jugador.nombre());
		
		
	}
	 
	 public void personajeClickeado(Personaje personaje){
		 
	 }
	 
	public void setVistaTablero(VistaTablero vista){
		this.vistaTablero = vista;
	}
	
	
}
