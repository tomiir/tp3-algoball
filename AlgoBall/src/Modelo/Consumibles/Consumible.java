package Modelo.Consumibles;


public abstract class Consumible {
	
	
	int turnosRestantes;
	int bonificacionAtaque;
	int bonificacionVelocidad;
	int aumentoDeVida;
	String nombre;
	
	
	public int obtenerBonificacionAtaque() {
		return bonificacionAtaque;
	}

	public int obtenerBonificacionVelocidad() {	
		return bonificacionVelocidad;
	}
	
	public int obtenerAumentoDeVida(){
		return aumentoDeVida;
	}
	
	public int turnosRestantes(){
		return turnosRestantes;
	}
	
	public void avanzarTurno(){
		turnosRestantes--;
	}
	
	public String nombre(){
		return nombre;
	}
}
