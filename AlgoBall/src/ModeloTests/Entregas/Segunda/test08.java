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
	
	public class test08 {
		
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
		
	@Test (expected = ExcAtaqueImposible.class)	
	public void majinBooNoPuedeHacerAtaqueEspecialSinKi() throws ExcNoEsPosibleTransformarse, ExcFueraDeRango, ExcAtaqueImposible, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado{
		iniciarPartida();
		partida.realizarAtaque(jugador2, majinBoo, goku.posicion(), true);
	}
	
	@Test
	public void majinBooPuedeHacerAtaqueEspecial() throws ExcNoEsPosibleTransformarse, ExcHayGanador, ExcFueraDeRango, ExcAtaqueImposible, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado{
		iniciarPartida();
		for(int i=0;i<5;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de majinBoo es correcto", majinBoo.ki(), 30);
		Assert.assertEquals("El ki de Goku es correcto", goku.ki(), 30);
		
		partida.realizarAtaque(jugador2, majinBoo, goku.posicion(), true);
		
		Assert.assertEquals("El ki de majinBoo es correcto", majinBoo.ki(), 0);
		
		for(int i=0;i<3;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de Goku es correcto", goku.ki(), 30);
		
	}

	@Test (expected = ExcPersonajeInmovilizado.class)	
	public void gokuNoPuedeMoverseAlSerConvertidoEnChocolate() throws ExcNoEsPosibleTransformarse, ExcHayGanador, ExcFueraDeRango, ExcAtaqueImposible, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcMovimientoIlegitimo, ExcPosicionOcupada, ExcDireccionInvalida{
		iniciarPartida();
		for(int i=0;i<5;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de majinBoo es correcto", majinBoo.ki(), 30);
		
		partida.realizarAtaque(jugador2, majinBoo, goku.posicion(), true);
		
		Assert.assertEquals("El ki de majinBoo es correcto", majinBoo.ki(), 0);
		
		partida.realizarMovimiento(jugador1, goku, new Direccion(1,1));
		
	}
	
	@Test (expected = ExcPersonajeInmovilizado.class)	
	public void gokuNoPuedeAtacarAlSerConvertidoEnChocolate() throws ExcNoEsPosibleTransformarse, ExcHayGanador, ExcFueraDeRango, ExcAtaqueImposible, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcMovimientoIlegitimo, ExcPosicionOcupada, ExcDireccionInvalida{
		iniciarPartida();
		for(int i=0;i<5;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de majinBoo es correcto", majinBoo.ki(), 30);
		
		partida.realizarAtaque(jugador2, majinBoo, goku.posicion(), true);
		
		Assert.assertEquals("El ki de majinBoo es correcto", majinBoo.ki(), 0);
		
		partida.realizarAtaque(jugador1, goku, majinBoo.posicion(), false);
		
	}
		
}

