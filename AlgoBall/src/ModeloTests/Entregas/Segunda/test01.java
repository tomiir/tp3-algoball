package ModeloTests.Entregas.Segunda;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcPosicionOcupada;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Personajes.Piccolo;
import org.junit.Assert;

public class test01 {
	Tablero tablero = new Tablero(15, 15);
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
		equipo2.agregarPersonaje (piccolo);
		equipo2.agregarPersonaje (majinBoo);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		partida.iniciar();
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void GohanNoSePuedeTransformar() throws ExcNoEsPosibleTransformarse{
		iniciarPartida();
		gohan.transformar();
	}
	
	@Test
	public void GohanSePuedeTransformarPasados2Turnos() throws ExcNoEsPosibleTransformarse, ExcHayGanador{
		iniciarPartida();
		for(int i=0;i<2;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 10);
		gohan.transformar();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 0);
		Assert.assertEquals("El poder de pelea de gohan es correcto", gohan.poderDePelea(),30);
		Assert.assertEquals("El rango de ataque de gohan es correcto", gohan.rangoDeAtaque(), 2);
		Assert.assertEquals("La velocidad de gohan es correcta", gohan.velocidad(), 2);
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void GohanNoSePuedeTransformarDevuelta() throws ExcNoEsPosibleTransformarse, ExcHayGanador{
		iniciarPartida();
		for(int i=0;i<2;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 10);
		gohan.transformar();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 0);
		gohan.transformar();
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void gohanNoSePuedeTransformarDevueltaConKiSuficiente() throws ExcNoEsPosibleTransformarse, ExcHayGanador{
		iniciarPartida();
		for(int i=0;i<2;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 10);
		gohan.transformar();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 0);
		for(int i=0;i<6;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 30);
		gohan.transformar();
	}
}
