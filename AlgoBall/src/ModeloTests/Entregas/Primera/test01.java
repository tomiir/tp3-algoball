package ModeloTests.Entregas.Primera;

import org.junit.Assert;
import org.junit.Test;


import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test01 {
	Tablero tablero = new Tablero(15,14);
	Personaje personaje1 = new PersonajeDePrueba ("Nombre", 300, 5, 3,100);
	
	@Test
	public void seMueveCorrectamenteEnLineaRecta() throws ExcCasilleroOcupado, ExcFueraDeTablero, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango {
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 2, personaje1.posicion().posY());
		
		tablero.moverPersonaje(personaje1, new Posicion(2,1));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 2, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
		
		tablero.moverPersonaje(personaje1, new Posicion(1,1));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 1, personaje1.posicion().posY());
		
		tablero.moverPersonaje(personaje1, new Posicion(1,2));
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 1, personaje1.posicion().posX());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 2, personaje1.posicion().posY());
	}
}
