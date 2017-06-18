package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Posicion;
import Modelo.Excepciones.ExcPosicionNegativa;

public class PosicionUnitTests {
	
	@Test
	public void posicionSeCreaCorrectamente() throws ExcPosicionNegativa {
		Posicion pos = new Posicion(20,34);
		Assert.assertEquals("La direccion en el eje 'x' es correcta", pos.posX(), 20);
		Assert.assertEquals("La direccion en el eje 'y' es correcta", pos.posY(), 34);
	}
	
	@Test (expected = ExcPosicionNegativa.class)
	public void posicionNegativaNoSePuedeCrear() throws ExcPosicionNegativa {
		new Posicion(-1,1);
	}
	
	@Test
	public void posicionCalculaSuDistanciaBien() throws ExcPosicionNegativa {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(2,6);
		Assert.assertEquals("La distancia es lo que debe",pos1.distanciaA(pos2),5);
		
		pos1 = new Posicion(1,2);
		pos2 = new Posicion(1,4);
		Assert.assertEquals("La distancia es lo que debe",pos1.distanciaA(pos2),2);
	}
}
