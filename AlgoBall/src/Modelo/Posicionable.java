package Modelo;

public interface Posicionable {
	public abstract Casillero posicion();
	public abstract void posicionar(Casillero casillero) throws ExcCasilleroOcupado;
}
