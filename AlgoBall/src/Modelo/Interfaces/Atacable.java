package Modelo.Interfaces;

import Modelo.Posicion;
import Modelo.Excepciones.ExcNumeroNegativo;

public interface Atacable {
	public abstract int recibirDaņo(int cantidad) throws ExcNumeroNegativo;
	public abstract boolean estaMuerto();
	public abstract Posicion posicion();
}
