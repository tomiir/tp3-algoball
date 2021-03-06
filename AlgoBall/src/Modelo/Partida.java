package Modelo;


import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import Modelo.Consumibles.Consumible;
import Modelo.Consumibles.EsferaDelDragon;
import Modelo.Consumibles.NubeVoladora;
import Modelo.Consumibles.SemillaDeErmitanio;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcDestinatarioEnEquipoPropio;
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
import Modelo.Interfaces.Atacable;
import Modelo.Personajes.Personaje;

public class Partida {
	
	protected boolean iniciada=false;
	protected Jugador jugador1;
	protected Jugador jugador2;
	protected Jugador jugadorActivo;
	
	protected Tablero tablero;	
	
	public Partida (Tablero tablero, Jugador primerJugador, Jugador segundoJugador){
		this.tablero = tablero;
		jugador1 = primerJugador;
		jugador2 = segundoJugador;
		
		jugadorActivo = randomJugadorInicial();
		
	}
	
	private Jugador randomJugadorInicial() {
		Random generador = new Random();
		int randomNum = generador.nextInt(2);
		
		if(randomNum == 0) return jugador1;
		return jugador2;
		
	}

	public void iterarPersonajes(Consumer<Personaje> action){
		jugador1.equipo().forEach(action);
		jugador2.equipo().forEach(action);
	}
	
	public void realizarAtaqueNormal(Jugador jugador, Personaje remitente, Posicion posicion) throws ExcJugadorNoAutorizado, ExcJugadorYaAtacoOTransformo, ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcDestinatarioEnEquipoPropio, ExcCasilleroDesocupado{
		Atacable destinatario = tablero.obtenerCasillero(posicion).obtenerAtacable();
		if(verificarAtaqueLegitimo(jugador, remitente, destinatario)) jugador.realizarAtaqueNormal(remitente, destinatario);
		tablero.removerSiEstaMuerto(destinatario);
	}
	
	public void realizarAtaqueEspecial(Jugador jugador, Personaje remitente, Posicion posicion) throws ExcJugadorNoAutorizado, ExcJugadorYaAtacoOTransformo, ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcDestinatarioEnEquipoPropio, ExcCasilleroDesocupado{
		Atacable destinatario = tablero.obtenerCasillero(posicion).obtenerAtacable();
		if(verificarAtaqueLegitimo(jugador, remitente, destinatario)) jugador.realizarAtaqueEspecial(remitente, destinatario);
		tablero.removerSiEstaMuerto(destinatario);
	}
	
	
	public void realizarMovimiento(Jugador jugador, Personaje personaje, Posicion posicion) throws ExcFueraDeTablero, ExcJugadorNoAutorizado, ExcJugadorYaMovio, ExcEsChocolate, ExcCasilleroOcupado, ExcFueraDeRango{
		if(verificarMovimientoLegitimo(jugador, personaje)) jugador.realizarMovimiento(personaje, posicion);
	
	}
	
	public void realizarTransformacion(Jugador jugador, Personaje personaje) throws ExcNoEsPosibleTransformarse, ExcEsChocolate, ExcJugadorYaAtacoOTransformo{
		
		if(jugador.realizoAtaque() || jugador.realizoTransformacion()) throw new ExcJugadorYaAtacoOTransformo();
		jugador.realizarTransformacion(personaje);
	}
	
	public void iniciar() throws ExcHayGanador{
		if(iniciada==false){
			try {
				posicionPersonajesInicial();
				avanzarTurno();
			} catch (ExcHayGanador e) {
				throw e;
			}
			iniciada=true;
		}
	}

	public void avanzarTurno() throws ExcHayGanador{
		if(hayGanador()) throw new ExcHayGanador(ganador());
		
		cambiarJugadorActivo();
		jugadorActivo.pasarTurno();
		this.posicionarConsumibleRandom();
	}
	
	

	private void cambiarJugadorActivo() {

		if(jugadorActivo == jugador1) jugadorActivo = jugador2;
		else jugadorActivo = jugador1 ;
	}

	public Equipo obtenerEquipoAliado(Personaje personaje) {
		
		Equipo equipo1 = jugador1.equipo();		
		Equipo equipo2 = jugador2.equipo();
		
		if(equipo1.personajePertenece(personaje.nombre())){
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
	
	public void iterarCasilleros(BiConsumer<Casillero,Posicion> accion){
		tablero.iterarCasilleros(accion);
	}
	
	private Jugador ganador(){
		if (jugador1.equipo().perdio()) return jugador2;
		if (jugador2.equipo().perdio()) return jugador1;
		return null;
	}
	
	private boolean verificarAtaqueLegitimo(Jugador jugador, Personaje remitente, Atacable destinatario) throws ExcJugadorNoAutorizado, ExcJugadorYaAtacoOTransformo, ExcDestinatarioEnEquipoPropio{
		if(!personajePerteneceAJugador(jugador,remitente.nombre())) throw new ExcJugadorNoAutorizado();
		if(personajePerteneceAJugador(jugador,destinatario.nombre())) throw new ExcDestinatarioEnEquipoPropio();
		if(jugador.realizoAtaque() || jugador.realizoTransformacion()) throw new ExcJugadorYaAtacoOTransformo();
		return true;
	}
	
	private boolean verificarMovimientoLegitimo(Jugador jugador, Personaje personaje) throws ExcJugadorNoAutorizado, ExcJugadorYaMovio{
		if(!personajePerteneceAJugador(jugador,personaje.nombre())) throw new ExcJugadorNoAutorizado();
		if(jugador.realizoMovimiento()) throw new ExcJugadorYaMovio();
		return true;
	}
	
	private boolean personajePerteneceAJugador(Jugador jugador, String nombre){
		return jugador.equipo().personajePertenece(nombre);
	}
	
	private boolean hayGanador(){
		return (jugador1.equipo().perdio() || jugador2.equipo().perdio());
	}
	
	private void posicionPersonajesInicial() {
		LinkedList<Personaje> listaEquipo1 = new LinkedList<Personaje>();
		LinkedList<Personaje> listaEquipo2 = new LinkedList<Personaje>();
		jugador1.equipo().forEach((p)->listaEquipo1.addLast(p));
		jugador2.equipo().forEach((p)->listaEquipo2.addLast(p));
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
				tablero.posicionarPersonaje(iter2.next(), new Posicion(tablero.dimension().ancho()-i, tablero.dimension().alto()));
			} catch (ExcFueraDeTablero | ExcCasilleroOcupado | ExcPosicionNegativa e) {
			}
			i++;
		}
	}
	
	public Jugador esTurnoDelJugador(){
		return jugadorActivo;
	}

	private void posicionarConsumibleRandom(){
		
		Random generador = new Random();
		int numeroConsumible = generador.nextInt(3);
		Consumible consumible = new NubeVoladora();
		
		if(numeroConsumible == 1) consumible = new EsferaDelDragon();
		else if(numeroConsumible == 2) consumible = new SemillaDeErmitanio();
		
		int randAlto = generador.nextInt(tablero.dimension().alto());
		int randAncho = generador.nextInt(tablero.dimension().ancho());
		int randChance = generador.nextInt(10);
		
		//20% de chances de aparicion
		if(randChance <= 3)
			try {
				tablero.posicionarConsumible(consumible, new Posicion(randAncho,randAlto));
			} catch (ExcCasilleroOcupado | ExcFueraDeTablero | ExcPosicionNegativa e) {	}
		}
}

