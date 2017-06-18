package ModeloTests.Entregas.Segunda;

import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcHayGanador;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Freezer;
import Modelo.Personajes.Gohan;
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.Piccolo;
import org.junit.Assert;

public class test01 {
	Tablero tablero = new Tablero(15, 15);
	Equipo GuerrerosZ = new Equipo("GuerrerosZ");
	Goku goku = new Goku(tablero);
	Piccolo piccolo = new Piccolo(tablero);
	Gohan gohan = new Gohan(tablero);
	
	@Test
	public void GohanSeTransformaCorrectamente() throws ExcNoEsPosibleTransformarse, ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
		GuerrerosZ.agregarPersonaje(goku);
		GuerrerosZ.agregarPersonaje(piccolo);
		GuerrerosZ.agregarPersonaje(gohan);
		
		Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
		Freezer freezer = new Freezer(tablero);
		EnemigosDeLaTierra.agregarPersonaje(freezer);
		
		tablero.posicionarPersonaje(goku, new Posicion(1, 1));
		tablero.posicionarPersonaje(piccolo, new Posicion(2, 2));
		tablero.posicionarPersonaje(gohan, new Posicion(5, 5));
		
		tablero.posicionarPersonaje(freezer, new Posicion(6, 6));;
		
		int vidaInicialFreezer = freezer.puntosDeVida();
		gohan.atacar(freezer, false);
		
		int vidaTrasPrimerAtaque = freezer.puntosDeVida();
		
		int dañoRealizadoSinTransformar = vidaInicialFreezer - vidaTrasPrimerAtaque;
		
		gohan.seAvanzoUnTurno(10);
		
		gohan.transformar(GuerrerosZ);
		
		gohan.atacar(freezer, false);
		
		int vidaTrasSegundoAtaque = freezer.puntosDeVida();
		
		int dañoRealizadoSiTransformo = vidaTrasPrimerAtaque - vidaTrasSegundoAtaque;
		
		Assert.assertTrue("El ataque cuando se transformo saca mas vida", (dañoRealizadoSiTransformo - dañoRealizadoSinTransformar) > 0);
		
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void GohanNoPuedeLlegarALaSegundaTransformacionYaQueNoSeAtacoASusCompañeros() throws ExcNumeroNegativo, ExcNoEsPosibleTransformarse, ExcEsChocolate{
		GuerrerosZ.agregarPersonaje(goku);
		GuerrerosZ.agregarPersonaje(piccolo);
		GuerrerosZ.agregarPersonaje(gohan);
		
		gohan.seAvanzoUnTurno(10);
		gohan.transformar(GuerrerosZ);
		
		gohan.seAvanzoUnTurno(30);
		gohan.transformar(GuerrerosZ);		
		
	}
	
	
	
		
}
	
