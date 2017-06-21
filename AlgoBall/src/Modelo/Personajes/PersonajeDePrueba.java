package Modelo.Personajes;

import Modelo.Estado;
import Modelo.Posicion;
import Modelo.Vida;
import Modelo.Ataques.Ataque;
import Modelo.Transformaciones.Transformacion;

public class PersonajeDePrueba extends Personaje {
	
	int cantidadAbsorciones;
	public PersonajeDePrueba(String nombre, int puntosDeVida, int rangoDeAtaque, int velocidad, int poderDePelea){
		
		this.nombre = nombre;
		vida = new Vida(puntosDeVida);
		estado = new Estado("Normal", poderDePelea, rangoDeAtaque, velocidad);
		ataqueEspecial = null;
	}

	public Posicion posicion(){
		return posicion;
	}
	
	public void setAtaqueEspecial (Ataque ataque){
		this.ataqueEspecial = ataque;
	}
	
	public void agregarTransformacion(Transformacion trans){
		transformaciones.add(trans);
	}
	
	public void setKi(int nuevo){
		ki=nuevo;
	}
	
	public void setAbsorciones(int num){
		cantidadAbsorciones=num;
	}
	
	public int cantidadDeAbsorciones(){
		return cantidadAbsorciones;
	}
}