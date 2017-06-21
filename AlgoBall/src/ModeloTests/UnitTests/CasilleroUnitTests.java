package ModeloTests.UnitTests;

import org.junit.Test;
import org.junit.Assert;

import Modelo.Casillero;
import Modelo.Consumibles.NubeVoladora;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class CasilleroUnitTests {
	Personaje personaje1 = new PersonajeDePrueba ("Jorge", 300, 5, 3,100);
	Casillero casilleroNuevo = new Casillero();
	NubeVoladora nube = new NubeVoladora();
	
	
	
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
	
	@Test
	public void desocuparCasillero() throws ExcCasilleroOcupado{
		casilleroNuevo.ocuparAtacable(personaje1);
		Assert.assertTrue(casilleroNuevo.estaOcupado());
		casilleroNuevo.desocupar();
		Assert.assertTrue(!casilleroNuevo.estaOcupado());		
	}
	
	
}
