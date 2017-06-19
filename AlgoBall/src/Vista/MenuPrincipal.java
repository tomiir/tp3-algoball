package Vista;

import Vista.eventos.MutearDesmutearEvento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MenuPrincipal extends BorderPane{
	MediaPlayer mediaPlayer;
	Stage stage;
	Scene escenaJugar;
	
	public MenuPrincipal(Stage stage, Scene escenaJugar){
		this.stage = stage;
		this.escenaJugar = escenaJugar;
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		this.getStyleClass().add("ventana-menu");
		
		String path = getClass().getResource("mp3/Menu Principal - Opening.mp3").toString();
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
        setCentro(mediaPlayer);
        setSuperior();
	}
	
	private void setCentro(MediaPlayer mediaPlayer){
		this.setCenter(new OpcionesMenuPrincipal(stage, escenaJugar,mediaPlayer));
	}
	
	private void setSuperior(){
		Button botonSilenciar = new Button();
		botonSilenciar.setAlignment(Pos.TOP_RIGHT);
		Image sonido = new Image(getClass().getResource("img/speaker.png").toExternalForm());
		botonSilenciar.setGraphic(new ImageView(sonido));
		botonSilenciar.setOnAction(new MutearDesmutearEvento(botonSilenciar,mediaPlayer));
		
		VBox panelHorizontal = new VBox();
		panelHorizontal.getChildren().add(botonSilenciar);
		panelHorizontal.setPadding(new Insets(5));
		panelHorizontal.setAlignment(Pos.BOTTOM_RIGHT);
		
		this.setTop(panelHorizontal);
	}
	
	
}
