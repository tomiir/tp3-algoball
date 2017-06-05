package Modelo;

public abstract class Transformacion {

	public abstract boolean esPosible(Personaje personaje);
	public abstract int getRangoDeAtaque();
	public abstract int getVelocidad();
	public abstract AtaqueNormal transformarAtaqueNormal(AtaqueNormal ataque);
	
}
