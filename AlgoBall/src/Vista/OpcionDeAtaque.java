package Vista;

import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Personajes.Personaje;
import Vista.eventos.AtacarEvento;
import Vista.eventos.MoverEvento;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class OpcionDeAtaque extends Rectangle {
	
	public OpcionDeAtaque(Juego juego,Partida partida, Personaje personaje, Posicion posicion, boolean esEspecial){
		this.setFill(Paint.valueOf("red"));
		this.getStyleClass().add("opcion-ataque");
		this.setHeight(juego.pixelesAlto());
		this.setWidth(juego.pixelesAncho());
		this.setOnMouseClicked(new AtacarEvento(juego, personaje, posicion, partida, esEspecial));
	}
	
}
