package Modelo;

public class Casillero {
	Posicionable contenido;
	
	public Casillero(Posicionable cont){
		contenido=cont;
	}
	
	public Posicionable obtenerContenido(){
		return contenido;
	}


}

