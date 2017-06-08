package ModeloTests.UnitTests;

import org.junit.Test;

import Modelo.Tablero;
import Modelo.Ataques.Makankosappo;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.PersonajeDePrueba;
import javafx.scene.control.Tab;
import org.junit.Assert;
import Modelo.Posicion;

public class AtaqueMakansosappoUnitTest {
	Tablero mundo = new Tablero(5, 5);
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(mundo, "Nombre1", 300, 5, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(mundo, "Nombre1", 300, 5, 3, 50);
	
	@Test
	public void haceElDañoCorrecto () throws ExcFueraDeRango, ExcAtaqueImposible, ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa {
		personaje1.setAtaqueEspecial(new Makankosappo());
		personaje1.incrementarKi(10);
		
		mundo.posicionarPersonaje(personaje1, new Posicion(2,3));
				
		mundo.posicionarPersonaje(personaje2, new Posicion(3,3));
		
		personaje1.atacar(personaje2, true);
				
		Assert.assertEquals(personaje2.puntosDeVida(),238);
	}
	
}
