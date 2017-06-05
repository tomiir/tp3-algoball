package ModeloTests;

import org.junit.Assert;

import Modelo.Direccion;
import Modelo.Goku;
import Modelo.Tablero;
import Modelo.Casillero;




public class PruebaTableroPosicionar {
	
	Tablero tablero = new Tablero(3,3);
	
	Goku goku = new Goku(tablero);
	
	tablero.posicionar(goku, 1 ,1);
	
	Casillero casillero = tablero.obtenerCasillero(2,1);
	
	goku.mover(casillero);
	
	Assert.equals(goku.posicion() == (2,1));
	


}

