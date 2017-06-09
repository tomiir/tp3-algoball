package ModeloTests.Entregas.Primera;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test07 {
	Tablero tablero = new Tablero(15,14);
	Jugador primerJugador = new Jugador("nombre1");
	Jugador segundoJugador = new Jugador("nombre2");
	Partida partida = new Partida(tablero, primerJugador, segundoJugador);
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba (partida, "Nombre", 300, 1, 3,100);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba (partida, "Nombre", 300, 1, 3,200);
	
	@Test
	public void atacaConDañoEsperado () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		
		int pts1inicial=personaje1.puntosDeVida();
		int pts2inicial=personaje2.puntosDeVida();
		
		personaje1.atacar(personaje2, false);
		Assert.assertEquals("El personaje2 recibe el daño esperado",pts2inicial-personaje2.puntosDeVida(),(100*8)/10);
		personaje2.atacar(personaje1, false);
		Assert.assertEquals("El personaje1 recibe el daño esperado",pts1inicial-personaje1.puntosDeVida(),200);
	}
	
	@Test (expected = ExcFueraDeRango.class)
	public void ataqueFueraDeRango() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,4));
		personaje1.atacar(personaje2, false);
	}
}
