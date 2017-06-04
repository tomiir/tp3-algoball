package Modelo;

import org.junit.Assert;

public class PruebaTableroPosicionar {
	
	Tablero tablero = new Tablero(3,3);
	Goku goku = new Goku();
	
	tablero.posicionar(goku, 1,1);
	
	Direccion derecha = new Direccion(1,0);
	
	goku.mover(derecha);
	
	Assert.equals(goku.posicion() == (2,1));
	
	

	
	


}
