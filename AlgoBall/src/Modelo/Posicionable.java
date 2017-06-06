package Modelo;

public interface Posicionable {
	public abstract Posicion posicion();
	public abstract void posicionar(Posicion pos) throws ExcCasilleroOcupado;
}
