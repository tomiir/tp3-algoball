package Vista;

import Modelo.Partida;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class VistaSuperior extends VBox {
	PanelDeVida panelDeVida;
	BarraDeMenu barraMenu;
	
	public VistaSuperior(Partida partida, MediaPlayer mediaPlayer, Stage stage){
		barraMenu = new BarraDeMenu(mediaPlayer,stage);
		panelDeVida = new PanelDeVida(partida);

		this.getChildren().addAll(barraMenu,panelDeVida);
		
	}
	
	public void update(){
		panelDeVida.update();
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return barraMenu;
	}

}
