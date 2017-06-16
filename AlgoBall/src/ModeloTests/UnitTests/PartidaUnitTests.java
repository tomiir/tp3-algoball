package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ErrorFatal;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;


public class PartidaUnitTests {

	Tablero tablero = new Tablero(15,15);
	Jugador jugador1 = new Jugador("Jugador 1");
	Jugador jugador2 = new Jugador("Jugador 2");
	Partida partida = new Partida(tablero,jugador1,jugador2);

	Equipo equipo1 = new Equipo("Guerreros Z");
	Equipo equipo2 = new Equipo("Enemigos de la tierra");
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "bueno", 300, 1, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "malo", 300, 1, 3, 50);
	
	
	@Test
	public void puedoIniciarLaPartida() throws ErrorFatal, ExcPosicionNegativa{
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		Assert.assertEquals("El personaje 1 se posiciono correctamente en pos x",personaje1.posicion().posX(),1);
		Assert.assertEquals("El personaje 1 se posiciono correctamente en pos y",personaje1.posicion().posY(),1);
		Assert.assertEquals("El personaje 2 se posiciono correctamente en pos x",personaje2.posicion().posX(),15);
		Assert.assertEquals("El personaje 2 se posiciono correctamente en pos y",personaje2.posicion().posY(),15);
	
	}
	
	@Test
	public void seInicioLaPartidaPorEndeSeComenzoUnTurno() throws ErrorFatal{
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		Assert.assertEquals("Comenzo la partida, por lo que el ki aumento en 5",personaje1.ki(),5);
		Assert.assertEquals("Comenzo la partida, por lo que el ki aumento en 5",personaje2.ki(),5);
	}
	
	@Test
	public void avanzarUnTurnoModificaElKiDeLosPersonajes(){
		
	}
	
	@Test
	public void SeAvanzaUnTurnoYHayGanador(){
		
		
	}
	
}
