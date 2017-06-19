package Vista.eventos;

import com.sun.glass.ui.MenuItem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;

public class MostrarAcercaDeNosotrosEvento implements EventHandler<ActionEvent>{
	
    @Override
    public void handle(ActionEvent actionEvent){
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Acerca de Nosotros");
    	alert.setHeaderText("Acerca de Nosotros");
    	alert.setContentText("Escribir sobre nosotros");
    	alert.showAndWait();
    }
    
}
