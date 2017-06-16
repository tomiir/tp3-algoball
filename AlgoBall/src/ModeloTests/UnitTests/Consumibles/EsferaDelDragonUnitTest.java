package ModeloTests.UnitTests.Consumibles;



import org.junit.Test;

import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Consumibles.EsferaDelDragon;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;
import  org.junit.Assert;


public class EsferaDelDragonUnitTest {
	
	Tablero tablero = new Tablero(15,15);
	Jugador jugador = new Jugador("Jorge");
	
	@Test
	public void sePosicionaCorerctamente() throws ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeTablero, ExcEsChocolate, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcNumeroNegativo{
		EsferaDelDragon esfera = new EsferaDelDragon();
		tablero.posicionarConsumible(esfera, new Posicion(3,3));
		
		Personaje personaje = new PersonajeDePrueba(tablero,"pj",300, 1,1,100);
		Personaje personaje2 = new PersonajeDePrueba(tablero, "pj2", 300, 1, 1, 100);
		
		tablero.posicionarPersonaje(personaje, new Posicion(2,3));
		tablero.posicionarPersonaje(personaje2, new Posicion(4,3));
		
		personaje.mover(new Posicion(3,3));
		
		personaje.atacar(personaje2, false);
		
		Assert.assertEquals(personaje2.puntosDeVida(), 175);
		
		
		
	}

}
