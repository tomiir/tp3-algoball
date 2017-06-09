package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDa�oNegativo;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Personaje;

public class Absorcion extends Ataque{
	Cell beneficiario;

	public Absorcion(Cell cell){
		beneficiario=cell;
		costo=5;
	}
	
	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int da�oRealizado) {
		beneficiario.aumentarVidaPorAbsorcion(da�oRealizado);
	}

}