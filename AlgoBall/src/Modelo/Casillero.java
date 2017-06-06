package Modelo;

public class Casillero {
	Posicionable contenido=null;
	
	public Casillero(Posicionable cont){
		contenido=cont;
	}
	
	public Posicionable obtenerContenido(){
		return contenido;
	}
}

