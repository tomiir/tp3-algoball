package Modelo;

public abstract class Ataque {
	
	Juego juego;
	
	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
			destinatario.recibirDaño(this.daño(destinatario));
		} catch(ExcAtaqueImposible e){
			throw e;
		}
	}
	
	public abstract void lastimar(Personaje destinatario);
	protected abstract int costo();
	protected abstract int daño(Personaje destinatario);
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
