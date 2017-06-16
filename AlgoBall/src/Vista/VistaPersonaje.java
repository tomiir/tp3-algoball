package Vista;

import Modelo.Personajes.Personaje;
import javafx.scene.layout.HBox;

public class VistaPersonaje extends HBox{
	public VistaPersonaje(Personaje personaje, int pixelesAncho, int pixelesAlto){
		this.setMaxSize(pixelesAncho, pixelesAlto);
		this.getStyleClass().add("personaje");
		String imagen = getClass().getResource(personaje.nombre()+".png").toExternalForm();
		this.setStyle("-fx-background-image: url('" + imagen + "'); ");
	}
}