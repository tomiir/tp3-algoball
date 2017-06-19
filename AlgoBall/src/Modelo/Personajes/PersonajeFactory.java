package Modelo.Personajes;


import Modelo.Tablero;

public class PersonajeFactory {

	
	Tablero tablero;
	
	public PersonajeFactory(Tablero tablero){
		 
		this.tablero = tablero;
	}
	
	public Personaje getPersonaje(String nombre){
		
		Personaje personaje = null;
	
		if(nombre.equalsIgnoreCase("goku")) personaje = new Goku(tablero);
		else if(nombre.equalsIgnoreCase("gohan")) personaje =  new Gohan(tablero);
		else if(nombre.equalsIgnoreCase("piccolo")) personaje = new Piccolo(tablero);
		
		else if(nombre.equalsIgnoreCase("freezer")) personaje = new Freezer(tablero);
		else if(nombre.equalsIgnoreCase("cell"))  personaje = new Cell(tablero);
		else if(nombre.equalsIgnoreCase("majinboo"))  personaje = new MajinBoo(tablero);
		
		return personaje;
		
		}
}


