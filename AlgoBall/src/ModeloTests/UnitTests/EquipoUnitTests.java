package ModeloTests.UnitTests;

import java.util.HashMap;

import org.junit.*;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Tablero;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeDePrueba;
public class EquipoUnitTests {
	
	Tablero tablero = new Tablero(5, 5);
	Jugador jugador1 = new Jugador("nombre1");
	Jugador jugador2 = new Jugador("nombre2");
	Partida partida = new Partida(tablero, jugador1, jugador2);
	Equipo equipo1 = new Equipo("equipo1");
	Equipo equipo2 = new Equipo("equipo2");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida, "nombre", 300, 3, 3, 1);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida, "nombre", 300, 3, 3, 1);
	PersonajeDePrueba personaje3 = new PersonajeDePrueba(partida, "nombre", 300, 3, 3, 1);
	PersonajeDePrueba personaje4 = new PersonajeDePrueba(partida, "nombre", 300, 3, 3, 1);
	
	@Test
	public void seCreaCorrectamente(){
		
		String nombre = "Test";
		Equipo equipo = new Equipo(nombre);
		
		Assert.assertEquals(equipo.nombre(), nombre);
		Assert.assertEquals(equipo.cantidadPersonajes(), 0);
		
	}
	
	
	//SE ASUME QUE NO HAY @ PERSONAJES DIFERENTES CON EL MISMO NOMBRE NI UN ITEM CON NOMBRE DE PERSONAJE
	@Test
	public void agregaMiembrosCorrectamente(){
		
		String nombre = "Test";
		Equipo equipo = new Equipo(nombre);
		
		PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida,"personaje",500,4,4,50);
		equipo.agregarPersonaje(personaje1);
		
		Assert.assertTrue(equipo.personajePertenece(personaje1));
		Assert.assertTrue(equipo.cantidadPersonajes() == 1);
		
		PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida,"personaje2",500,4,4,50);
		equipo.agregarPersonaje(personaje2);
	

		Assert.assertTrue(equipo.personajePertenece(personaje2));
		Assert.assertTrue(equipo.cantidadPersonajes() == 2);
		
		PersonajeDePrueba personaje3 = new PersonajeDePrueba(partida,"personaje3",500,4,4,50);
		
		Assert.assertFalse(equipo.personajePertenece(personaje3));
	}
	
	@Test
	public void iteraCorrectamente(){
		
		String nombre = "Test";
		Equipo equipo = new Equipo(nombre);
		
		HashMap<String,Personaje> diccionario = new HashMap<String, Personaje>();

		PersonajeDePrueba personaje1 = new PersonajeDePrueba(partida,"personaje1",500,4,4,50);
		PersonajeDePrueba personaje2 = new PersonajeDePrueba(partida,"personaje2",500,4,4,50);
		PersonajeDePrueba personaje3 = new PersonajeDePrueba(partida,"personaje3",500,4,4,50);
		
		equipo.agregarPersonaje(personaje1);
		equipo.agregarPersonaje(personaje2);
		equipo.agregarPersonaje(personaje3);
		
		equipo.forEach((k,p)->diccionario.put(k,p));
		
		Assert.assertEquals(diccionario.size(), 3);
		Assert.assertTrue(diccionario.containsKey("personaje1"));
		Assert.assertTrue(diccionario.containsKey("personaje2"));
		Assert.assertTrue(diccionario.containsKey("personaje3"));
		
		
		
	}
	
	

}
