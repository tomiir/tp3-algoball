package Modelo;

import java.util.HashMap;
import java.util.Map;

import Modelo.Excepciones.ExcAtaqueIlegitimo;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Personajes.Personaje;

public class Partida {
	//LOGICA DE LA PARTIDA (turnos,...)
	//
	Jugador jugador1;
	Jugador jugador2;
	Tablero tablero;
	Map<String, Integer> movsRestantes= new HashMap<String, Integer>();
	Map<String, Boolean> yaAtaco= new HashMap<String, Boolean>();
	Map<String, Jugador> adversarios= new HashMap<String, Jugador>();
	
	public Partida (Tablero tab, Jugador primerJugador, Jugador segundoJugador){
		tablero = tab;
		jugador1 = primerJugador;
		jugador2 = segundoJugador;
		adversarios.put(jugador1.nombre(),jugador2);
		adversarios.put(jugador2.nombre(),jugador1);
		try {
			resetear();
		} catch (ExcHayGanador e) {
			throw new RuntimeException();
		}
	}

	public void realizarAtaque(Jugador jugador, Personaje personaje, Posicion posicion, boolean esEspecial){
		if(!ataqueLegitimo(jugador, personaje, posicion)) throw new ExcAtaqueIlegitimo();
		//tablero.obtenerCasillero(posicion).obtenerContenido();
	}
	
	public void resetear() throws ExcHayGanador{
		if(hayGanador()) throw new ExcHayGanador(ganador());
		jugador1.equipo.forEach((k,v)->movsRestantes.put(k, v.velocidad()));
		jugador1.equipo.forEach((k,v)->yaAtaco.put(k,false));
		jugador2.equipo.forEach((k,v)->movsRestantes.put(k, v.velocidad()));
		jugador2.equipo.forEach((k,v)->yaAtaco.put(k,false));
	}
	
	private Jugador ganador(){
		return jugador1;
		//Devuelve al ganador
	}
	
	private boolean personajePerteneceAJugador(Jugador jugador, Personaje personaje){
		return jugador.equipo().personajePertenece(personaje);
	}
	
	private boolean hayGanador(){
		return false;
		//Iterar equipos y ver si hay alguno con todos muertos
	}
	
	private boolean movimientoLegitimo(Jugador jugador, Personaje personaje, Direccion dir){
		if(!personajePerteneceAJugador(jugador,personaje)) return false;
		if(movsRestantes.get(personaje.nombre())==0) return false;
		return true;
	}
	
	private boolean ataqueLegitimo(Jugador jugador, Personaje personaje, Posicion posicion){
		if(!personajePerteneceAJugador(jugador,personaje)) return false;
		try {
			Posicionable pos=tablero.obtenerCasillero(posicion).obtenerContenido();
		} catch (ExcFueraDeTablero e) {
			return false;
		}
		if(!adversario(jugador).equipo().personajePertenece(personaje)) return false;
		return yaAtaco.get(personaje.nombre());
	}
	
	private Jugador adversario(Jugador jugador){
		return adversarios.get(jugador.nombre);
	}
	
}
