package Modelo.Ataques;

import Modelo.Personajes.Cell;
import Modelo.Personajes.Personaje;

public class Absorcion extends Ataque{
	Cell beneficiario;

	public Absorcion(Cell cell){
		beneficiario=cell;
		costo=5;
	}
	
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado){
		beneficiario.aumentarVidaPorAbsorcion(dañoRealizado);
	}

}