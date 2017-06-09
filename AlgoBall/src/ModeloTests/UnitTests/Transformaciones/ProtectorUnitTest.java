package ModeloTests.UnitTests.Transformaciones;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Protector;

public class ProtectorUnitTest {
	Tablero tablero = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "Personaje2", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba(partida, "Gohan", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba(partida, "Personaje4", 300, 3, 3, 1);
	
	Protector transformacionProtector = new Protector(partida);
	
	private void iniciarPartida(){
		equipo1.agregarPersonaje (personaje1);
		equipo1.agregarPersonaje (personaje2);
		equipo2.agregarPersonaje (personaje3);
		equipo2.agregarPersonaje (personaje4);
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		partida.iniciar();
	}
	
	@Test
	public void seCreaCorrectamente (){
		iniciarPartida();
		
		Assert.assertEquals(transformacionProtector.costo(), 0);
		Assert.assertEquals(transformacionProtector.poderDePelea(), 60);
		Assert.assertEquals(transformacionProtector.rangoDeAtaque(), 6);
		Assert.assertEquals(transformacionProtector.velocidad(), 4);
	}
	
	@Test
	public void noEsPosibleTransformarProtector (){
		iniciarPartida();
		Assert.assertEquals(transformacionProtector.esPosible(personaje1) , false);	
	}
	
	@Test
	public void esPosibleTransformarProtector ()throws ExcDañoNegativo{
		iniciarPartida();
		personaje3.recibirDaño(241);
		
		Assert.assertEquals(transformacionProtector.esPosible(personaje1), true);
	}
	
}
