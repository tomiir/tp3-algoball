package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class Masenko extends Ataque {
	
	public Masenko (){
		costo = 10;
		modificadorDa�o = 125;
	}

	@Override
	protected void efectosColaterales(int da�oRealizado) {
	}
	
}
