package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Dimension;
import Modelo.Posicion;
import Modelo.Excepciones.ExcPosicionNegativa;

public class DimensionUnitTests {
	
	@Test
	public void seCreaDimensionCorrectamente(){
		int alto = 10;
		int ancho = 10;
		Dimension dimension = new Dimension(ancho,alto);
		Assert.assertEquals("El alto es el correcto",alto,dimension.alto());
		Assert.assertEquals("El ancho es el correcto",ancho,dimension.ancho());

	}
	
	@Test
	public void posicionSeEncuentraEnDimension() throws ExcPosicionNegativa{
		int alto = 10;
		int ancho = 10;
		Dimension dimension = new Dimension(ancho,alto);
		Posicion pos = new Posicion(1,1);
		Assert.assertTrue("La posicion esta en dimension",dimension.posicionEstaEnDimension(pos));
	}
	
	@Test
	public void posicionNoSeEncuentraEnDimension() throws ExcPosicionNegativa{
		int alto = 10;
		int ancho = 10;
		Dimension dimension = new Dimension(ancho,alto);
		Posicion pos = new Posicion(10,11);
		Assert.assertFalse("La posicion esta en dimension",dimension.posicionEstaEnDimension(pos));
	}

}
