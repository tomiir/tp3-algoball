package Vista;


import Vista.eventos.AplicacionOnKeyPressEvento;
import Vista.eventos.SalirEventoWindowEvent;
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
        
        escenaJugar.setOnKeyPressed(new AplicacionOnKeyPressEvento(vistaJugar.getBarraDeMenu()));
        
    	MenuPrincipal menuPrincipal = new MenuPrincipal(stage, escenaJugar);
        Scene escenaPrincipal = new Scene(menuPrincipal, 800,600);

        stage.setScene(escenaPrincipal);

        stage.show();

    }
    

    
}

