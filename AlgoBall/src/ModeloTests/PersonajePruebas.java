package ModeloTests;
import Modelo.ExcCasilleroOcupado;
import Modelo.ExcFueraDeTablero;
import Modelo.ExcMovimientoImposible;
import Modelo.Goku;
import Modelo.Personaje;
import Modelo.PersonajeDePrueba;
import Modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

import com.sun.jndi.cosnaming.ExceptionMapper;

public class PersonajePruebas {
	
	Tablero tablero = new Tablero(15,15);
	Personaje personaje1 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	Personaje personaje2 = new PersonajeDePrueba (tablero, "Nombre", 300, 5, 3);
	
	@Test
	public void seCreaEnPosicionCorrecta () throws ExcCasilleroOcupado, ExcFueraDeTablero{
		personaje1.posicionar(posicion());
		
		Assert.assertEquals ("El personaje esta en posicion 'x' correcta", 1, personaje1.posicion().pos_x());
		Assert.assertEquals ("El personaje esta en posicion 'y' correcta", 2, personaje1.posicion().pos_y());
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void noSePuedenPosicionarDosEnMismaPosicion () throws ExcCasilleroOcupado, ExcFueraDeTablero {		
		personaje1.posicionar(tablero.obtenerCasillero(1, 2));
		personaje2.posicionar(tablero.obtenerCasillero(1, 2));
	}
	
	@Test
	public void seMueveCorrectamenteEnLineaRecta() throws ExcMovimientoImposible, ExcCasilleroOcupado, ExcFueraDeTablero {
		personaje1.posicionar(tablero.obtenerCasillero(1, 2));
		personaje1.mover (tablero.obtenerCasillero(3, 2));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 3, personaje1.posicion().pos_x());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 2, personaje1.posicion().pos_y());
	}
	
	@Test
	public void seMueveCorrectamenteEnDiagonal () throws ExcMovimientoImposible, ExcCasilleroOcupado, ExcFueraDeTablero {
		personaje1.posicionar(tablero.obtenerCasillero(1, 2));
		personaje1.mover (tablero.obtenerCasillero(3, 3));
		
		Assert.assertEquals("El personaje esta en la posicion 'x' correcta", 3, personaje1.posicion().pos_x());
		Assert.assertEquals("El personaje esta en la posicion 'y' correcta", 3, personaje1.posicion().pos_y());
	}
	
	@Test (expected = ExcMovimientoImposible.class)
	public void noSeMueveFueraDeRango () throws ExcMovimientoImposible, ExcCasilleroOcupado, ExcFueraDeTablero {
		personaje1.posicionar(tablero.obtenerCasillero(1, 2));
		personaje1.mover (tablero.obtenerCasillero(4, 4));
	}
	
	@Test (expected = ExcMovimientoImposible.class)
	public void noSePuedeMoverACasilleroOcupado () throws ExcCasilleroOcupado, ExcFueraDeTablero, ExcMovimientoImposible {
		personaje1.posicionar(tablero.obtenerCasillero(1, 2));
		personaje2.posicionar(tablero.obtenerCasillero(3, 2));
		
		personaje1.mover(tablero.obtenerCasillero(3, 2));
	}
	
}
