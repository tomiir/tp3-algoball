package Modelo.Personajes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.json.simple.JSONObject;

import Modelo.Equipo;
import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Posicion;
import Modelo.Vida;
import Modelo.Interfaces.Atacable;
import Modelo.Estado;
import Modelo.Transformaciones.Transformacion;
import Modelo.Ataques.Ataque;
import Modelo.Consumibles.Consumible;
import Modelo.Excepciones.ExcFueraDeRango;
import Modelo.Excepciones.ExcFueraDeTablero;
import Modelo.Excepciones.ExcKiInsuficiente;
import Modelo.Excepciones.ExcNoEsPosibleTransformarse;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Excepciones.ExcPersonajeMurio;
import Modelo.Excepciones.ExcPosicionNegativa;

public class Personaje implements Atacable{
	
	String nombre;
	Vida vida;
	Estado estado;
	int ki = 0;
	int tiempoComoChocolate = -1;
	Ataque ataqueEspecial;
	Ataque ataqueNormal = Ataque.AtaqueNormal();
	Posicion posicion;
	Queue <Transformacion> transformaciones = new LinkedList<Transformacion>();
	ArrayList<Consumible> consumidos = new ArrayList<Consumible>();
	
	
	public int recibirDanio(int danioRecibido) throws ExcNumeroNegativo{
		return vida.recibirDanio(danioRecibido);
	}
	
