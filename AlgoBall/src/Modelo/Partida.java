package Modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import Modelo.Excepciones.ErrorFatal;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcJugadorNoAutorizado;
import Modelo.Excepciones.ExcJugadorYaAtacoOTransformo;
import Modelo.Excepciones.ExcJugadorYaMovio;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNoHayPersonaje;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcRemitenteEnEquipoPropio;
import Modelo.Personajes.Personaje;

public class Partida {
	
	boolean iniciada=false;
	Jugador jugador1;
	Jugador jugador2;
	Tablero tablero;
	Map<String, Boolean> yaMovio= new HashMap<String, Boolean>();
	Map<String, Boolean> yaAtacoOTransformo=new HashMap<String, Boolean>();
	
	public Partida (Tablero tablero, Jugador primerJugador, Jugador segundoJugador){
		this.tablero = tablero;
		jugador1 = primerJugador;
		jugador2 = segundoJugador;
	}
	
	public void iterarPersonajes(BiConsumer<String, Personaje> action){
		jugador1.equipo().forEach(action);
		jugador2.equipo().forEach(action);
	}
	
	public void realizarAtaque(Jugador jugador, Personaje remitente, Personaje destinatario, boolean esEspecial) throws ExcJugadorNoAutorizado, ExcJugadorYaAtacoOTransformo, ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcRemitenteEnEquipoPropio{
		if(verificarAtaqueLegitimo(jugador, remitente, destinatario)) jugador.realizarAtaque(remitente, destinatario, esEspecial);
	}
	
	public void realizarMovimiento(Jugador jugador, Personaje personaje, Posicion posicion) throws ExcFueraDeTablero, ExcJugadorNoAutorizado, ExcJugadorYaMovio, ExcEsChocolate, ExcCasilleroOcupado, ExcCasilleroDesocupado, ExcFueraDeRango{
		if(verificarMovimientoLegitimo(jugador, personaje)) jugador.realizarMovimiento(personaje, posicion);
	}
	
	public void realizarTransformacion(Jugador jugador, Personaje personaje) throws ExcNoEsPosibleTransformarse, ExcEsChocolate, ExcJugadorYaAtacoOTransformo{
		if(jugadorYaAtacoOTransformo(jugador)) throw new ExcJugadorYaAtacoOTransformo();
		jugador.realizarTransformacion(personaje);
	}
	
	public void iniciar() throws ErrorFatal{
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
		
		yaMovio.put(jugador1.nombre, false);
		yaAtacoOTransformo.put(jugador1.nombre,false);
		jugador1.equipo().forEach((k,v)->{
			try {
				v.seAvanzoUnTurno(5);
			} catch (ExcNumeroNegativo e) {
			}
		});
		
		yaMovio.put(jugador2.nombre, false);
		yaAtacoOTransformo.put(jugador2.nombre,false);
		jugador2.equipo().forEach((k,v)->{
			try {
				v.seAvanzoUnTurno(5);
			} catch (ExcNumeroNegativo e) {
			}
		});
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

	public Tablero tablero() {
		return tablero;
	}
	
	private Jugador ganador(){
		return jugador1;
	}
	
	private boolean verificarAtaqueLegitimo(Jugador jugador, Personaje remitente, Personaje destinatario) throws ExcJugadorNoAutorizado, ExcJugadorYaAtacoOTransformo, ExcRemitenteEnEquipoPropio{
		if(!personajePerteneceAJugador(jugador,remitente)) throw new ExcJugadorNoAutorizado();
		if(personajePerteneceAJugador(jugador,destinatario)) throw new ExcRemitenteEnEquipoPropio();
		if(jugadorYaAtacoOTransformo(jugador)) throw new ExcJugadorYaAtacoOTransformo();
		return true;
	}
	
	private boolean verificarMovimientoLegitimo(Jugador jugador, Personaje personaje) throws ExcJugadorNoAutorizado, ExcJugadorYaMovio{
		if(!personajePerteneceAJugador(jugador,personaje)) throw new ExcJugadorNoAutorizado();
		if(jugadorYaMovio(jugador)) throw new ExcJugadorYaMovio();
		return true;
	}
	
	private boolean personajePerteneceAJugador(Jugador jugador, Personaje personaje){
		return jugador.equipo().personajePertenece(personaje);
	}
	
	private boolean hayGanador(){
		return false;
	}
	
	private boolean jugadorYaMovio(Jugador jugador){
		return yaMovio.get(jugador.nombre);
	}
	
	private boolean jugadorYaAtacoOTransformo(Jugador jugador){
		return yaAtacoOTransformo.get(jugador);
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
			} catch (ExcFueraDeTablero | ExcCasilleroOcupado | ExcPosicionNegativa e) {
			}
			i++;
		}
		Iterator<Personaje> iter2 = listaEquipo2.iterator();
		i = 0;
		while(iter2.hasNext()){
			try {
				tablero.posicionarPersonaje(iter2.next(), new Posicion(tablero.ancho()-i, tablero.alto()));
			} catch (ExcFueraDeTablero | ExcCasilleroOcupado | ExcPosicionNegativa e) {
			}
			i++;
		}
	}
	

	
}

