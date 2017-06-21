package ModeloTests.Entregas.Segunda;

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


public class test05 {
	Tablero tablero = new Tablero(15, 15);
	
	PersonajeFactory factory = new PersonajeFactory();
	Personaje goku = factory.getPersonaje("goku");
	Personaje cell = factory.getPersonaje("cell");
	
	Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void CellNoSePuedeTransformarYaQueNoAbsorbeVida4Veces () throws ExcNumeroNegativo, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNoEsPosibleTransformarse{
		tablero.posicionarPersonaje(cell, new Posicion(5, 5));
		tablero.posicionarPersonaje(goku, new Posicion(5,6));
		
		cell.seAvanzoUnTurno(5);
		cell.atacarNormal(goku);
		cell.seAvanzoUnTurno(5);
		cell.atacarNormal(goku);
		cell.seAvanzoUnTurno(5);
		cell.atacarNormal(goku);
		
		cell.transformar(EnemigosDeLaTierra);		
	}
}	