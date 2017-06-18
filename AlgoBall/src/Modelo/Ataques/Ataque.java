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
	protected int modificadorDaño=100;
	protected String nombre;
	
	public Ataque(){}
	
	public Ataque (int costo, int modificadorDaño, String nombre) {
		this.costo = costo;
		this.modificadorDaño = modificadorDaño;	
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
		
		int dañoActual = calcularDaño(remitente, destinatario, bonificacionPorcentual);
		int dañoRecibido;
		dañoRecibido = destinatario.recibirDaño(dañoActual);
		efectosColaterales(remitente, destinatario, dañoRecibido);
	}
	
	protected int calcularDaño(Personaje remitente, Atacable destinatario, int bonificacionPorcentual) {
		
		int daño = remitente.poderDePelea() * modificadorDaño / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			daño = daño*8/10;
		}
		return (daño*(100+bonificacionPorcentual))/100;
		
	}
	
	public int costo() {
		return this.costo;
	}
	
	public String nombre(){
		return nombre;
	}
	
	protected void efectosColaterales(Personaje remitente, Atacable destinatario, int dañoRealizado) throws ExcEsChocolate{		
	}
}
