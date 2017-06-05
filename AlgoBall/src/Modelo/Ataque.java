package Modelo;

public abstract class Ataque {
	
	public void enviar(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible{
		try{
			this.verificarCondiciones(remitente, destinatario);
			destinatario.recibirDaño(this.daño(destinatario));
		} catch(ExcAtaqueImposible e){
			throw e;
		}
	}
	
	protected abstract int costo();
	protected abstract int daño(Personaje destinatario);
	protected abstract void verificarCondiciones(Personaje remitente, Personaje destinatario) throws ExcAtaqueImposible;
}
