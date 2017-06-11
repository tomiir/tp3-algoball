package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcAtaqueIlegitimo;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDañoNegativo;
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
	
	public class test09 {
		
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
	public void gokuAumentaDañoAlTenerMenosDel30PorcientoDeVida() throws ExcNoEsPosibleTransformarse, ExcDañoNegativo, ExcAtaqueImposible, ExcFueraDeRango, ExcAtaqueIlegitimo, ExcFueraDeTablero, ExcPersonajeInmovilizado, ExcHayGanador{
		iniciarPartida();
		
		int vida_cell = cell.puntosDeVida();
		partida.realizarAtaque(jugador1, goku, cell.posicion(), false);
		
		Assert.assertEquals("El ataque hace el daño correcto",cell.puntosDeVida(),vida_cell-goku.poderDePelea());
		
		goku.recibirDaño(355);
		partida.avanzarTurno();
		
		Assert.assertEquals("La vida porcentual de goku es correcta",goku.vidaPorcentual(), 29);
		int vida_freezer = freezer.puntosDeVida();
		partida.realizarAtaque(jugador1, goku, freezer.posicion(), false);
		
		Assert.assertEquals("El ataque hace 20% mas de daño ",freezer.puntosDeVida(),vida_freezer-goku.poderDePelea()-(goku.poderDePelea()*20)/100);
	}
	
	
		
}
