package ModeloTests.UnitTests;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class PersonajeUnitTests {
	
	@Test
	public void seCreaEnPosicionCorrecta () throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		
		Assert.assertEquals ("El personaje esta en posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals ("El personaje esta en posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedenPosicionarDosEnMismaPosicion () throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
	}
	
	@Test
	public void seMueveCorrectamenteEnLineaRecta() throws ExcFueraDeTablero,  ExcPosicionNegativa, ExcCasilleroOcupado, ExcEsChocolate {
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(3,3));
		personaje1.mover (new Posicion(2,3));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 3, personaje1.posicion().posY());
	}
	
	@Test
	public void seMueveCorrectamenteEnDiagonal () throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado, ExcEsChocolate {
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(3,3));
		personaje1.mover (new Posicion(4,4));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 4, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 4, personaje1.posicion().posY());
	
	}
	
	@Test
	public void seMueveCorrectamenteAlMinimo () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		personaje1.mover (new Posicion(1,1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
	}
	
	@Test
	public void seMueveCorrectamenteAlMaximo () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(14,13));
		personaje1.mover (new Posicion(15,14));
	
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 15, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 14, personaje1.posicion().posY());
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void noSePuedeMoverFueraDelTablero () throws ExcPosicionNegativa, ExcFueraDeTablero, ExcCasilleroOcupado, ExcEsChocolate {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		Posicion pos = new Posicion(1,1);
		tablero.posicionarPersonaje(personaje1, pos);
		personaje1.mover (new Posicion(0,0));
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedeMoverAPosicionDeOtro () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate{		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		personaje1.mover (new Posicion(1,3));
	}
	
	@Test
	public void atacaConDañoEsperado () throws ExcFueraDeTablero, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		
		int pts1inicial=personaje1.puntosDeVida();
		int pts2inicial=personaje2.puntosDeVida();
		
		personaje1.atacar(personaje2, false);
		Assert.assertEquals("El personaje2 recibe el daño esperado",pts2inicial-personaje2.puntosDeVida(),(personaje1.poderDePelea()*8)/10);
		personaje2.atacar(personaje1, false);
		Assert.assertEquals("El personaje1 recibe el daño esperado",pts1inicial-personaje1.puntosDeVida(),personaje2.poderDePelea());
	}
	
	@Test (expected = ExcFueraDeRango.class)
	public void ataqueFueraDeRango() throws  ExcFueraDeTablero, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcNumeroNegativo {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,4));
		personaje1.atacar(personaje2, false);
	}
	
	@Test
	public void puedoSumarKi() throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado, ExcNumeroNegativo{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		Assert.assertEquals("El ki inicial es correcto",personaje1.ki(),0);
		personaje1.seAvanzoUnTurno(5);
		Assert.assertEquals("El ki aumentado es correcto",personaje1.ki(),5);
	}
	
	@Test (expected = ExcEsChocolate.class)
	public void noSePuedeMoverSiEsChocolate () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		personaje1.convertirEnChocolate(3);
		personaje1.mover(new Posicion(2,1));
	}
	
	@Test (expected = ExcEsChocolate.class)
	public void noPuedeAtacarSiEsChocolate() throws  ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcNumeroNegativo{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(3,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(3,3));
		
		personaje1.convertirEnChocolate(3);
		personaje1.atacar(personaje2, false);
	}

	
	
	@Test
	public void noAumentaDeKiSiEsChocolate() throws ExcEsChocolate, ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		Assert.assertEquals("El ki inicial es correcto",personaje1.ki(),0);
		
		personaje1.convertirEnChocolate(3);
		
		Assert.assertTrue(personaje1.esChocolate());
		
		personaje1.seAvanzoUnTurno(5);
		Assert.assertEquals("El ki no aumenta",personaje1.ki(),0);
		
		personaje1.seAvanzoUnTurno(5);
		Assert.assertEquals("El ki no aumenta",personaje1.ki(),0);
		
		personaje1.seAvanzoUnTurno(5);
		Assert.assertEquals("El ki no aumenta",personaje1.ki(),0);
		
		personaje1.seAvanzoUnTurno(5);
		Assert.assertFalse(personaje1.esChocolate());
		Assert.assertEquals("El ki aumenta pasados 3 turnos",personaje1.ki(),5);
		
	}
	
	
}
