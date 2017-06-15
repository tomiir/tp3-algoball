package Modelo.Excepciones;

import Modelo.Jugador;

public class ExcHayGanador extends Exception {
	Jugador ganador;
	public ExcHayGanador(Jugador ganador){
		this.ganador = ganador;
	}
	
	public Jugador ganador(){
		return ganador;
	}
}
