package Modelo.Ataques;

import Modelo.Excepciones.ExcEsChocolate;
import Modelo.Excepciones.ExcNumeroNegativo;
import Modelo.Personajes.Personaje;

public class Ataque {

	private static Ataque Kamekameha;
	private static Ataque Makankosappo;
	private static Ataque Masenko;
	private static Ataque RayoMortal;
	private static Ataque AtaqueNormal;
	
	static{
		Kamekameha = new Ataque (20, 150);
		Makankosappo = new Ataque (10, 125);
		Masenko = new Ataque (10, 125);
		RayoMortal = new Ataque (20, 150);
		AtaqueNormal = new Ataque (0, 100);		
	}
	
	int costo;
	int modificadorDaño;
	
	public Ataque(){}
	
	public Ataque (int costo, int modificadorDaño) {
		this.costo = costo;
		this.modificadorDaño = modificadorDaño;		
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
	
	public void enviar(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) throws ExcEsChocolate, ExcNumeroNegativo{
		
		int dañoActual = calcularDaño(remitente, destinatario, bonificacionPorcentual);
		int dañoRecibido;
		dañoRecibido = destinatario.recibirDaño(dañoActual);
		this.efectosColaterales(remitente, destinatario, dañoRecibido);
	}
	
	protected int calcularDaño(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		
		int daño = remitente.poderDePelea() * modificadorDaño / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			daño = daño*8/10;
		}
		return (daño*(100+bonificacionPorcentual))/100;
		
	}
	
	public int costo() {
		return this.costo;
	}
	
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int dañoRealizado) throws ExcEsChocolate{		
	}
}
