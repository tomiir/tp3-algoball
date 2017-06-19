package Vista;

import java.util.Optional;

import Modelo.Jugador;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Personajes.Personaje;
import Vista.eventos.BotonPasarDeTurnoEvento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

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
		VistaLateral.setAlignment(getBottom(), Pos.CENTER);
		
		update();		
	}
	
	 public void update() {
		if(juego.partida().jugadorYaAtacoOTransformo(juego.partida().esTurnoDelJugador()) && juego.partida().jugadorYaMovio(juego.partida().esTurnoDelJugador())){
			try {
				juego.partida().avanzarTurno();
			} catch (ExcHayGanador e) {
				Alert ganador = new Alert(AlertType.INFORMATION);
		    	ganador.setTitle("Partida terminada");
		    	ganador.setHeaderText("Hay ganador");
		    	Stage stage2 = (Stage) ganador.getDialogPane().getScene().getWindow();
		    	stage2.getIcons().add(new Image(getClass().getResourceAsStream("img/icon.png")));
		    	ganador.setContentText("Gano el jugador: "+ e.ganador().nombre()
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
