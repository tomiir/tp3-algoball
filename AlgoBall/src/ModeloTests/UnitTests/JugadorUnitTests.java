package ModeloTests.UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Excepciones.ExcCasilleroDesocupado;
import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;
import Modelo.Personajes.PersonajeDePrueba;
import Modelo.Transformaciones.Transformacion;
import Modelo.Transformaciones.TransformacionPorKi;

public class JugadorUnitTests {
	
	Tablero tablero = new Tablero(15, 14);
	
	Jugador jugador1 = new Jugador("Jugador 1");
	Equipo equipo1 = new Equipo("Equipo 1");
	PersonajeDePrueba personaje1 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);
	
	Jugador jugador2 = new Jugador("Jugador 2");
	Equipo equipo2 = new Equipo("Equipo 2");
	PersonajeDePrueba personaje2 = new PersonajeDePrueba(tablero, "nombre", 300, 1, 3, 50);

	@Test
	public void seCreaJugadorCorrectamente(){		
		Assert.assertEquals("El jugador se creo correctamente",jugador1.nombre(),"Jugador 1");
	}
	
	@Test
	public void seAsignaEquipoAJugadorCorrectamente(){
		
		jugador1.asignarEquipo(equipo1);
			
		Assert.assertEquals("El equipo se asingo correctamente",jugador1.equipo().nombre(),"Equipo 1");
		
	}
	
	@Test
	public void jugadorPuedeMoverPersonaje() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado{
		
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		
		Posicion pos2 = new Posicion(2,2);
		jugador1.realizarMovimiento(personaje1, pos2);
		
		Assert.assertEquals("Personaje se movio lo esperado",personaje1.posicion(),pos2);
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void jugadorNoPuedeMoverPersonajePorFueraDeTablero() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado{
		
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		
		Posicion pos2 = new Posicion(0,2);
		jugador1.realizarMovimiento(personaje1, pos2);
		
	}
	
	@Test (expected = ExcCasilleroOcupado.class)
	public void jugadorNoPuedeMoverPersonajePorCasilleroOcupado() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado{
		
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,3));
		
		jugador1.realizarMovimiento(personaje1, new Posicion(1,3));
		
	}
	
	@Test (expected = ExcPosicionNegativa.class)
	public void jugadorNoPuedeMoverPersonajePorPosicionNegativa() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcCasilleroDesocupado{

		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,2));
		
		jugador1.realizarMovimiento(personaje1, new Posicion(-1,3));
		
	}
	
	@Test (expected = ExcEsChocolate.class)
	public void jugadorNoPuedeMoverPersonajePorPersonajeEsChocolate() throws ExcEsChocolate, ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcCasilleroDesocupado{

		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		
		personaje1.convertirEnChocolate(3);
		
		jugador1.realizarMovimiento(personaje1, new Posicion(1,3));
		
	}
	
	@Test
	public void jugadorPuedeRealizarAtaque() throws ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcCasilleroOcupado, ExcPosicionNegativa{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
		
		int vida_inicial = personaje2.puntosDeVida();
		jugador1.realizarAtaque(personaje1, personaje2, false);
		
		Assert.assertEquals("Se realizo el ataque correcto",personaje2.puntosDeVida(),vida_inicial-personaje1.poderDePelea());
		
	}
	
	@Test (expected = ExcFueraDeRango.class)
	public void jugadorNoPuedeRealizarAtaquePorFueraDeRango() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		tablero.posicionarPersonaje(personaje2, new Posicion(10,10));
		
		jugador1.realizarAtaque(personaje1, personaje2, false);
	}
	
	@Test (expected = ExcFueraDeTablero.class)
	public void jugadorNoPuedeRealizarAtaquePorFueraDeTablero() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(14,15));
		tablero.posicionarPersonaje(personaje2, new Posicion(15,15));
		
		jugador1.realizarAtaque(personaje1, personaje2, false);
	}
	
	@Test (expected = ExcKiInsuficiente.class)
	public void jugadorNoPuedeRealizarAtaqueConKiInsuficiente() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		Ataque kame = Ataque.Kamekameha();
		
		personaje1.setAtaqueEspecial(kame);
		equipo2.agregarPersonaje(personaje2);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
		
		jugador1.realizarAtaque(personaje1, personaje2, true);
	}
	@Test (expected = ExcEsChocolate.class)
	public void jugadorNoPuedeRealizarAtaqueEsCholate() throws ExcEsChocolate, ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcNumeroNegativo, ExcCasilleroOcupado, ExcPosicionNegativa{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje2);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
		
		personaje1.convertirEnChocolate(3);
		
		jugador1.realizarAtaque(personaje1,personaje2,false);

	}
	
	@Test
	public void jugadorPuedeRealizarAtaqueLanzaExcepcionAlMorir() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo, ExcCasilleroDesocupado{
		PersonajeDePrueba personaje3 = new PersonajeDePrueba(tablero, "pj", 50, 1, 3, 50);
		
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		equipo2.agregarPersonaje(personaje3);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		Posicion pos_2=  new Posicion(1,2);
		tablero.posicionarPersonaje(personaje3,pos_2);
		
		jugador1.realizarAtaque(personaje1,personaje3,false);
		
		jugador1.realizarMovimiento(personaje1, pos_2);
	}
	
	@Test
	public void jugadorPuedeRealizarTransformacion() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNoEsPosibleTransformarse, ExcEsChocolate, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcNumeroNegativo{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		tablero.posicionarPersonaje(personaje2, new Posicion(1,2));
		
		Transformacion trans = new TransformacionPorKi("Prueba", 0, 20, 30, 100);
		personaje1.agregarTransformacion(trans);
		
		jugador1.realizarTransformacion(personaje1);
		
		int vida_inicial = personaje2.puntosDeVida();
		
		jugador1.realizarAtaque(personaje1, personaje2, false);
		
		Assert.assertEquals("Se espera el daño esperado",personaje2.puntosDeVida(),vida_inicial-personaje1.poderDePelea());
		
	}
	
	@Test (expected = ExcNoEsPosibleTransformarse.class)
	public void jugadorNoPuedeRealizarTransformacionPorKiInsuficiente() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNoEsPosibleTransformarse, ExcEsChocolate{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		
		Transformacion trans = new TransformacionPorKi("Prueba", 5, 20, 30, 100);
		personaje1.agregarTransformacion(trans);
		
		jugador1.realizarTransformacion(personaje1);
	}
	
	@Test (expected = ExcEsChocolate.class)
	public void jugadorNoPuedeRealizarTransformacionPorEstarEnFormaChocolate() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcEsChocolate, ExcFueraDeRango, ExcPersonajeMurio, ExcKiInsuficiente, ExcNumeroNegativo{
		jugador1.asignarEquipo(equipo1);
		equipo1.agregarPersonaje(personaje1);
		
		tablero.posicionarPersonaje(personaje1, new Posicion(1,1));
		
		Transformacion trans = new TransformacionPorKi("Prueba", 5, 20, 30, 100);
		personaje1.agregarTransformacion(trans);
		
		personaje1.convertirEnChocolate(3);
		
		jugador1.realizarAtaque(personaje1,personaje2,false);
		
	}
}
