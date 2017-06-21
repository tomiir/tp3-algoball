package ModeloTests.UnitTests.Ataques;

import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

import org.junit.Assert;
import org.junit.Test;

public class AtaqueNormalUnitTests {
	Tablero tablero = new Tablero(2,100);
	Personaje personaje1 = new PersonajeDePrueba("1", 300, 100, 100,200);
	Personaje personaje2 = new PersonajeDePrueba("1", 300, 100, 100,100);
	Ataque ataque = Ataque.AtaqueNormal();
	
	@Test
	public void seCreaUnAtaqueCorrectamente(){
		Assert.assertEquals("El costo de ki es 0", ataque.costo(), 0);
	}
	
	@Test
	public void ataqueDa�aLoEsperadoParaMenorPoderDePelea() throws ExcAtaqueImposible, ExcEsChocolate, ExcNumeroNegativo{
		int da�oEsperado=personaje1.poderDePelea();
		
		int vidaAnterior = personaje2.puntosDeVida();
		ataque.enviar(personaje1, personaje2, 0);
		Assert.assertEquals("Se hizo el da�o esperado", personaje2.puntosDeVida(), vidaAnterior-da�oEsperado);
	}
	
	@Test
	public void ataqueDa�aLoEsperadoParaMayorPoderDePelea () throws ExcAtaqueImposible, ExcEsChocolate, ExcNumeroNegativo{
		int da�oEsperado = personaje2.poderDePelea() * 80/100; 
		int vidaAnterior = personaje1.puntosDeVida(); 
		ataque.enviar(personaje2, personaje1, 0);
		
		Assert.assertEquals("Se hizo el da�o esperado", personaje1.puntosDeVida(), vidaAnterior - da�oEsperado);
	}	
	
}
