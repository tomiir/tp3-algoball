package ModeloTests.UnitTests;

import org.junit.Test;
import org.junit.Assert;

import Modelo.Casillero;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class CasilleroUnitTests {
	Tablero tablero = new Tablero(10,10);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Personaje personaje1 = new PersonajeDePrueba (partida, "Nombre", 300, 5, 3,100);
	Casillero casilleroNuevo = new Casillero();
	
	@Test
	public void seCreaCorrectamente(){
		Assert.assertTrue(!casilleroNuevo.estaOcupado());
	}
	
	@Test
	public void seOcupaCorrectamente() throws ExcCasilleroOcupado{
		casilleroNuevo.ocupar(personaje1);
		Assert.assertTrue(casilleroNuevo.estaOcupado());
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedeOcuparSiEstaOcupado() throws ExcCasilleroOcupado{
		casilleroNuevo.ocupar(personaje1);
		Assert.assertTrue(casilleroNuevo.estaOcupado());
		casilleroNuevo.ocupar(personaje1);
	}
}
