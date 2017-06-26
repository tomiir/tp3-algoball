package Modelo.Ataques;

import Modelo.Interfaces.Atacable;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Personaje;

public class Absorcion extends Ataque{
	protected Cell beneficiario;

	public Absorcion(Cell cell){
		beneficiario=cell;
		costo=5;
		nombre = "Absorcion";
	}
	
	protected void efectosColaterales(Personaje remitente, Atacable destinatario, int danioRealizado){
		beneficiario.aumentarVidaPorAbsorcion(danioRealizado);
	}

}