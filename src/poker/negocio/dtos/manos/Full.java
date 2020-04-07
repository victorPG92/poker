package poker.negocio.dtos.manos;

import java.util.ArrayList;

import poker.negocio.constantes.ConstantesPR1;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.util.ordenar.OrdenarCartas;

/**
 * Mano Full
 * @author victor
 *
 */
public class Full extends Mano
{
	
	
	public Full(ArrayList<Carta> mano )
	{
		
			
			tipo=ManoEnum.full_house;
			ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
			this.cartas=manoOrd;
			
		
	}
	
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.FULL);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s and ");
		sb.append(cartas.get(3).dameNombre());
		sb.append("s");	//\n
		
	
		return sb.toString();
	}

	
	
	
}
