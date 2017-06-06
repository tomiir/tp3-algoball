package Modelo;

import java.util.ArrayList;

import Modelo.Personajes.Personaje;

public class Juego {
	Tablero tablero;
	ArrayList<Personaje> guerrerosZ;
	ArrayList<Personaje> enemigosDeLaTierra;
	
	
	public Juego(int sizex, int sizey){
		tablero = new Tablero(sizex,sizey);
		guerrerosZ = new ArrayList<Personaje>();
		enemigosDeLaTierra = new ArrayList<Personaje>();

	}
	
	public void elegirPersonajes(){
		
		//mostrar mensaje
		
	}
	
	
	
	
}
