package ModeloTests.Entregas.Primera;

import org.junit.Test;

import Modelo.Direccion;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;

public class test03 {
	Tablero tablero = new Tablero(15,14);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	Personaje personaje2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3,100);
	
	@Test (expected = ExcPosicionOcupada.class)
	public void noSePuedeMoverAPosicionDeOtro () throws ExcPosicionOcupada, ExcFueraDeTablero, ExcDireccionInvalida, ExcPosicionNegativa {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		personaje1.mover (new Direccion(0,1));
	}
}
