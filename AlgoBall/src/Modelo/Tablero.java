package Modelo;

public class Tablero {
	Casillero[][] casilleros;
	
	public Tablero(int alto,int ancho){
		casilleros = new Casillero[alto][ancho];
	}
	
	public void posicionar(Posicionable posicionable, int pos_x, int pos_y){
		
		Casillero casillero = casilleros[pos_x][pos_y];
		casillero.posicionar(posicionable);
	}
}