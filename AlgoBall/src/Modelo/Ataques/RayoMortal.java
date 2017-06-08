package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class RayoMortal extends Ataque {
	
	public RayoMortal (){
		costo = 10;
		modificadorDaño = 150;
	}
	

	@Override
	protected void efectosColaterales(int dañoRealizado) {
	}
	
}
