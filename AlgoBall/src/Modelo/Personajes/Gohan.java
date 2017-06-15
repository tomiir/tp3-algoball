package Modelo.Personajes;

import Modelo.Tablero;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.GohanSS2;
import Modelo.Transformaciones.TransformacionPorKi;

public class Gohan extends Personaje {

	public Gohan(Tablero tablero){
			
		nombre = "Gohan";
		puntosDeVida = 300;
		poderDePelea = 15;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueEspecial = Ataque.Masenko();
		this.tablero = tablero;
		
		TransformacionPorKi superSaiyan1 = new TransformacionPorKi("Super Saiyan 1", 10, 2,2,30 );
		GohanSS2 superSaiyan2 = new GohanSS2();
		
		transformaciones.add(superSaiyan1);
		transformaciones.add(superSaiyan2);
		

		inicializar();
	}
	
}
