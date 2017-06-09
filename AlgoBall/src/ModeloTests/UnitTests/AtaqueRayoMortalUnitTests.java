package ModeloTests.UnitTests;

import org.junit.Test;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.RayoMortal;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.PersonajeDePrueba;
import org.junit.Assert;

public class AtaqueRayoMortalUnitTests {
	Tablero mundo = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(mundo, jugador1, jugador2);
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Nombre1", 300, 5, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "Nombre1", 300, 5, 3, 50);

	@Test
	public void seCreaCorrectamente () {
		RayoMortal rayo = new RayoMortal();
		
		Assert.assertEquals(rayo.costo(), 20);
	}
	
	@Test
	public void haceElDañoCorrecto () throws ExcAtaqueImposible {
		RayoMortal rayo = new RayoMortal();
		rayo.enviar(personaje1, personaje2, 0);
	
		Assert.assertEquals(personaje2.puntosDeVida(), 300 - (personaje1.poderDePelea()*150) / 100);
	}
}
