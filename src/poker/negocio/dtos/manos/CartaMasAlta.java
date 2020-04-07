 package poker.negocio.dtos.manos;

import java.util.ArrayList;

import poker.negocio.constantes.ConstantesPR1;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.util.ordenar.OrdenarCartas;

/**
 * Mano Carta mas alta
 * @author victor
 *
 */
public class CartaMasAlta extends Mano  implements Comparable<Mano>
{
	
	
	
	
	
	
	// Constructor de carta mas alta
	public CartaMasAlta(ArrayList<Carta> mano)//,ManoEnum me
	{
		
		tipo=ManoEnum.high_card;
		ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorNumero(mano);
		cartas=manoOrd;
			
	}
	
	
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.CARTA_MAS_ALTA);
                sb.append(" ");
		//sb.append(" carta mas alta : ");
		sb.append(cartas.get(0).dameNombre());
			
		return sb.toString();
	}
	
}