	public void atacarNormal(Atacable personajeObjetivo) throws ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
		this.enviarAtaque(personajeObjetivo, ataqueNormal);
	}
	
	public void atacarEspecial(Atacable personajeObjetivo) throws ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
		this.enviarAtaque(personajeObjetivo, ataqueEspecial);
	}
	
	private void enviarAtaque(Atacable personajeObjetivo, Ataque ataque) throws ExcFueraDeRango, ExcKiInsuficiente, ExcPersonajeMurio, ExcEsChocolate, ExcNumeroNegativo{
		if(esChocolate()) throw new ExcEsChocolate();
		if(personajeObjetivo.estaMuerto()) throw new ExcPersonajeMurio();
		if(estaEnRango(personajeObjetivo.posicion(), this.estado.getRangoDeAtaque())){
			if(ki < ataque.costo()) throw new ExcKiInsuficiente();
			ataque.enviar(this, personajeObjetivo, this.bonificacionDeAtaquePorcentual() + this.bonificacionDeAtaquePorcentualPorConsumibles());
			ki -= ataque.costo();
		} else {
			throw new ExcFueraDeRango();
		}
	}
	
	public void seAvanzoUnTurno(int aumentoKi) throws ExcNumeroNegativo{
		if(aumentoKi<0) throw new ExcNumeroNegativo();
		if(tiempoComoChocolate >=0) tiempoComoChocolate--;
		if(!this.esChocolate())ki+=aumentoKi;
		this.actualizarConsumidos();
	}
	
	public boolean esChocolate (){
		return tiempoComoChocolate>=0;
	}
	
	public void setPosicion(Posicion casillero){
		this.posicion = casillero;
	}
	
	public int poderDePelea(){
		return estado.getPoderDePelea();
	}
	
	public int velocidadActual(){
		return this.estado.getVelocidad() + this.estado.getVelocidad()*this.multiplicadorDeVelocidadPorConsumibles();
	}
	
	public Posicion posicion(){
		return posicion;
	}
	
	public int ki(){
		return ki;
	}
	
	public String nombre() {
		return nombre;
	}
	
	public boolean estaMuerto(){
		if(vida.getVidaActual()==0) return true;
		return false;
	}
	
	public int cantidadDeAbsorciones(){
		return 0;
	}
	
	public void transformar (Equipo equipoPropio) throws ExcNoEsPosibleTransformarse, ExcEsChocolate {
		if(esChocolate()) throw new ExcEsChocolate();
		Transformacion transformacion = transformaciones.peek();
		if(transformacion!=null && transformacion.esPosible(this, equipoPropio)){
			transformaciones.remove();
			estado = transformacion.getNuevoEstado();
			ki -= transformacion.costo();
		} else {
			throw new ExcNoEsPosibleTransformarse();
		}
	}
	
	public void convertirEnChocolate(int turnos) throws ExcEsChocolate{
		if(this.esChocolate()) throw new ExcEsChocolate();
		tiempoComoChocolate = turnos;
	}
	
	protected int bonificacionDeAtaquePorcentual(){
		return 0;
	}

	private int bonificacionDeAtaquePorcentualPorConsumibles(){
		int bonificacionDeAtaquePorcentual = 0;
		
		if (this.consumidos.isEmpty() == false){
			Iterator<Consumible> iterador = consumidos.iterator();
			while(iterador.hasNext()){				
				Consumible consumible = iterador.next();
				bonificacionDeAtaquePorcentual += consumible.obtenerBonificacionAtaque();
			}			
		}
		
		return bonificacionDeAtaquePorcentual;
		
	}
	
	private int multiplicadorDeVelocidadPorConsumibles(){
		int bonificacion = 0;
		if (this.consumidos.isEmpty() == false){
			Iterator<Consumible> iterador = consumidos.iterator();
			while(iterador.hasNext()){				
				Consumible consumible = iterador.next();
				bonificacion += consumible.obtenerBonificacionVelocidad();
			}			
		}
		
		return bonificacion;
	}
	
	public int vidaPorcentual(){
		return vida.vidaPorcentual();
	}
	
	
	public boolean estaEnRango (Posicion objetivo, int rango){
		try{
			if(this.posicion.distanciaA(objetivo) > rango){
				return false;
			}
		} catch (ExcPosicionNegativa e) {
			return false;
		}
		return true;
	}
	
	public int puntosDeVida(){
		return vida.getVidaActual();
	}
	
	public boolean sePuedeTransformar(Equipo miEquipo){
		if(transformaciones.peek()!=null) return transformaciones.peek().esPosible(this, miEquipo);
		return false;
	}

	
	public void consumir(Consumible consumible, Posicion posicion) throws ExcFueraDeTablero{
		
		int vida = consumible.obtenerAumentoDeVida();
		this.vida.aumentar(vida);
	
		if(consumible.turnosRestantes() > 0) consumidos.add(consumible);		
		
	}
	
	private void actualizarConsumidos(){
		Iterator<Consumible> iterador = consumidos.iterator();
		ArrayList<Consumible> eliminables = new ArrayList<Consumible>();
		while(iterador.hasNext()){
			
			Consumible consumible = iterador.next();
			if(consumible.turnosRestantes() <= 0) eliminables.add(consumible);
			consumible.avanzarTurno();
			
			
		}
		
		Iterator<Consumible> iterador2 = eliminables.iterator();
		
		while(iterador2.hasNext()){					
		Consumible consumible = iterador2.next();
		consumidos.remove(consumible);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public String representar(){
		JSONObject personajeJSON = new JSONObject();
		personajeJSON.put("nombre", this.nombre);
		personajeJSON.put("estado", estado.getNombre());
		personajeJSON.put("poder_de_pelea", estado.getPoderDePelea());
		personajeJSON.put("rango_de_ataque", estado.getRangoDeAtaque());
		personajeJSON.put("velocidad", estado.getVelocidad());
		personajeJSON.put("ki", ki);
		personajeJSON.put("cantidad_de_absorciones", cantidadDeAbsorciones());
		personajeJSON.put("es_chocolate", esChocolate());
		personajeJSON.put("esta_muerto", estaMuerto());
		personajeJSON.put("vida_actual", this.vida.getVidaActual());
		personajeJSON.put("vida_inicial", this.vida.getVidaInicial());
		personajeJSON.put("vida_porcentual", this.vida.vidaPorcentual());
		personajeJSON.put("bonificacion_ataque_por_consumibles", this.bonificacionDeAtaquePorcentualPorConsumibles());
		personajeJSON.put("bonificacion_ataque_porcentual", this.bonificacionDeAtaquePorcentual());
		personajeJSON.put("multiplicador_velocidad_consumibles", this.multiplicadorDeVelocidadPorConsumibles());
		
		JSONObject ataqueEspecialJSON = new JSONObject();
		ataqueEspecialJSON.put("nombre", this.ataqueEspecial.nombre());
		ataqueEspecialJSON.put("costo", this.ataqueEspecial.costo());
		
		personajeJSON.put("ataque_especial", ataqueEspecialJSON.toJSONString());
		
		if(transformaciones.peek() == null){
			personajeJSON.put("tiene_transformacion", false);
		} else {
			personajeJSON.put("tiene_transformacion", true);
			
			JSONObject transformacionJSON = new JSONObject();
			transformacionJSON.put("nombre", transformaciones.peek().getNuevoEstado().getNombre());
			transformacionJSON.put("costo", transformaciones.peek().costo());
			
			personajeJSON.put("siguiente_transformacion", transformacionJSON.toJSONString());
		}
		
		return personajeJSON.toJSONString();
	}
}
