package Modelo;

public abstract class Ataque {
	
	Juego juego;
	
	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
			destinatario.recibirDa�o(this.da�o(destinatario));
		} catch(ExcAtaqueImposible e){
			throw e;
		}
	}
	
	public abstract void lastimar(Personaje destinatario);
	protected abstract int costo();
	protected abstract int da�o(Personaje destinatario);
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
