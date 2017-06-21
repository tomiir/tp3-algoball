package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcDestinatarioEnEquipoPropio;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcJugadorNoAutorizado;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Personajes.PersonajeFactory;
import Modelo.Excepciones.ExcJugadorYaAtacoOTransformo;
import Modelo.Excepciones.ExcJugadorYaMovio;


public class PartidaUnitTests {

	
	
	@Test
	public void puedoIniciarLaPartida() throws ExcPosicionNegativa, ExcHayGanador{
		
		Tablero tablero = new Tablero(3,3);
		Jugador jugador1 = new Jugador("Jugador 1", tablero);
		Jugador jugador2 = new Jugador("Jugador 2", tablero);
		Partida partida = new Partida(tablero,jugador1,jugador2);

		Equipo equipo1 = new Equipo("Guerreros Z");
		Equipo equipo2 = new Equipo("Enemigos de la tierra");
		
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("bueno1", 300, 2, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("bueno2", 50, 2, 3, 50);
		
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
	
	@Test
	public void avanzarUnTurnoModificaElKiDeLosPersonajes() throws ExcHayGanador{
		Tablero tablero = new Tablero(3,3);
		Jugador jugador1 = new Jugador("Jugador 1", tablero);
		Jugador jugador2 = new Jugador("Jugador 2", tablero);
		Partida partida = new Partida(tablero,jugador1,jugador2);

		Equipo equipo1 = new Equipo("Guerreros Z");
		Equipo equipo2 = new Equipo("Enemigos de la tierra");
		
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("bueno1", 300, 2, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("bueno2", 50, 2, 3, 50);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		partida.avanzarTurno();
		if (partida.esTurnoDelJugador()==jugador1){
			Assert.assertEquals("Comenzo la partida y se avanza un turno, el ki es el esperado para jugador 2",personaje2.ki(),5);
		}
		else{
			Assert.assertEquals("Comenzo la partida y se avanza un turno, el ki es el esperado para jugador 1",personaje1.ki(),5);
		}
		
	}
	
	@Test (expected = ExcHayGanador.class)
	public void avanzarUnTurnoCuandoTodosLosPersonajesDelEquipoContrarioEstanMuertos() throws ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcHayGanador{
		Tablero tablero = new Tablero(3,3);
		Jugador jugador1 = new Jugador("Jugador 1", tablero);
		Jugador jugador2 = new Jugador("Jugador 2", tablero);
		Partida partida = new Partida(tablero,jugador1,jugador2);

		Equipo equipo1 = new Equipo("Guerreros Z");
		Equipo equipo2 = new Equipo("Enemigos de la tierra");
		
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("bueno1", 300, 2, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("bueno2", 50, 2, 3, 50);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
			
		partida.iniciar();
		
		jugador1.realizarAtaqueNormal(personaje1, personaje2);
		
		partida.avanzarTurno();
	}
	
	@Test (expected = ExcJugadorYaAtacoOTransformo.class)
	public void jugadorNoPuedeAtacarDosVecesEnElMismoTurno() throws ExcHayGanador, ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcJugadorNoAutorizado, ExcJugadorYaAtacoOTransformo, ExcDestinatarioEnEquipoPropio, ExcCasilleroDesocupado{
		Tablero tablero = new Tablero(3,3);
		Jugador jugador1 = new Jugador("Jugador 1", tablero);
		Jugador jugador2 = new Jugador("Jugador 2", tablero);
		Partida partida = new Partida(tablero,jugador1,jugador2);

		Equipo equipo1 = new Equipo("Guerreros Z");
		Equipo equipo2 = new Equipo("Enemigos de la tierra");
		
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("bueno1", 300, 2, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("bueno2", 50, 2, 3, 50);
		PersonajeDePrueba personaje3 = new PersonajeDePrueba("malo1", 500, 2, 3, 50);
		PersonajeDePrueba personaje4 = new PersonajeDePrueba("malo2", 500, 2, 3, 50);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo1.agregarPersonaje(personaje2);
		equipo2.agregarPersonaje(personaje3);
		equipo2.agregarPersonaje(personaje4);
		
		partida.iniciar();
		
		if(partida.esTurnoDelJugador() == jugador1){
			partida.realizarAtaqueNormal(jugador1, personaje1, personaje3.posicion());			
			partida.realizarAtaqueNormal(jugador1, personaje2, personaje4.posicion());
		}
		
		if(partida.esTurnoDelJugador() == jugador2){
			partida.realizarAtaqueNormal(jugador2, personaje3, personaje1.posicion());
			partida.realizarAtaqueNormal(jugador2, personaje3, personaje2.posicion());
		}
		
		partida.realizarAtaqueNormal(jugador1, personaje1, personaje3.posicion());
		
		partida.realizarAtaqueNormal(jugador1, personaje2, personaje4.posicion());
		
	}
	
	@Test(expected = ExcJugadorYaMovio.class)
	public void jugadorNoPuedeMoverseDosVecesEnElMismoTurno() throws ExcFueraDeTablero, ExcJugadorNoAutorizado, ExcJugadorYaMovio, ExcEsChocolate, ExcCasilleroOcupado, ExcCasilleroDesocupado, ExcFueraDeRango, ExcPosicionNegativa, ExcHayGanador{
		Tablero tablero = new Tablero(3,3);
		Jugador jugador1 = new Jugador("Jugador 1", tablero);
		Jugador jugador2 = new Jugador("Jugador 2", tablero);
		Partida partida = new Partida(tablero,jugador1,jugador2);

		Equipo equipo1 = new Equipo("Guerreros Z");
		Equipo equipo2 = new Equipo("Enemigos de la tierra");
		
		PersonajeDePrueba personaje1 = new PersonajeDePrueba("bueno1", 300, 2, 3, 50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba("bueno2", 50, 2, 3, 50);
		PersonajeDePrueba personaje3 = new PersonajeDePrueba("malo1", 500, 2, 3, 50);
		PersonajeDePrueba personaje4 = new PersonajeDePrueba("malo2", 500, 2, 3, 50);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(personaje1);
		equipo1.agregarPersonaje(personaje2);
		equipo2.agregarPersonaje(personaje3);
		equipo2.agregarPersonaje(personaje4);
		
		partida.iniciar();
		
		if(partida.esTurnoDelJugador() == jugador1){
			partida.realizarMovimiento(jugador1, personaje1, new Posicion(3, 1));
			partida.realizarMovimiento(jugador1, personaje2, new Posicion(2, 2));
		}
		
		if(partida.esTurnoDelJugador() == jugador2){
			partida.realizarMovimiento(jugador2, personaje3, new Posicion(3, 1));
			partida.realizarMovimiento(jugador2, personaje4, new Posicion(2, 2));
		}
		
		
	}
	
	@Test (expected = ExcJugadorYaAtacoOTransformo.class)
	public void jugadorNoPuedeAtacarYTransformarEnElMismoTurno() throws ExcHayGanador, ExcJugadorNoAutorizado, ExcJugadorYaAtacoOTransformo, ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcDestinatarioEnEquipoPropio, ExcCasilleroDesocupado, ExcNoEsPosibleTransformarse{
		Tablero tablero = new Tablero(2,2);
		Jugador jugador1 = new Jugador("Jugador 1", tablero);
		Jugador jugador2 = new Jugador("Jugador 2", tablero);
		Partida partida = new Partida(tablero,jugador1,jugador2);

		Equipo equipo1 = new Equipo("Guerreros Z");
		Equipo equipo2 = new Equipo("Enemigos de la tierra");
		
		PersonajeFactory factory = new PersonajeFactory();
		Personaje goku = factory.getPersonaje("Goku");
		Personaje freezer = factory.getPersonaje("Freezer");
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(goku);
		equipo2.agregarPersonaje(freezer);
		
		partida.iniciar();
		
		//20 de ki para transformacion de goku
		partida.avanzarTurno();
		partida.avanzarTurno();
		partida.avanzarTurno();
		partida.avanzarTurno();
		
		if(partida.esTurnoDelJugador() == jugador1){
			partida.realizarAtaqueNormal(jugador1, goku, freezer.posicion());
			partida.realizarTransformacion(jugador1, goku);
		}
		
		if(partida.esTurnoDelJugador() == jugador2){
			partida.realizarAtaqueNormal(jugador2, freezer, goku.posicion());
			partida.realizarTransformacion(jugador2, freezer);
		}
				
	}
	
	@Test
	public void sePruebaQueSeAvanzaDeTurnoCorrectamente() throws ExcHayGanador{
		Tablero tablero = new Tablero(3,3);
		Jugador jugador1 = new Jugador("Jugador 1", tablero);
		Jugador jugador2 = new Jugador("Jugador 2", tablero);
		Partida partida = new Partida(tablero,jugador1,jugador2);

		Equipo equipo1 = new Equipo("Guerreros Z");
		Equipo equipo2 = new Equipo("Enemigos de la tierra");
		
		PersonajeFactory factory = new PersonajeFactory();
		Personaje goku = factory.getPersonaje("Goku");
		Personaje freezer = factory.getPersonaje("Freezer");
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		equipo1.agregarPersonaje(goku);
		equipo2.agregarPersonaje(freezer);
		
		partida.iniciar();
		
		Jugador jugadorAux1 = partida.esTurnoDelJugador();
		
		partida.avanzarTurno();
		
		Jugador jugadorAux2 = partida.esTurnoDelJugador();
		
		Assert.assertTrue(jugadorAux1 != jugadorAux2);		
	}
	
	
}
