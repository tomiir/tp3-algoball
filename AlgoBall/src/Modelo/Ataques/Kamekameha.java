package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Personajes.Personaje;

public class Kamekameha extends Ataque {
	
	public Kamekameha() {
		costo = 20;
	}

	@Override
	protected int dañoParcial() {
		return ((dañoBase*150)/100);
	
	}

	@Override
	protected void efectosColaterales(int dañoRealizado) {
	}
	
	
}
