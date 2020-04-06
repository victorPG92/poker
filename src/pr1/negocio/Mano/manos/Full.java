package pr1.negocio.Mano.manos;

import java.util.ArrayList;

import pr1.negocio.Mano.ManoEnum;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.ordenar.OrdenarCartas;
import pr1.constantes.Constantes;

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
		sb.append(Constantes.FULL);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s and ");
		sb.append(cartas.get(3).dameNombre());
		sb.append("s");	//\n
		
	
		return sb.toString();
	}

	
	
	
}
