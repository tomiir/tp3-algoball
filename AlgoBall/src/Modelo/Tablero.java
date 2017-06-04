package Modelo;

public class Tablero {
	Casillero[][] casilleros;
	
	public Tablero(int alto,int ancho){
		casilleros = new Casillero[alto][ancho];
	}
	
	public posicionar(Personaje personaje, pos_x,pos_y){
		
		casillero = casilleros[pos_x][pos_y];
		
	}
}
