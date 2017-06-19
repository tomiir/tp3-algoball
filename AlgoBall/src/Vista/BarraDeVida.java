package Vista;

import Modelo.Personajes.Personaje;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

public class BarraDeVida extends StackPane{
	Personaje personaje;
	
	public BarraDeVida(Personaje personaje){
		this.personaje = personaje;
		ProgressBar vida = new ProgressBar((double)personaje.vidaPorcentual()/100);
		if(personaje.vidaPorcentual()<30) vida.getStyleClass().add("rojo");
		else if(personaje.vidaPorcentual()<70) vida.getStyleClass().add("naranja");
		vida.getStyleClass().add("progress-bar");
		
		Label texto = new Label(String.valueOf(personaje.puntosDeVida())+"/"+String.valueOf(personaje.vidaInicial()));
		
		this.getChildren().addAll(vida, texto);
	}
	
}
