package Vista;

import Modelo.Partida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

public class PanelDeVida extends HBox{
	Partida partida;
	
	public PanelDeVida(Partida partida){
		this.partida = partida;
		this.setPadding(new Insets(2));
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		update();
	}
	
	public void update(){
		this.getChildren().clear();
		partida.iterarPersonajes((k,v)->{
			this.getChildren().add(new InfoPersonaje(v));
		});
	}
}

