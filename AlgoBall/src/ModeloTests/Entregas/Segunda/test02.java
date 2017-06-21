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
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeFactory;
import Modelo.Personajes.Piccolo;

public class test02 {
	Tablero tablero = new Tablero(15, 15);
	Equipo GuerrerosZ = new Equipo("GuerrerosZ");
	PersonajeFactory factory = new PersonajeFactory();
	Personaje goku = factory.getPersonaje("goku");
	Personaje piccolo = factory.getPersonaje("piccolo");
	Personaje gohan = factory.getPersonaje("gohan");
	
	
	@Test
	public void gohanSeTransformaCorrectamenteEnSS2 () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcNoEsPosibleTransformarse, ExcEsChocolate, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio{
		GuerrerosZ.agregarPersonaje(goku);
		GuerrerosZ.agregarPersonaje(piccolo);
		GuerrerosZ.agregarPersonaje(gohan);
		
		Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
		Personaje freezer = factory.getPersonaje("freezer");
		EnemigosDeLaTierra.agregarPersonaje(freezer);
		
		tablero.posicionarPersonaje(goku, new Posicion(1, 1));
		tablero.posicionarPersonaje(piccolo, new Posicion(2, 2));
		tablero.posicionarPersonaje(gohan, new Posicion(5, 5));
		//freezer en rango de ataque de gohan
		tablero.posicionarPersonaje(freezer, new Posicion(6, 6));;
		
		gohan.seAvanzoUnTurno(10);
		gohan.transformar(GuerrerosZ);
		
		int vidaInicial = freezer.puntosDeVida();
		gohan.atacarNormal(freezer);
		
		int vidaTrasAtaquePrimeraTransformacion = freezer.puntosDeVida();
		
		int dañoRealizadoConAtaqueDePrimeraTransformacion = vidaInicial - vidaTrasAtaquePrimeraTransformacion;
		
		gohan.seAvanzoUnTurno(30);
		goku.recibirDaño(400);
		piccolo.recibirDaño(400);
		gohan.transformar(GuerrerosZ);
		gohan.atacarNormal(freezer);
		
		int vidaTrasAtaqueSegundaTransformacion = freezer.puntosDeVida();
		
		int dañoRealizadoConAtaqueDeSegundaTransformacion = vidaTrasAtaquePrimeraTransformacion - vidaTrasAtaqueSegundaTransformacion;
		
		Assert.assertTrue("El ataque cuando hizo la segunda transformacion saca mas que el ataque de la primera", (dañoRealizadoConAtaqueDeSegundaTransformacion > dañoRealizadoConAtaqueDePrimeraTransformacion));
	}
	
}