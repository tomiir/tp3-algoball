package Vista;

import Vista.interfaces.Responsivo;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MenuPrincipal extends StackPane implements Responsivo{
	MediaView mediaView;
	Stage stage;
	
	public MenuPrincipal(Stage stage, Scene escenaJugar){
		this.stage = stage;
		String path = getClass().getResource("video/video_background.flv").toString();
        Media media = new Media(path);
        MediaPlayer video = new MediaPlayer(media);
       	video.setCycleCount(MediaPlayer.INDEFINITE);
        video.setAutoPlay(true);
        video.setMute(true);
        mediaView = new MediaView(video);
        this.getStyleClass().add("ventana-menu");
        
        MenuInanimado menuInanimado = new MenuInanimado(stage, escenaJugar);
        
        this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		this.getChildren().addAll(mediaView, menuInanimado);
	}

	public void cambiarDimension() {
		mediaView.setFitHeight(stage.getHeight()-45);
	}
}
