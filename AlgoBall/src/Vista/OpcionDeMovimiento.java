package Vista;

import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Personajes.Personaje;
import Vista.eventos.MoverEvento;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class OpcionDeMovimiento extends Rectangle{
	public OpcionDeMovimiento(Personaje personaje, Posicion posicion, Partida partida, VistaTablero vistaTablero, int pixelesAncho, int pixelesAlto){
		this.setWidth(pixelesAncho);
		this.setHeight(pixelesAlto);
		this.setFill(Paint.valueOf("orange"));
		this.setOnMouseClicked(new MoverEvento(personaje, posicion, partida, vistaTablero));
	}
}
