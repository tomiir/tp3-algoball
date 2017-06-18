package ModeloTests.Entregas.Segunda;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Equipo;
import Modelo.Posicion;
import Modelo.Tablero;
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
import Modelo.Personajes.Gohan;
import Modelo.Personajes.MajinBoo;
	
	public class test08 {
		
		Tablero tablero = new Tablero(15, 15);
		Equipo EnemigosDeLaTierra = new Equipo("EnemigosDeLaTierra");
		MajinBoo majinBoo = new MajinBoo(tablero);
		
		@Test
		public void MajinBooConvierteEnChocolateYRivalNoGanaKi () throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate{
			Gohan gohan = new Gohan(tablero);
			tablero.posicionarPersonaje(gohan, new Posicion(5, 6));
			tablero.posicionarPersonaje(majinBoo, new Posicion(5, 5));
			
			majinBoo.seAvanzoUnTurno(30);
			
			int puntosKiGohanIniciales = gohan.ki();
			
			majinBoo.atacar(gohan, true);
			
			gohan.seAvanzoUnTurno(10);
			
			int puntosKiGohanFinales = gohan.ki();
			
			Assert.assertEquals("Gohan no gana puntos de ki cuando es chocolate", puntosKiGohanIniciales, puntosKiGohanFinales);			
		}
		
		@Test (expected = ExcEsChocolate.class)
		public void MajinBooConvierteEnChocolateYRivalNoPuedeAtacar() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
			Gohan gohan = new Gohan(tablero);
			tablero.posicionarPersonaje(gohan, new Posicion(5, 6));
			tablero.posicionarPersonaje(majinBoo, new Posicion(5, 5));
			
			majinBoo.seAvanzoUnTurno(30);
			
			majinBoo.atacar(gohan, true);
			
			gohan.atacar(majinBoo, false);
		}
		
		@Test (expected = ExcEsChocolate.class)
		public void MajinBooConvierteEnChocolateYRivalNoPuedeMover() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo, ExcCasilleroDesocupado{
			Gohan gohan = new Gohan(tablero);
			tablero.posicionarPersonaje(gohan, new Posicion(5, 6));
			tablero.posicionarPersonaje(majinBoo, new Posicion(5, 5));
			
			majinBoo.seAvanzoUnTurno(30);
			
			majinBoo.atacar(gohan, true);
			
			gohan.mover(new Posicion(5, 4));
		}
		
		@Test (expected = ExcEsChocolate.class)
		public void MajinBooConvierteEnChocolateYRivalNoPuedeTransformar() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo, ExcNoEsPosibleTransformarse{
			Gohan gohan = new Gohan(tablero);
			Equipo GuerrerosZ = new Equipo("GuerrerosZ");
			GuerrerosZ.agregarPersonaje(gohan);
			tablero.posicionarPersonaje(gohan, new Posicion(5, 6));
			tablero.posicionarPersonaje(majinBoo, new Posicion(5, 5));
			
			majinBoo.seAvanzoUnTurno(30);
			
			majinBoo.atacar(gohan, true);
			
			gohan.seAvanzoUnTurno(50);
			gohan.transformar(GuerrerosZ);
		}
		
		@Test
		public void MajinBooConvierteEnChocolateYLuegoDeTresTurnosSeVa() throws ExcFueraDeTablero, ExcCasilleroOcupado, ExcPosicionNegativa, ExcNumeroNegativo, ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNoEsPosibleTransformarse, ExcCasilleroDesocupado{
			Gohan gohan = new Gohan(tablero);
			Equipo GuerrerosZ = new Equipo("GuerrerosZ");
			GuerrerosZ.agregarPersonaje(gohan);
			tablero.posicionarPersonaje(gohan, new Posicion(5, 6));
			tablero.posicionarPersonaje(majinBoo, new Posicion(5, 5));
			
			gohan.seAvanzoUnTurno(30);
			majinBoo.seAvanzoUnTurno(30);
			
			majinBoo.atacar(gohan, true);
			
			gohan.seAvanzoUnTurno(0);
			gohan.seAvanzoUnTurno(0);
			gohan.seAvanzoUnTurno(0);
			
			gohan.atacar(majinBoo, false);
			gohan.transformar(GuerrerosZ);
			gohan.mover(new Posicion(5, 4));
			
			//hago un assert de una sola, pero ya se que las otras se puede hacer ya que no tiro excepcion
			
			Assert.assertEquals(gohan.posicion().posX(), 5);
			Assert.assertEquals(gohan.posicion().posY(), 4);
			
		}
		
}

