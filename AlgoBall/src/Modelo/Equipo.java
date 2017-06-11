package Modelo;

import java.util.HashMap;
import java.util.function.BiConsumer;

import Modelo.Personajes.Personaje;

public class Equipo{
	HashMap<String, Personaje> personajes;
	String nombre;
	
	public Equipo(String nombreNuevo){
		this.nombre = nombreNuevo;
		this.personajes = new HashMap<String,Personaje>();
	}
	

	public void agregarPersonaje(Personaje personaje){
		personajes.put(personaje.nombre(),personaje);
	}
	
	public int cantidadPersonajes(){
		return personajes.size();
	}
	
	public void forEach(BiConsumer<? super String, ? super Personaje> action){
		personajes.forEach(action);
	}
	
	public boolean personajePertenece(Personaje personaje){
		return personajes.containsKey(personaje.nombre());
	}
	
	public Personaje buscarPersonaje(String nombre){
		if(personajes.containsKey(nombre)) return personajes.get(nombre);
		return null;
	}

	public String nombre() {
		return this.nombre;
	}
	
}
