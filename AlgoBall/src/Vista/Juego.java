package Vista;

import Modelo.Partida;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Juego extends BorderPane{
	Partida partida;
	
	public Juego(Stage stage, Partida partida){
		this.partida = partida;
		setSuperior();
	}
	
	private void setSuperior(){
		this.setTop(new PanelDeVida(partida));
	}
}
