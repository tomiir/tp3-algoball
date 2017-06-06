package ModeloTests.UnitTests;
import Modelo.Direccion;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jndi.cosnaming.ExceptionMapper;

public class PersonajeUnitTests {
	
	Tablero tablero = new Tablero(15,14);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	Personaje personaje2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	
	@Test
	public void seCreaEnPosicionCorrecta () throws ExcPosicionOcupada, ExcFueraDeTablero{
		tablero.posicionar(personaje1, new Posicion(1,2));
		
		Assert.assertEquals ("El personaje esta en posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals ("El personaje esta en posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedenPosicionarDosEnMismaPosicion () throws ExcPosicionOcupada, ExcFueraDeTablero {		
		tablero.posicionar(personaje1, new Posicion(1,2));
		tablero.posicionar(personaje2, new Posicion(1,2));
	}
	
	@Test
	public void seMueveCorrectamenteEnLineaRecta() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida {
		tablero.posicionar(personaje1, new Posicion(1,2));
		personaje1.mover (new Direccion(1,0));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
	
	@Test
	public void seMueveCorrectamenteEnDiagonal () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida {
		tablero.posicionar(personaje1, new Posicion(1,2));
		personaje1.mover (new Direccion(1,-1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
	
	}
	
	@Test
	public void seMueveCorrectamenteAlMinimo () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida {
		tablero.posicionar(personaje1, new Posicion(2,2));
		personaje1.mover (new Direccion(-1,-1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
	}
	
	@Test
	public void seMueveCorrectamenteAlMaximo () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida {
		tablero.posicionar(personaje1, new Posicion(14,13));
		personaje1.mover (new Direccion(1,1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 15, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 14, personaje1.posicion().posY());
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeMoverFueraDelTablero () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida {		
		tablero.posicionar(personaje1, new Posicion(1,1));
		personaje1.mover (new Direccion(-1,0));
	}
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedeMoverAPosicionDeOtro () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida {		
		tablero.posicionar(personaje1, new Posicion(1,2));
		tablero.posicionar(personaje2, new Posicion(1,3));
		personaje1.mover (new Direccion(0,1));
	}
	
}
