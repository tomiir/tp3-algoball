package ModeloTests.UnitTests.Transformaciones;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Perfecto;

import org.junit.Assert;

public class PerfectoUnitTest {
	Tablero tablero = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");

	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Personaje1", 300, 3, 3, 1);
	
	Perfecto perfecto = new Perfecto();
	
	@Test
	public void NoEsPosibleTransformarSemiPerfecto(){
		Assert.assertEquals(perfecto.esPosible(personaje1),false);
	} 
	@Test
	public void esPosibleTransformarSemiPerfecto() {
		personaje1.setAbsorciones(8);
		Assert.assertEquals(perfecto.esPosible(personaje1), true);
	}
	
}