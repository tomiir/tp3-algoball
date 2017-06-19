package Vista;

import Modelo.Consumibles.Consumible;
import javafx.scene.layout.Pane;

public class VistaConsumible extends Pane {
	public VistaConsumible(Juego juego, Consumible consumible){
		this.setMinWidth(juego.pixelesAncho());
		this.getStyleClass().add("consumible");
		String imagen = getClass().getResource("img/consumibles/"+consumible.nombre()+".png").toExternalForm();
		this.setStyle("-fx-background-image: url('" + imagen + "'); ");
	}
}