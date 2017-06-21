package Vista.Interpretes;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Modelo.Personajes.Personaje;

public class InterpretePersonaje {
	JSONObject json;
	public InterpretePersonaje(Personaje personaje){
		String datos=personaje.representar();
		JSONParser parser = new JSONParser();
		try {
			json = (JSONObject) parser.parse(datos);
		} catch (ParseException e) {}
	}
	
	public int ki(){
		return (int) json.get("ki");
	}
	
	public int cantidadDeAbsorciones(){
		return (int) json.get("cantidad_de_absorciones");
	}

	public int poderDePelea(){
		return (int) json.get("poder_de_pelea");
	}
	
	public int rangoDeAtaque(){
		return (int) json.get("rango_de_ataque");
	}
	
	public int velocidad(){
		return (int) json.get("velocidad");
	}
	
	public int vidaPorcentual(){
		return (int) json.get("vida_porcentual");
	}
	
	public int vidaActual(){
		return (int) json.get("vida_actual");
	}
	
	public int vidaInicial(){
		return (int) json.get("vida_inicial");
	}
	
	public boolean esChocolate(){
		return (boolean) json.get("es_chocolate");
	}
	
	public String nombreAtaqueEspecial(){
		return (String) ataqueEspecialJSON().get("nombre");
	}
	
	public int costoAtaqueEspecial(){
		return (int) ataqueEspecialJSON().get("costo");
	}
	
	public boolean tieneTransformacion(){
		return (boolean) json.get("tiene_transformacion");
	}
	
	private JSONObject 
	
	private JSONObject ataqueEspecialJSON(){
		JSONParser parser = new JSONParser();
		try {
			JSONObject ataqueEspecialJSON = (JSONObject) parser.parse((String) json.get("ataque_especial"));
			return ataqueEspecialJSON;
		} catch (ParseException e) {}
		return null;
	}
}
