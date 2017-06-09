package ModeloTests.UnitTests;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueNormal;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class AtaqueNormalUnitTests {
	Tablero mundo = new Tablero(2,100);
	Ataque ataque = new AtaqueNormal();
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(mundo, jugador1, jugador2);
	Personaje personaje1 = new PersonajeDePrueba(partida,"1", 100, 100, 100,200);
	Personaje personaje2 = new PersonajeDePrueba(partida,"1", 100, 100, 100,100);
	
	@Test
	public void seCreaUnAtaqueCorrectamente(){
		Assert.assertEquals("El costo de ki es 0", ataque.costo(),0);
	}
	
	@Test
	public void ataqueDañaLoEsperadoParaMenorPoderDePelea() throws ExcAtaqueImposible{
		int dañoEsperado=200;
		
		int vidaAnterior = personaje2.puntosDeVida();
		ataque.enviar(personaje1, personaje2, 0);
		Assert.assertEquals("Se hizo el daño esperado", personaje2.puntosDeVida(), vidaAnterior-dañoEsperado);
	}
	
	@Test
	public void ataqueDañaLoEsperadoParaMayorPoderDePelea () throws ExcAtaqueImposible{
		int dañoEsperado = 80; 
		int vidaAnterior = personaje1.puntosDeVida(); 
		ataque.enviar(personaje2, personaje1, 0);
		
		Assert.assertEquals("Se hizo el daño esperado", personaje1.puntosDeVida(), vidaAnterior - dañoEsperado);
	}
	
	
}
