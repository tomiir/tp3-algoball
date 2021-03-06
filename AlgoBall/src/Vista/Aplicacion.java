package Vista;

import Vista.eventos.AplicacionOnKeyPressedEvento;
import Vista.eventos.SalirEventoWindowEvent;
import Vista.eventos.cambiaDimension;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
    	
        stage.setTitle("DragonAlgoBall");
        stage.setOnCloseRequest(new SalirEventoWindowEvent());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/icon.png")));
        
        Juego vistaJugar = new Juego(stage);
        Scene escenaJugar = new Scene(vistaJugar, 800,600);
        
        escenaJugar.setOnKeyPressed(new AplicacionOnKeyPressedEvento(vistaJugar.getBarraDeMenu()));
        
    	MenuPrincipal menuPrincipal = new MenuPrincipal(stage, escenaJugar);
        Scene escenaPrincipal = new Scene(menuPrincipal, 800,600);
        
		escenaPrincipal.heightProperty().addListener(new cambiaDimension(menuPrincipal));
		escenaPrincipal.widthProperty().addListener(new cambiaDimension(menuPrincipal));
		
        stage.setScene(escenaPrincipal);

        stage.show();

    }
    

    
}

