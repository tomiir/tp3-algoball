package Modelo;

import Modelo.Excepciones.ExcCasilleroOcupado;

public class Casillero {
	Posicionable contenido;
	
	public Posicionable obtenerContenido(){
		return contenido;
	}

	public boolean estaOcupado() {
		if(contenido==null) return false;
		return true;
	}

	public void ocupar(Posicionable posicionable) throws ExcCasilleroOcupado{
		if(estaOcupado()) throw new ExcCasilleroOcupado();
		contenido=posicionable;
	}

	public void desocupar() {
		contenido=null;
	}
}

