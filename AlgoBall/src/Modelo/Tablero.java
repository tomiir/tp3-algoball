package Modelo;

public class Tablero {
	Casillero[][] casilleros;
	
	public Tablero(int alto,int ancho){
		casilleros = new Casillero[alto][ancho];
		for(int i=0;i<alto;i++){
			for(int j=0;j<ancho;j++){
				casilleros[i][j] = new Casillero(i,j);
			}
		}
	}
	
	public void posicionar(Posicionable posicionable, int pos_x, int pos_y) throws ExcCasilleroOcupado{
		Casillero casillero = casilleros[pos_x][pos_y];
		try{
		    casillero.posicionar(posicionable);
		} catch(ExcCasilleroOcupado e){
			throw e;
		}
	}
}