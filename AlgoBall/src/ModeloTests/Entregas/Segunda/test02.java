package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.Piccolo;

public class test02 {
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
		equipo2.agregarPersonaje (freezer);
		equipo2.agregarPersonaje (majinBoo);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		partida.iniciar();
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void gohanNoSePuedeTransformarSegundaTransformacionPorKi() throws ExcHayGanador, ExcNoEsPosibleTransformarse, ExcDañoNegativo{
		iniciarPartida();
		
		partida.avanzarTurno();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 10);
		gohan.transformar();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 0);
		
		Assert.assertEquals("La vida porcentualde goku es correcta",goku.vidaPorcentual(), 100);
		Assert.assertEquals("La vida porcentualde piccolo es correcta",goku.vidaPorcentual(), 100);
		
		
		goku.recibirDaño(350);
		piccolo.recibirDaño(350);
		
		Assert.assertEquals("La vida porcentual de goku es correcta",goku.vidaPorcentual(), 30);
		Assert.assertEquals("La vida porcentual de piccolo es correcta",piccolo.vidaPorcentual(), 30);
		
		gohan.transformar();
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void gohanNoSePuedeTransformarSegundaTransformacionPorCompañerosConVidaMayorA30Porciento() throws ExcHayGanador, ExcDañoNegativo, ExcNoEsPosibleTransformarse{
		iniciarPartida();
		
		partida.avanzarTurno();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 10);
		gohan.transformar();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 0);
		
		Assert.assertEquals("La vida porcentualde goku es correcta",goku.vidaPorcentual(), 100);
		Assert.assertEquals("La vida porcentualde piccolo es correcta",goku.vidaPorcentual(), 100);
		
		for(int i=0;i<6;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 30);
		gohan.transformar();
	}
	
	@Test
	public void gohanSePuedeTransformarSegundaTransformacionConCondicionesCorrectas() throws ExcHayGanador, ExcNoEsPosibleTransformarse, ExcDañoNegativo{
		iniciarPartida();
		
		partida.avanzarTurno();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 10);
		gohan.transformar();
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 0);
		for(int i=0;i<6;i++){
			partida.avanzarTurno();
		}
		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 30);
		
		Assert.assertEquals("La vida porcentualde goku es correcta",goku.vidaPorcentual(), 100);
		Assert.assertEquals("La vida porcentualde piccolo es correcta",goku.vidaPorcentual(), 100);
		
		
		goku.recibirDaño(350);
		piccolo.recibirDaño(350);
		
		Assert.assertEquals("La vida porcentualde goku es correcta",goku.vidaPorcentual(), 30);
		Assert.assertEquals("La vida porcentualde piccolo es correcta",piccolo.vidaPorcentual(), 30);
		
		gohan.transformar();

		Assert.assertEquals("El ki de gohan es correcto", gohan.ki(), 0);
		Assert.assertEquals("El poder de pelea de gohan es correcto", gohan.poderDePelea(),100);
		Assert.assertEquals("El rango de ataque de gohan es correcto", gohan.rangoDeAtaque(), 4);
		Assert.assertEquals("La velocidad de gohan es correcta", gohan.velocidad(), 3);
		
	}
	
}
