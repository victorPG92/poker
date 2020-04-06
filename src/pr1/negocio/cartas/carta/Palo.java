package pr1.negocio.cartas.carta;

/**
 * Los palos de la baraja francesa
 * @author victor
 *
 */
public enum Palo
{
	PICAS("spades",'S'),DIAMANTES("diamonds",'D'),TREBOLES("clubs",'C'),CORAZONES("hearts",'H');
	
	private String ingles;
	private char letra;
	
	Palo(String i, char c)
	{
		ingles=i;
		letra=c;
	}
	
	
	public String ing()
	{
		return ingles;
	}
	
	public char letr()
	{
		return letra;
	}
	
}
