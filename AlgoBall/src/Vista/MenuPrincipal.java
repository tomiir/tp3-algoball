package Vista;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MenuPrincipal extends StackPane{
	public MenuPrincipal(Stage stage, Scene escenaJugar){
		String path = getClass().getResource("video/video_background.flv").toString();
        Media media = new Media(path);
        MediaPlayer video = new MediaPlayer(media);
       	video.setCycleCount(MediaPlayer.INDEFINITE);
        video.setAutoPlay(true);
        video.setMute(true);
        MediaView mediaView = new MediaView(video);
        mediaView.setFitHeight(600);
        mediaView.setFitWidth(800);
        this.getStyleClass().add("ventana-menu");
        
        MenuInanimado menuInanimado = new MenuInanimado(stage, escenaJugar);
        
        this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		this.getChildren().addAll(mediaView, menuInanimado);
	}
}
