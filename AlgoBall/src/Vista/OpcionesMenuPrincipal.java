package Vista;

import Vista.eventos.CambiarEscenaEvento;
import Vista.eventos.MostrarInstruccionesEvento;
import Vista.eventos.SalirEventoOnAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class OpcionesMenuPrincipal extends VBox {
	
	public OpcionesMenuPrincipal(Stage stage, Scene escenaJugar, MediaPlayer mediaPlayer){
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		
		
		Image logo = new Image(getClass().getResource("img/logo.png").toExternalForm());
		ImageView vistaLogo = new ImageView(logo);
		
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");
		botonJugar.getStyleClass().add("boton-menu");
		botonJugar.setOnAction(new CambiarEscenaEvento(stage, escenaJugar, mediaPlayer));
		
		Button botonInstrucciones = new Button();
		botonInstrucciones.setText("Instrucciones");
		botonInstrucciones.getStyleClass().add("boton-menu");
		botonInstrucciones.setOnAction(new MostrarInstruccionesEvento());
		
		Button botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.getStyleClass().add("boton-menu");
		botonSalir.setOnAction(new SalirEventoOnAction());
		
		this.getChildren().addAll(vistaLogo, botonJugar, botonInstrucciones, botonSalir);
	}
}
