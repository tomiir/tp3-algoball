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
    	
        stage.setTitle("AlgoBall");
        stage.setOnCloseRequest(new SalirEventoWindowEvent());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/esferaDragon.png")));
        
        Partida partida = crearModelo();
        
        Juego jugar = new Juego(stage, partida);
        Scene escenaJugar = new Scene(jugar, 640, 480);
        
    	MenuPrincipal menuPrincipal = new MenuPrincipal(stage, escenaJugar);
        Scene escenaPrincipal = new Scene(menuPrincipal, 640, 480);

        stage.setScene(escenaPrincipal);

        stage.show();

    }
    
    private Partida crearModelo(){
    	Tablero tablero = new Tablero(5,5);
		Jugador jugador1 = new Jugador("Guerreros Z");
    	Jugador jugador2 = new Jugador("Enemigos de la tierra");
    	
    	Equipo guerrerosZ = new Equipo("Guerreros Z");
    	Equipo enemigosDeLaTierra = new Equipo("Enemigos de la tierra");
    	
    	Goku goku = new Goku(tablero);
    	Gohan gohan = new Gohan(tablero);
    	Piccolo piccolo = new Piccolo(tablero);
    	
    	Cell cell = new Cell(tablero);
    	Freezer freezer = new Freezer(tablero);
    	MajinBoo majinBoo = new MajinBoo(tablero);
    	
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

