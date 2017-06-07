package ModeloTests.UnitTests;
import Modelo.Posicion;
import Modelo.Posicionable;
import Modelo.Tablero;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class TableroUnitTests {
	
	Tablero tablero = new Tablero(20,30);
	Posicionable posicionable1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	Posicionable posicionable2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	
	@Test
	public void sePosicionaCorrectamente() throws ExcFueraDeTablero, ExcPosicionOcupada, ExcPosicionNegativa{
		Posicion pos1=new Posicion(20,30);
		tablero.posicionar(posicionable1, pos1);
		Assert.assertEquals("Se posiciona correctamente en 'x'", posicionable1.posicion().posX(), 20 );
		Assert.assertEquals("Se posiciona correctamente en 'y'", posicionable1.posicion().posY(), 30 );
		
		Posicion pos2=new Posicion(3,2);
		tablero.posicionar(posicionable2, pos2);
		Assert.assertEquals("Se posiciona correctamente en 'x'", posicionable2.posicion().posX(), 3 );
		Assert.assertEquals("Se posiciona correctamente en 'y'", posicionable2.posicion().posY(), 2 );
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedePosicionarFueraDelTablero() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.posicionar(posicionable1, new Posicion(21,15));
	}
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedePosicionarEnCasilleroOcupado() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.posicionar(posicionable1, new Posicion(14,14));
		tablero.posicionar(posicionable2, new Posicion(14,14));
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeObtenerCasilleroFueraDeRangoPositivo() throws ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.obtenerCasillero(new Posicion(12,31));
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeObtenerCasilleroFueraDeRangoNegativo() throws ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.obtenerCasillero(new Posicion(0,1));
	}
}