package Modelo.Interfaces;

import Modelo.Posicion;
import Modelo.Excepciones.ExcDa�oNegativo;

public interface Atacable {
	public abstract int recibirDa�o(int cantidad) throws ExcDa�oNegativo;
	public abstract boolean estaMuerto();
	public abstract Posicion posicion();
}
