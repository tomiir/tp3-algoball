package Vista;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeFactory;
import Modelo.Personajes.Piccolo;
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
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/esferaDragon.png")));
        
        Partida partida = crearModelo();
        
        Juego vistaJugar = new Juego(stage, partida);
        Scene escenaJugar = new Scene(vistaJugar, 800,600);
        
    	MenuPrincipal menuPrincipal = new MenuPrincipal(stage, escenaJugar);
        Scene escenaPrincipal = new Scene(menuPrincipal, 800,600);

        stage.setScene(escenaPrincipal);

        stage.show();

    }
    
    private Partida crearModelo(){
    	Tablero tablero = new Tablero(21,8);
		Jugador jugador1 = new Jugador("Guerreros Z");
    	Jugador jugador2 = new Jugador("Enemigos de la tierra");
    	
    	Equipo guerrerosZ = new Equipo("Guerreros Z");
    	Equipo enemigosDeLaTierra = new Equipo("Enemigos de la tierra");
    	
    	PersonajeFactory factory = new PersonajeFactory(tablero);
    	
    	Personaje goku = factory.getPersonaje("goku");
    	Personaje gohan = factory.getPersonaje("gohan");
    	Personaje piccolo = factory.getPersonaje("piccolo");
    	
    	Personaje cell = factory.getPersonaje("cell");
    	Personaje freezer = factory.getPersonaje("freezer");
    	Personaje majinBoo = factory.getPersonaje("majinboo");
    	
    	/*try {
			gohan.recibirDaño(250);
			piccolo.recibirDaño(400);
			goku.recibirDaño(400);
			
			cell.recibirDaño(400);
			freezer.recibirDaño(350);
			majinBoo.recibirDaño(250);
		} catch (ExcNumeroNegativo e) {
		}*/
    	
    	
    	guerrerosZ.agregarPersonaje(goku);
    	guerrerosZ.agregarPersonaje(gohan);
    	guerrerosZ.agregarPersonaje(piccolo);
    	
    	enemigosDeLaTierra.agregarPersonaje(cell);
    	enemigosDeLaTierra.agregarPersonaje(freezer);
    	enemigosDeLaTierra.agregarPersonaje(majinBoo);
    	
    	jugador1.asignarEquipo(guerrerosZ);
    	jugador2.asignarEquipo(enemigosDeLaTierra);
    	
    	Partida partida = new Partida(tablero, jugador1, jugador2);
    	return partida;
    }
    
}

