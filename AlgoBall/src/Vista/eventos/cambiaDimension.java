package Vista.eventos;

import Vista.interfaces.Responsivo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class cambiaDimension implements ChangeListener<Number>  {
	
	Responsivo responsivo;
	
	public cambiaDimension(Responsivo responsivo){
		this.responsivo = responsivo;
	}
	
	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		responsivo.cambiarDimension();
	}

}
