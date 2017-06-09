package ModeloTests.UnitTests.Ataques;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.Kamekameha;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.PersonajeDePrueba;
import org.junit.Assert;

public class AtaqueKamekamehaUnitTests {
	
	
	Tablero mundo = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(mundo, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Nombre1", 300, 5, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "Nombre1", 300, 5, 3, 50);
	
	@Test
	public void seCreaCorrectamente () {
		Kamekameha kame = new Kamekameha();
		
		Assert.assertEquals(kame.costo(), 20);
	}
	
	@Test
	public void haceElDañoCorrecto () throws ExcAtaqueImposible {
		Kamekameha kame = new Kamekameha();
		kame.enviar(personaje1, personaje2, 0);
	
		Assert.assertEquals(personaje2.puntosDeVida(), 300 - (personaje1.poderDePelea()*150) / 100);
	}
		
	
	
	
}
