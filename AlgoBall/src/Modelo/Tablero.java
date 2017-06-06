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
	
	public void posicionar(Posicionable posicionable, Posicion pos) throws ExcCasilleroOcupado, ExcFueraDeTablero{
		if(!coordenadasEstanEnRango(pos)) throw new ExcFueraDeTablero();
		Casillero casillero = casilleros[pos.posX()][pos.posY()];
		try{
			casillero.posicionar(posicionable);
		}	catch(ExcCasilleroOcupado e){
			throw e;
		}
		posicionable.posicionar(pos);
	}
	
	private boolean coordenadasEstanEnRango(Posicion pos) {
		return (pos.posX() >= 0 && pos.posX() < ancho && pos.posY() >= 0 && pos.posY() < alto);
	}
}