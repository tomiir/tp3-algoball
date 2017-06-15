package ModeloTests.UnitTests;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class TableroUnitTests {
	
	Tablero tablero = new Tablero(20, 30);

	PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "nombre", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba(tablero, "nombre", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba(tablero, "nombre", 300, 3, 3, 1);
	
	@Test
	public void sePosicionaCorrectamente() throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado{
		Posicion pos1=new Posicion(20,30);
		tablero.posicionarPersonaje(personaje1, pos1);
		Assert.assertEquals("Se posiciona correctamente en 'x'", personaje1.posicion().posX(), 20 );
		Assert.assertEquals("Se posiciona correctamente en 'y'", personaje1.posicion().posY(), 30 );
		
		Posicion pos2=new Posicion(3,2);
		tablero.posicionarPersonaje(personaje2, pos2);
		Assert.assertEquals("Se posiciona correctamente en 'x'", personaje2.posicion().posX(), 3 );
		Assert.assertEquals("Se posiciona correctamente en 'y'", personaje2.posicion().posY(), 2 );
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedePosicionarFueraDelTablero() throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado{
		tablero.posicionarPersonaje(personaje1, new Posicion(21,15));
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedePosicionarEnCasilleroOcupado() throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado{
		tablero.posicionarPersonaje(personaje1, new Posicion(14,14));
		tablero.posicionarPersonaje(personaje2, new Posicion(14,14));
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