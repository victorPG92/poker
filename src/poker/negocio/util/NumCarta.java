package poker.negocio.util;

/**
 * Transforma el numero de la carta en el nombre 
 * @author victor
 *
 */
public class NumCarta 
{

	
	public static String nombreCarta(int num)
	{
		String n="0";
		
		if(num >=2 && num < 10) n = Integer.toString(num);
		else if(num == 1) n="Ace";
		else if(num == 10) n="Ten";
		else if(num == 11) n="Jack"; //Jockey
		else if(num == 12) n="Queen";
		else if(num == 13) n="King";
		else if(num == 14 || num == 15  ) n="Ace";
		
		return n;
	}
	
	public static String letraCarta(int num)
	{
		String n="0";
		
		if(num >=2 && num < 10) n = Integer.toString(num);
		else if(num == 1) n="A";
		else if(num == 10) n="T";
		else if(num == 11) n="J"; //Jockey
		else if(num == 12) n="Q";
		else if(num == 13) n="K";
		else if(num == 14 || num == 15  ) n="A";
		
		return n;
	}
}
