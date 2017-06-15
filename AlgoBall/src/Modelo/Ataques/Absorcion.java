package Modelo.Ataques;

import Modelo.Personajes.Cell;

public class Absorcion extends Ataque{
	Cell beneficiario;

	public Absorcion(Cell cell){
		beneficiario=cell;
		costo=5;
	}

}