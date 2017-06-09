package Modelo.Ataques;

import Modelo.Excepciones.ExcAtaqueImposible;
import Modelo.Excepciones.ExcDañoNegativo;
import Modelo.Personajes.Cell;
import Modelo.Personajes.Personaje;

public class Absorcion extends Ataque{
	Cell beneficiario;

	public Absorcion(Cell cell){
		beneficiario=cell;
		costo=5;
	}
	
	@Override
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) {
		beneficiario.aumentarVidaPorAbsorcion(dañoRealizado);
	}

}