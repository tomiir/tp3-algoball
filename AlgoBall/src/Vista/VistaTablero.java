package Vista;


import Modelo.Posicion;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Personaje;
import Vista.Interpretes.InterpretePersonaje;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class VistaTablero extends GridPane {
	
	int ancho, alto;
	VistaPersonaje[][] vistasPersonajes;
	Juego juego;
	
	public VistaTablero(Juego juego){
		this.setAlignment(Pos.CENTER);
		this.getStyleClass().add("tablero");
		ancho=juego.partida().tablero().dimension().ancho();
		alto=juego.partida().tablero().dimension().alto();
		vistasPersonajes= new VistaPersonaje[ancho][alto];
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
		InterpretePersonaje interprete = new InterpretePersonaje(personaje);
		Posicion inicial = personaje.posicion();
		long rango=interprete.rangoDeAtaque();
		int cont=0;
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				try {
					if(vistasPersonajes[i][j]!=null && inicial.distanciaA(new Posicion(i+1,j+1))<=rango && !(inicial.posX()==i+1 && inicial.posY()==j+1)){
						this.add(new OpcionDeAtaque(juego, juego.partida() ,personaje, new Posicion(i+1,j+1), esEspecial), i, j);
						cont++;
					}
				} catch (ExcPosicionNegativa e) {
				}
			}
		}
		if(cont==0){
			Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Error");
	    	alert.setHeaderText("");
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("img/icon.png")));
	    	alert.setContentText("No hay nadie a quien atacar");
	    	alert.showAndWait();
		}
	}
	
	public void ofrecerMovimiento(Personaje personaje){
		InterpretePersonaje interprete = new InterpretePersonaje(personaje);
		Posicion inicial = personaje.posicion();
		long rango=interprete.velocidad() + interprete.velocidad()*interprete.multiplicadorDeVelocidadPorConsumibles();
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				try {
					if(vistasPersonajes[i][j]==null && inicial.distanciaA(new Posicion(i+1,j+1))<=rango){
						this.add(new OpcionDeMovimiento(juego, juego.partida() ,personaje, new Posicion(i+1,j+1)), i, j);
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
		juego.partida().iterarPersonajes(v->{
			if(!(v.estaMuerto())){
				VistaPersonaje vistaPersonaje=new VistaPersonaje(juego, v, juego.partida());
				this.add(vistaPersonaje, v.posicion().posX()-1, v.posicion().posY()-1);
				vistasPersonajes[v.posicion().posX()-1][v.posicion().posY()-1]=vistaPersonaje;
			}
		});
		juego.partida().iterarCasilleros((cas,pos)->{
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
