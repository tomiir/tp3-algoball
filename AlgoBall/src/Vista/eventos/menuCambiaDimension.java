package Vista.eventos;

import Vista.MenuPrincipal;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class menuCambiaDimension implements ChangeListener<Number>  {
	
	MenuPrincipal menuPrincipal;
	
	public menuCambiaDimension(MenuPrincipal menuPrincipal){
		this.menuPrincipal = menuPrincipal;
	}
	
	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		menuPrincipal.cambiarDimension();
	}

}
