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

	public void posicionar(Posicionable posicionable, Posicion pos) throws ExcPosicionOcupada, ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(pos)) throw new ExcFueraDeTablero();
		Posicion posAnterior = posicionable.posicion();
		if(casilleros.containsKey(pos)){
			throw new ExcPosicionOcupada();
		} else {
			Casillero casilleroNuevo= new Casillero(posicionable);
			casilleros.put(pos, casilleroNuevo);
		}
		posicionable.setPosicion(pos);
		casilleros.remove(posAnterior);
	}
	
	private boolean coordenadasEstanEnRango(Posicion pos) {
		return (pos.posX() >= 0 && pos.posX() < ancho && pos.posY() >= 0 && pos.posY() < alto);
	}
}