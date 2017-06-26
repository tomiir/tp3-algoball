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
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeFactory;

public class test07 {
	Tablero tablero = new Tablero(15, 15);
	PersonajeFactory factory = new PersonajeFactory();
	Personaje gohan = factory.getPersonaje("gohan");
	Personaje cell = factory.getPersonaje("cell");
	Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
	
	@Test
	public void CellAbsorbeVidaCorrectamente () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNoEsPosibleTransformarse{
		EnemigosDeLaTierra.agregarPersonaje(cell);
		
		tablero.posicionarPersonaje(gohan, new Posicion(5, 5));
		tablero.posicionarPersonaje(cell, new Posicion(5, 6));
		
		
		cell.seAvanzoUnTurno(5);
		cell.recibirDanio(200);
		cell.seAvanzoUnTurno(5);
		cell.recibirDanio(200);
		cell.seAvanzoUnTurno(5);
		cell.recibirDanio(200);		
		
		cell.seAvanzoUnTurno(5);
		cell.recibirDanio(200);		
		
		cell.atacarEspecial(gohan);
				
		cell.atacarEspecial(gohan);
		cell.atacarEspecial(gohan);
		
		int vidaInicialCell = cell.puntosDeVida();
		
		cell.atacarEspecial(gohan);
		
		int vidaFinalCell = cell.puntosDeVida();
		int vidaAbsorbidaPorCellSinHaberseTransformado = vidaFinalCell - vidaInicialCell;
		
		cell.transformar(EnemigosDeLaTierra);
		cell.seAvanzoUnTurno(5);
		
		vidaInicialCell = cell.puntosDeVida();
		
		cell.atacarEspecial(gohan);
		
		vidaFinalCell = cell.puntosDeVida();
		
		int vidaAbsorbidaPorCellConTransformacion = vidaFinalCell - vidaInicialCell;
		
		Assert.assertTrue("Una vez realizada la transfomacion, se absorbe mas vida", vidaAbsorbidaPorCellConTransformacion > vidaAbsorbidaPorCellSinHaberseTransformado);
	}		
}
