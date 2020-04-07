package poker.negocio.dtos.manos;

import java.util.ArrayList;

import poker.negocio.constantes.ConstantesPR1;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.util.ordenar.OrdenarCartas;

/**
 * Mano Pareja
 * @author victor
 *
 */
public class Pareja extends Mano
{
	
	
	
	
	public Pareja(ArrayList<Carta> mano )
	{
		
			
			tipo=ManoEnum.pair;
			ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
			this.cartas=manoOrd;
			
		
	}

	@Override
	public ManoEnum dameTipo() {
		
		return ManoEnum.pair;
	}
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConstantesPR1.PAREJA);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s");	//\n
		return sb.toString();
		
		
	}
	
	

}
