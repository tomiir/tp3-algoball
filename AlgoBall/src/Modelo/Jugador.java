package Modelo;

import Modelo.Excepciones.ExcCasilleroOcupado;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Interfaces.Atacable;
import Modelo.Personajes.Personaje;

public class Jugador {
	
	protected String nombre;
	protected Equipo equipo;
	protected boolean yaAtaco=false;
	protected boolean yaTransformo=false;
	protected boolean yaMovio=false;
	protected Tablero tablero;
	
	
	public Jugador(String nombreNuevo, Tablero tablero){
		this.nombre = nombreNuevo;
		this.tablero = tablero;
	}
	
	public void asignarEquipo(Equipo equipoNuevo){
		this.equipo = equipoNuevo;
	}
	
	public void realizarAtaqueNormal(Personaje remitente, Atacable destinatario) throws ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo{
		remitente.atacarNormal(destinatario);
		this.yaAtaco = true;
		tablero.removerSiEstaMuerto(destinatario);
	}
	
	public void realizarAtaqueEspecial(Personaje remitente, Atacable destinatario) throws ExcFueraDeRango, ExcFueraDeTablero, ExcPersonajeMurio, ExcKiInsuficiente, ExcEsChocolate, ExcNumeroNegativo{
		remitente.atacarEspecial(destinatario);
		this.yaAtaco=true;
		tablero.removerSiEstaMuerto(destinatario);
	}
	
	public void realizarMovimiento(Personaje personaje, Posicion posicion) throws ExcFueraDeTablero, ExcEsChocolate, ExcCasilleroOcupado, ExcCasilleroOcupado, ExcFueraDeRango{
		
		tablero.moverPersonaje(personaje,posicion);
		this.yaMovio = true;
			
	}
	
	public void realizarTransformacion(Personaje personaje) throws ExcNoEsPosibleTransformarse, ExcEsChocolate{
		personaje.transformar(equipo);
		this.yaTransformo=true;
	}
	
	public void pasarTurno(){
		this.yaMovio = false;
		this.yaAtaco = false;
		this.yaTransformo = false;
		equipo().forEach(pers->{
			try {
				pers.seAvanzoUnTurno(5);
			} catch (ExcNumeroNegativo e) {	}	
		});
	}
	
	
	public Equipo equipo(){
		return equipo;
	}
	
	
	public String nombre(){
		return nombre;
	}
	
	public boolean realizoMovimiento(){
		return yaMovio;
	}
	
	public boolean realizoAtaque(){
		return yaAtaco;
	}
	
	public boolean realizoTransformacion(){
		return yaTransformo;
	}
}
