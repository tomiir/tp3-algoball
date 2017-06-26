package Modelo;

import Modelo.Excepciones.ExcNumeroNegativo;

public class Vida {
	int vidaInicial;
	int vidaActual;
	
	public Vida(int vidaInicial){
		this.vidaInicial = vidaInicial;
		this.vidaActual = vidaInicial;
	}
	
	public int recibirDanio(int danioRecibido) throws ExcNumeroNegativo{
		if(danioRecibido < 0) throw new ExcNumeroNegativo();
		
		
		if(danioRecibido <= vidaActual) this.vidaActual -= danioRecibido;
		else{
			danioRecibido = vidaActual;
			vidaActual = 0;
		}
		return  danioRecibido;		
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
		float vidaPorcentual = ((float)vidaActual / (float)vidaInicial)*100;
		return (int) vidaPorcentual;
	}

	
}
