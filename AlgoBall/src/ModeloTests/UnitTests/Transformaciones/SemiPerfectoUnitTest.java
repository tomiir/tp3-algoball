package ModeloTests.UnitTests.Transformaciones;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Tablero;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.SemiPerfecto;

import org.junit.Assert;

public class SemiPerfectoUnitTest {
	Tablero tablero = new Tablero(5, 5);
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba("Personaje1", 300, 3, 3, 1);
	
	SemiPerfecto semiperfecto = new SemiPerfecto();
	
	@Test
	public void NoEsPosibleTransformarSemiPerfecto(){
		Equipo equipo = new Equipo("Equipo");
		equipo.agregarPersonaje(personaje1);
		Assert.assertEquals(semiperfecto.esPosible(personaje1,equipo),false);
	} 
	@Test
	public void esPosibleTransformarSemiPerfecto() {
		personaje1.setAbsorciones(4);
		Equipo equipo = new Equipo("Equipo");
		equipo.agregarPersonaje(personaje1);
		Assert.assertEquals(semiperfecto.esPosible(personaje1,equipo), true);
	}
	
}
