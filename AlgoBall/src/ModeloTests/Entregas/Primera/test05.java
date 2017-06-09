package ModeloTests.Entregas.Primera;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Direccion;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Goku;

public class test05 {
	Tablero tablero = new Tablero(15,14);
	Jugador primerJugador = new Jugador("nombre1");
	Jugador segundoJugador = new Jugador("nombre2");
	Partida partida = new Partida(tablero, primerJugador, segundoJugador);
	
	@Test
	 public void Test05TransformaYMueveCorrectamente() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcNoEsPosibleTransformarse, ExcPosicionNegativa{
		Goku goku = new Goku(partida);
		Posicion posicion =  new Posicion(10,10);
			
		tablero.posicionarPersonaje(goku, posicion);
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
