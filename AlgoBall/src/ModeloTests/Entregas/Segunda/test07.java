package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcAtaqueIlegitimo;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcPersonajeInmovilizado;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.Piccolo;

public class test07 {
	Tablero tablero = new Tablero(3, 3);
	Jugador jugador1 = new Jugador("Jugador Guerreros Z");
	Jugador jugador2 = new Jugador("Jugador Enemigos de la tierra");
	Partida partida;
	Equipo equipo1;
	Equipo equipo2;
	Goku goku;
	Gohan gohan;
	Piccolo piccolo;
	Cell cell;
	Freezer freezer;
	MajinBoo majinBoo;
	
	
	
	private void iniciarPartida(){
		partida = new Partida(tablero, jugador1, jugador2);
		equipo1 = new Equipo("Guerreros Z");
		equipo2 = new Equipo("Enemigos de la tierra");
		goku = new Goku(partida);
		gohan = new Gohan(partida);
		piccolo = new Piccolo(partida);
		cell = new Cell(partida);
		freezer = new Freezer(partida);
		majinBoo = new MajinBoo(partida);
		
		//Guerreros Z
		equipo1.agregarPersonaje (goku);
		equipo1.agregarPersonaje (gohan);
		equipo1.agregarPersonaje (piccolo);
		
		//Enemigos de la tierra
		equipo2.agregarPersonaje (cell);
		equipo2.agregarPersonaje (freezer);
		equipo2.agregarPersonaje (majinBoo);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		partida.iniciar();
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void cellNoSePuedeTransformar() throws ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcHayGanador, ExcNoEsPosibleTransformarse{
		iniciarPartida();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		
		Assert.assertEquals("Cell hizo 4 absorciones", cell.cantidadDeAbsorciones(),3);
		
		cell.transformar();
	}
	
	@Test
	public void cellHaceSuPrimerTransformacionCorrectamente() throws ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcHayGanador, ExcNoEsPosibleTransformarse{
		iniciarPartida();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		
		Assert.assertEquals("Cell hizo 4 absorciones", cell.cantidadDeAbsorciones(),4);
		
		cell.transformar();
		Assert.assertEquals("El poder de pelea de cell es correcto", cell.poderDePelea(),40);
		Assert.assertEquals("El rango de ataque de cell es correcto", cell.rangoDeAtaque(), 4);
		Assert.assertEquals("La velocidad de cell es correcta", cell.velocidad(), 3);
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void cellNoSePuedeVolverATransformar() throws ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcHayGanador, ExcNoEsPosibleTransformarse{
		iniciarPartida();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		
		Assert.assertEquals("Cell hizo 4 absorciones", cell.cantidadDeAbsorciones(),4);
		
		cell.transformar();
		cell.transformar();
	}
	
	@Test
	public void cellHaceSuSegundaPrimerTransformacionCorrectamente() throws ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcHayGanador, ExcNoEsPosibleTransformarse{
		iniciarPartida();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		
		Assert.assertEquals("Cell hizo 4 absorciones", cell.cantidadDeAbsorciones(),4);
		cell.transformar();
		
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		partida.avanzarTurno();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		Assert.assertEquals("Cell hizo 8 absorciones", cell.cantidadDeAbsorciones(),8);
		
		cell.transformar();
		Assert.assertEquals("El poder de pelea de cell es correcto", cell.poderDePelea(),80);
		Assert.assertEquals("El rango de ataque de cell es correcto", cell.rangoDeAtaque(), 4);
		Assert.assertEquals("La velocidad de cell es correcta", cell.velocidad(), 4);
	}
}
