package Modelo;

import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcPosicionNegativa;

public class Posicion{
	
	int posX;
	int posY;
	
	public Posicion(int pX, int pY) throws ExcPosicionNegativa{
		if(pX<0 || pY<0) throw new ExcPosicionNegativa();
		posX=pX;
		posY=pY;
	}
	
	public int posX(){
		return posX;
	}
	
	public int posY(){
		return posY;
	}
	
	public int distanciaA(Posicion destino) throws ExcPosicionNegativa, ExcDireccionInvalida{
		int distancia = 0;
		Posicion auxiliar= new Posicion(posX,posY);
		
		while(auxiliar.posX()!=destino.posX() || auxiliar.posY()!=destino.posY()){
			Direccion movimiento = obtenerMovimientoUnitario(auxiliar, destino);
			auxiliar=new Posicion(auxiliar.posX()+movimiento.dx(), auxiliar.posY()+movimiento.dy());
			if(auxiliar.posX()!=destino.posX() || auxiliar.posY()!=destino.posY()) distancia++;
		}
		return distancia;
	}
	
	private Direccion obtenerMovimientoUnitario(Posicion origen, Posicion destino) throws ExcPosicionNegativa, ExcDireccionInvalida{
		int dirX=destino.posX()-origen.posX();
		int dirY=destino.posY()-origen.posY();
		if(dirX!=0) dirX=dirX/Math.abs(dirX);
		if(dirY!=0) dirY=dirY/Math.abs(dirY);
		return new Direccion(dirX, dirY);
	} 
	
}
