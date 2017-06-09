package ModeloTests.UnitTests.Ataques;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.ConvierteteEnChocolate;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.PersonajeDePrueba;
import org.junit.Assert;

public class AtaqueConvierteteEnChocolateUnitTests {
	Tablero tablero = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "Personaje2", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba(partida, "Personaje3", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba(partida, "Personaje4", 300, 3, 3, 1);
	Ataque convierteteEnChocolate = new ConvierteteEnChocolate(partida);
	
	private void iniciarPartida(){
		equipo1.agregarPersonaje (personaje1);
		equipo1.agregarPersonaje (personaje2);
		equipo2.agregarPersonaje (personaje3);
		equipo2.agregarPersonaje (personaje4);
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		partida.iniciar();
	}
	
	@Test
	public void seCreaCorrectamente(){
		iniciarPartida();
		Assert.assertEquals("El costo es correcto", convierteteEnChocolate.costo(), 30);
	}
	
	@Test
	public void atacaEInmoviliza() throws ExcAtaqueImposible{
		iniciarPartida();
		Assert.assertFalse(partida.estaInmovilizado(personaje3));
		convierteteEnChocolate.enviar(personaje1, personaje3, 0);
		Assert.assertTrue(partida.estaInmovilizado(personaje3));
	}
	
}
