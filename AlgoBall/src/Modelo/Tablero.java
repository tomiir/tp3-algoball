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
	
	public Casillero obtenerCasillero(Posicion posicion) throws ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(posicion)) throw new ExcFueraDeTablero();
		return casilleros.get(posicion);
	}

	public void posicionar(Posicionable posicionable, Posicion pos) throws ExcCasilleroOcupado, ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(pos)) throw new ExcFueraDeTablero();
		Casillero casillero = casilleros.get(pos);
		try{
			casillero.posicionar(posicionable);
		}	catch(ExcCasilleroOcupado e){
			throw e;
		}
		posicionable.setPosicion(pos);
	}
	
	private boolean coordenadasEstanEnRango(Posicion pos) {
		return (pos.posX() >= 0 && pos.posX() < ancho && pos.posY() >= 0 && pos.posY() < alto);
	}
}