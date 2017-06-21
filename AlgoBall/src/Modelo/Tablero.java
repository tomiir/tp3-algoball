package Modelo;

import java.util.function.BiConsumer;

import Modelo.Consumibles.Consumible;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Interfaces.Atacable;
import Modelo.Personajes.Personaje;

public class Tablero {
	protected Casillero[][] casilleros;
	protected Dimension dimension;
	
	public Tablero(int anchoDeseado, int altoDeseado){
		dimension = new Dimension(anchoDeseado, altoDeseado);
		casilleros = new Casillero[dimension().ancho()][dimension().alto()];
		inicializarCasilleros(casilleros);
	}

	public Casillero obtenerCasillero(Posicion posicion) throws ExcFueraDeTablero{
		if(!dimension.posicionEstaEnDimension(posicion)) throw new ExcFueraDeTablero();
		return casilleros[posicion.posX()-1][posicion.posY()-1];
	}
	
	public Dimension dimension(){
		return dimension;
	}
	
	public void posicionarPersonaje(Personaje personaje, Posicion pos) throws ExcFueraDeTablero, ExcCasilleroOcupado{
		Casillero casNuevo = obtenerCasillero(pos);
		Posicion posAnterior = personaje.posicion();
		
		casNuevo.ocuparAtacable(personaje);
		
		if(posAnterior!=null) obtenerCasillero(posAnterior).desocupar();
		personaje.setPosicion(pos);
	}
	
	public void moverPersonaje(Personaje personaje, Posicion posicion) throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcFueraDeRango, ExcEsChocolate{
		if(personaje.esChocolate()) throw new ExcEsChocolate();
		if(personaje.estaEnRango(posicion, personaje.velocidadActual()) ){
			this.posicionarPersonaje(personaje, posicion);
		} else {
			throw new ExcFueraDeRango();
		}
		
		if(this.obtenerCasillero(posicion).tieneUnConsumible()){
			Consumible consumible;
			try {
				consumible = this.obtenerCasillero(posicion).obtenerConsumible();
				personaje.consumir(consumible, posicion);
				this.obtenerCasillero(posicion).desocuparConsumible();
			} catch (ExcCasilleroDesocupado e) {}
		}	
	}
	
	private void inicializarCasilleros(Casillero[][] casilleros) {
		for(int i=0;i<dimension().ancho();i++){
			for(int j=0;j<dimension().alto();j++){
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
		for(int i=0;i<dimension().ancho();i++){
			for(int j=0;j<dimension().alto();j++){
				try {
					accion.accept(casilleros[i][j], new Posicion(i+1,j+1));
				} catch (ExcPosicionNegativa e) {
				}
			}
		}
	}	
	
}