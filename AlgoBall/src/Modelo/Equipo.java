package Modelo;

import java.util.ArrayList;

import Modelo.Personajes.Personaje;

public class Equipo {
	
	ArrayList<Personaje> personajes;
	String nombre;
	
	public Equipo(String nombreNuevo){
		this.nombre = nombreNuevo;
		this.personajes = new ArrayList<Personaje>();
	}
	

	public void agregarPersonaje(Personaje personaje){
		personajes.add(personaje);
	}

}
