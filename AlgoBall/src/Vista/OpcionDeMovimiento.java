package Vista;

import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Personajes.Personaje;
import Vista.eventos.MoverEvento;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class OpcionDeMovimiento extends Rectangle{
	public OpcionDeMovimiento(Juego juego,Partida partida, Personaje personaje, Posicion posicion){
		this.setFill(Paint.valueOf("orange"));
		this.getStyleClass().add("opcion-movimiento");
		this.setHeight(juego.pixelesAlto());
		this.setWidth(juego.pixelesAncho());
		this.setOnMouseClicked(new MoverEvento(juego, personaje, posicion, partida));
	}
}
