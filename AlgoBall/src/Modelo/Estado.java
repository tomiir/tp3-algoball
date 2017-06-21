package Modelo;

public class Estado {
	String nombre;
	int poderDePelea;
	int velocidad;
	int rangoDeAtaque;
	
	public Estado(String nombre, int poderDePelea, int rangoDeAtaque, int velocidad){
		this.nombre = nombre;
		this.poderDePelea = poderDePelea;
		this.velocidad = velocidad;
		this.rangoDeAtaque = rangoDeAtaque;		
	}

	public String getNombre() {
		return nombre;
	}

	public int getPoderDePelea() {
		return poderDePelea;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getRangoDeAtaque() {
		return rangoDeAtaque;
	}
}
