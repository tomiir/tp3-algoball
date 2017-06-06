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
	
<<<<<<< HEAD
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
=======
	public void posicionar(Posicionable posicionable, Posicion pos) throws ExcCasilleroOcupado, ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(pos)) throw new ExcFueraDeTablero();
		Casillero casillero = casilleros[pos.posX()][pos.posY()];
		try{
			casillero.posicionar(posicionable);
		}	catch(ExcCasilleroOcupado e){
			throw e;
		}
		posicionable.posicionar(pos);
	}
	
	private boolean coordenadasEstanEnRango(Posicion pos) {
		return (pos.posX() >= 0 && pos.posX() < ancho && pos.posY() >= 0 && pos.posY() < alto);
>>>>>>> fa6f773502b781b0003017067e2bcda5d3848684
	}
}