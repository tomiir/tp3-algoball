package Vista;

import Vista.eventos.CambiarEscenaEvento;
import Vista.eventos.MostrarInstruccionesEvento;
import Vista.eventos.SalirEventoOnAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MenuPrincipal extends VBox {
	
	public MenuPrincipal(Stage stage, Scene escenaJugar){
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("ventana-menu");
		
		Label cartel= new Label();
		cartel.setText("AlgoBall");
		cartel.getStyleClass().add("titulo-algoball");
		cartel.setTextAlignment(TextAlignment.CENTER);
		
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");
		botonJugar.getStyleClass().add("boton-menu");
		botonJugar.setOnAction(new CambiarEscenaEvento(stage, escenaJugar));
		
		Button botonInstrucciones = new Button();
		botonInstrucciones.setText("Instrucciones");
		botonInstrucciones.getStyleClass().add("boton-menu");
		botonInstrucciones.setOnAction(new MostrarInstruccionesEvento());
		
		Button botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.getStyleClass().add("boton-menu");
		botonSalir.setOnAction(new SalirEventoOnAction());
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
		
		this.getChildren().addAll(cartel, botonJugar, botonInstrucciones, botonSalir);
	}
}
