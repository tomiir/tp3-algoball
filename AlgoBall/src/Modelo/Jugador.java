package Modelo;

public class Jugador {
	
	String nombre;
	Equipo equipo;
	
	
	public Jugador(String nombreNuevo){
		this.nombre = nombreNuevo;
	}
	
	public void asignarEquipo(Equipo equipoNuevo){
		this.equipo = equipoNuevo;
	}
	
	public Equipo equipo(){
		return equipo;
	}
	
	public String nombre(){
		return nombre;
	}
}
