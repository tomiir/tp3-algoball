package Modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import Modelo.Excepciones.ErrorFatal;
import Modelo.Excepciones.ExcAtaqueIlegitimo;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcJugadorNoAutorizado;
import Modelo.Excepciones.ExcJugadorYaAtaco;
import Modelo.Excepciones.ExcMovimientoIlegitimo;
import Modelo.Excepciones.ExcNoHayPersonaje;
import Modelo.Excepciones.ExcPersonajeInmovilizado;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;

public class Partida {
	//LOGICA DE LA PARTIDA (turnos,...)
	boolean iniciada=false;
	Jugador jugador1;
	Jugador jugador2;
	Tablero tablero;
	Map<String, Integer> movsRestantes= new HashMap<String, Integer>();Map<String, Boolean> yaAtaco=w new HashMap<String, Boolean>();
	Map<String, Integer> turnosInmovilizados= new HashMap<String, Integer>();
	
	public Partida (Tablero tab, Jugador primerJugador, Jugador segundoJugador){
		tablero = tab;
		jugador1 = primerJugador;
		jugador2 = segundoJugador;
	}
	
	public void paralizarPorTurnos(Personaje personaje, int turnos){
		turnosInmovilizados.put(personaje.nombre(), turnos);
	}

	public void realizarAtaque(Jugador jugador, Personaje remitente, Personaje destinatario, boolean esEspecial){
		
	}
	
	public void realizarMovimiento(Jugador jugador, Personaje personaje, Direccion direccion) throws ExcMovimientoIlegitimo, ExcPosicionOcupada, ExcFueraDeTablero, ExcPersonajeInmovilizado{
		if(!movimientoLegitimo(jugador, personaje, direccion)) throw new ExcMovimientoIlegitimo();
		if(estaInmovilizado(personaje)) throw new ExcPersonajeInmovilizado();
		try {
			personaje.mover(direccion);
		} catch (ExcPosicionOcupada | ExcFueraDeTablero e) {
			throw e;
		}
	}
	
	public void iniciar(){
		if(iniciada==false){
			try {
				posicionPersonajesInicial();
				avanzarTurno();
			} catch (ExcHayGanador e) {
				throw new ErrorFatal();
			}
			iniciada=true;
		}
	}

	public void avanzarTurno() throws ExcHayGanador{
		if(hayGanador()) throw new ExcHayGanador(ganador());
		
		jugador1.equipo().forEach((k,v)->movsRestantes.put(k, v.velocidad()));
		jugador1.equipo().forEach((k,v)->yaAtaco.put(k,false));
		jugador1.equipo().forEach((k,v)->{
			if(!estaInmovilizado(v)) v.pasoDeTurno(5);
		});
		
		jugador2.equipo().forEach((k,v)->movsRestantes.put(k, v.velocidad()));
		jugador2.equipo().forEach((k,v)->yaAtaco.put(k,false));
		jugador2.equipo().forEach((k,v)->{
			if(!estaInmovilizado(v)) v.pasoDeTurno(5);
		});
		
		turnosInmovilizados.forEach((k,v)->v--);
	}
	
	public Equipo obtenerEquipoAliado(Personaje personaje) {
		
		Equipo equipo1 = jugador1.equipo();		
		Equipo equipo2 = jugador2.equipo();
		
		if(equipo1.personajePertenece(personaje)){
			return equipo1;
		}
		return equipo2;
	}

	public Personaje obtenerPersonaje(String nombre) throws ExcNoHayPersonaje{
		try {
			return jugador1.equipo().obtenerPersonaje(nombre);
		} catch (ExcNoHayPersonaje e) {
			return jugador2.equipo().obtenerPersonaje(nombre);
		}
	}
	
	public boolean estaInmovilizado(Personaje personaje){
		Integer turnos = turnosInmovilizados.get(personaje.nombre());
		if(turnos!=null && turnos>0) return true;
		return false;
	}

	public Tablero tablero() {
		return tablero;
	}
	
	private Jugador ganador(){
		return jugador1;
	}
	
	private boolean personajePerteneceAJugador(Jugador jugador, Personaje personaje){
		return jugador.equipo().personajePertenece(personaje);
	}
	
	private boolean hayGanador(){
		return false;
	}
	
	private boolean movimientoLegitimo(Jugador jugador, Personaje personaje){
		if(!personajePerteneceAJugador(jugador,personaje)) return false;
		if(movsRestantes.get(personaje.nombre())==0) return false;
		return true;
	}
	
	private void verificarAtaqueLegitimo(Jugador jugador, Personaje remitente, Personaje destinatario){
		if(!personajePerteneceAJugador(jugador,remitente)) throw new ExcJugadorNoAutorizado();
		if(yaAtaco.get(remitente.nombre())) throw new ExcJugadorYaAtaco();
	}
	
	private Jugador adversario(Jugador jugador){
		if(jugador==jugador1){
			return jugador2;
		}
		return jugador1;
	}
	
	private void posicionPersonajesInicial() {
		LinkedList<Personaje> listaEquipo1 = new LinkedList<Personaje>();
		LinkedList<Personaje> listaEquipo2 = new LinkedList<Personaje>();
		jugador1.equipo().forEach((n,p)->listaEquipo1.addLast(p));
		jugador2.equipo().forEach((n,p)->listaEquipo2.addLast(p));
		Iterator<Personaje> iter1 = listaEquipo1.iterator();
		int i = 1;
		while(iter1.hasNext()){
			try {
				tablero.posicionarPersonaje(iter1.next(), new Posicion(i, 1));
			} catch (ExcPosicionOcupada | ExcFueraDeTablero | ExcPosicionNegativa e) {
			}
			i++;
		}
		Iterator<Personaje> iter2 = listaEquipo2.iterator();
		i = 1;
		while(iter2.hasNext()){
			try {
				tablero.posicionarPersonaje(iter2.next(), new Posicion(i, tablero.alto()));
			} catch (ExcPosicionOcupada | ExcFueraDeTablero | ExcPosicionNegativa e) {
			}
			i++;
		}
	}
	
}

