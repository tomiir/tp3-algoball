package Modelo;

public class Posicion{
	
	int posX;
	int posY;
	
	public Posicion(int pX, int pY){
		posX=pX;
		posY=pY;
	}
	
	public int posX(){
		return posX;
	}
	
	public int posY(){
		return posY;
	}
	
	public double distanciaA(Posicion posicion){
		return (Math.sqrt(Math.pow(posicion.posX()-posX, 2)+Math.pow(posicion.posY()-posY, 2)));
	}
	
	
}
