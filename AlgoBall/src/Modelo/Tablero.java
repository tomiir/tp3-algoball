package Modelo;

import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;

public class Tablero {
	Casillero[][] casilleros;
	int ancho; 
	int alto;
	
	public Tablero(int anchoDeseado, int altoDeseado){
		ancho = anchoDeseado;
		alto = altoDeseado;
		casilleros = new Casillero[ancho][alto];
		inicializarCasilleros(casilleros);
	}

	public Casillero obtenerCasillero(Posicion posicion) throws ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(posicion)) throw new ExcFueraDeTablero();
		return casilleros[posicion.posX()-1][posicion.posY()-1];
	}
	
	public int ancho(){
		return ancho;
	}
	
	public int alto(){
		return alto;
	}
	
	public void posicionarPersonaje(Personaje p, Posicion pos) throws ExcPosicionOcupada, ExcFueraDeTablero{
		Casillero casNuevo = obtenerCasillero(pos);
		Posicion posAnterior = p.posicion();
		try{
			casNuevo.ocupar(p);
		} catch(ExcCasilleroOcupado e){
			throw new ExcPosicionOcupada();
		}
		if(posAnterior!=null) obtenerCasillero(p.posicion()).desocupar();
		p.setPosicion(pos);
	}
	
	private boolean coordenadasEstanEnRango(Posicion pos) {
		return (pos.posX() > 0 && pos.posX() <= ancho && pos.posY() > 0 && pos.posY() <= alto);
	}
	
	private void inicializarCasilleros(Casillero[][] casilleros) {
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				casilleros[i][j]=new Casillero();
			}
		}
	}
}