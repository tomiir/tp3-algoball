package ModeloTests.UnitTests.Ataques;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Tablero;
import Modelo.Ataques.Absorcion;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.Cell;
import Modelo.Personajes.PersonajeDePrueba;

public class AtaqueAbsorcionUnitTest {
	Tablero mundo = new Tablero(5, 5);
	Cell cell = new Cell();
	PersonajeDePrueba personaje2 = new PersonajeDePrueba("Nombre1", 300, 5, 3, 20);
	Absorcion absorcion = new Absorcion(cell);
	
	@Test
	public void seCreaCorrectamente () {
		Absorcion absorcion = new Absorcion(cell);
		
		Assert.assertEquals(absorcion.costo(), 5);
	}
	
	@Test
	public void haceElDañoCorrecto () throws ExcAtaqueImposible, ExcEsChocolate, ExcNumeroNegativo {
		
		int vida_anterior_cell = cell.puntosDeVida();
		int vida_anterior_personaje = personaje2.puntosDeVida();
		
		absorcion.enviar(cell,personaje2, 0);
	
		Assert.assertEquals(personaje2.puntosDeVida(), vida_anterior_personaje - cell.poderDePelea());
		Assert.assertEquals(cell.puntosDeVida(), vida_anterior_cell);
	}
}
