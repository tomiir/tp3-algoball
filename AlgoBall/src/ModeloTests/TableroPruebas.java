package ModeloTests;
import Modelo.ExcCasilleroOcupado;
import Modelo.ExcFueraDeRango;
import Modelo.ExcFueraDeTablero;
import Modelo.ExcMovimientoImposible;
import Modelo.PersonajeDePrueba;
import Modelo.Posicionable;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

import com.sun.jndi.cosnaming.ExceptionMapper;

public class TableroPruebas {
	
	Tablero tablero = new Tablero(15,15);
	Posicionable posicionable1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	Posicionable posicionable2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	
	@Test
	public void sePosicionaCorrectamente() throws ExcFueraDeTablero, ExcCasilleroOcupado{
		tablero.posicionar(posicionable1, 0, 0);
		Assert.assertEquals("Se posiciona correctamente", posicionable1, tablero.obtenerCasillero(0, 0).obtenerContenido());
		tablero.posicionar(posicionable1, 3, 2);
		Assert.assertEquals("Se posiciona correctamente", posicionable1, tablero.obtenerCasillero(3, 2).obtenerContenido());
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedePosicionarFueraDelTablero() throws ExcCasilleroOcupado, ExcFueraDeTablero{
		tablero.posicionar(posicionable1, 1, 15);
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedePosicionarEnCasilleroOcupado() throws ExcCasilleroOcupado, ExcFueraDeTablero{
		tablero.posicionar(posicionable1, 14, 14);
		tablero.posicionar(posicionable2, 14, 14);
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeObtenerCasilleroFueraDeRangoPositivo() throws ExcFueraDeTablero{
		tablero.obtenerCasillero(15, 15);
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeObtenerCasilleroFueraDeRangoNegativo() throws ExcFueraDeTablero{
		tablero.obtenerCasillero(-1,-1);
	}
}