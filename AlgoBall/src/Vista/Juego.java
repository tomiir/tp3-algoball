package Vista;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeFactory;
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
	protected boolean sonidoMute;
	
	public Juego(Stage stage){
		iniciarModelo();
		
		String path = getClass().getResource("mp3/Batalla.mp3").toString();
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.7);
		
		vistaLateral = new VistaLateral(this);
		vistaTablero = new VistaTablero(this);
		vistaSuperior = new VistaSuperior(this,mediaPlayer,stage);
		
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
	
    public void iniciarModelo(){
    	Tablero tablero = new Tablero(16,8);
		Jugador jugador1 = new Jugador("Guerreros Z");
    	Jugador jugador2 = new Jugador("Enemigos de la tierra");
    	
    	Equipo guerrerosZ = new Equipo("Guerreros Z");
    	Equipo enemigosDeLaTierra = new Equipo("Enemigos de la tierra");
    	
    	PersonajeFactory factory = new PersonajeFactory();
    	
    	Personaje goku = factory.getPersonaje("goku");
    	Personaje gohan = factory.getPersonaje("gohan");
    	Personaje piccolo = factory.getPersonaje("piccolo");
    	
    	
    	Personaje cell = factory.getPersonaje("cell");
    	Personaje freezer = factory.getPersonaje("freezer");
    	Personaje majinBoo = factory.getPersonaje("majinboo");

    	guerrerosZ.agregarPersonaje(goku);
    	guerrerosZ.agregarPersonaje(gohan);
    	guerrerosZ.agregarPersonaje(piccolo);
    	
    	enemigosDeLaTierra.agregarPersonaje(cell);
    	enemigosDeLaTierra.agregarPersonaje(freezer);
    	enemigosDeLaTierra.agregarPersonaje(majinBoo);
    	
    	jugador1.asignarEquipo(guerrerosZ);
    	jugador2.asignarEquipo(enemigosDeLaTierra);
    	
    	Partida partidaAux = new Partida(tablero, jugador1, jugador2);
    	this.partida = partidaAux;
    	try {
			partida.iniciar();
		} catch (ExcHayGanador e) {
		}
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
	
	public boolean sonidoMuteado(){
		return sonidoMute;
	}
	
	public void setMuteoSonido(boolean eleccion){
		sonidoMute=eleccion;
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
