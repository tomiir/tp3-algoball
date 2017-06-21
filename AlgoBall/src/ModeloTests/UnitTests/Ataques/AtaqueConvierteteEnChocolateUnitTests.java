package ModeloTests.UnitTests.Ataques;

import org.junit.Test;


import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.ConvierteteEnChocolate;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.PersonajeDePrueba;
import org.junit.Assert;

public class AtaqueConvierteteEnChocolateUnitTests {
	Tablero tablero = new Tablero(5, 5);
	PersonajeDePrueba personaje1 = new PersonajeDePrueba("Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba("Personaje2", 300, 3, 3, 1);
	Ataque convierteteEnChocolate = new ConvierteteEnChocolate();
	
	@Test
	public void seCreaCorrectamente(){
		Assert.assertEquals("El costo es correcto", convierteteEnChocolate.costo(), 30);
	}
	
	@Test
	public void atacaEInmoviliza() throws ExcAtaqueImposible, ExcEsChocolate, ExcNumeroNegativo{
		Assert.assertFalse(personaje2.esChocolate());
		convierteteEnChocolate.enviar(personaje1, personaje2, 0);
		Assert.assertTrue(personaje2.esChocolate());
	}
	
}
