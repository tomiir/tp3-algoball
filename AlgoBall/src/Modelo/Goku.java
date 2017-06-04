package Modelo;


public class Goku extends Personaje {
	
	
	public Goku(){
		
		this.nombre = "Goku";
		this.puntosDeVida = 500;
		this.rangoDeAtaque = 2;
		this.velocidad = 2;
		this.poderDePelea = 20;
		this.ataqueNormal = new AtaqueNormal(poderDePelea);
		this.ataqueEspecial = new Kamehameha(20);
		this.ki = super.ki;
		
		
	}
	
	
	@Override
	public void atacar(Personaje personajeObjetivo, Ataque ataqueElegido) {
		// TODO Auto-generated method stub

	}
	
	

}
