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
	
	public int pos_x(){
		return pos_x;
	}
	
	public int pos_y(){
		return pos_y;
	}

	public int distanciaA(Casillero objetivo) {
		int resultado = (int) Math.sqrt(Math.pow(pos_x-objetivo.pos_x,2)+Math.pow(pos_y-objetivo.pos_y,2));
		return resultado;
	}

}

