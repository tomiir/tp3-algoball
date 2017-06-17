package Vista;

import Modelo.Personajes.Personaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class InfoPersonaje extends VBox {
	
	public InfoPersonaje(Personaje personaje){
		this.setPadding(new Insets(0));
		this.setSpacing(0);
		this.getStyleClass().add("info-personaje");
		this.setAlignment(Pos.CENTER);
		
		
		ProgressBar vida = new ProgressBar((double)personaje.vidaPorcentual()/100);
		if(personaje.vidaPorcentual()<30) vida.getStyleClass().add("rojo");
		vida.getStyleClass().add("progress-bar");
		
		NameTagPersonaje nameTag = new NameTagPersonaje(personaje);
		
		this.getChildren().addAll(nameTag, vida);
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
}
