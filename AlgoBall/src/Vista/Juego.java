package Vista;

import Modelo.Partida;
import Modelo.Excepciones.ErrorFatal;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Juego extends BorderPane{
	Partida partida;
	VistaTablero vistaTablero;
	VistaLateral vistaLateral;
	
	public Juego(Stage stage, Partida partida){
		this.partida = partida;
		try {
			partida.iniciar();
		} catch (ErrorFatal e) {
		}
		vistaLateral = new VistaLateral(partida);
		vistaTablero = new VistaTablero(partida, vistaLateral);
		vistaLateral.setVistaTablero(vistaTablero);
		setSuperior();
		setCentro();
		setVistaLateralDerecha();
	}
	
	private void setSuperior(){
		this.setTop(new PanelDeVida(partida));
	}
	
	private void setCentro(){
		this.setCenter(vistaTablero);
	}
	
	private void setVistaLateralDerecha(){
		this.setRight(vistaLateral);
	}
}
