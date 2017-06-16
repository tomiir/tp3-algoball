package Modelo;

import Modelo.Consumibles.Consumible;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Interfaces.Atacable;

public class Casillero {
	Atacable atacable;
	Consumible consumible;
	
	public Atacable obtenerAtacable() throws ExcCasilleroDesocupado{
		if(!estaOcupado()) throw new ExcCasilleroDesocupado();
		return atacable;
	}
	
	public Consumible obtenerConsumible() throws ExcCasilleroDesocupado{
		if(!tieneUnConsumible()) throw new ExcCasilleroDesocupado();
		return consumible;	
		
	}
	public boolean estaOcupado() {
		if(atacable==null) return false;
		return true;
	}
	
	public boolean tieneUnConsumible(){
		return !(consumible == null);
	}

	public void ocuparAtacable(Atacable atacable) throws ExcCasilleroOcupado{
		if(estaOcupado()) throw new ExcCasilleroOcupado();
		this.atacable=atacable;
	}
	
	public void ocuparConsumible(Consumible consumible) throws ExcCasilleroOcupado{
		if(tieneUnConsumible()) throw new ExcCasilleroOcupado();
		this.consumible = consumible;
	}

	public void desocupar() {
		atacable=null;
	}
	public void eliminarConsumible(){
		consumible = null;
	}
}

