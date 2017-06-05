package Modelo;

public class Tablero {
	Casillero[][] casilleros;
	int ancho; 
	int alto;
	
	public Tablero(int altoDeseado,int anchoDeseado){
		ancho = anchoDeseado;
		alto = altoDeseado;
		casilleros = new Casillero[alto][ancho];
		
		for(int i=0;i<alto;i++){
			for(int j=0;j<ancho;j++){
				casilleros[i][j] = new Casillero(i,j);
			}
		}
	}
	
	public void posicionar(Posicionable posicionable, int posX, int posY) throws ExcCasilleroOcupado, ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(posX, posY)) throw new ExcFueraDeTablero();
		Casillero casillero = casilleros[posX][posY];
		posicionable.posicionar(this.obtenerCasillero(posX,posY));
	}
	
	public Casillero obtenerCasillero(int posX,int posY) throws ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(posX, posY)) throw new ExcFueraDeTablero();
		return casilleros[posX][posY];
	}
	
	private boolean coordenadasEstanEnRango(int posX, int posY) {
		return (posX >= 0 && posX < ancho && posY >= 0 && posY < alto);
	}
}