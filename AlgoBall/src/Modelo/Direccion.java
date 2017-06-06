package Modelo;

public class Direccion {	
	int dx;
	int dy;
	
	public Direccion(int x, int y) throws ExcDireccionInvalida{
		if(x>1 || x<-1 || y>1 || y<-1) throw new ExcDireccionInvalida();
		this.dx = x;
		this.dy =y;
	}
	
	public int dx(){
		return dx;
	}
	
	public int dy(){
		return dy;
	}
}




