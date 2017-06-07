package ModeloTests.UnitTests;

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
	Personaje personaje1 = new PersonajeDePrueba(mundo,"1", 100, 100, 100,200);
	Personaje personaje2 = new PersonajeDePrueba(mundo,"1", 100, 100, 100,100);
	
	@Test
	public void seCreaUnAtaqueCorrectamente(){
		Assert.assertEquals("El costo de ki es 0",ataque.costo(),0);
	}
	
	@Test
	public void ataqueDa�aLoEsperadoParaMenorPoderDePelea() throws ExcAtaqueImposible{
		int da�oEsperado=ataque.da�oBase();
		
		int vidaAnterior = personaje2.puntosDeVida();
		ataque.enviar(personaje1, personaje2);
		Assert.assertEquals("Se hizo el da�o esperado", personaje2.puntosDeVida(), vidaAnterior-da�oEsperado);
	}
	
	@Test
	public void ataqueDa�aLoEsperadoParaMayorPoderDePelea () throws ExcAtaqueImposible{
		int da�oEsperado = (ataque.da�oBase()*8) / 10; 
		int vidaAnterior = personaje1.puntosDeVida(); 
		ataque.enviar(personaje2, personaje1);
		
		Assert.assertEquals("Se hizo el da�o esperado", personaje1.puntosDeVida(), vidaAnterior - da�oEsperado);
	}
	
	
}
