package ModeloTests.UnitTests.Transformaciones;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Tablero;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Perfecto;

import org.junit.Assert;

public class PerfectoUnitTest {
	Tablero tablero = new Tablero(5, 5);
	PersonajeDePrueba personaje1 = new PersonajeDePrueba("Personaje1", 300, 3, 3, 1);
	
	Perfecto perfecto = new Perfecto();
	
	@Test
	public void NoEsPosibleTransformarSemiPerfecto(){
		Equipo equipo = new Equipo("Equipo");
		equipo.agregarPersonaje(personaje1);
		Assert.assertFalse(perfecto.esPosible(personaje1, equipo)); 
	}
		
	@Test
	public void esPosibleTransformarSemiPerfecto() {
		Equipo equipo = new Equipo("Equipo");
		equipo.agregarPersonaje(personaje1);
		personaje1.setAbsorciones(8);
		Assert.assertTrue(perfecto.esPosible(personaje1,equipo));
	}
	
}