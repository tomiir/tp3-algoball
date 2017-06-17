package Vista;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Personajes.Personaje;
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
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		
		update();		
	}
	
	 public void update(){
		this.getChildren().clear();
		Label turnoDelJugador = new Label();
		turnoDelJugador.getStyleClass().add("turnoDelJugador");
		turnoDelJugador.setTextAlignment(TextAlignment.CENTER);
		Jugador jugador = partida.esTurnoDelJugador();
		turnoDelJugador.setText("Le toca jugar a :\n" + jugador.nombre());
		this.getChildren().add(turnoDelJugador);
	}
	 
	 public void personajeClickeado(Personaje personaje){
		 this.vistaTablero.remarcarPersonaje(personaje);
		 update();
		 this.getChildren().add(new MenuPersonaje(personaje, vistaTablero));		 
		 
	 }
	 
	public void setVistaTablero(VistaTablero vista){
		this.vistaTablero = vista;
	}
	
	
}
