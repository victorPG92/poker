package pr1.negocio.Mano.manos;

import java.util.ArrayList;

import pr1.negocio.Mano.ManoEnum;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.ordenar.OrdenarCartas;
import pr1.constantes.Constantes;

public class DoblesParejas extends Mano
{
	
	
	
	public DoblesParejas(ArrayList<Carta> mano)
	{
		
		tipo=ManoEnum.two_pair;
		ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
		this.cartas=manoOrd;
			
			
	}
		
	public String toString()
	{
		
		Carta c1 = cartas.get(0);
		Carta c2 = cartas.get(2);
		
		if(c1.compareTo(c2)==-1)
		{
			Carta c= c1;
			c1=c2;
			c2=c;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(Constantes.DOBLES_PAREJAS);
		sb.append(" of ");
		sb.append(c1.dameNombre());
		sb.append("s and ");
		sb.append(c2.dameNombre());
		sb.append("s");	//\n
		
	
		return sb.toString();
	}
	
	
	
}
