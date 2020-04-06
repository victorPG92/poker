package pr1.negocio.Mano.manos;

import java.util.ArrayList;

import pr1.negocio.Mano.ManoEnum;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.ordenar.OrdenarCartas;
import pr1.constantes.Constantes;


public class Escalera extends Mano
{
	
	
	public Escalera(ArrayList<Carta> mano )
	{
			
			tipo=ManoEnum.straight;
			//cartas =  (new OrdenarCartas()).ordenarPorNumeroAscendente(mano);
                        cartas =  (new OrdenarCartas()).ordenarPorNumero(mano);
                        
                         // si la escalera contiene un as, pero su carta mas baja es un 2, poner el as como ultima 
			if(cartas.get(4).getNum()==2 && cartas.get(0).getNum()==1)
			{
				Carta as = cartas.get(0);
				cartas.add(5,as);
				cartas.remove(0);
			}
	
	}

	
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(Constantes.ESCALERA);
		
		/*sb.append(" desde ");
		sb.append(cartas.get(0).dameNombre());
		sb.append(" hasta ");
		sb.append(cartas.get(4).dameNombre());
		*/
	
		return sb.toString();
	}
	
	
	
}
