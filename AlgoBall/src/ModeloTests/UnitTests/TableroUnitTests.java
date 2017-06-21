package ModeloTests.UnitTests;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class TableroUnitTests {
	
	Tablero tablero = new Tablero(20, 30);

	PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba("nombre", 300, 3, 3, 1);
	PersonajeDePrueba personajeMuerto = new PersonajeDePrueba("nombre", 0, 3, 3, 1);

	
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
	
	public void sePuedeEliminarPersonajeMuerto() throws ExcPosicionNegativa, ExcFueraDeTablero, ExcCasilleroOcupado{
		Posicion pos1=new Posicion(20,30);
		tablero.posicionarPersonaje(personajeMuerto, pos1);
		Assert.assertTrue("Se ocupo el tablero",tablero.obtenerCasillero(pos1).estaOcupado());
		tablero.removerSiEstaMuerto(personajeMuerto);
		Assert.assertFalse("No esta ocupado por que el personaje",tablero.obtenerCasillero(pos1).estaOcupado());
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedenPosicionarDosPersonajesEnMismaPosicion () throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("nombre 2", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
	}
	
	@Test
	public void personajeSeMueveCorrectamenteEnLineaRecta() throws ExcFueraDeTablero,  ExcPosicionNegativa, ExcCasilleroOcupado, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango {
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(3,3));
		tablero.moverPersonaje(personaje1, new Posicion(2,3));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 3, personaje1.posicion().posY());
	}
	
	@Test
	public void personajeSeMueveCorrectamenteEnDiagonal () throws ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroOcupado, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango {
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(3,3));
		tablero.moverPersonaje(personaje1,new Posicion(4,4));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 4, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 4, personaje1.posicion().posY());
	
	}
	
	@Test
	public void personajeSeMueveCorrectamenteAlMinimo () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		tablero.moverPersonaje(personaje1,new Posicion(1,1));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
	}
	
	@Test
	public void personajeSeMueveCorrectamenteAlMaximo () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		tablero.posicionarPersonaje(personaje1, new Posicion(14,13));
		tablero.moverPersonaje(personaje1,new Posicion(15,14));
	
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 15, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 14, personaje1.posicion().posY());
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void personajeNoSePuedeMoverFueraDelTablero () throws ExcPosicionNegativa, ExcFueraDeTablero, ExcCasilleroOcupado, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango {		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		Posicion pos = new Posicion(1,1);
		tablero.posicionarPersonaje(personaje1, pos);
		tablero.moverPersonaje(personaje1,new Posicion(0,0));
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void personajeNoSePuedeMoverAPosicionDeOtro () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{		
		Tablero tablero = new Tablero(15, 14);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300, 1, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("nombre 2", 300, 1, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		tablero.moverPersonaje(personaje1,new Posicion(1,3));
	}
	
	@Test(expected = ExcFueraDeRango.class)
	public void personajeNoSePuedeMoverFueraDeRango() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300,1,3,100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		
		tablero.moverPersonaje(personaje1,new Posicion(10,10));
			
	}
	
	@Test
	public void personajeSePuedeMoverAlRangoLimite() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("nombre", 300,1,3,100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		
		tablero.posicionarPersonaje(personaje1,new Posicion(4,1));
		tablero.posicionarPersonaje(personaje1,new Posicion(7,1));
		tablero.posicionarPersonaje(personaje1,new Posicion(7,4));
		tablero.posicionarPersonaje(personaje1,new Posicion(10,7));
		tablero.posicionarPersonaje(personaje1,new Posicion(7,10));
		
		
	}
}