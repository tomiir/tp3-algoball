package Vista;

import Vista.Interpretes.InterpretePersonaje;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

public class BarraDeVida extends StackPane{
	
	public BarraDeVida(InterpretePersonaje interprete){
		ProgressBar vida = new ProgressBar((double)interprete.vidaPorcentual()/100);
		
		if(interprete.vidaPorcentual()<30) vida.getStyleClass().add("rojo");
		else if(interprete.vidaPorcentual()<70) vida.getStyleClass().add("naranja");
		
		vida.getStyleClass().add("progress-bar");
		
		Label texto = new Label(String.valueOf(interprete.vidaActual())+"/"+String.valueOf(interprete.vidaInicial()));
		
		this.getChildren().addAll(vida, texto);
	}
	
}
