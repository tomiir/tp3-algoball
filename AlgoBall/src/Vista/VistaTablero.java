package Vista;


import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Personajes.Personaje;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.Node;

public class VistaTablero extends GridPane {
	static final int pixelesAncho=40;
	static final int pixelesAlto=80;
	
	int ancho, alto;
	VistaLateral vistaLateral;
	VistaPersonaje[][] vistasPersonajes;
	Partida partida;
	
	public VistaTablero(Partida partida, VistaLateral vistaLateral){
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("tablero");
		ancho=partida.tablero().ancho();
		alto=partida.tablero().alto();
		vistasPersonajes= new VistaPersonaje[ancho][alto];
		this.partida = partida;
		this.vistaLateral = vistaLateral;
		
		this.setGridLinesVisible(true);
		
		for (int j = 0; j < ancho; j++) {
		    ColumnConstraints cc = new ColumnConstraints(pixelesAncho);
		    this.getColumnConstraints().add(cc);
		}

		for (int j = 0; j < alto; j++) {
		    RowConstraints rc = new RowConstraints(pixelesAlto);
		    this.getRowConstraints().add(rc);
		}
		
		update();
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
	
	public void remarcarPersonaje(Personaje personaje){
		update();
		obtenerVistaPersonaje(personaje.posicion()).remarcar();
	}
	
	public void mostrarRangoDeMovimiento(Personaje personaje){
		Posicion inicial = personaje.posicion();
		int rango=personaje.rangoDeAtaque();
	}
	
	public VistaPersonaje obtenerVistaPersonaje(Posicion posicion){
		return vistasPersonajes[posicion.posX()-1][posicion.posY()-1];
	}
	
	private void update(){
		this.getChildren().clear();
		vistasPersonajes=new VistaPersonaje[ancho][alto];
		partida.iterarPersonajes((k,v)->{
			VistaPersonaje vistaPersonaje=new VistaPersonaje(v, pixelesAncho,pixelesAlto, partida, vistaLateral);
			this.add(vistaPersonaje, v.posicion().posX()-1, v.posicion().posY()-1);
			vistasPersonajes[v.posicion().posX()-1][v.posicion().posY()-1]=vistaPersonaje;
		});
	}
	
	//https://stackoverflow.com/questions/20825935/javafx-get-node-by-row-and-column
	public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
	    Node result = null;
	    ObservableList<Node> childrens = gridPane.getChildren();

	    for (Node node : childrens) {
	        if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }

	    return result;
	}
}
