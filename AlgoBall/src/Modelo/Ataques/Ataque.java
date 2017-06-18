package Modelo.Ataques;

import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Interfaces.Atacable;
import Modelo.Personajes.Personaje;

public class Ataque {

	private static Ataque Kamekameha;
	private static Ataque Makankosappo;
	private static Ataque Masenko;
	private static Ataque RayoMortal;
	private static Ataque AtaqueNormal;
	
	static{
		Kamekameha = new Ataque (20, 150,"Kamehameha");
		Makankosappo = new Ataque (10, 125, "Makankosappo");
		Masenko = new Ataque (10, 125, "Masenko");
		RayoMortal = new Ataque (20, 150, "Rayo Mortal");
		AtaqueNormal = new Ataque (0, 100, "Ataque Normal");		
	}
	
	protected int costo;
	protected int modificadorDa�o=100;
	protected String nombre;
	
	public Ataque(){}
	
	public Ataque (int costo, int modificadorDa�o, String nombre) {
		this.costo = costo;
		this.modificadorDa�o = modificadorDa�o;	
		this.nombre = nombre;
	}
	
	public static Ataque Makankosappo(){
		return Makankosappo;
	}
	
	public static Ataque Masenko(){
		return Masenko;
	}
	
	public static Ataque RayoMortal(){
		return RayoMortal;
	}
	
	public static Ataque AtaqueNormal(){
		return AtaqueNormal;
	}
	
	public static Ataque Kamekameha(){
		return Kamekameha;
	}
	
	public void enviar(Personaje remitente, Atacable destinatario, int bonificacionPorcentual) throws ExcEsChocolate, ExcNumeroNegativo{
		
		int da�oActual = calcularDa�o(remitente, destinatario, bonificacionPorcentual);
		int da�oRecibido;
		da�oRecibido = destinatario.recibirDa�o(da�oActual);
		efectosColaterales(remitente, destinatario, da�oRecibido);
	}
	
	protected int calcularDa�o(Personaje remitente, Atacable destinatario, int bonificacionPorcentual) {
		
		int da�o = remitente.poderDePelea() * modificadorDa�o / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			da�o = da�o*8/10;
		}
		return (da�o*(100+bonificacionPorcentual))/100;
		
	}
	
	public int costo() {
		return this.costo;
	}
	
	public String nombre(){
		return nombre;
	}
	
	protected void efectosColaterales(Personaje remitente, Atacable destinatario, int da�oRealizado) throws ExcEsChocolate{		
	}
}
