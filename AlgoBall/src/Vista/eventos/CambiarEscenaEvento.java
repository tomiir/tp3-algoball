package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambiarEscenaEvento implements EventHandler<ActionEvent>{

	Stage stage;
	Scene escena;
	
	public CambiarEscenaEvento(Stage stage, Scene escena) {
		this.stage=stage;
		this.escena=escena;
	}

	@Override
	public void handle(ActionEvent event) {
		stage.setScene(escena);
	}
	
}