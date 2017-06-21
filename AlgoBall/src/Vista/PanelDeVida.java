package Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PanelDeVida extends HBox{
	Juego juego;
	
	public PanelDeVida(Juego juego){
		this.juego = juego;
		this.setPadding(new Insets(2));
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		update();
	}
	
	public void update(){
		this.getChildren().clear();
		juego.partida().iterarPersonajes(v->{
			this.getChildren().add(new InfoPersonaje(v));
		});
	}
}

