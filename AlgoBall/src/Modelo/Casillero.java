package Modelo;

public class Casillero {
	int pos_x;
	int pos_y;
	Posicionable contenido;
	
	public Casillero(int x, int y){
		
		this.pos_x = x;
		this.pos_y = y;
		
	}
	
	public Posicionable obtenerContenido(){
		
		return contenido;
	}
	
	public void posicionar(Posicionable posicionable){
		this.contenido = posicionable;
	}

}

