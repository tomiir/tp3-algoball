package Vista;

import Vista.eventos.MutearDesmutearMenuEvento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MenuInanimado extends BorderPane{
	MediaPlayer mediaPlayer;
	Stage stage;
	Scene escenaJugar;
	
	public MenuInanimado(Stage stage, Scene escenaJugar){
		this.stage = stage;
		this.escenaJugar = escenaJugar;
		
		String path = getClass().getResource("mp3/Menu Principal - Opening.mp3").toString();
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.7);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
        setCentro();
        setSuperior();
	}
	
	private void setCentro(){
		this.setCenter(new OpcionesMenuPrincipal(stage, escenaJugar,mediaPlayer));
	}
	
	private void setSuperior(){
		Button botonSilenciar = new Button();
		botonSilenciar.setAlignment(Pos.TOP_RIGHT);
		Image sonido = new Image(getClass().getResource("img/speaker.png").toExternalForm());
		botonSilenciar.setGraphic(new ImageView(sonido));
		botonSilenciar.setOnAction(new MutearDesmutearMenuEvento(botonSilenciar,mediaPlayer));
		
		VBox panelHorizontal = new VBox();
		panelHorizontal.getChildren().add(botonSilenciar);
		panelHorizontal.setPadding(new Insets(5));
		panelHorizontal.setAlignment(Pos.BOTTOM_RIGHT);
		
		this.setTop(panelHorizontal);
	}
	
	
}
