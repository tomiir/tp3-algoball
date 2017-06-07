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
	public void ataqueDañaLoEsperadoParaMenorPoderDePelea() throws ExcAtaqueImposible{
		int dañoEsperado=ataque.dañoBase();
		
		int vidaAnterior = personaje2.puntosDeVida();
		ataque.enviar(personaje1, personaje2);
		Assert.assertEquals("Se hizo el daño esperado", personaje2.puntosDeVida(), vidaAnterior-dañoEsperado);
	}
	
	@Test
	public void ataqueDañaLoEsperadoParaMayorPoderDePelea () throws ExcAtaqueImposible{
		int dañoEsperado = (ataque.dañoBase()*8) / 10; 
		int vidaAnterior = personaje1.puntosDeVida(); 
		ataque.enviar(personaje2, personaje1);
		
		Assert.assertEquals("Se hizo el daño esperado", personaje1.puntosDeVida(), vidaAnterior - dañoEsperado);
	}
	
	
}
