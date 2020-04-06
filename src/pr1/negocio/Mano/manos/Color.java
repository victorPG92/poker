package pr1.negocio.Mano.manos;

import java.util.ArrayList;

import pr1.negocio.Mano.ManoEnum;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.ordenar.OrdenarCartas;
import pr1.constantes.Constantes;

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
		sb.append(Constantes.COLOR);
		//sb.append(" carta mas alta : ");
		//sb.append(cartas.get(0));
		
	
		return sb.toString();
	}
	
	
	
	
	
}
