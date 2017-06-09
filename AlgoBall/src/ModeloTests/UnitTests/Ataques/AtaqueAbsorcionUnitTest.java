package ModeloTests.UnitTests.Ataques;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.Absorcion;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Cell;
import Modelo.Personajes.PersonajeDePrueba;

public class AtaqueAbsorcionUnitTest {
	Jugador jug1 = new Jugador("Jug1");
	Jugador jug2 = new Jugador("Jug2");
	Equipo equipo1 = new Equipo("Equi1");
	Equipo equipo2 = new Equipo("Equi2");
	
	Tablero mundo = new Tablero(5, 5);
	
	Partida partida = new Partida(mundo,jug1,jug2);
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Nombre1", 300, 5, 3, 20);
	Cell cell = new Cell(partida);

	@Test
	public void seCreaCorrectamente () {
		Absorcion absorcion = new Absorcion(cell);
		
		Assert.assertEquals(absorcion.costo(), 5);
	}
	
	@Test
	public void haceElDañoCorrecto () throws ExcAtaqueImposible {
		
		int vida_anterior_cell = cell.puntosDeVida();
		int vida_anterior_personaje = personaje1.puntosDeVida();
		
		Absorcion absorcion = new Absorcion(cell);
		absorcion.enviar(cell,personaje1, 0);
	
		Assert.assertEquals(personaje1.puntosDeVida(), vida_anterior_personaje - cell.poderDePelea());
		Assert.assertEquals(cell.puntosDeVida(), vida_anterior_cell+cell.poderDePelea());
	}
}
