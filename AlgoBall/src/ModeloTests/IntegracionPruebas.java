package ModeloTests;

import Modelo.Tablero;
import Modelo.Goku;
import Modelo.Posicion;
import org.junit.Assert;

import org.junit.Test;

import Modelo.Direccion;
import Modelo.ExcDireccionInvalida;
import Modelo.ExcFueraDeTablero;
import Modelo.ExcNoEsPosibleTransformarse;
import Modelo.ExcPosicionOcupada;
import Modelo.Juego;

public class IntegracionPruebas {
	
	Gohan gohan = new Gohan();
	Piccolo piccolo = new Piccolo();
	Goku goku = new Goku();
	
	Cell cell = new Cell();
	Freezer freezer = new Freezer();
	MajinBoo majinBoo = new MajinBoo();
	
	Equipo equipo = new Equipo([gohan,goku,piccolo]);
	
	
	@Test
	public void crearNuevoJuego(){
		
		Juego juego = new Juego(15,15);
		
		
	}
	

}
