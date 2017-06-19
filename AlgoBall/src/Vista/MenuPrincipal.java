package Vista;

import Vista.eventos.CambiarEscenaEvento;
import Vista.eventos.MostrarInstruccionesEvento;
import Vista.eventos.MutearDesmutearEvento;
import Vista.eventos.SalirEventoOnAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MenuPrincipal extends VBox {
	
	public MenuPrincipal(Stage stage, Scene escenaJugar){
		String path = getClass().getResource("mp3/Menu Principal - Opening.mp3").toString();
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.setAutoPlay(true);
        		
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("ventana-menu");
		
		Image logo = new Image(getClass().getResource("img/logo.png").toExternalForm());
		ImageView vistaLogo = new ImageView(logo);
		
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");
		botonJugar.getStyleClass().add("boton-menu");
		botonJugar.setOnAction(new CambiarEscenaEvento(stage, escenaJugar, mediaPlayer));
		
		Button botonInstrucciones = new Button();
		botonInstrucciones.setText("Instrucciones");
		botonInstrucciones.getStyleClass().add("boton-menu");
		botonInstrucciones.setOnAction(new MostrarInstruccionesEvento());
		
		Button botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.getStyleClass().add("boton-menu");
		botonSalir.setOnAction(new SalirEventoOnAction());
		
		Button botonSilenciar = new Button();
		botonSilenciar.setAlignment(Pos.TOP_RIGHT);
		Image sonido = new Image(getClass().getResource("img/speaker.png").toExternalForm());
		botonSilenciar.setGraphic(new ImageView(sonido));
		botonSilenciar.setOnAction(new MutearDesmutearEvento(botonSilenciar,mediaPlayer));
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		
		this.getChildren().addAll(vistaLogo, botonJugar, botonInstrucciones, botonSalir, botonSilenciar);
	}
}
