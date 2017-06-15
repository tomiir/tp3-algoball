package Modelo;

import Modelo.Excepciones.ExcPosicionNegativa;

public class Posicion{
	
	int posX;
	int posY;
	
	public Posicion(int posX, int posY) throws ExcPosicionNegativa{
		if(posX<0 || posY<0) throw new ExcPosicionNegativa();
		this.posX=posX;
		this.posY=posY;
	}
	
	public int posX(){
		return posX;
	}
	
	public int posY(){
		return posY;
	}
	
	public int distanciaA(Posicion destino) throws ExcPosicionNegativa{
		int distancia = 0;
		Posicion auxiliar= new Posicion(posX,posY);
		
		while(auxiliar.posX()!=destino.posX() || auxiliar.posY()!=destino.posY()){
			int dirX=destino.posX()-auxiliar.posX();
			int dirY=destino.posY()-auxiliar.posY();
			if(dirX!=0) dirX=dirX/Math.abs(dirX);
			if(dirY!=0) dirY=dirY/Math.abs(dirY);
			distancia++;
			auxiliar=new Posicion(auxiliar.posX()+dirX, auxiliar.posY()+dirY);
		}
		return distancia;
	}
	
}
