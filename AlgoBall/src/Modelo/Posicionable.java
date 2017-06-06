package Modelo;

import Modelo.Excepciones.ExcPosicionOcupada;

public interface Posicionable {
	public void setPosicion(Posicion casillero) throws ExcPosicionOcupada;
	public abstract Posicion posicion();
}
