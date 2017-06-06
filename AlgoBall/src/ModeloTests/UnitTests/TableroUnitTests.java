package ModeloTests.UnitTests;
import Modelo.Posicion;
import Modelo.Posicionable;
import Modelo.Tablero;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jndi.cosnaming.ExceptionMapper;

public class TableroUnitTests {
	
	Tablero tablero = new Tablero(20,30);
	Posicionable posicionable1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	Posicionable posicionable2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	
	@Test
	public void sePosicionaCorrectamente() throws ExcFueraDeTablero, ExcPosicionOcupada{
		Posicion pos1=new Posicion(20,30);
		tablero.posicionar(posicionable1, pos1);
		Assert.assertEquals("Se posiciona correctamente", posicionable1, tablero.obtenerCasillero(pos1).obtenerContenido());
		
		Posicion pos2=new Posicion(3,2);
		tablero.posicionar(posicionable2, pos2);
		Assert.assertEquals("Se posiciona correctamente", posicionable1, tablero.obtenerCasillero(pos2).obtenerContenido());
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedePosicionarFueraDelTablero() throws ExcPosicionOcupada, ExcFueraDeTablero{
		tablero.posicionar(posicionable1, new Posicion(21,15));
	}
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedePosicionarEnCasilleroOcupado() throws ExcPosicionOcupada, ExcFueraDeTablero{
		tablero.posicionar(posicionable1, new Posicion(14,14));
		tablero.posicionar(posicionable2, new Posicion(14,14));
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeObtenerCasilleroFueraDeRangoPositivo() throws ExcFueraDeTablero{
		tablero.obtenerCasillero(new Posicion(12,31));
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeObtenerCasilleroFueraDeRangoNegativo() throws ExcFueraDeTablero{
		tablero.obtenerCasillero(new Posicion(-1,1));
	}
}