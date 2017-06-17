package Vista;

import Modelo.Partida;
import Modelo.Consumibles.Consumible;
import Modelo.Personajes.Personaje;
import Vista.eventos.PersonajePresionadoMouseEvent;
import javafx.scene.layout.Pane;

public class VistaConsumible extends Pane {
	public VistaConsumible(Juego juego, Consumible consumible){
		this.setMinWidth(juego.pixelesAncho());
		this.getStyleClass().add("consumible");
		String imagen = getClass().getResource("img/consumibles/"+consumible.nombre()+".png").toExternalForm();
		this.setStyle("-fx-background-image: url('" + imagen + "'); ");
	}
}