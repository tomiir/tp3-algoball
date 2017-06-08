package ModeloTests.Entregas.Primera;

import org.junit.Test;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test02 {
	Tablero tablero = new Tablero(20,30);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	Personaje personaje2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedePosicionarEnCasilleroOcupado() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.posicionarPersonaje(personaje1, new Posicion(14,14));
		tablero.posicionarPersonaje(personaje2, new Posicion(14,14));
	}
}
