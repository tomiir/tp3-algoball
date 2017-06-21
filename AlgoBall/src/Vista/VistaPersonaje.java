package Vista;

import Modelo.Partida;
import Modelo.Personajes.Personaje;
import Vista.Interpretes.InterpretePersonaje;
import Vista.eventos.PersonajePresionadoMouseEvent;
import javafx.scene.layout.HBox;

public class VistaPersonaje extends HBox{
	public VistaPersonaje(Juego juego, Personaje personaje, Partida partida){
		InterpretePersonaje interprete = new InterpretePersonaje(personaje);
		this.setMaxSize(juego.pixelesAncho(), juego.pixelesAlto());
		this.getStyleClass().add("personaje");
		String imagen = getClass().getResource("img/personajes/"+interprete.nombre()+"/"+interprete.nombre()+"_"+interprete.estado()+".png").toExternalForm();
		if(interprete.esChocolate()) imagen=getClass().getResource("img/personajes/chocolate.png").toExternalForm();
		this.setStyle("-fx-background-image: url('" + imagen + "'); ");
		if(partida.esTurnoDelJugador().equipo().personajePertenece(interprete.nombre())){
			this.getStyleClass().add("coloreado");
			this.setOnMouseClicked(new PersonajePresionadoMouseEvent(personaje,juego.vistaLateral()));
		}
		
	}
	
	public void remarcar(){
		this.getStyleClass().add("remarcado");
	}
}