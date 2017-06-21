package Vista;

import Vista.Interpretes.InterpretePersonaje;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

public class NameTagPersonaje extends HBox{
	
	public NameTagPersonaje(InterpretePersonaje interprete){
		this.setSpacing(5);
		
		Image cara;
		if (interprete.estaMuerto()){
			cara = new Image(getClass().getResource("img/personajes/"+interprete.nombre()+"/"+"cara"+interprete.nombre()+"_"+interprete.estado()+"_muerto.png").toExternalForm());
		}else if(interprete.esChocolate()){
			cara = new Image(getClass().getResource("img/personajes/cara_chocolate.png").toExternalForm());
		} else if(interprete.vidaPorcentual()<30){
			cara = new Image(getClass().getResource("img/personajes/"+interprete.nombre()+"/"+"cara"+interprete.nombre()+"_"+interprete.estado()+"_herido.png").toExternalForm());
		} else {
			cara = new Image(getClass().getResource("img/personajes/"+interprete.nombre()+"/"+"cara"+interprete.nombre()+"_"+interprete.estado()+".png").toExternalForm());
		}
		ImageView caraImView = new ImageView();
		caraImView.setImage(cara);
		caraImView.getStyleClass().add("cara-personaje");
        
		Label nombre= new Label();
		nombre.setText(interprete.nombre());
		nombre.getStyleClass().add("nombre-personaje");
		nombre.setTextAlignment(TextAlignment.CENTER);
		this.getChildren().addAll(caraImView, nombre);
	}
	
}
