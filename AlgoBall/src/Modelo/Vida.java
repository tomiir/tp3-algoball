package Modelo;

import Modelo.Excepciones.ExcNumeroNegativo;

public class Vida {
	int vidaInicial;
	int vidaActual;
	
	public Vida(int vidaInicial){
		this.vidaInicial = vidaInicial;
		this.vidaActual = vidaInicial;
	}
	
	public int recibirDa�o(int da�oRecibido) throws ExcNumeroNegativo{
		if(da�oRecibido < 0) throw new ExcNumeroNegativo();
		
		
		if(da�oRecibido <= vidaActual) this.vidaActual -= da�oRecibido;
		else{
			da�oRecibido = vidaActual;
			vidaActual = 0;
		}		
		return  da�oRecibido;		
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
