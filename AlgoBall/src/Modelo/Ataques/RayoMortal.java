package Modelo.Ataques;

import Modelo.Personajes.Personaje;

public class RayoMortal extends Ataque {
	
	public RayoMortal (){
		costo = 20;
		modificadorDa�o = 150;
	}
	

	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int da�oRealizado) {
	}
	
}
