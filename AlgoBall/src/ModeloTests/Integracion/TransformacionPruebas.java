package ModeloTests.Integracion;

import Modelo.Tablero;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Goku;
import Modelo.Posicion;
import org.junit.Assert;

import org.junit.Test;

import Modelo.Direccion;


public class TransformacionPruebas {
	
	
	
	
	@Test
	public void Test04SePosicionaYTransformaCorrectamente() throws ExcNoEsPosibleTransformarse, ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		Tablero tablero = new Tablero(15,15);
		Goku goku = new Goku(tablero);
		Posicion posicion =  new Posicion(10,10);
		
		tablero.posicionar(goku, posicion);
		Assert.assertEquals(goku.posicion(), posicion);
		
		goku.incrementarKi(100);
		
		goku.transformar();
		Assert.assertEquals(goku.velocidad(), 3);
		Assert.assertEquals(goku.rangoDeAtaque(), 4);
		Assert.assertEquals(goku.poderDePelea(), 40);
		Assert.assertEquals(goku.ki(), 80);
		
	}
	 @Test
	 public void Test05TransformaYMueveCorrectamente() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcNoEsPosibleTransformarse, ExcPosicionNegativa{
		 Tablero tablero = new Tablero(15,15);
		 Goku goku = new Goku(tablero);
		 Posicion posicion =  new Posicion(10,10);
			
		 tablero.posicionar(goku, posicion);
		 Assert.assertEquals(goku.posicion(), posicion);
		goku.incrementarKi(100);
		
		goku.transformar();
		Assert.assertEquals(goku.velocidad(), 3);
		Assert.assertEquals(goku.rangoDeAtaque(), 4);
		Assert.assertEquals(goku.poderDePelea(), 40);
		Assert.assertEquals(goku.ki(), 80);
		
		goku.mover(new Direccion(1,0));
		Assert.assertEquals(goku.posicion().posX(), 11);
		Assert.assertEquals(goku.posicion().posY(), 10);
	 }
}
