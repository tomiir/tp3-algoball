package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Direccion;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcAtaqueIlegitimo;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDireccionInvalida;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcMovimientoIlegitimo;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcPersonajeInmovilizado;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.Piccolo;

public class test06 {
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
	
	@Test
	public void cellAbsorveCorrectamente() throws ExcNoEsPosibleTransformarse, ExcHayGanador, ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcMovimientoIlegitimo, ExcPosicionOcupada, ExcDireccionInvalida{
		iniciarPartida();
		int vidaCell=cell.puntosDeVida();
		int vidaGoku=goku.puntosDeVida();
		partida.realizarAtaque(jugador2, cell, goku.posicion(), true);
		Assert.assertEquals("A goku se le resta la vida",goku.puntosDeVida(),vidaGoku-cell.poderDePelea());
		Assert.assertEquals("A cell se le suma la vida",cell.puntosDeVida(),vidaCell+cell.poderDePelea());
		Assert.assertEquals("La cantidad de absorciones de Cell es correcta",cell.cantidadDeAbsorciones(),1);
	}
}
