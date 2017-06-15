package ModeloTests.UnitTests;

import org.junit.Test;
import org.junit.Assert;

import Modelo.Casillero;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class CasilleroUnitTests {
	Tablero tablero = new Tablero(10,10);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	Casillero casilleroNuevo = new Casillero();
	
	@Test
	public void seCreaCorrectamente(){
		Assert.assertTrue(!casilleroNuevo.estaOcupado());
	}
	
	@Test
	public void seOcupaCorrectamente() throws ExcCasilleroOcupado{
		casilleroNuevo.ocuparAtacable(personaje1);
		Assert.assertTrue(casilleroNuevo.estaOcupado());
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedeOcuparSiEstaOcupado() throws ExcCasilleroOcupado{
		casilleroNuevo.ocuparAtacable(personaje1);
		Assert.assertTrue(casilleroNuevo.estaOcupado());
		casilleroNuevo.ocuparAtacable(personaje1);
	}
}
