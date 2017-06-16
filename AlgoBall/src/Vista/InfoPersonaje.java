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
		
		Label cartel= new Label();
		cartel.setText(personaje.nombre());
		cartel.getStyleClass().add("nombre-personaje");
		cartel.setTextAlignment(TextAlignment.CENTER);
		
		ProgressBar vida = new ProgressBar((double)personaje.vidaPorcentual()/100);
		
		vida.getStyleClass().add("progress-bar");
		
		this.getChildren().addAll(cartel, vida);
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
}
