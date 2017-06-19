package Vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

public class MutearDesmutearEvento implements EventHandler<ActionEvent>{
	MediaPlayer mediaPlayer;
	Button boton;
	
	public MutearDesmutearEvento(Button boton,MediaPlayer mediaPlayer){
		this.mediaPlayer = mediaPlayer;
		this.boton = boton;
	}
	
    @Override
    public void handle(ActionEvent actionEvent){
    	if(!mediaPlayer.isMute()){
			mediaPlayer.setMute(true);
			Image sonido = new Image(getClass().getResource("../img/speaker_mute.png").toExternalForm());
			boton.setGraphic(new ImageView(sonido));
		}else {
			mediaPlayer.setMute(false);
			Image sonido = new Image(getClass().getResource("../img/speaker.png").toExternalForm());
			boton.setGraphic(new ImageView(sonido));
		}

    }
}
