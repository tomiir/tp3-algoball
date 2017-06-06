package Modelo;

public class PersonajeDePrueba extends Personaje {
	
	
	public PersonajeDePrueba(Tablero mundo, String Inombre, int IpuntosDeVida, int IrangoDeAtaque, int Ivelocidad){
		
		nombre = Inombre;
		puntosDeVida = IpuntosDeVida;
		rangoDeAtaque = IrangoDeAtaque;
		velocidad = Ivelocidad;
		tablero = mundo;
		
	}
	
	

}