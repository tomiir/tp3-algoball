package Modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.function.Consumer;

import Modelo.Excepciones.ExcNoHayPersonaje;
import Modelo.Personajes.Personaje;

public class Equipo{
	protected HashMap<String, Personaje> personajes;
	protected String nombre;
	
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
	
	public void forEach(Consumer<? super Personaje> action){
		personajes.values().forEach(action);
	}
	
	public boolean personajePertenece(String nombre){
		return personajes.containsKey(nombre);
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
	
	public boolean perdio(){
		LinkedList<Personaje> listaEquipo = new LinkedList<Personaje>();
		personajes.forEach((nombre,personaje)->listaEquipo.addLast(personaje));
		Iterator<Personaje> iter = listaEquipo.iterator();
		
		while(iter.hasNext()){
			Personaje personaje = iter.next();
			if (!personaje.estaMuerto()) return false;
		}
		return true;
	}
	
}
