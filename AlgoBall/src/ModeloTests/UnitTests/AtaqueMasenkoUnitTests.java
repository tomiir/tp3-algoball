package ModeloTests.UnitTests;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.Masenko;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.PersonajeDePrueba;
import org.junit.Assert;

public class AtaqueMasenkoUnitTests {
	Tablero tablero = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Nombre1", 300, 5, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "Nombre1", 300, 5, 3, 50);

	@Test
	public void seCreaCorrectamente () {
		Masenko masenko = new Masenko();
		
		Assert.assertEquals(masenko.costo(), 10);
	}
	
	@Test
	public void haceElDañoCorrecto () throws ExcAtaqueImposible {
		Masenko masen = new Masenko();
		masen.enviar(personaje1, personaje2, 0);
	
		Assert.assertEquals(personaje2.puntosDeVida(), 300 - (personaje1.poderDePelea()*125) / 100);
	}
}