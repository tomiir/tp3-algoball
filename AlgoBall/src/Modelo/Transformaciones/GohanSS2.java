package Modelo.Transformaciones;

import Modelo.Equipo;
import Modelo.Estado;
import Modelo.Personajes.Personaje;

public class GohanSS2 extends Transformacion {
	protected boolean aux;
	
	public GohanSS2(){
		this.nombre = "Super Sayajin 2";
		this.costo = 30;
		this.estado = new Estado("Super Sayajin 2", 100, 4, 3);
		
	}
	
	@Override
	public boolean esPosible(Personaje personaje, Equipo equipo) {
		aux = (personaje.ki() >= this.costo);
				
		equipo.forEach(pers->{
			aux &=this.comprobarCondicion(personaje,pers);
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
