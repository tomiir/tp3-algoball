package ModeloTests.UnitTests.Consumibles;

import org.junit.Test;

import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Consumibles.EsferaDelDragon;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;
import  org.junit.Assert;


public class EsferaDelDragonUnitTest {
	
	Tablero tablero = new Tablero(15,15);
	Jugador jugador = new Jugador("Jorge", tablero);
	
	@Test
	public void incrementaElDanioRealizadoPorElPersonajeQueLoConsume() throws ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeTablero, ExcEsChocolate, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcNumeroNegativo, ExcCasilleroDesocupado{
		EsferaDelDragon esfera = new EsferaDelDragon();
		tablero.posicionarConsumible(esfera, new Posicion(3,3));
		
		Personaje personaje1 = new PersonajeDePrueba("pj",300, 3 ,3 ,100);
		Personaje personaje2 = new PersonajeDePrueba("pj2", 300, 3, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(2, 3));
		tablero.posicionarPersonaje(personaje2, new Posicion(4, 3));
		
		int vidaInicialPersonaje2 = personaje2.puntosDeVida();
		personaje1.atacarNormal(personaje2);
		int vidaFinalPersonaje2 = personaje2.puntosDeVida();
		
		int danioRealizadoSinConsumible = vidaInicialPersonaje2 - vidaFinalPersonaje2;
		
		tablero.moverPersonaje(personaje1, new Posicion(3, 3));
		
		vidaInicialPersonaje2 = vidaFinalPersonaje2;
		personaje1.atacarNormal(personaje2);
		vidaFinalPersonaje2 = personaje2.puntosDeVida();
		
		int danioRealizadoConConsumible = vidaInicialPersonaje2 - vidaFinalPersonaje2;
		
		Assert.assertTrue(danioRealizadoConConsumible > danioRealizadoSinConsumible);
		Assert.assertEquals(danioRealizadoConConsumible, (danioRealizadoSinConsumible + (danioRealizadoSinConsumible * esfera.obtenerBonificacionAtaque()/100) ));	
	}
	
	@Test
	public void luegoDeTresTurnosElAtaqueDisminuye () throws ExcCasilleroOcupado, ExcFueraDeTablero, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango, ExcNumeroNegativo, ExcKiInsuficiente, ExcPersonajeMurio{
		EsferaDelDragon esfera = new EsferaDelDragon();
		tablero.posicionarConsumible(esfera, new Posicion(3,3));
		
		Personaje personaje1 = new PersonajeDePrueba("pj",300, 3 ,3 ,100);
		Personaje personaje2 = new PersonajeDePrueba("pj2", 300, 3, 3, 100);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(2, 3));
		tablero.posicionarPersonaje(personaje2, new Posicion(4, 3));
		
		//El personaje agarra la esfera
		tablero.moverPersonaje(personaje1, new Posicion(3, 3));
		
		personaje1.seAvanzoUnTurno(5);
		
		int vidaInicialPersonaje2 = personaje2.puntosDeVida();
		personaje1.atacarNormal(personaje2);
		int vidaFinalPersonaje2 = personaje2.puntosDeVida();
		
		int danioRealizadoConConsumible = vidaInicialPersonaje2 - vidaFinalPersonaje2;
		
		personaje1.seAvanzoUnTurno(5);
		personaje1.seAvanzoUnTurno(5);
		
		vidaInicialPersonaje2 = vidaFinalPersonaje2;
		
		personaje1.atacarNormal(personaje2);
		
		vidaFinalPersonaje2 = personaje2.puntosDeVida();
		
		int danioRealizadoSinConsumible = vidaInicialPersonaje2 - vidaFinalPersonaje2;

		
		Assert.assertTrue(danioRealizadoConConsumible > danioRealizadoSinConsumible);
		Assert.assertEquals(danioRealizadoConConsumible, (danioRealizadoSinConsumible + (danioRealizadoSinConsumible * esfera.obtenerBonificacionAtaque()/100) ));
		
	}	

}

