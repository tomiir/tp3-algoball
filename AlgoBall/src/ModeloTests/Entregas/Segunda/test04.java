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
	
	public class test04 {
		
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
		public void piccoloNoSePuedeTransformarDevueltaSinCondicionesCumplidas() throws ExcNoEsPosibleTransformarse, ExcHayGanador, ExcDañoNegativo{
			iniciarPartida();
			for(int i=0;i<3;i++){
				partida.avanzarTurno();
			}
			Assert.assertEquals("El ki de piccolo es correcto", piccolo.ki(), 20);
			piccolo.transformar();
			
			Assert.assertEquals("El ki de piccolo es correcto", piccolo.ki(), 0);
			Assert.assertEquals("El poder de pelea de piccolo es correcto", piccolo.poderDePelea(),40);
			Assert.assertEquals("El rango de ataque de piccolo es correcto", piccolo.rangoDeAtaque(), 4);
			Assert.assertEquals("La velocidad de piccolo es correcta", piccolo.velocidad(), 3);
			
			Assert.assertEquals("La vida de gohan es la correcta", gohan.puntosDeVida(), 300);
			
			gohan.recibirDaño(240);
			
			Assert.assertEquals("La vida de gohan es la correcta", gohan.puntosDeVida(), 60);
			Assert.assertEquals("La vida porcentual de gohan es 20", gohan.vidaPorcentual(), 20);
			
			piccolo.transformar();
			
		}
		
		@Test
		public void piccoloSePuedeTransformarConGohanHerido() throws ExcNoEsPosibleTransformarse, ExcHayGanador, ExcDañoNegativo{
			iniciarPartida();
			for(int i=0;i<3;i++){
				partida.avanzarTurno();
			}
			Assert.assertEquals("El ki de piccolo es correcto", piccolo.ki(), 20);
			
			piccolo.transformar();
			Assert.assertEquals("El ki de piccolo es correcto", piccolo.ki(), 0);
			Assert.assertEquals("El poder de pelea de piccolo es correcto", piccolo.poderDePelea(),40);
			Assert.assertEquals("El rango de ataque de piccolo es correcto", piccolo.rangoDeAtaque(), 4);
			Assert.assertEquals("La velocidad de piccolo es correcta", piccolo.velocidad(), 3);
			
			Assert.assertEquals("La vida de gohan es la correcta", gohan.puntosDeVida(), 300);
			gohan.recibirDaño(241);	
			Assert.assertEquals("La vida de gohan es la correcta", gohan.puntosDeVida(), 59);
			Assert.assertEquals("La vida porcentual de gohan es 19", gohan.vidaPorcentual(), 19);
			
			piccolo.transformar();
			Assert.assertEquals("El ki de piccolo es correcto", piccolo.ki(), 0);
			Assert.assertEquals("El poder de pelea de piccolo es correcto", piccolo.poderDePelea(),60);
			Assert.assertEquals("El rango de ataque de piccolo es correcto", piccolo.rangoDeAtaque(), 6);
			Assert.assertEquals("La velocidad de piccolo es correcta", piccolo.velocidad(), 4);
			
		}
		
		
}