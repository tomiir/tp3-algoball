package Modelo;

public interface Posicionable {
	public void setPosicion(Posicion casillero) throws ExcCasilleroOcupado;
	public abstract Posicion posicion();
}
