package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Direccion;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeTablero;

public class DireccionUnitTests {
	
	@Test
	public void direccionSeCreaCorrectamente() throws ExcDireccionInvalida{
		Direccion direccion = new Direccion(1,0);
		Assert.assertEquals("La direccion en el eje 'x' es correcta", direccion.dx(), 1);
		Assert.assertEquals("La direccion en el eje 'y' es correcta", direccion.dy(), 0);
	}
	
	@Test (expected = ExcDireccionInvalida.class)
	public void direccionEstaAlLimite() throws ExcDireccionInvalida{
		new Direccion(2,0);
	}
}
