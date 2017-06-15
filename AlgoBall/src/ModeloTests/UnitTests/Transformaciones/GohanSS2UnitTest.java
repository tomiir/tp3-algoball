package ModeloTests.UnitTests.Transformaciones;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.GohanSS2;
import org.junit.Assert;

public class GohanSS2UnitTest {
	
	Tablero tablero = new Tablero(5, 5);
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "Personaje2", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba(tablero, "Personaje3", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba(tablero, "Personaje4", 300, 3, 3, 1);
	
	GohanSS2 transformacionEspecialGohan = new GohanSS2 ();
	
	@Test
	public void seCreaCorrectamente() {
		
		GohanSS2 transformacionEspecialGohan = new GohanSS2 ();
		
		Assert.assertEquals(transformacionEspecialGohan.costo(), 30);
		Assert.assertEquals(transformacionEspecialGohan.poderDePelea(), 100);
		Assert.assertEquals(transformacionEspecialGohan.rangoDeAtaque(), 4);
		Assert.assertEquals(transformacionEspecialGohan.velocidad(), 3);
	
	}	
	
	@Test 
	public void noEsPosibleTransformarGohanSS2 () throws ExcNoEsPosibleTransformarse{
		iniciarPartida();
		Assert.assertEquals(transformacionEspecialGohan.esPosible(personaje1, partida) , false);	
		
	}
	
	@Test
	public void esPosibleTransformarGohanSS2 () throws ExcDañoNegativo{
		iniciarPartida();
		personaje1.sumarKi(30);
		personaje2.recibirDaño(250);
		
		Assert.assertEquals(transformacionEspecialGohan.esPosible(personaje1, partida), true);		
	}
	 
}
