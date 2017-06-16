package Vista.eventos;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class SalirEventoOnAction implements EventHandler<ActionEvent>{
	
    @Override
    public void handle(ActionEvent actionEvent){
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Salir");
    	alert.setHeaderText("Salir");
    	alert.setContentText("Seguro que desea salir?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		System.exit(0);
    	} else {
    		
    	}
    }
}
