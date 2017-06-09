package ModeloTests.UnitTests;

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
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "Personaje2", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba(partida, "Personaje3", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba(partida, "Personaje4", 300, 3, 3, 1);
	
	
	private void iniciarPartida(){
		equipo1.agregarPersonaje (personaje1);
		equipo1.agregarPersonaje (personaje2);
		equipo2.agregarPersonaje (personaje3);
		equipo2.agregarPersonaje (personaje4);
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo1);
		partida.iniciar();
	}
	
	GohanSS2 transformacionEspecialGohan = new GohanSS2 (partida);
	
	@Test
	public void seCreaCorrectamente() {
		iniciarPartida();
		Assert.assertEquals(transformacionEspecialGohan.costo(), 30);
		Assert.assertEquals(transformacionEspecialGohan.poderDePelea(), 100);
		Assert.assertEquals(transformacionEspecialGohan.rangoDeAtaque(), 4);
		Assert.assertEquals(transformacionEspecialGohan.velocidad(), 3);
	
	}	
	
	@Test 
	public void noEsPosibleTransformarGohanSS2 () throws ExcNoEsPosibleTransformarse{
		iniciarPartida();
		Assert.assertEquals(transformacionEspecialGohan.esPosible(personaje1) , false);	
		
	}
	
	@Test
	public void esPosibleTransformarGohanSS2 () throws ExcDañoNegativo{
		iniciarPartida();
		personaje1.sumarKi(30);
		personaje2.recibirDaño(250);
		
		Assert.assertEquals(transformacionEspecialGohan.esPosible(personaje1), true);		
	}
	 
}
