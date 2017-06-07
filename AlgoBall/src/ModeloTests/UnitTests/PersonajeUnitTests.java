package ModeloTests.UnitTests;
import Modelo.Direccion;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class PersonajeUnitTests {
	
	Tablero tablero = new Tablero(15,14);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	Personaje personaje2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	
	@Test
	public void seCreaEnPosicionCorrecta () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		
		Assert.assertEquals ("El personaje esta en posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals ("El personaje esta en posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedenPosicionarDosEnMismaPosicion () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
	}
	
	@Test
	public void seMueveCorrectamenteEnLineaRecta() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		personaje1.mover (new Direccion(1,0));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
	
	@Test
	public void seMueveCorrectamenteEnDiagonal () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		personaje1.mover (new Direccion(1,-1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
	
	}
	
	@Test
	public void seMueveCorrectamenteAlMinimo () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		personaje1.mover (new Direccion(-1,-1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
	}
	
	@Test
	public void seMueveCorrectamenteAlMaximo () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {
		tablero.posicionarPersonaje(personaje1, new Posicion(14,13));
		personaje1.mover (new Direccion(1,1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 15, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 14, personaje1.posicion().posY());
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeMoverFueraDelTablero () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		personaje1.mover (new Direccion(-1,0));
	}
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedeMoverAPosicionDeOtro () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		personaje1.mover (new Direccion(0,1));
	}
	
}
