package ModeloTests.Entregas.Tercera;

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
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test03 {
	
	Tablero tablero = new Tablero(15,15);
	
	@Test
	public void desapareceAlOcuparSuPosicion() throws ExcCasilleroOcupado, ExcFueraDeTablero, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		Posicion posConsumible = new Posicion(3,3);
		SemillaDeErmitaño esfera = new SemillaDeErmitaño();
		tablero.posicionarConsumible(esfera, posConsumible);
		
		Personaje personaje1 = new PersonajeDePrueba("pj",300, 3 ,3 ,100);
		tablero.posicionarPersonaje(personaje1, new Posicion(2,2));
		tablero.moverPersonaje(personaje1, posConsumible);
		
		Assert.assertFalse(tablero.obtenerCasillero(posConsumible).tieneUnConsumible());
		
	}
	
	
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
		
		PersonajeDePrueba personaje = new PersonajeDePrueba( "nombre", 500, 3, 3, 5);
		tablero.posicionarPersonaje(personaje, new Posicion(2,3));
		
		int vida_inicial =  personaje.puntosDeVida();
		
		tablero.moverPersonaje(personaje, new Posicion(3,3));
		
		Assert.assertEquals("No aumenta la vida maxima del personaje",vida_inicial,personaje.puntosDeVida());
		
	}
}
