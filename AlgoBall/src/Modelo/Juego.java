package Modelo;

import java.util.ArrayList;

public class Juego {
	Tablero tablero;
	ArrayList<Personaje> personajes;
	
	public Juego(int sizex, int sizey){
		tablero = new Tablero(sizex,sizey);
		personajes = new ArrayList<Personaje>();
	}
	
}
