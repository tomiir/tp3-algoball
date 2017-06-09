package ModeloTests.Entregas.Primera;

import org.junit.Test;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test02 {
	
	Tablero tablero = new Tablero(15,14);
	Jugador primerJugador = new Jugador("nombre1");
	Jugador segundoJugador = new Jugador("nombre2");
	Partida partida = new Partida(tablero, primerJugador, segundoJugador);
	Personaje personaje1 = new PersonajeDePrueba (partida, "Nombre1", 300, 5, 3,100);
	Personaje personaje2 = new PersonajeDePrueba (partida, "Nombre2", 300, 5, 3,100);
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedePosicionarEnCasilleroOcupado() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.posicionarPersonaje(personaje1, new Posicion(14,14));
		tablero.posicionarPersonaje(personaje2, new Posicion(14,14));
	}
}
