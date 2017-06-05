package Modelo;


public class Goku extends Personaje {
	
	
	public Goku(Casillero posinicial, Tablero mundo){
		
		nombre = "Goku";
		puntosDeVida = 500;
		rangoDeAtaque = 2;
		velocidad = 2;
		ataqueNormal = new AtaqueNormal(20);
		ataqueEspecial = null;
		posicion = posinicial;
		tablero = mundo;
		
	}
	
	

}
