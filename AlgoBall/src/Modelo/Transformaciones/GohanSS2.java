package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Personajes.Personaje;

public class GohanSS2 extends Transformacion {
	protected boolean aux;
	
	public GohanSS2(){
		this.nombre = "Super Sayajin 2";
		this.rangoDeAtaque =4;
		this.costo = 30;
		this.velocidad = 3;
		this.poderDePelea = 100;
		
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		aux = (personaje.ki() >= this.costo);
				
		equipo.forEach((k,v)->{
			aux &=this.comprobarCondicion(personaje,v);
			});
		
		return aux;
	}
	
	public boolean comprobarCondicion(Personaje personaje, Personaje aliado){
		if(aliado.nombre() != personaje.nombre()){
			return (aliado.vidaPorcentual() <= 30);
		}
		return true;
	}


}
