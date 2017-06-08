package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class RayoMortal extends Ataque {
	
	public RayoMortal (){
		costo = 10;
	}
	
	protected int dañoParcial() {
		return ((dañoBase*150)/100);	
	}

	@Override
	protected void efectosColaterales(int dañoRealizado) {
	}
	
}
