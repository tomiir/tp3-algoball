package Modelo;

import java.util.HashMap;
import java.util.function.BiConsumer;

import Modelo.Excepciones.ExcNoHayPersonaje;
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
	
	public Personaje obtenerPersonaje(String nombre) throws ExcNoHayPersonaje{
		if(personajes.containsKey(nombre)){
			return personajes.get(nombre);
		} else {
			throw new ExcNoHayPersonaje();
		}
	}

	public String nombre() {
		return this.nombre;
	}
	
}
