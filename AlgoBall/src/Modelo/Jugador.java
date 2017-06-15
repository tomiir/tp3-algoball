package Modelo;

import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Personajes.Personaje;

public class Jugador {
	
	String nombre;
	Equipo equipo;
	
	
	public Jugador(String nombreNuevo){
		this.nombre = nombreNuevo;
	}
	
	public void asignarEquipo(Equipo equipoNuevo){
		this.equipo = equipoNuevo;
	}
	
	public void realizarAtaque(Personaje remitente, Personaje destinatario, boolean esEspecial) throws ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo{
		remitente.atacar(destinatario, esEspecial);
	}
	
	public void realizarMovimiento(Personaje personaje, Posicion posicion) throws ExcFueraDeTablero, ExcEsChocolate, ExcCasilleroOcupado{
		personaje.mover(posicion);
	}
	
	public void realizarTransformacion(Personaje personaje) throws ExcNoEsPosibleTransformarse, ExcEsChocolate{
		personaje.transformar(equipo);
	}
	
	
	public Equipo equipo(){
		return equipo;
	}
	
	public String nombre(){
		return nombre;
	}
}
