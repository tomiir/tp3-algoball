package Vista;

import Modelo.Partida;
import Modelo.Excepciones.ErrorFatal;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import Vista.VistaLateral;
import Vista.VistaTablero;

public class Juego extends BorderPane{
	static final int pixelesAncho=30;
	static final int pixelesAlto=60;
	protected Partida partida;
	protected VistaTablero vistaTablero;
	protected VistaLateral vistaLateral;
	protected VistaSuperior vistaSuperior;
	protected BarraDeMenu barraMenu;
	protected MediaPlayer mediaPlayer;
	
	public Juego(Stage stage, Partida partida){
		this.partida = partida;
		try {
			partida.iniciar();
		} catch (ErrorFatal e) {
		}
		
		String path = getClass().getResource("mp3/Batalla.mp3").toString();
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.3);
		
		vistaLateral = new VistaLateral(partida, this);
		vistaTablero = new VistaTablero(partida, this);
		vistaSuperior = new VistaSuperior(partida,mediaPlayer,stage);
		
		
		setSuperior();
		setCentro();
		setVistaLateralDerecha();
		
	}
	
	public void update(){
		mediaPlayer.setAutoPlay(true);
		vistaLateral.update();
		vistaSuperior.update();
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
	public BarraDeMenu getBarraDeMenu(){
		return vistaSuperior.getBarraDeMenu();
	}
	
	private void setSuperior(){
		this.setTop(vistaSuperior);
	}
	
	private void setCentro(){
		this.setCenter(vistaTablero);
	}
	
	private void setVistaLateralDerecha(){
		this.setRight(vistaLateral);
	}
}
