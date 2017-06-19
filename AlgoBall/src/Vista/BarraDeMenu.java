package Vista;

import Vista.eventos.MostrarAcercaDeNosotrosEvento;
import Vista.eventos.MostrarInstruccionesEvento;
import Vista.eventos.MutearDesmutearMusicaJuegoEvento;
import Vista.eventos.MutearDesmutearSonidoJuegoEvento;
import Vista.eventos.OpcionPantallaCompletaEvento;
import Vista.eventos.OpcionReiniciarEvento;
import Vista.eventos.SalirEventoOnAction;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {
	
	MenuItem opcionPantallaCompleta;
	
	public BarraDeMenu(MediaPlayer mediaPlayer, Stage stage, Juego juego){
	
		Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuSonido = new Menu("Sonido");
        Menu menuAyuda = new Menu("Ayuda");
        

        MenuItem opcionSalir = new MenuItem("Salir");
        opcionPantallaCompleta = new MenuItem("Pantalla Completa");
        MenuItem opcionMusica = new MenuItem("Mutear música");
        MenuItem opcionFX = new MenuItem("Mutear sonidos");
        MenuItem opcionReiniciar = new MenuItem("Reiniciar Juego");
        MenuItem opcionInstrucciones = new MenuItem("Instrucciones");
        MenuItem opcionAcercaDe = new MenuItem("Acerca De");
        
        opcionSalir.setOnAction(new SalirEventoOnAction());
        opcionInstrucciones.setOnAction(new MostrarInstruccionesEvento());
        opcionAcercaDe.setOnAction(new MostrarAcercaDeNosotrosEvento());
        opcionReiniciar.setOnAction(new OpcionReiniciarEvento(juego));
        
        opcionMusica.setOnAction(new MutearDesmutearMusicaJuegoEvento(opcionMusica,mediaPlayer));
        opcionFX.setOnAction(new MutearDesmutearSonidoJuegoEvento(juego, opcionFX));
        
        opcionPantallaCompleta.setOnAction(new OpcionPantallaCompletaEvento(opcionPantallaCompleta,stage));
        
        
        menuArchivo.getItems().addAll(opcionReiniciar,new SeparatorMenuItem(),opcionSalir);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuSonido.getItems().addAll(opcionMusica, opcionFX);
        menuAyuda.getItems().addAll(opcionInstrucciones,new SeparatorMenuItem(), opcionAcercaDe);
        
        
        this.getMenus().addAll(menuArchivo,menuVer,menuSonido, menuAyuda);
		
	}

	public void aplicacionHabilitarMaximizar() {
		opcionPantallaCompleta.setDisable(false);
	}

}
