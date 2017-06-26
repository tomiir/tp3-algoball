package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

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
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeFactory;

public class test06 {
	Tablero tablero = new Tablero(15, 15);
	
	
	PersonajeFactory factory = new PersonajeFactory();
	Personaje gohan= factory.getPersonaje("gohan");
	Personaje cell = factory.getPersonaje("cell");
	
	
	@Test
	public void CellAbsorbeVidaCorrectamente () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate{
		
		tablero.posicionarPersonaje(gohan, new Posicion(5, 5));
		tablero.posicionarPersonaje(cell, new Posicion(5, 6));
		
		cell.seAvanzoUnTurno(5);
		cell.recibirDanio(200);
		
		int vidaInicialCell = cell.puntosDeVida();
		int vidaInicialGohan = gohan.puntosDeVida();
		
		//ataco con absorcion
		cell.atacarEspecial(gohan);
		
		int vidaFinalCell = cell.puntosDeVida();
		int vidaFinalGohan = gohan.puntosDeVida();
		
		Assert.assertTrue("La vida de cell aumenta al absorber vida", vidaFinalCell > vidaInicialCell);
		
		Assert.assertTrue("La vida final de gohan disminuye", vidaFinalGohan < vidaInicialGohan);
		
		int vidaAbsorbidaPorCell = vidaFinalCell - vidaInicialCell;
		int vidaAbsorbidaDeGohan = vidaInicialGohan - vidaFinalGohan;
		
		Assert.assertEquals("La cantidades de vida son correctas", vidaAbsorbidaDeGohan, vidaAbsorbidaPorCell);		
		
	}
	

}
