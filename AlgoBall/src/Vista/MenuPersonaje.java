package Vista;


import Modelo.Personajes.Personaje;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuPersonaje extends VBox {
	
	public MenuPersonaje (Personaje personaje, VistaTablero vistaTablero){
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("menuPersonaje");
		this.setSpacing(12);
		
		NameTagPersonaje nombreDelPersonaje = new NameTagPersonaje(personaje);
		
		Button botonAtacar = new Button();
		botonAtacar.setText("Atacar");
		botonAtacar.getStyleClass().add("boton-menu");
		botonAtacar.setOnAction(new BotonAtacarControlador(personaje, vistaTablero));
		
		Button botonMover = new Button();
		botonMover.setText("Mover");
		botonMover.getStyleClass().add("boton-menu");
		botonMover.setOnAction(new BotonMoverControlador(personaje, vistaTablero));
		
		Button botonTransformar = new Button();
		botonTransformar.setText("Transformar");
		botonTransformar.getStyleClass().add("boton-menu");
		
		Label puntosDeVida = new Label();
		puntosDeVida.setText("Vida:" + personaje.puntosDeVida());
		puntosDeVida.getStyleClass().add("labels-informacion");
		
		Label puntosKi = new Label();
		puntosKi.setText("Ki:" + personaje.ki());
		puntosKi.getStyleClass().add("labels-informacion");
		
		this.getChildren().addAll(nombreDelPersonaje, puntosDeVida, puntosKi, botonAtacar, botonMover, botonTransformar);
		
		
	}
}
