package poker.negocio.dtos.manos;

import java.util.ArrayList;

import poker.negocio.constantes.ConstantesPR1;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.util.ordenar.OrdenarCartas;

/**
 * Mano Escalera color
 * @author victor
 *
 */
public class EscaleraColor extends Mano{

	

	public EscaleraColor(ArrayList<Carta> mano )
	{
		
			
			tipo=ManoEnum.straight_flush;
			ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorNumero(mano);
			
                        // si la escalera contiene un as, pero su carta mas alta, es en realidad un rey, poner el as como primera 
			if(manoOrd.get(0).getNum()==12 && manoOrd.get(4).getNum()==1)
			{
				Carta as = manoOrd.get(4);
				manoOrd.add(0,as);
				manoOrd.remove(5);
			}
                        
                        // si la escalera contiene un as, pero su carta mas baja es un 2, poner el as como ultima 
			if(manoOrd.get(4).getNum()==2 && manoOrd.get(0).getNum()==1)
			{
				Carta as = manoOrd.get(0);
				manoOrd.add(5,as);
				manoOrd.remove(0);
			}
			cartas=manoOrd;
	}
	
	
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.ESCALERA_COLOR);
		sb.append(" desde ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("hasta ");
		sb.append(cartas.get(4).dameNombre());
		
	
		return sb.toString();
		
	}
	
	
	
}
