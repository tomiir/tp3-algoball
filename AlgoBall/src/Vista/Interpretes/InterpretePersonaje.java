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
	
	public String nombre(){
		return (String) json.get("nombre");
	}
	
	public String estado(){
		return (String) json.get("estado");
	}
	
	public boolean estaMuerto(){
		return (boolean) json.get("esta_muerto");
	}
	
	public long ki(){
		return (long) json.get("ki");
	}
	
	public long cantidadDeAbsorciones(){
		return (long) json.get("cantidad_de_absorciones");
	}

	public long poderDePelea(){
		return (long) json.get("poder_de_pelea");
	}
	
	public long rangoDeAtaque(){
		return (long) json.get("rango_de_ataque");
	}
	
	public long velocidad(){
		return (long) json.get("velocidad");
	}
	
	public long vidaPorcentual(){
		return (long) json.get("vida_porcentual");
	}
	
	public long vidaActual(){
		return (long) json.get("vida_actual");
	}
	
	public long vidaInicial(){
		return (long) json.get("vida_inicial");
	}
	
	public boolean esChocolate(){
		return (boolean) json.get("es_chocolate");
	}
	
	public String nombreAtaqueEspecial(){
		return (String) ataqueEspecialJSON().get("nombre");
	}
	
	public long costoAtaqueEspecial(){
		return (long) ataqueEspecialJSON().get("costo");
	}
	
	public boolean tieneTransformacion(){
		return (boolean) json.get("tiene_transformacion");
	}
	
	public long costoTransformar(){
		return (long) siguienteTransformacion().get("costo");
	}
	
	public String nombreTransformacion(){
		return (String) siguienteTransformacion().get("nombre");
	}
	
	public long bonificacionDeAtaquePorcentualPorConsumibles(){
		return (long) json.get("bonificacion_ataque_por_consumibles");
	}
	
	public long bonificacionDeAtaquePorcentual(){
		return (long) json.get("bonificacion_ataque_porcentual");
	}
	
	public long multiplicadorDeVelocidadPorConsumibles(){
		return (long) json.get("multiplicador_velocidad_consumibles");
	}
	
	private JSONObject siguienteTransformacion(){
		JSONParser parser = new JSONParser();
		try {
			JSONObject transformacionJSON = (JSONObject) parser.parse((String) json.get("siguiente_transformacion"));
			return transformacionJSON;
		} catch (ParseException e) {}
		return null;
	}
	
	private JSONObject ataqueEspecialJSON(){
		JSONParser parser = new JSONParser();
		try {
			JSONObject ataqueEspecialJSON = (JSONObject) parser.parse((String) json.get("ataque_especial"));
			return ataqueEspecialJSON;
		} catch (ParseException e) {}
		return null;
	}
}
