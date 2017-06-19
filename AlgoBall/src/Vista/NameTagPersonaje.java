package Vista;

import Modelo.Personajes.Personaje;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

public class NameTagPersonaje extends HBox{
	
	public NameTagPersonaje(Personaje personaje){
		this.setSpacing(5);
		
		Image cara;
		if (personaje.estaMuerto()){
			cara = new Image(getClass().getResource("img/personajes/"+personaje.nombre()+"/"+"cara"+personaje.nombre()+"_"+personaje.forma()+"_muerto.png").toExternalForm());
		}else if(personaje.esChocolate()){
			cara = new Image(getClass().getResource("img/personajes/cara_chocolate.png").toExternalForm());
		} else if(personaje.vidaPorcentual()<30){
			cara = new Image(getClass().getResource("img/personajes/"+personaje.nombre()+"/"+"cara"+personaje.nombre()+"_"+personaje.forma()+"_herido.png").toExternalForm());
		} else {
			cara = new Image(getClass().getResource("img/personajes/"+personaje.nombre()+"/"+"cara"+personaje.nombre()+"_"+personaje.forma()+".png").toExternalForm());
		}
		ImageView caraImView = new ImageView();
		caraImView.setImage(cara);
		caraImView.getStyleClass().add("cara-personaje");
        
		Label nombre= new Label();
		nombre.setText(personaje.nombre());
		nombre.getStyleClass().add("nombre-personaje");
		nombre.setTextAlignment(TextAlignment.CENTER);
		this.getChildren().addAll(caraImView, nombre);
	}
	
}
