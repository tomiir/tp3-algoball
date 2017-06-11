package ModeloTests.UnitTests;
import Modelo.Direccion;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class PersonajeUnitTests {
	
	Tablero tablero = new Tablero(15, 14);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "nombre", 300, 1, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "nombre", 300, 1, 3, 100);
	
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
	
	@Test
	public void atacaConDañoEsperado () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		
		int pts1inicial=personaje1.puntosDeVida();
		int pts2inicial=personaje2.puntosDeVida();
		
		//Se sabe que el daño base para el ataque normal es 50
		personaje1.atacar(personaje2, false);
		Assert.assertEquals("El personaje2 recibe el daño esperado",pts2inicial-personaje2.puntosDeVida(),(50*8)/10);
		personaje2.atacar(personaje1, false);
		Assert.assertEquals("El personaje1 recibe el daño esperado",pts1inicial-personaje1.puntosDeVida(),100);
	}
	
	@Test (expected = ExcFueraDeRango.class)
	public void ataqueFueraDeRango() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,4));
		personaje1.atacar(personaje2, false);
	}
	
	@Test
	public void puedoSumarKi() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		Assert.assertEquals("El ki inicial es correcto",personaje1.ki(),0);
		personaje1.sumarKi(5);
		Assert.assertEquals("El ki aumentado es correcto",personaje1.ki(),5);
		personaje1.sumarKi(-5);
		Assert.assertEquals("El ki aumentado es correcto",personaje1.ki(),0);
	}
	
	
	
}
