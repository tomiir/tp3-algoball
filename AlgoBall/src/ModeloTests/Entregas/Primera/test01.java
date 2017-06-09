package ModeloTests.Entregas.Primera;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Direccion;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test01 {
	Tablero tablero = new Tablero(15,14);
	Jugador primerJugador = new Jugador("nombre1");
	Jugador segundoJugador = new Jugador("nombre2");
	Partida partida = new Partida(tablero, primerJugador, segundoJugador);
	Personaje personaje1 = new PersonajeDePrueba (partida, "Nombre", 300, 5, 3,100);
	
	@Test
	public void seMueveCorrectamenteEnLineaRecta() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 2, personaje1.posicion().posY());
		
		personaje1.mover (new Direccion(1,-1));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
		
		personaje1.mover (new Direccion(-1,0));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
		
		personaje1.mover (new Direccion(0,1));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
}
