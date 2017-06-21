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
import Modelo.Personajes.Goku;
import Modelo.Personajes.MajinBoo;
import Modelo.Personajes.Personaje;
import Modelo.Personajes.PersonajeFactory;
	
	public class test09 {		
		Tablero tablero = new Tablero(15, 15);
		PersonajeFactory factory = new PersonajeFactory();
		Personaje goku = factory.getPersonaje("goku");
		Personaje majinBoo = factory.getPersonaje("majinboo");
		Equipo GuerrerosZ = new Equipo("GuerrerosZ");
		
		@Test
		public void GokuAumentaDañoCuandoTienePocaVida () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
			GuerrerosZ.agregarPersonaje(goku);
		
			tablero.posicionarPersonaje(goku, new Posicion(5, 5));
			tablero.posicionarPersonaje(majinBoo, new Posicion(5, 6));
			
			int vidaInicialMajinBoo = majinBoo.puntosDeVida();
			goku.atacarNormal(majinBoo);
			int vidaFinalMajinBoo = majinBoo.puntosDeVida();
			
			int dañoRealizadoConAltoNivelDeVida = vidaInicialMajinBoo- vidaFinalMajinBoo;
						
			goku.recibirDaño(450);
			
			vidaInicialMajinBoo = vidaFinalMajinBoo;
			
			goku.atacarNormal(majinBoo);
			
			vidaFinalMajinBoo = majinBoo.puntosDeVida();
			
			int dañoRealizadoConBajoNivelDeVida = vidaInicialMajinBoo - vidaFinalMajinBoo;
			
			Assert.assertTrue("El daño realizado con menos vida es mayor al realizado con mas", dañoRealizadoConBajoNivelDeVida > dañoRealizadoConAltoNivelDeVida);
		}	
		
}
