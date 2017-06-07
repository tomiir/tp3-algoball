package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Posicion;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcPosicionNegativa;

public class PosicionUnitTests {
	
	@Test
	public void posicionSeCreaCorrectamente() throws ExcPosicionNegativa {
		Posicion pos = new Posicion(20,34);
		Assert.assertEquals("La direccion en el eje 'x' es correcta", pos.posX(), 20);
		Assert.assertEquals("La direccion en el eje 'y' es correcta", pos.posY(), 34);
	}
	
	@Test (expected = ExcPosicionNegativa.class)
	public void posicionNegativaNoSePuedeCrear() throws ExcPosicionNegativa, ExcDireccionInvalida {
		Posicion pos1 = new Posicion(-1,1);
	}
	
	@Test
	public void posicionCalculaSuDistanciaBien() throws ExcPosicionNegativa, ExcDireccionInvalida {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(2,6);
		Assert.assertEquals("La posicion es lo que debe ser",pos1.distanciaA(pos2),4);
	}
}
