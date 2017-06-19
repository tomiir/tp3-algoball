package Vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MostrarAcercaDeNosotrosEvento implements EventHandler<ActionEvent>{
	
    @Override
    public void handle(ActionEvent actionEvent){
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Acerca de Nosotros");
    	alert.setHeaderText("");
    	alert.setContentText("Escribir sobre nosotros");
    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
    	
    	DialogPane pane = alert.getDialogPane();
    	
    	   
    	pane.setContentText(
    				"Trabajo realizado para la materia Algoritmos y Programación 3 de la Facultad de Ingenieria de la Universidad de Buenos Aires.\n"
    	    		+ "\n"
    	    		+ "Realizado por:\n"
    	    		+"\n"
    	    		+ "Tomas Rocchi\n"
    	    		+ "Kelman Uriel\n"
    	    		+ "Cafferata Gian\n"
    	    		+ "Costa Facundo\n"
    	    		+ "");
    	
    	
    	alert.showAndWait();
    }
    
}
