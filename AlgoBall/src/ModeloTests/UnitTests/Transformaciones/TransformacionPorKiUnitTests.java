package ModeloTests.UnitTests.Transformaciones;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Transformacion;
import Modelo.Transformaciones.TransformacionPorKi;

public class TransformacionPorKiUnitTests {
	
	Tablero tablero = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "nombre", 300, 3, 3, 1);
	Transformacion trans = new TransformacionPorKi("Prueba", 10, 20, 30, 40);

	
	@Test
	public void transformacionSeCreaCorrectamente(){
		Assert.assertEquals("",trans.nombre(),"Prueba");
		Assert.assertEquals("",trans.costo(),10);
		Assert.assertEquals("",trans.rangoDeAtaque(),20);
		Assert.assertEquals("",trans.velocidad(),30);
		Assert.assertEquals("",trans.poderDePelea(),40);
	}
	
	@Test
	public void transformacionNoEsPosible(){
		Assert.assertFalse(trans.esPosible(personaje1));
	}
	
	@Test
	public void transformacionEsPosible(){
		personaje1.sumarKi(10);
		Assert.assertTrue(trans.esPosible(personaje1));
	}
}
