 package pr1.negocio.Mano.manos;

import java.util.ArrayList;

import pr1.negocio.Mano.ManoEnum;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.ordenar.OrdenarCartas;
import pr1.constantes.Constantes;

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
		sb.append(Constantes.CARTA_MAS_ALTA);
                sb.append(" ");
		//sb.append(" carta mas alta : ");
		sb.append(cartas.get(0).dameNombre());
			
		return sb.toString();
	}
	
}
