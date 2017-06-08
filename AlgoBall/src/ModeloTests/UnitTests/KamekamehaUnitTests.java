package ModeloTests.UnitTests;

import org.junit.Test;

import Modelo.Tablero;
import Modelo.Ataques.Kamekameha;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Personajes.PersonajeDePrueba;
import javafx.scene.control.Tab;
import junit.framework.Assert;

public class KamekamehaUnitTests {
	Tablero mundo = new Tablero(5, 5);
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(mundo, "Nombre1", 300, 5, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(mundo, "Nombre1", 300, 5, 3, 50);
	
	@Test
	public void haceElDañoCorrecto () throws ExcFueraDeRango, ExcAtaqueImposible {
		personaje1.setAtaqueEspecial(new Kamekameha());
		personaje1.incrementarKi(20);		
		personaje1.atacar(personaje2, true);
		
		Assert.assertEquals("Se realiza el daño correcto", personaje2.puntosDeVida(), );
	}
	
}
