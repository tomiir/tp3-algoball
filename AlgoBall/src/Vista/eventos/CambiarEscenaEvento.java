package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class CambiarEscenaEvento implements EventHandler<ActionEvent>{

	Stage stage;
	Scene escena;
	MediaPlayer mediaPlayer;
	
	public CambiarEscenaEvento(Stage stage, Scene escena, MediaPlayer mediaPlayer) {
		this.stage=stage;
		this.escena=escena;
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public void handle(ActionEvent event) {
		if (mediaPlayer != null) mediaPlayer.stop();
		stage.setScene(escena);
	}
	
}