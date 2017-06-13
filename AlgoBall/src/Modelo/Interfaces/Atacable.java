package Modelo.Interfaces;

import Modelo.Posicion;
import Modelo.Excepciones.ExcDañoNegativo;

public interface Atacable {
	public abstract int recibirDaño(int cantidad) throws ExcDañoNegativo;
	public abstract boolean estaMuerto();
	public abstract Posicion posicion();
}
