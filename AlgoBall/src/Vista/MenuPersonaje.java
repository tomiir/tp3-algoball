package Vista;


import Modelo.Partida;
import Modelo.Personajes.Personaje;
import Vista.Interpretes.InterpretePersonaje;
import Vista.eventos.BotonAtacarEvento;
import Vista.eventos.BotonMoverEvento;
import Vista.eventos.BotonTransformarEvento;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuPersonaje extends VBox {
	
	public MenuPersonaje (Personaje personaje, Juego juego, Partida partida){
		InterpretePersonaje interprete = new InterpretePersonaje(personaje);
		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getStyleClass().add("menu-personaje");
		
		NameTagPersonaje nombreDelPersonaje = new NameTagPersonaje(interprete);		
		
		Button botonMover = new Button();
		botonMover.setText("Mover");
		botonMover.getStyleClass().add("boton-menu");
		botonMover.setOnAction(new BotonMoverEvento(personaje, juego.vistaTablero()));
		if(partida.esTurnoDelJugador().realizoMovimiento() || interprete.esChocolate()){
			botonMover.setDisable(true);
		}
		
		
		Button botonAtaqueNormal = new Button();
		botonAtaqueNormal.setText("Ataque normal");
		botonAtaqueNormal.getStyleClass().add("boton-menu");
		botonAtaqueNormal.setOnAction(new BotonAtacarEvento(personaje, juego.vistaTablero(), false));
		if(personaje.esChocolate()){
			botonAtaqueNormal.setDisable(true);
		}

		
		Button botonAtaqueEspecial = new Button();
		botonAtaqueEspecial.setText(interprete.nombreAtaqueEspecial() + "\n(costo:" + interprete.costoAtaqueEspecial() + ")");
		botonAtaqueEspecial.getStyleClass().add("boton-menu");
		botonAtaqueEspecial.wrapTextProperty().setValue(true);
		botonAtaqueEspecial.setOnAction(new BotonAtacarEvento(personaje, juego.vistaTablero(), true));
		if( interprete.ki() < interprete.costoAtaqueEspecial() || interprete.esChocolate()){
			botonAtaqueEspecial.setDisable(true);
		}
		
		
		Button botonTransformar = new Button();
		botonTransformar.setText("Transformar");
		
		if(interprete.tieneTransformacion()) botonTransformar.setText("Transformar en " + interprete.nombreTransformacion() + "\n(costo:" + interprete.costoTransformar()+ ")");
		
		if(!interprete.tieneTransformacion() || interprete.esChocolate() || !personaje.sePuedeTransformar(partida.esTurnoDelJugador().equipo())){
			botonTransformar.setDisable(true);
		}
		
		botonTransformar.wrapTextProperty().setValue(true);
		botonTransformar.getStyleClass().add("boton-menu");
		botonTransformar.setOnAction(new BotonTransformarEvento(personaje, partida.esTurnoDelJugador().equipo(), juego));
		
		if(partida.esTurnoDelJugador().realizoAtaque() || partida.esTurnoDelJugador().realizoTransformacion()){
			botonTransformar.setDisable(true);
			botonAtaqueNormal.setDisable(true);
			botonAtaqueEspecial.setDisable(true);
			
		}
		
		Label puntosDeVida = new Label();
		puntosDeVida.setText("Vida: " + interprete.vidaActual());
		puntosDeVida.getStyleClass().add("labels-informacion");
		
		Label puntosKi = new Label();
		puntosKi.setText("Ki: " + interprete.ki());
		puntosKi.getStyleClass().add("labels-informacion");
		
		Label puntosPoderPelea = new Label();
		puntosPoderPelea.setText("Poder de pelea: " + interprete.poderDePelea() + " (+ %" + String.valueOf(interprete.bonificacionDeAtaquePorcentual()+interprete.bonificacionDeAtaquePorcentualPorConsumibles()) + ")");
		puntosPoderPelea.getStyleClass().add("labels-informacion");
		
		Label puntosVelocidad = new Label();
		puntosVelocidad.setText("Velocidad: " + interprete.velocidad()  + " (+ " + String.valueOf(interprete.multiplicadorDeVelocidadPorConsumibles()*interprete.velocidad()) + ")");
		puntosVelocidad.getStyleClass().add("labels-informacion");
		
		Label puntosDistanciaAtaque= new Label();
		puntosDistanciaAtaque.setText("Rango de ataque: " + interprete.rangoDeAtaque());
		puntosDistanciaAtaque.getStyleClass().add("labels-informacion");
		
		Label absorciones= new Label();
		absorciones.setText("Absorciones: " + interprete.cantidadDeAbsorciones());
		if (interprete.cantidadDeAbsorciones() == 0) absorciones.setText("");
		
		puntosDistanciaAtaque.getStyleClass().add("labels-informacion");
		
		this.getChildren().addAll(nombreDelPersonaje, puntosDeVida,  puntosKi, puntosPoderPelea, puntosVelocidad, puntosDistanciaAtaque, absorciones, botonAtaqueNormal, botonAtaqueEspecial, botonMover, botonTransformar);
		
	}
	

}
