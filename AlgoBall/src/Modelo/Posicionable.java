package Modelo;

public interface Posicionable {
	public abstract Posicion setPosicion();
	public abstract void posicionar(Posicion pos) throws ExcCasilleroOcupado;
}
