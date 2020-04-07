package poker.negocio.dtos.manos;

import java.util.ArrayList;

import poker.negocio.constantes.ConstantesPR1;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.util.ordenar.OrdenarCartas;

/**
 * Mano Trio
 * @author victor
 *
 */
public class Trio extends Mano 
{

	
	
		public Trio(ArrayList<Carta> mano )
		{
			
				
				tipo=ManoEnum.three_of_a_kind;
				ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
				this.cartas=manoOrd;
				
				
			
		}
		
	
	public String toString()
	{
				
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.TRIO);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s");	//\n
		return sb.toString();
	}
	
	
	
	
}
