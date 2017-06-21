package Modelo;

public class Dimension {
	private int ancho;
	private int alto;
	
	public Dimension(int ancho, int alto){
		this.ancho=ancho;
		this.alto=alto;
	}
	
	public int ancho(){
		return ancho;
	}
	
	public int alto(){
		return alto;
	}
	
	public boolean posicionEstaEnDimension(Posicion pos){
		return (pos.posX() > 0 && pos.posX() <= ancho && pos.posY() > 0 && pos.posY() <= alto);
	}
}
