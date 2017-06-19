package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEvento implements EventHandler<ActionEvent>{
	MenuItem opcionPantallaCompleta;
	Stage stage;
	
	public OpcionPantallaCompletaEvento(MenuItem opcionPantallaCompleta,Stage stage){
		this.opcionPantallaCompleta = opcionPantallaCompleta;
		this.stage=stage;
	}
	@Override
	public void handle(ActionEvent actionEvent){
		if (!stage.isFullScreen()) {
	        stage.hide();
	        stage.setFullScreen(true);
	        opcionPantallaCompleta.setDisable(true);
	        stage.show();
		}
	}
}
