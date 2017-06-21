package Modelo;

import Modelo.Excepciones.ExcNumeroNegativo;

public class Vida {
	int vidaInicial;
	int vidaActual;
	
	public Vida(int vidaInicial){
		this.vidaInicial = vidaInicial;
		this.vidaActual = vidaInicial;
	}
	
	public int recibirDaño(int dañoRecibido) throws ExcNumeroNegativo{
		if(dañoRecibido < 0) throw new ExcNumeroNegativo();
		
		
		if(dañoRecibido <= vidaActual) this.vidaActual -= dañoRecibido;
		else{
			dañoRecibido = vidaActual;
			vidaActual = 0;
		}		
		return  dañoRecibido;		
	}
	
	public void aumentar (int vida){
		if(vidaActual + vida > vidaInicial) vidaActual = vidaInicial;
		else vidaActual += vida;
	}

	public int getVidaInicial() {
		return vidaInicial;
	}

	public int getVidaActual() {
		return vidaActual;
	}
	
	public int vidaPorcentual(){
		float vidaPorcentual = (vidaActual / vidaInicial)*100;
		return (int)vidaPorcentual;
	}

	
}
