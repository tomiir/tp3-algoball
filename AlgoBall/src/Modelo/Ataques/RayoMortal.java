package Modelo.Ataques;

import Modelo.Personajes.Personaje;

public class RayoMortal extends Ataque {
	
	public RayoMortal (){
		costo = 20;
		modificadorDaño = 150;
	}
	

	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) {
	}
	
}
