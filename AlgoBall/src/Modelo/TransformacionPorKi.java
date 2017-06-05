package Modelo;

public class TransformacionPorKi extends Transformacion {
	int ki;
	int rangoDeAtaque;
	int velocidad;
	int dañoAtaqueNormal;
	
	public TransformacionPorKi(String str, int costo, int rango, int velocida, int daño){
		nombre=str;
		ki=costo;
		rangoDeAtaque=rango;
		velocidad=velocida;
		dañoAtaqueNormal=daño;
	}
	
	@Override
	public boolean esPosible(Personaje personaje) {
		return (personaje.ki()>=ki);
	}

	@Override
	public int rangoDeAtaque() {
		return rangoDeAtaque;
	}

	@Override
	public int velocidad() {
		return velocidad;
	}

	@Override
	public AtaqueNormal ataqueNormal() {
		return new AtaqueNormal(dañoAtaqueNormal);
	}

}
