package ModeloTests.UnitTests.Consumibles;




import org.junit.Test;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Consumibles.NubeVoladora;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;


public class NubeVoladoraUnitTest {
	
	@Test(expected = ExcFueraDeRango.class)
	public void noPuedeMoverseAPosicionFueraDeRango() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje = new PersonajeDePrueba(tablero,"pj",300, 3 ,3 ,100);
		
		//Posiciono al personaje y lo muevo a un casillero fuera de su rango
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		personaje.mover(new Posicion(1,5));
		
		
	
	}
	
	@Test
	public void puedeMoverseCuandoConsumeUnaNube() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje = new PersonajeDePrueba(tablero,"pj",300, 3 ,4 ,100);
		NubeVoladora nube = new NubeVoladora();
		
		
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		tablero.posicionarConsumible(nube,  new Posicion(1,2));
		
		//Agarro la nube
		personaje.mover(new Posicion(1,2));
		
		//Pruebo que se puede mover en vertical 5 espcios ( 4 de su velocidad + 4*25% = 5)
		personaje.mover(new Posicion(6,2));
		
		//Pruebo que se pueda mover en horizontal 5
		personaje.mover(new Posicion(6,7));
		
		//Pruebo que se pueda mover en diagonal 5
		personaje.mover(new Posicion(1,2));
		
		
		
	}
	
	@Test(expected = ExcFueraDeRango.class)
	public void noSePuedeMoverAMasDelRangoAdicional() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje = new PersonajeDePrueba(tablero,"pj",300, 3 ,4 ,100);
		NubeVoladora nube = new NubeVoladora();
		
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		tablero.posicionarConsumible(nube,  new Posicion(1,2));
		
		//Agarro la nube
		personaje.mover(new Posicion(1,2));
			
		//Pruebo que se puede mover 5
		personaje.mover(new Posicion(6,2));
		
		//Pruebo moverme 6 casilleros, deberia lanzar una excepcion
		personaje.mover(new Posicion(13,2));
		
	}
	
	@Test(expected = ExcFueraDeRango.class)
	public void despuesDeDosTurnosElEfectoDesaparece() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango, ExcPosicionNegativa, ExcNumeroNegativo{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje = new PersonajeDePrueba(tablero,"pj",300, 3 ,4 ,100);
		NubeVoladora nube = new NubeVoladora();
		
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		tablero.posicionarConsumible(nube,  new Posicion(1,2));
		
		//Agarro la nube
		personaje.mover(new Posicion(1,2));
	
		//Pruebo que se puede mover 5
		personaje.mover(new Posicion(6,2));
		
		//Avanzo un turno y verifico que se pueda mover 5
		personaje.seAvanzoUnTurno(5);
		personaje.mover(new Posicion(6,7));

		//Avanzo un turno y me muevo 5, deberia lanzar una excepcion
		personaje.seAvanzoUnTurno(5);
		personaje.mover(new Posicion(11,12));
		
		
		
		
		
		
		
		
	}
}	