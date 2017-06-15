package Modelo;

import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Interfaces.Atacable;

public class Casillero {
	Atacable atacable;
	
	public Atacable obtenerAtacable() throws ExcCasilleroDesocupado{
		if(!estaOcupado()) throw new ExcCasilleroDesocupado();
		return atacable;
	}

	public boolean estaOcupado() {
		if(atacable==null) return false;
		return true;
	}

	public void ocuparAtacable(Atacable atacable) throws ExcCasilleroOcupado{
		if(estaOcupado()) throw new ExcCasilleroOcupado();
		this.atacable=atacable;
	}

	public void desocupar() {
		atacable=null;
	}
}

