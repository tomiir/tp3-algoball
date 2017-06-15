package ModeloTests.UnitTests.Transformaciones;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Protector;

public class ProtectorUnitTest {
	Tablero tablero = new Tablero(5, 5);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "Personaje2", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba(tablero, "Gohan", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba(tablero, "Personaje4", 300, 3, 3, 1);
	
	Protector transformacionProtector = new Protector(partida);

	
	@Test
	public void seCreaCorrectamente (){
		equipo1.agregarPersonaje(personaje1);
		Gohan gohan = new Gohan(tablero);
		equipo2.agregarPersonaje(gohan);
		
		Assert.assertEquals(transformacionProtector.costo(), 0);
		Assert.assertEquals(transformacionProtector.poderDePelea(), 60);
		Assert.assertEquals(transformacionProtector.rangoDeAtaque(), 6);
		Assert.assertEquals(transformacionProtector.velocidad(), 4);
	}
	
	@Test
	public void noEsPosibleTransformarProtector (){
		iniciarPartida();
		Assert.assertEquals(transformacionProtector.esPosible(personaje1, partida) , false);	
	}
	
	@Test
	public void esPosibleTransformarProtector ()throws ExcDañoNegativo{
		iniciarPartida();
		personaje3.recibirDaño(241);
		Assert.assertEquals(transformacionProtector.esPosible(personaje1, partida), true);
	}
	
}
