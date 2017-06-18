package Vista.eventos;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MostrarInstruccionesEvento implements EventHandler<ActionEvent>{
	
    @Override
    public void handle(ActionEvent actionEvent){
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Instrucciones");
    	alert.setHeaderText("Instrucciones");
    	alert.setContentText("Escribir instrucciones");
    	alert.showAndWait();
    }
}
