package Vista.eventos;


import Vista.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class MutearDesmutearSonidoJuegoEvento implements EventHandler<ActionEvent>{
	private Juego juego;
	private MenuItem opcionFX;
	
	public MutearDesmutearSonidoJuegoEvento(Juego juego, MenuItem opcionFX){
		this.juego = juego;
		this.opcionFX = opcionFX;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(juego.sonidoMuteado()){
			juego.setMuteoSonido(false);
			opcionFX.setText("Mutear sonido");
		} else {
			juego.setMuteoSonido(true);
			opcionFX.setText("Desmutear sonido");
		}
		
	}

}
