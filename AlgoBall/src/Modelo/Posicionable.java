package Modelo;

public interface Posicionable {
	public void setPosicion(Posicion casillero) throws ExcPosicionOcupada;
	public abstract Posicion posicion();
}
