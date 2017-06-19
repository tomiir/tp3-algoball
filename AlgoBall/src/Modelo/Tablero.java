package Modelo;

import java.util.function.BiConsumer;

import Modelo.Consumibles.Consumible;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Interfaces.Atacable;
import Modelo.Personajes.Personaje;

public class Tablero {
	protected Casillero[][] casilleros;
	protected int ancho; 
	protected int alto;
	
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
	
	public void posicionarPersonaje(Personaje personaje, Posicion pos) throws ExcFueraDeTablero, ExcCasilleroOcupado{
		Casillero casNuevo = obtenerCasillero(pos);
		Posicion posAnterior = personaje.posicion();
		
		casNuevo.ocuparAtacable(personaje);
		
		if(posAnterior!=null) obtenerCasillero(posAnterior).desocupar();
		personaje.setPosicion(pos);
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
	
	public void removerSiEstaMuerto(Atacable atacable){	
		if(atacable.estaMuerto()){
			Posicion posicion = atacable.posicion();
			Casillero casillero = casilleros[posicion.posX()-1][posicion.posY()-1];
			casillero.desocupar();	
		}
	}

	public void posicionarConsumible(Consumible consumible, Posicion posicion) throws ExcCasilleroOcupado, ExcFueraDeTablero {
		
		Casillero casillero = this.obtenerCasillero(posicion);
		if(!casillero.tieneUnConsumible() && !casillero.estaOcupado()) casillero.ocuparConsumible(consumible);
		
		
	}

	public void iterarCasilleros(BiConsumer<Casillero,Posicion> accion) {
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				try {
					accion.accept(casilleros[i][j], new Posicion(i+1,j+1));
				} catch (ExcPosicionNegativa e) {
				}
			}
		}
	}	
	
}