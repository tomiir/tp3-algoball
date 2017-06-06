package ModeloTests;
import Modelo.Jugador;

import Modelo.Tablero;
import Modelo.Goku;
import Modelo.Posicion;
import org.junit.Assert;
import Modelo.Equipo;
import Modelo.Gohan;
import Modelo.Piccolo;
import Modelo.Freezer;
import Modelo.Cell;
import Modelo.MajinBoo;
import Modelo.Personaje;

import org.junit.Test;

import Modelo.Direccion;
import Modelo.ExcDireccionInvalida;
import Modelo.ExcFueraDeTablero;
import Modelo.ExcNoEsPosibleTransformarse;
import Modelo.ExcPosicionOcupada;
import Modelo.Juego;


public class IntegracionPruebas {
	
	
	Jugador jugador1 = new Jugador("J1");
	Jugador jugador2 = new Jugador("J2");
	
	Tablero tablero = new Tablero(20,20);
	
	Goku goku = new Goku(tablero);
	Gohan gohan = new Gohan(tablero);
	Piccolo piccolo = new Piccolo(tablero);
	

	Cell cell = new Cell(tablero);
	Freezer freezer = new Freezer(tablero);
	MajinBoo majinBoo = new MajinBoo(tablero);
	
	
	@Test
	public void Test06CrearJugadoresYPosicionarEquipos() throws ExcPosicionOcupada, ExcFueraDeTablero{
	
		Equipo guerrerosZ = new Equipo("Guerreros Z");
		
		guerrerosZ.agregarPersonaje(goku);
		guerrerosZ.agregarPersonaje(gohan);
		guerrerosZ.agregarPersonaje(piccolo);
		
		
		Equipo enemigos = new Equipo("Enemigos de la Tierra");
		
		enemigos.agregarPersonaje(cell);
		enemigos.agregarPersonaje(freezer);
		enemigos.agregarPersonaje(majinBoo);
		
		jugador1.asignarEquipo(guerrerosZ);
		jugador2.asignarEquipo(enemigos);
		
		
		tablero.posicionar(goku,new Posicion(1,0));
		tablero.posicionar(gohan,new Posicion(2,0));
		tablero.posicionar(piccolo,new Posicion(3,0));
		
		tablero.posicionar(freezer,  new Posicion(20,20));
		tablero.posicionar(cell, new Posicion(19,20));
		tablero.posicionar(majinBoo, new Posicion(18,20));
		
		
	
	}
	
	
	

}
