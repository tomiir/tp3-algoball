package Modelo;

public class Cell extends Personaje {
	
	public Cell(Tablero mundo){
		
		nombre = "Cell";
		puntosDeVida = 500;
		rangoDeAtaque = 3;
		velocidad = 2;
		ataqueNormal = new AtaqueNormal(20);
		ataqueEspecial = null;
		tablero = mundo;
		
		//Transformacion especial no implementado
	}

}
