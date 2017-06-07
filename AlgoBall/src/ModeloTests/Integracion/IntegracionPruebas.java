package ModeloTests.Integracion;
import Modelo.Jugador;

import Modelo.Tablero;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Excepciones.ExcPosicionOcupada;

import Modelo.Personajes.*;
import Modelo.Posicion;
import org.junit.Assert;
import Modelo.Equipo;

import org.junit.Test;


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
	public void Test06CrearJugadoresYPosicionarEquipos() throws ExcPosicionOcupada, ExcFueraDeTablero, ExcPosicionNegativa{
	
		Equipo guerrerosZ = new Equipo("Guerreros Z");
		
		guerrerosZ.agregarPersonaje(goku);
		guerrerosZ.agregarPersonaje(gohan);
		guerrerosZ.agregarPersonaje(piccolo);
		
		Assert.assertEquals("Cantidad de integrantes del equipo GuerrerosZ correcto",guerrerosZ.cantidadPersonajes(),3);
		
		Equipo enemigos = new Equipo("Enemigos de la Tierra");
		
		enemigos.agregarPersonaje(cell);
		enemigos.agregarPersonaje(freezer);
		enemigos.agregarPersonaje(majinBoo);
		Assert.assertEquals("Cantidad de integrantes del equipo Enemigos correcto",enemigos.cantidadPersonajes(),3);
		
		jugador1.asignarEquipo(guerrerosZ);
		jugador2.asignarEquipo(enemigos);
		
		
		tablero.posicionar(goku,new Posicion(1,1));
		tablero.posicionar(gohan,new Posicion(2,1));
		tablero.posicionar(piccolo,new Posicion(3,1));
		
		Assert.assertEquals("Goku se encuentra en la pos X espereada",goku.posicion().posX(),1);
		Assert.assertEquals("Goku se encuentra en la pos Y espereada",goku.posicion().posY(),1);
		
		Assert.assertEquals("Gohan se encuentra en la pos X espereada",gohan.posicion().posX(),2);
		Assert.assertEquals("Gohan se encuentra en la pos Y espereada",gohan.posicion().posY(),1);

		Assert.assertEquals("Piccolo se encuentra en la pos X espereada",piccolo.posicion().posX(),3);
		Assert.assertEquals("Piccolo se encuentra en la pos Y espereada",piccolo.posicion().posY(),1);
		
		tablero.posicionar(freezer,  new Posicion(20,20));
		tablero.posicionar(cell, new Posicion(19,20));
		tablero.posicionar(majinBoo, new Posicion(18,20));
		
		Assert.assertEquals("Freezer se encuentra en la pos X espereada",freezer.posicion().posX(),20);
		Assert.assertEquals("Freezer se encuentra en la pos Y espereada",freezer.posicion().posY(),20);
	
		Assert.assertEquals("Cell se encuentra en la pos X espereada",cell.posicion().posX(),19);
		Assert.assertEquals("Cell se encuentra en la pos Y espereada",cell.posicion().posY(),20);
		
		Assert.assertEquals("MajinBoo se encuentra en la pos X espereada",majinBoo.posicion().posX(),18);
		Assert.assertEquals("MajinBoo se encuentra en la pos Y espereada",majinBoo.posicion().posY(),20);
	}	
	
	
	

}
