package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Vida;
import Modelo.Excepciones.ExcNumeroNegativo;

public class VidaUnitTests {
	
	@Test
	public void seCreaVidaCorrectamente(){
		int cantidad_vida = 300;
		Vida vida = new Vida(cantidad_vida);
		
		Assert.assertEquals("La vida se crea correctamente",cantidad_vida,vida.getVidaInicial());
	}
	
	@Test
	public void vidaIniciarNoSeModificaAlReducirseLaVida() throws ExcNumeroNegativo{
		int cantidad_vida = 300;
		Vida vida = new Vida(cantidad_vida);
		
		vida.recibirDanio(30);
		Assert.assertEquals("La vida inicial no se modifica",cantidad_vida,vida.getVidaInicial());
	}
	
	@Test
	public void vidaQueSeReduceEsVidaActual() throws ExcNumeroNegativo{
		int cantidad_vida = 300;
		Vida vida = new Vida(cantidad_vida);
		int cantidad_danio = 30;
		vida.recibirDanio(cantidad_danio);
		Assert.assertEquals("La vida actual es la correcta",cantidad_vida-cantidad_danio,vida.getVidaActual());
	}
		
	@Test
	public void vidaPorcentualVariaCorrectamente() throws ExcNumeroNegativo{
		int cantidad_vida = 300;
		Vida vida = new Vida(cantidad_vida);
		int porcentaje_actual = 100;
		Assert.assertEquals("La vida porcentual es la correcta",vida.vidaPorcentual(),porcentaje_actual);
		
		int porcentaje = 80;
		int cantidad_danio = cantidad_vida - (porcentaje*cantidad_vida/100);
		vida.recibirDanio(cantidad_danio);
		
		Assert.assertEquals("La vida porcentual es la correcta",vida.vidaPorcentual(),porcentaje);

	}

}
