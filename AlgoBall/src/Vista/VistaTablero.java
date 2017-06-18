package Vista;


import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Personaje;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.Node;

public class VistaTablero extends GridPane {
	
	int ancho, alto;
	VistaPersonaje[][] vistasPersonajes;
	Partida partida;
	Juego juego;
	
	public VistaTablero(Partida partida, Juego juego){
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("tablero");
		ancho=partida.tablero().ancho();
		alto=partida.tablero().alto();
		vistasPersonajes= new VistaPersonaje[ancho][alto];
		this.partida = partida;
		this.juego = juego;
		
		this.setGridLinesVisible(true);
		
		for (int j = 0; j < ancho; j++) {
		    ColumnConstraints cc = new ColumnConstraints(juego.pixelesAncho());
		    this.getColumnConstraints().add(cc);
		}

		for (int j = 0; j < alto; j++) {
		    RowConstraints rc = new RowConstraints(juego.pixelesAlto());
		    this.getRowConstraints().add(rc);
		}
		
		update();
		
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
	
	public void remarcarPersonaje(Personaje personaje){
		update();
		obtenerVistaPersonaje(personaje.posicion()).remarcar();
	}
	
	public void ofrecerAtaque(Personaje personaje, boolean esEspecial){
		Posicion inicial = personaje.posicion();
		int rango=personaje.velocidad();
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				try {
					if(vistasPersonajes[i][j]!=null && inicial.distanciaA(new Posicion(i+1,j+1))<=rango && !(inicial.posX()==i+1 && inicial.posY()==j+1)){
						this.add(new OpcionDeAtaque(juego, partida ,personaje, new Posicion(i+1,j+1), esEspecial), i, j);
					}
				} catch (ExcPosicionNegativa e) {
				}
			}
		}
	}
	
	public void ofrecerMovimiento(Personaje personaje){
		Posicion inicial = personaje.posicion();
		int rango=personaje.velocidad();
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				try {
					if(vistasPersonajes[i][j]==null && inicial.distanciaA(new Posicion(i+1,j+1))<=rango){
						this.add(new OpcionDeMovimiento(juego, partida ,personaje, new Posicion(i+1,j+1)), i, j);
					}
				} catch (ExcPosicionNegativa e) {
				}
			}
		}
	}
	
	public VistaPersonaje obtenerVistaPersonaje(Posicion posicion){
		return vistasPersonajes[posicion.posX()-1][posicion.posY()-1];
	}
	
	public void update(){
		this.getChildren().clear();
		vistasPersonajes=new VistaPersonaje[ancho][alto];
		setFondoCasillero();
		partida.iterarPersonajes((k,v)->{
			VistaPersonaje vistaPersonaje=new VistaPersonaje(juego, v, partida);
			if(!(v.estaMuerto())){
				this.add(vistaPersonaje, v.posicion().posX()-1, v.posicion().posY()-1);
				vistasPersonajes[v.posicion().posX()-1][v.posicion().posY()-1]=vistaPersonaje;
			}
			
		});
		partida.iterarCasilleros((cas,pos)->{
			try {
				this.add(new VistaConsumible(juego, cas.obtenerConsumible()),pos.posX()-1,pos.posY()-1);
			} catch (ExcCasilleroDesocupado e) {
			}
		});
	}
	
	private void setFondoCasillero(){
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				this.add(new CasilleroFondo(), i, j);
			}
		}
	}
}
