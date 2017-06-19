package Modelo.Excepciones;

@SuppressWarnings("serial")
public class ExcAtaqueImposible extends Exception {
	String razon;
	public ExcAtaqueImposible(String str){
		razon=str;
	}
}
