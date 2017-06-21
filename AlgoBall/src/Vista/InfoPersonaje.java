package Vista;

import Modelo.Personajes.Personaje;
import Vista.Interpretes.InterpretePersonaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class InfoPersonaje extends VBox {
	
	public InfoPersonaje(Personaje personaje){
		this.setPadding(new Insets(0));
		this.setSpacing(0);
		this.getStyleClass().add("info-personaje");
		this.setAlignment(Pos.CENTER);
		InterpretePersonaje interprete = new InterpretePersonaje(personaje);
		
		BarraDeVida barraVida = new BarraDeVida(interprete);
		
		NameTagPersonaje nameTag = new NameTagPersonaje(interprete);
		
		this.getChildren().addAll(nameTag, barraVida);
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
}
