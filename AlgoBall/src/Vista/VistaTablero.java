package Vista;

import Modelo.Partida;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class VistaTablero extends GridPane {
	static final int pixelesAncho=30;
	static final int pixelesAlto=60;
	Partida partida;
	
	public VistaTablero(Partida partida){
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("tablero");
		int ancho=partida.tablero().ancho();
		int alto=partida.tablero().alto();
		this.partida = partida;
		
		this.setGridLinesVisible(true);
		
		for (int j = 0; j < ancho; j++) {
		    ColumnConstraints cc = new ColumnConstraints(30);
		    this.getColumnConstraints().add(cc);
		}

		for (int j = 0; j < alto; j++) {
		    RowConstraints rc = new RowConstraints(60);
		    this.getRowConstraints().add(rc);
		}
		
		update();
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
	
	private void update(){
		partida.iterarPersonajes((k,v)->{
			this.add(new VistaPersonaje(v, pixelesAncho,pixelesAlto), v.posicion().posX()-1, v.posicion().posY()-1);
		});
	}
}
