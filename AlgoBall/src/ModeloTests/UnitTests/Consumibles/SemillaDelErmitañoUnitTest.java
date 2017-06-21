package ModeloTests.UnitTests.Consumibles;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Consumibles.SemillaDeErmitaño;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;

public class SemillaDelErmitañoUnitTest {
	Tablero tablero = new Tablero(15,15);
	
	@Test
	public void semillaDeHErmitañoAumentaVidaCorrectamente () throws ExcCasilleroOcupado, ExcFueraDeTablero, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango, ExcNumeroNegativo {
		SemillaDeErmitaño semilla = new SemillaDeErmitaño();
		tablero.posicionarConsumible(semilla, new Posicion(3,3));
		
		PersonajeDePrueba personaje = new PersonajeDePrueba("nombre", 500, 3, 3, 5);
		
		tablero.posicionarPersonaje(personaje, new Posicion(2,3));
		
		personaje.recibirDaño(200);
		
		int vidaInicial = personaje.puntosDeVida();
		
		tablero.moverPersonaje(personaje, new Posicion(3,3));
		
		int vidaFinal = personaje.puntosDeVida();
		
		Assert.assertTrue(vidaFinal > vidaInicial);
		Assert.assertEquals("La vida aumenta lo esperado",vidaFinal, vidaInicial + 100);
		
	}
	@Test
	public void semillaDelHermitañoNoAumentaMasDeLaVidaMaxima() throws ExcCasilleroOcupado, ExcFueraDeTablero, ExcPosicionNegativa, ExcCasilleroDesocupado, ExcFueraDeRango, ExcEsChocolate{
		SemillaDeErmitaño semilla = new SemillaDeErmitaño();
		tablero.posicionarConsumible(semilla, new Posicion(3,3));
		
		PersonajeDePrueba personaje = new PersonajeDePrueba("nombre", 500, 3, 3, 5);
		tablero.posicionarPersonaje(personaje, new Posicion(2,3));
		
		int vida_inicial =  personaje.puntosDeVida();
		
		tablero.moverPersonaje(personaje, new Posicion(3,3));
		
		Assert.assertEquals("No aumenta la vida maxima del personaje",vida_inicial,personaje.puntosDeVida());
		
	}
}
