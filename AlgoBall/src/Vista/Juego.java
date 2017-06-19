package Vista;

import java.io.File;

import Modelo.Partida;
import Modelo.Excepciones.ErrorFatal;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import Vista.VistaLateral;
import Vista.VistaTablero;

public class Juego extends BorderPane{
	static final int pixelesAncho=30;
	static final int pixelesAlto=60;
	Partida partida;
	VistaTablero vistaTablero;
	VistaLateral vistaLateral;
	PanelDeVida panelDeVida;
	
	public Juego(Stage stage, Partida partida){
		this.partida = partida;
		try {
			partida.iniciar();
		} catch (ErrorFatal e) {
		}
		vistaLateral = new VistaLateral(partida, this);
		vistaTablero = new VistaTablero(partida, this);
		panelDeVida = new PanelDeVida(partida);
		setSuperior();
		setCentro();
		setVistaLateralDerecha();
		
		String path = getClass().getResource("mp3/battle 1.mp3").toString();
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.3);
	}
	
	public void update(){
		vistaLateral.update();
		panelDeVida.update();
		vistaTablero.update();
		
	}
	
	public VistaTablero vistaTablero(){
		return vistaTablero;
	}
	
	public VistaLateral vistaLateral(){
		return vistaLateral;
	}
	
	public int pixelesAncho(){
		return pixelesAncho;
	}
	
	public int pixelesAlto(){
		return pixelesAlto;
	}
	
	public Partida partida(){
		return this.partida;
	}
	
	private void setSuperior(){
		this.setTop(panelDeVida);
	}
	
	private void setCentro(){
		this.setCenter(vistaTablero);
	}
	
	private void setVistaLateralDerecha(){
		this.setRight(vistaLateral);
	}
}
