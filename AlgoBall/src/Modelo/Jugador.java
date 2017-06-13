package Modelo;

import Modelo.Excepciones.ExcAtaqueIlegitimo;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPersonajeInmovilizado;
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
	
	public void realizarAtaque(Jugador jugador, Personaje personaje, Posicion posicion, boolean esEspecial) throws ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado{
		
		if(estaInmovilizado(personaje)) throw new ExcPersonajeInmovilizado();
		try {
			destinatario = tablero.obtenerCasillero(posicion).obtenerPersonaje();
		} catch (ExcCasilleroDesocupado e) {
			throw new ExcAtaqueIlegitimo();
		}
		
		try {
			personaje.atacar(destinatario, esEspecial);
		} catch (ExcFueraDeRango | ExcAtaqueImposible e) {
			throw e;
		}
	}
	
	public void realizarAtaque (Personaje remitente, Personaje destinatario, boolean esEspecial){
		if(!partida.verificarAtaqueLegitimo(this, remitente, destinatario) throw ExcPoronga;
		if()
		
		
	}
	
	public Equipo equipo(){
		return equipo;
	}
	
	public String nombre(){
		return nombre;
	}
}
