package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ErrorFatal;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;


public class PartidaUnitTests {

	Tablero tablero = new Tablero(3,3);
	Jugador jugador1 = new Jugador("Jugador 1");
	Jugador jugador2 = new Jugador("Jugador 2");
	Partida partida = new Partida(tablero,jugador1,jugador2);

	Equipo equipo1 = new Equipo("Guerreros Z");
	Equipo equipo2 = new Equipo("Enemigos de la tierra");
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "bueno", 300, 2, 3, 50);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "malo", 50, 2, 3, 50);
	
	
	@Test
	public void puedoIniciarLaPartida() throws ErrorFatal, ExcPosicionNegativa{
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		Assert.assertEquals("El personaje 1 se posiciono correctamente en pos x",personaje1.posicion().posX(),1);
		Assert.assertEquals("El personaje 1 se posiciono correctamente en pos y",personaje1.posicion().posY(),1);
		Assert.assertEquals("El personaje 2 se posiciono correctamente en pos x",personaje2.posicion().posX(),3);
		Assert.assertEquals("El personaje 2 se posiciono correctamente en pos y",personaje2.posicion().posY(),3);
	
	}
	/*
	@Test
	public void seInicioLaPartidaPorEndeSeComenzoUnTurno() throws ErrorFatal{
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		Assert.assertEquals("Comenzo la partida, el ki es el esperado para jugador 1",personaje1.ki(),5);
		Assert.assertEquals("Comenzo la partida, el ki es el esperado para jugador 2",personaje2.ki(),5);
	}
	
	@Test
	public void avanzarUnTurnoModificaElKiDeLosPersonajes() throws ErrorFatal, ExcHayGanador{
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		partida.avanzarTurno();
		
		Assert.assertEquals("Comenzo la partida y se avanza un turno, el ki es el esperado para jugador 1",personaje1.ki(),10);
		Assert.assertEquals("Comenzo la partida y se avanza un turno, el ki es el esperado para jugador 2",personaje2.ki(),10);
	}
	*/
	@Test (expected = ExcHayGanador.class)
	public void avanzarUnTurnoCuandoTodosLosPersonajesDelEquipoContrarioEstanMuertos() throws ErrorFatal, ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcHayGanador{
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		jugador1.realizarAtaque(personaje1, personaje2, false);
		
		partida.avanzarTurno();
	}
	
	
	
	
}
