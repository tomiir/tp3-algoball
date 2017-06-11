package ModeloTests.UnitTests.Transformaciones;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.SemiPerfecto;

import org.junit.Assert;

public class SemiPerfectoUnitTest {
	Tablero tablero = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");

	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Personaje1", 300, 3, 3, 1);
	
	SemiPerfecto semiperfecto = new SemiPerfecto();
	
	@Test
	public void NoEsPosibleTransformarSemiPerfecto(){
		Assert.assertEquals(semiperfecto.esPosible(personaje1, partida),false);
	} 
	@Test
	public void esPosibleTransformarSemiPerfecto() {
		personaje1.setAbsorciones(4);
		Assert.assertEquals(semiperfecto.esPosible(personaje1, partida), true);
	}
	
}
