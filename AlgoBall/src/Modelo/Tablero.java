package Modelo;

import java.util.HashMap;

public class Tablero {
	HashMap<Posicion, Casillero> casilleros;
	int ancho; 
	int alto;
	
	public Tablero(int altoDeseado,int anchoDeseado){
		ancho = anchoDeseado;
		alto = altoDeseado;
		casilleros = new HashMap<Posicion, Casillero>();
		
		
	}
	
	public void posicionar(Posicionable posicionable, Posicion posicion) throws ExcCasilleroOcupado, ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(posicion)) throw new ExcFueraDeTablero();
		Casillero casillero = casilleros.get(posicion);
		posicionable.posicionar(casillero);
	}
	
	public Casillero obtenerCasillero(int posX,int posY) throws ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(posicion)) throw new ExcFueraDeTablero();
		return casilleros.get(posicion);
	}
	
	private boolean coordenadasEstanEnRango(Posicion posicion) {
		posX = posicion.posX();
		posY = posicion.posY();
				
		return (posX >= 0 && posX < ancho && posY >= 0 && posY < alto);
	}
}