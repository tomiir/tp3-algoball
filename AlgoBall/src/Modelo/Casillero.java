package Modelo;

public class Casillero {
	int pos_x;
	int pos_y;
	Posicionable contenido;
	
	public Casillero(int x, int y){
		this.pos_x = x;
		this.pos_y = y;
	}
	
	public boolean estaOcupado(){
		if(contenido==null) return false;
		return true;
	}
	
	public void desocupar(){
		contenido=null;
	}
	
	public Posicionable obtenerContenido(){
		return contenido;
	}
	
	public void posicionar(Posicionable posicionable) throws ExcCasilleroOcupado{
		if(this.estaOcupado()) throw new ExcCasilleroOcupado();
		this.contenido = posicionable;
	}

}

