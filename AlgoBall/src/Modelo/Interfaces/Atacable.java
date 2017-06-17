package Modelo.Interfaces;

import Modelo.Posicion;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;

public interface Atacable {
	public abstract int recibirDaño(int cantidad) throws ExcNumeroNegativo;
	public abstract boolean estaMuerto();
	public abstract Posicion posicion();
	public abstract String nombre();
	public abstract int poderDePelea();
	public abstract void convertirEnChocolate(int i) throws ExcEsChocolate ;
}
