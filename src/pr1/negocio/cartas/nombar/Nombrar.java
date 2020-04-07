package pr1.negocio.cartas.nombar;

import poker.negocio.dtos.cartas.Carta;
/**
 * Obtiene el nombre de la imagen que representa la carta
 * @author victor
 *
 */
public abstract class Nombrar
{

	
	private static Nombrar inst;
	
	public static Nombrar getInstancia()
	{
		if(inst==null) inst = new NombrarCartasDibujo();
						//inst = new NombrarCartasDibujo();
		return inst;
		
	}
	
	public abstract String  nombreFoto(Carta c);
	
	
	
}
