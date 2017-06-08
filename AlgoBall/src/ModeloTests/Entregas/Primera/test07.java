package ModeloTests.Entregas.Primera;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test07 {
	Tablero tablero = new Tablero(15,14);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 1, 3,100);
	Personaje personaje2 = new PersonajeDePrueba (tablero, "Nombre", 300, 1, 3,200);
	
	@Test
	public void atacaConDa�oEsperado () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		
		int pts1inicial=personaje1.puntosDeVida();
		int pts2inicial=personaje2.puntosDeVida();
		
		//Se sabe que el da�o base para el ataque normal es 50
		personaje1.atacar(personaje2, false);
		Assert.assertEquals("El personaje2 recibe el da�o esperado",pts2inicial-personaje2.puntosDeVida(),(50*8)/10);
		personaje2.atacar(personaje1, false);
		Assert.assertEquals("El personaje1 recibe el da�o esperado",pts1inicial-personaje1.puntosDeVida(),50);
	}
	
	@Test (expected = ExcFueraDeRango.class)
	public void ataqueFueraDeRango() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,4));
		personaje1.atacar(personaje2, false);
	}
}