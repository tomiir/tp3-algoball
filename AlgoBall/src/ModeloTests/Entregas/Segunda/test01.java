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
import org.junit.Assert;

public class test01 {
	Tablero tablero = new Tablero(15, 15);
	Equipo GuerrerosZ = new Equipo("GuerrerosZ");
	PersonajeFactory factory = new PersonajeFactory();
	Personaje goku = factory.getPersonaje("goku");
	Personaje piccolo = factory.getPersonaje("piccolo");
	Personaje gohan = factory.getPersonaje("gohan");
	
	@Test
	public void GohanSeTransformaCorrectamente() throws ExcNoEsPosibleTransformarse, ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
		GuerrerosZ.agregarPersonaje(goku);
		GuerrerosZ.agregarPersonaje(piccolo);
		GuerrerosZ.agregarPersonaje(gohan);
		
		Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
		Personaje freezer = factory.getPersonaje("freezer");
		EnemigosDeLaTierra.agregarPersonaje(freezer);
		
		tablero.posicionarPersonaje(goku, new Posicion(1, 1));
		tablero.posicionarPersonaje(piccolo, new Posicion(2, 2));
		tablero.posicionarPersonaje(gohan, new Posicion(5, 5));
		
		tablero.posicionarPersonaje(freezer, new Posicion(6, 6));;
		
		int vidaInicialFreezer = freezer.puntosDeVida();
		gohan.atacarNormal(freezer);
		
		int vidaTrasPrimerAtaque = freezer.puntosDeVida();
		
		int danioRealizadoSinTransformar = vidaInicialFreezer - vidaTrasPrimerAtaque;
		
		gohan.seAvanzoUnTurno(10);
		
		gohan.transformar(GuerrerosZ);
		
		gohan.atacarNormal(freezer);
		
		int vidaTrasSegundoAtaque = freezer.puntosDeVida();
		
		int danioRealizadoSiTransformo = vidaTrasPrimerAtaque - vidaTrasSegundoAtaque;
		
		Assert.assertTrue("El ataque cuando se transformo saca mas vida", (danioRealizadoSiTransformo - danioRealizadoSinTransformar) > 0);
		
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void GohanNoPuedeLlegarALaSegundaTransformacionYaQueNoSeAtacoASusCompanieros() throws ExcNumeroNegativo, ExcNoEsPosibleTransformarse, ExcEsChocolate{
		GuerrerosZ.agregarPersonaje(goku);
		GuerrerosZ.agregarPersonaje(piccolo);
		GuerrerosZ.agregarPersonaje(gohan);
		
		gohan.seAvanzoUnTurno(10);
		gohan.transformar(GuerrerosZ);
		
		gohan.seAvanzoUnTurno(30);
		gohan.transformar(GuerrerosZ);		
		
	}
	
	
	
		
}
	
