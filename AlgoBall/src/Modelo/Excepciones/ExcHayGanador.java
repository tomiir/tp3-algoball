package Modelo.Excepciones;

import Modelo.Jugador;

public class ExcHayGanador extends Exception {
	Jugador jugador;
	public ExcHayGanador(Jugador jug){
		jugador=jug;
	}
}
