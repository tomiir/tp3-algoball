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
		PersonajeDePrueba personaje = new PersonajeDePrueba("pj",300, 3 ,3 ,100);
		
		//Posiciono al personaje y lo muevo a un casillero fuera de su rango
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		tablero.moverPersonaje(personaje, new Posicion(1,6));
		
		
	
	}
	
	@Test
	public void puedeMoverseCuandoConsumeUnaNube() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje = new PersonajeDePrueba("pj",300, 3 ,3 ,100);
		NubeVoladora nube = new NubeVoladora();
		
		
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		tablero.posicionarConsumible(nube,  new Posicion(1,2));
		
		//Agarro la nube
		tablero.moverPersonaje(personaje, new Posicion(1,2));
		
		//Pruebo que se puede mover en vertical 6 espcios ( el doble de su velocidad)
		tablero.moverPersonaje(personaje, new Posicion(7,2));
		
		//Pruebo que se pueda mover en horizontal 6
		tablero.moverPersonaje(personaje, new Posicion(7,8));
		
		//Pruebo que se pueda mover en diagonal 6
		tablero.moverPersonaje(personaje, new Posicion(1,2));
		
		
		
	}
	
	@Test(expected = ExcFueraDeRango.class)
	public void noSePuedeMoverAMasDelRangoAdicional() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje = new PersonajeDePrueba("pj",300, 3 ,3 ,100);
		NubeVoladora nube = new NubeVoladora();
		
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		tablero.posicionarConsumible(nube,  new Posicion(1,2));
		
		//Agarro la nube
		tablero.moverPersonaje(personaje, new Posicion(1,2));
			
		//Pruebo que se puede mover 6
		tablero.moverPersonaje(personaje, new Posicion(7,2));
		
		//Pruebo moverme 7 casilleros, deberia lanzar una excepcion
		tablero.moverPersonaje(personaje,new Posicion(14,2));
		
	}
	
	@Test(expected = ExcFueraDeRango.class)
	public void despuesDeDosTurnosElEfectoDesaparece() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcEsChocolate, ExcCasilleroDesocupado, ExcFueraDeRango, ExcPosicionNegativa, ExcNumeroNegativo{
		
		Tablero tablero = new Tablero(15,15);
		PersonajeDePrueba personaje = new PersonajeDePrueba("pj",300, 3 ,3 ,100);
		NubeVoladora nube = new NubeVoladora();
		
		tablero.posicionarPersonaje(personaje, new Posicion(1,1));
		tablero.posicionarConsumible(nube,  new Posicion(1,2));
		
		//Agarro la nube
		tablero.moverPersonaje(personaje, new Posicion(1,2));
	
		//Paso un turno y pruebo que se puede mover 6
		personaje.seAvanzoUnTurno(5);
		tablero.moverPersonaje(personaje, new Posicion(7,2));
		
		//Avanzo un turno y verifico que se pueda mover 6
		personaje.seAvanzoUnTurno(5);
		tablero.moverPersonaje(personaje, new Posicion(13,7));

		//Avanzo un turno y me muevo 6, deberia lanzar una excepcion
		personaje.seAvanzoUnTurno(5);
		tablero.moverPersonaje(personaje, new Posicion(13, 13));
		
		
		
		
		
		
		
		
	}
}	