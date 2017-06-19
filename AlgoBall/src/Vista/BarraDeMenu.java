package Vista;

import Vista.eventos.MostrarAcercaDeNosotrosEvento;
import Vista.eventos.MostrarInstruccionesEvento;
import Vista.eventos.MutearDesmutearMenuEvento;
import Vista.eventos.OpcionPantallaCompletaEvento;
import Vista.eventos.SalirEventoOnAction;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {
	
	MenuItem opcionPantallaCompleta;
	
	public BarraDeMenu(MediaPlayer mediaPlayer, Stage stage){
	
		Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuInstrucciones = new Menu("Instrucciones");
        Menu menuSonido = new Menu("Sonido");
        Menu menuAcercaDe = new Menu("Acerca De");
        

        MenuItem opcionSalir = new MenuItem("Salir");
        opcionPantallaCompleta = new MenuItem("Pantalla Completa");
        MenuItem opcionMutearDesmutear = new MenuItem("Mutear");
        //MenuItem opcionPrincipal = new MenuItem("Menu Principal");
        
        opcionSalir.setOnAction(new SalirEventoOnAction());
        menuInstrucciones.setOnAction(new MostrarInstruccionesEvento());
        menuAcercaDe.setOnAction(new MostrarAcercaDeNosotrosEvento());
        
        opcionMutearDesmutear.setOnAction(new MutearDesmutearMenuEvento(opcionMutearDesmutear,mediaPlayer));
        
        opcionPantallaCompleta.setOnAction(new OpcionPantallaCompletaEvento(opcionPantallaCompleta,stage));
        
        
        menuArchivo.getItems().addAll(opcionSalir);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuSonido.getItems().addAll(opcionMutearDesmutear);
        
        
        this.getMenus().addAll(menuArchivo, menuInstrucciones,menuVer,menuSonido, menuAcercaDe);
		
	}

	public void aplicacionHabilitarMaximizar() {
		opcionPantallaCompleta.setDisable(false);
	}

}
