package Modelo;

public class Freezer extends Personaje {
	
	public Freezer(Tablero mundo){
		
		nombre = "Freezer";
		puntosDeVida = 400;
		rangoDeAtaque = 3;
		velocidad = 4;
		ataqueNormal = new AtaqueNormal(20);
		ataqueEspecial = null;
		tablero = mundo;
		
		TransformacionPorKi segundaForma = new TransformacionPorKi("Segunda Forma", 20, 3,4,40 );
		
		transformaciones.add(segundaForma);
	}

}
