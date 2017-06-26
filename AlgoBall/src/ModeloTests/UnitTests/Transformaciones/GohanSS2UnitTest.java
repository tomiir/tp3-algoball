package ModeloTests.UnitTests.Transformaciones;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.GohanSS2;
import org.junit.Assert;

public class GohanSS2UnitTest {
	
	Tablero tablero = new Tablero(5, 5);
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba("Personaje1", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba("Personaje2", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba("Personaje3", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba("Personaje4", 300, 3, 3, 1);
	
	
	
	GohanSS2 transformacionEspecialGohan = new GohanSS2 ();
	
	
	@Test 
	public void noEsPosibleTransformarSinKi () throws ExcNoEsPosibleTransformarse, ExcNumeroNegativo{
		
		Equipo equipo = new Equipo("EquipoPrueba");
		
		equipo.agregarPersonaje(personaje1);
		equipo.agregarPersonaje(personaje2);
		equipo.agregarPersonaje(personaje3);
		
		personaje2.recibirDanio(210);
		personaje3.recibirDanio(210);
		
		Assert.assertFalse(transformacionEspecialGohan.esPosible(personaje1, equipo));		
	}
	
	@Test 
	public void noEsPosibleTransformarSinCondicionEspecial () throws ExcNoEsPosibleTransformarse, ExcNumeroNegativo{
		
		Equipo equipo = new Equipo("EquipoPrueba");
		
		equipo.agregarPersonaje(personaje1);
		equipo.agregarPersonaje(personaje2);
		equipo.agregarPersonaje(personaje3);
		
		
		Assert.assertFalse(transformacionEspecialGohan.esPosible(personaje1, equipo));	
		
	}
	
	
	@Test
	public void esPosibleTransformarGohanSS2 () throws ExcNumeroNegativo {
		
		Equipo equipo = new Equipo("EquipoPrueba");
		equipo.agregarPersonaje(personaje1);
		equipo.agregarPersonaje(personaje2);
		equipo.agregarPersonaje(personaje3);
		
		personaje1.seAvanzoUnTurno(30);
		personaje2.recibirDanio(210);
		personaje3.recibirDanio(210);
		
		Assert.assertTrue(transformacionEspecialGohan.esPosible(personaje1, equipo));		
	}
	
	@Test
	public void transformacionModificaParametrosCorrectamente() throws ExcNumeroNegativo, ExcNoEsPosibleTransformarse, ExcEsChocolate, ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio{
		
		Equipo equipo = new Equipo("EquipoPrueba");
		equipo.agregarPersonaje(personaje1);
		equipo.agregarPersonaje(personaje2);
		equipo.agregarPersonaje(personaje3);
		personaje1.agregarTransformacion(transformacionEspecialGohan);

		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje3, new Posicion(1,3));		
		tablero.posicionarPersonaje(personaje4, new Posicion(2,1));
		
		personaje1.seAvanzoUnTurno(30);
		personaje2.recibirDanio(210);
		personaje3.recibirDanio(210);
		
		
		personaje1.transformar(equipo);
		
		personaje1.atacarNormal(personaje4);
		
		Assert.assertEquals(personaje4.puntosDeVida(), 200);
		
	}
}
