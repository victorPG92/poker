package pr1.negocio.Mano;

import java.util.Comparator;

import pr1.negocio.Mano.manos.Mano;


/**
 * 
 * @author victor
 * Comparador de manos
 */
public class CompararMano implements Comparator<Mano>
{

	

	@Override
	public int compare(Mano o1, Mano o2)
	{
		
		return o1.compareTo(o2);
	}

}
