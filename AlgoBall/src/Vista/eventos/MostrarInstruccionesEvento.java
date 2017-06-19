package Vista.eventos;

import Vista.VistaInstrucciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MostrarInstruccionesEvento implements EventHandler<ActionEvent>{
	
    @Override
    public void handle(ActionEvent actionEvent){
    	Stage instrucciones = new Stage();
        instrucciones.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
    	instrucciones.setTitle("Instrucciones");
    	VistaInstrucciones vistaInstrucciones = new VistaInstrucciones();
    	Scene escena = new Scene(vistaInstrucciones,800,600);
    	instrucciones.setScene(escena);
    	instrucciones.show();
    }
}
