package ModeloTests.Entregas.Primera;

import org.junit.Test;


import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test02 {
	
	Tablero tablero = new Tablero(15,14);
	Personaje personaje1 = new PersonajeDePrueba ("Nombre1", 300, 5, 3,100);
	Personaje personaje2 = new PersonajeDePrueba ("Nombre2", 300, 5, 3,100);
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedePosicionarEnCasilleroOcupado() throws ExcCasilleroOcupado, ExcFueraDeTablero, ExcPosicionNegativa{
		tablero.posicionarPersonaje(personaje1, new Posicion(14,14));
		tablero.posicionarPersonaje(personaje2, new Posicion(14,14));
	}
}
