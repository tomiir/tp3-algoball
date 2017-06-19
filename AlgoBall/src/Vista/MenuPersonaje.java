package Vista;


import Modelo.Partida;
import Modelo.Personajes.Personaje;
import Vista.eventos.BotonAtacarEvento;
import Vista.eventos.BotonMoverEvento;
import Vista.eventos.BotonTransformarEvento;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuPersonaje extends VBox {
	
	public MenuPersonaje (Personaje personaje, Juego juego, Partida partida){
		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getStyleClass().add("menu-personaje");
		
		NameTagPersonaje nombreDelPersonaje = new NameTagPersonaje(personaje);		
		
		Button botonMover = new Button();
		botonMover.setText("Mover");
		botonMover.getStyleClass().add("boton-menu");
		botonMover.setOnAction(new BotonMoverEvento(personaje, juego.vistaTablero()));
		if(partida.jugadorYaMovio(partida.esTurnoDelJugador())){
			botonMover.setDisable(true);
		}
		
		
		
		Button botonAtaqueNormal = new Button();
		botonAtaqueNormal.setText("Ataque normal");
		botonAtaqueNormal.getStyleClass().add("boton-menu");
		botonAtaqueNormal.setOnAction(new BotonAtacarEvento(personaje, juego.vistaTablero(), false));
	

		
		Button botonAtaqueEspecial = new Button();
		botonAtaqueEspecial.setText(personaje.getAtaqueEspecial().nombre() + "\n(costo:" + personaje.getAtaqueEspecial().costo() + ")");
		botonAtaqueEspecial.getStyleClass().add("boton-menu");
		botonAtaqueEspecial.wrapTextProperty().setValue(true);
		botonAtaqueEspecial.setOnAction(new BotonAtacarEvento(personaje, juego.vistaTablero(), true));
		if( personaje.ki() < personaje.getAtaqueEspecial().costo() ){
			botonAtaqueEspecial.setDisable(true);
		}
		
		
		Button botonTransformar = new Button();
		botonTransformar.setText("Transformar");
		if(personaje.getTransformacion() != null && personaje.getTransformacion().esPosible(personaje, partida.esTurnoDelJugador().equipo()) ){
			botonTransformar.setText("Transformar en " + personaje.getTransformacion().nombre() + "\n(costo:" + personaje.getTransformacion().costo()+ ")");
		}
		else{
			botonTransformar.setDisable(true);
		}
		botonTransformar.wrapTextProperty().setValue(true);
		botonTransformar.getStyleClass().add("boton-menu");
		botonTransformar.setOnAction(new BotonTransformarEvento(personaje, partida.esTurnoDelJugador().equipo(), juego));
		
		if(partida.jugadorYaAtacoOTransformo(partida.esTurnoDelJugador())){
			botonTransformar.setDisable(true);
			botonAtaqueNormal.setDisable(true);
			botonAtaqueEspecial.setDisable(true);
			
		}
		
		Label puntosDeVida = new Label();
		puntosDeVida.setText("Vida: " + personaje.puntosDeVida());
		puntosDeVida.getStyleClass().add("labels-informacion");
		
		Label puntosKi = new Label();
		puntosKi.setText("Ki: " + personaje.ki());
		puntosKi.getStyleClass().add("labels-informacion");
		
		Label puntosPoderPelea = new Label();
		puntosPoderPelea.setText("Poder de pelea: " + personaje.poderDePelea());
		puntosPoderPelea.getStyleClass().add("labels-informacion");
		
		Label puntosVelocidad = new Label();
		puntosVelocidad.setText("Velocidad: " + personaje.velocidad());
		puntosVelocidad.getStyleClass().add("labels-informacion");
		
		Label puntosDistanciaAtaque= new Label();
		puntosDistanciaAtaque.setText("Rango de ataque: " + personaje.rangoDeAtaque());
		puntosDistanciaAtaque.getStyleClass().add("labels-informacion");
		
		this.getChildren().addAll(nombreDelPersonaje, puntosDeVida,  puntosKi, puntosPoderPelea, puntosVelocidad, puntosDistanciaAtaque, botonAtaqueNormal, botonAtaqueEspecial, botonMover, botonTransformar);
		
	}
	

}
