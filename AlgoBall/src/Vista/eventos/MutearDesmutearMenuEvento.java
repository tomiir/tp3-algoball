package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

public class MutearDesmutearMenuEvento implements EventHandler<ActionEvent>{
	MediaPlayer mediaPlayer;
	MenuItem opcionMutearDesmutear;
		
	public MutearDesmutearMenuEvento(MenuItem opcionMutearDesmutear, MediaPlayer mediaPlayer){
		this.mediaPlayer = mediaPlayer;
		this.opcionMutearDesmutear = opcionMutearDesmutear;
	}
		
	@Override
	public void handle(ActionEvent actionEvent){
	    if(!mediaPlayer.isMute()){
			mediaPlayer.setMute(true);
			opcionMutearDesmutear.setText("Desmutear");	
		}else {
			mediaPlayer.setMute(false);
			opcionMutearDesmutear.setText("Mutear");
	}
}

}
