package Vista;

import Modelo.Partida;
import Modelo.Excepciones.ErrorFatal;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Juego extends BorderPane{
	Partida partida;
	
	public Juego(Stage stage, Partida partida){
		this.partida = partida;
		try {
			partida.iniciar();
		} catch (ErrorFatal e) {
		}
		setSuperior();
		setCentro();
		setVistaLateralDerecha();
	}
	
	private void setSuperior(){
		this.setTop(new PanelDeVida(partida));
	}
	
	private void setCentro(){
		this.setCenter(new VistaTablero(partida));
	}
	
	private void setVistaLateralDerecha(){
		this.setRight(new VistaLateral(partida));
	}
}
