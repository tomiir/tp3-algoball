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
import Modelo.Personajes.Piccolo;
	
	public class test04 {
		Tablero tablero = new Tablero(15, 15);
		Equipo GuerrerosZ = new Equipo("GuerrerosZ");
		Piccolo piccolo = new Piccolo(tablero);
		Gohan gohan = new Gohan(tablero);
		
		@Test
		public void PiccoloSeTransformaCorrectamenteEnProtector () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcNoEsPosibleTransformarse, ExcEsChocolate, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio{
			GuerrerosZ.agregarPersonaje(piccolo);
			GuerrerosZ.agregarPersonaje(gohan);
			
			Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
			Freezer freezer = new Freezer(tablero);
			EnemigosDeLaTierra.agregarPersonaje(freezer);
			
		
			tablero.posicionarPersonaje(piccolo, new Posicion(2, 2));
			tablero.posicionarPersonaje(gohan, new Posicion(5, 5));
			//freezer en rango de ataque de piccolo
			tablero.posicionarPersonaje(freezer, new Posicion(6, 6));;
			
			piccolo.seAvanzoUnTurno(20);
			piccolo.transformar(GuerrerosZ);
			
			int vidaInicial = freezer.puntosDeVida();
			piccolo.atacar(freezer, false);
			
			int vidaTrasAtaquePrimeraTransformacion = freezer.puntosDeVida();
			
			int dañoRealizadoConAtaqueDePrimeraTransformacion = vidaInicial - vidaTrasAtaquePrimeraTransformacion;
			
			gohan.recibirDaño(450);
			
			piccolo.transformar(GuerrerosZ);
			piccolo.atacar(freezer, false);
			
			int vidaTrasAtaqueSegundaTransformacion = freezer.puntosDeVida();
			
			int dañoRealizadoConAtaqueDeSegundaTransformacion = vidaTrasAtaquePrimeraTransformacion - vidaTrasAtaqueSegundaTransformacion;
			
			Assert.assertTrue("El ataque cuando hizo la segunda transformacion saca mas que el ataque de la primera", (dañoRealizadoConAtaqueDeSegundaTransformacion > dañoRealizadoConAtaqueDePrimeraTransformacion));
		}		
		
}