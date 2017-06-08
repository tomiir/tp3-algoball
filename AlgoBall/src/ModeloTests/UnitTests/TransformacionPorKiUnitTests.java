package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Tablero;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Transformacion;
import Modelo.Transformaciones.TransformacionPorKi;

public class TransformacionPorKiUnitTests {
	
	Tablero tablero = new Tablero(15,14);
	Transformacion trans = new TransformacionPorKi("Prueba", 10, 20, 30, 40);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 1, 3,100);
	
	
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
