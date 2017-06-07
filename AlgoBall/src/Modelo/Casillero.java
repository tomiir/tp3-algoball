package Modelo;

import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Personajes.Personaje;

public class Casillero {
	Personaje personaje;
	
	public Personaje obtenerPersonaje(){
		return personaje;
	}

	public boolean estaOcupado() {
		if(personaje==null) return false;
		return true;
	}

	public void ocupar(Personaje p) throws ExcCasilleroOcupado{
		if(estaOcupado()) throw new ExcCasilleroOcupado();
		personaje=p;
	}

	public void desocupar() {
		personaje=null;
	}
}

