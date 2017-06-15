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
	int modificadorDa�o;
	
	public Ataque(){}
	
	public Ataque (int costo, int modificadorDa�o) {
		this.costo = costo;
		this.modificadorDa�o = modificadorDa�o;		
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
		
		int da�oActual = calcularDa�o(remitente, destinatario, bonificacionPorcentual);
		int da�oRecibido;
		da�oRecibido = destinatario.recibirDa�o(da�oActual);
		this.efectosColaterales(remitente, destinatario, da�oRecibido);
	}
	
	protected int calcularDa�o(Personaje remitente, Personaje destinatario, int bonificacionPorcentual) {
		
		int da�o = remitente.poderDePelea() * modificadorDa�o / 100;
		
		if(remitente.poderDePelea()<destinatario.poderDePelea()){
			da�o = da�o*8/10;
		}
		return (da�o*(100+bonificacionPorcentual))/100;
		
	}
	
	public int costo() {
		return this.costo;
	}
	
	protected void efectosColaterales(Personaje remitente, Personaje destinatario, int da�oRealizado) throws ExcEsChocolate{		
	}
}
