package Vista.eventos;

import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;

public class SalirEventoWindowEvent implements EventHandler<WindowEvent>{

	@Override
	public void handle(WindowEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Salir");
    	alert.setHeaderText("Salir");
    	alert.setContentText("Seguro que desea salir?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		System.exit(0);
    	} else {
    		event.consume();
    	}
	}

}
