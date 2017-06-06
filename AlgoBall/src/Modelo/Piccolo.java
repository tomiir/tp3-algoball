package Modelo;

public class Piccolo extends Personaje {
	
	public Piccolo(Tablero mundo){
		
		nombre = "Piccolo";
		puntosDeVida = 500;
		rangoDeAtaque = 2;
		velocidad = 3;
		ataqueNormal = new AtaqueNormal(20);
		ataqueEspecial = null;
		tablero = mundo;
		
		TransformacionPorKi fortalecido = new TransformacionPorKi("Fortalecido", 20, 4,3,40 );
		
		transformaciones.add(fortalecido);
	}

}
