package ModeloTests;

import Modelo.Personaje;
import Modelo.PersonajeDePrueba;
import Modelo.Tablero;

import org.junit.Test;

import Modelo.ExcNoEsPosibleTransformarse;


public class TransformacionPruebas {
	
	Tablero tablero = new Tablero(15,15);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	
	@Test
	public void Test04SeTransformaCorrectamente() throws ExcNoEsPosibleTransformarse{
		
	}
}
