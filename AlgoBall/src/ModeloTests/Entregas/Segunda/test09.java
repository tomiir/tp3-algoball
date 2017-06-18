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
	
	public class test09 {		
		Tablero tablero = new Tablero(15, 15);
		Goku goku = new Goku(tablero);
		Equipo GuerrerosZ = new Equipo("GuerrerosZ");
		
		@Test
		public void GokuAumentaDa�oCuandoTienePocaVida () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
			GuerrerosZ.agregarPersonaje(goku);
			MajinBoo majinBoo = new MajinBoo(tablero);
		
			tablero.posicionarPersonaje(goku, new Posicion(5, 5));
			tablero.posicionarPersonaje(majinBoo, new Posicion(5, 6));
			
			int vidaInicialMajinBoo = majinBoo.puntosDeVida();
			goku.atacar(majinBoo, false);
			int vidaFinalMajinBoo = majinBoo.puntosDeVida();
			
			int da�oRealizadoConAltoNivelDeVida = vidaInicialMajinBoo- vidaFinalMajinBoo;
						
			goku.recibirDa�o(450);
			
			vidaInicialMajinBoo = vidaFinalMajinBoo;
			
			goku.atacar(majinBoo, false);
			
			vidaFinalMajinBoo = majinBoo.puntosDeVida();
			
			int da�oRealizadoConBajoNivelDeVida = vidaInicialMajinBoo - vidaFinalMajinBoo;
			
			Assert.assertTrue("El da�o realizado con menos vida es mayor al realizado con mas", da�oRealizadoConBajoNivelDeVida > da�oRealizadoConAltoNivelDeVida);
		}	
		
}
