package Modelo.Personajes;


import Modelo.Tablero;

public class PersonajeFactory {

	
	Tablero tablero;
	
	public PersonajeFactory(){
		 
	
	}
	
	public Personaje getPersonaje(String nombre){
		
		Personaje personaje = null;
	
		if(nombre.equalsIgnoreCase("goku")) personaje = new Goku();
		else if(nombre.equalsIgnoreCase("gohan")) personaje =  new Gohan();
		else if(nombre.equalsIgnoreCase("piccolo")) personaje = new Piccolo();
		
		else if(nombre.equalsIgnoreCase("freezer")) personaje = new Freezer();
		else if(nombre.equalsIgnoreCase("cell"))  personaje = new Cell();
		else if(nombre.equalsIgnoreCase("majinboo"))  personaje = new MajinBoo();
		
		return personaje;
		
		}
}


