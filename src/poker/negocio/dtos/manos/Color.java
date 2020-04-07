package poker.negocio.dtos.manos;

import java.util.ArrayList;

import poker.negocio.constantes.ConstantesPR1;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.util.ordenar.OrdenarCartas;

/**
 * Mano Color
 * @author victor
 *
 */
public class Color extends Mano {
	
	
	
	// Constructor de carta mas alta
	public Color(ArrayList<Carta> mano)
	{
		
		tipo=ManoEnum.flush;
		ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorNumero(mano);
		this.cartas=manoOrd;
		
		
		
		
			
	}
	
	

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.COLOR);
		//sb.append(" carta mas alta : ");
		//sb.append(cartas.get(0));
		
	
		return sb.toString();
	}
	
	
	
	
	
}
