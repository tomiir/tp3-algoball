package Vista;


import Modelo.Personajes.Personaje;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuPersonaje extends VBox {
	
	public MenuPersonaje (Personaje personaje){
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("menuPersonaje");
		this.setSpacing(20);
		
		NameTagPersonaje nombreDelPersonaje = new NameTagPersonaje(personaje);
		
		Button botonAtacar = new Button();
		botonAtacar.setText("Atacar");
		botonAtacar.getStyleClass().add("boton-menu");
		
		Button botonMover = new Button();
		botonMover.setText("Mover");
		botonMover.getStyleClass().add("boton-menu");
		
		this.getChildren().addAll(nombreDelPersonaje, botonAtacar, botonMover);
		
		
	}
}
