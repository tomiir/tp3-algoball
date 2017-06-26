package ModeloTests.UnitTests;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroDesocupado;
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
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		
		Assert.assertEquals ("El personaje esta en posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals ("El personaje esta en posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
	
	
	
	
	
	
	
	@Test
	public void atacaConDanioEsperado () throws ExcFueraDeTablero, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("nombre 2", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		
		int pts1inicial=personaje1.puntosDeVida();
		int pts2inicial=personaje2.puntosDeVida();
		
		personaje1.atacarNormal(personaje2);
		Assert.assertEquals("El personaje2 recibe el danio esperado",pts2inicial-personaje2.puntosDeVida(),(personaje1.poderDePelea()*8)/10);
		personaje2.atacarNormal(personaje1);
		Assert.assertEquals("El personaje1 recibe el danio esperado",pts1inicial-personaje1.puntosDeVida(),personaje2.poderDePelea());
	}
	
	@Test (expected = ExcFueraDeRango.class)
	public void ataqueFueraDeRango() throws  ExcFueraDeTablero, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcNumeroNegativo {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("nombre 2", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,4));
		personaje1.atacarNormal(personaje2);
	}
	
	@Test
	public void puedoSumarKi() throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado, ExcNumeroNegativo{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		Assert.assertEquals("El ki inicial es correcto",personaje1.ki(),0);
		personaje1.seAvanzoUnTurno(5);
		Assert.assertEquals("El ki aumentado es correcto",personaje1.ki(),5);
	}
	
	@Test (expected = ExcEsChocolate.class)
	public void noSePuedeMoverSiEsChocolate () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		personaje1.convertirEnChocolate(3);
		tablero.moverPersonaje(personaje1,new Posicion(2,1));
	}
	
	@Test (expected = ExcEsChocolate.class)
	public void noPuedeAtacarSiEsChocolate() throws  ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcNumeroNegativo{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("nombre 2", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(3,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(3,3));
		
		personaje1.convertirEnChocolate(3);
		personaje1.atacarNormal(personaje2);
	}

	
	
	@Test
	public void noAumentaDeKiSiEsChocolate() throws ExcEsChocolate, ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
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
