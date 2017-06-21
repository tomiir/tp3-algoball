package ModeloTests.Entregas.Primera;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;

public class test07 {
	Tablero tablero = new Tablero(15,14);
	
	PersonajeDePrueba personaje1 = new PersonajeDePrueba ("Nombre", 300, 1, 3,100);
	PersonajeDePrueba personaje2 = new PersonajeDePrueba ("Nombre", 300, 1, 3,200);
	
	@Test
	public void atacaConDañoEsperado () throws ExcFueraDeTablero, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible, ExcCasilleroOcupado, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		
		int pts1inicial=personaje1.puntosDeVida();
		int pts2inicial=personaje2.puntosDeVida();
		
		personaje1.atacarNormal(personaje2);
		Assert.assertEquals("El personaje2 recibe el daño esperado",pts2inicial-personaje2.puntosDeVida(),(personaje1.poderDePelea()*8)/10);
		personaje2.atacarNormal(personaje1);
		Assert.assertEquals("El personaje1 recibe el daño esperado",pts1inicial-personaje1.puntosDeVida(),personaje2.poderDePelea());
	}
	
	@Test (expected = ExcFueraDeRango.class)
	public void ataqueFueraDeRango() throws ExcFueraDeTablero, ExcPosicionNegativa, ExcFueraDeRango, ExcAtaqueImposible, ExcCasilleroOcupado, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo {		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,4));
		personaje1.atacarNormal(personaje2);
	}
}
