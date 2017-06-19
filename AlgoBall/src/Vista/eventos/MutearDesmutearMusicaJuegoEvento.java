package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;

public class MutearDesmutearMusicaJuegoEvento implements EventHandler<ActionEvent>{
	MediaPlayer mediaPlayer;
	MenuItem opcionMutearDesmutear;
		
	public MutearDesmutearMusicaJuegoEvento(MenuItem opcionMutearDesmutear, MediaPlayer mediaPlayer){
		this.mediaPlayer = mediaPlayer;
		this.opcionMutearDesmutear = opcionMutearDesmutear;
	}
		
	@Override
	public void handle(ActionEvent actionEvent){
	    if(!mediaPlayer.isMute()){
			mediaPlayer.setMute(true);
			opcionMutearDesmutear.setText("Desmutear música");	
		}else {
			mediaPlayer.setMute(false);
			opcionMutearDesmutear.setText("Mutear música");
	}
}

}
