package Vista;

import Modelo.Personajes.Personaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class InfoPersonaje extends VBox {
	
	public InfoPersonaje(Personaje personaje){
		this.setPadding(new Insets(0));
		this.setSpacing(0);
		this.getStyleClass().add("info-personaje");
		this.setAlignment(Pos.CENTER);
		
		
		BarraDeVida barraVida =new BarraDeVida(personaje);
		
		NameTagPersonaje nameTag = new NameTagPersonaje(personaje);
		
		this.getChildren().addAll(nameTag, barraVida);
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
}
