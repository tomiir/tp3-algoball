package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Gohan;

public class test06 {
	Tablero tablero = new Tablero(15, 15);
	Cell cell = new Cell(tablero);
	Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
	
	@Test
	public void CellAbsorbeVidaCorrectamente () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate{
		Gohan gohan = new Gohan(tablero);
		tablero.posicionarPersonaje(gohan, new Posicion(5, 5));
		tablero.posicionarPersonaje(cell, new Posicion(5, 6));
		
		cell.seAvanzoUnTurno(5);
		cell.recibirDaño(200);
		
		int vidaInicialCell = cell.puntosDeVida();
		int vidaInicialGohan = gohan.puntosDeVida();
		
		cell.atacar(gohan, true);
		
		int vidaFinalCell = cell.puntosDeVida();
		int vidaFinalGohan = gohan.puntosDeVida();
		
		Assert.assertTrue("La vida de cell aumenta al absorber vida", vidaFinalCell > vidaInicialCell);
		
		Assert.assertTrue("La vida final de gohan disminuye", vidaFinalGohan < vidaInicialGohan);
		
		int vidaAbsorbidaPorCell = vidaFinalCell - vidaInicialCell;
		int vidaAbsorbidaDeGohan = vidaInicialGohan - vidaFinalGohan;
		
		Assert.assertEquals("La cantidades de vida son correctas", vidaAbsorbidaDeGohan, vidaAbsorbidaPorCell);		
		
	}
	

}
