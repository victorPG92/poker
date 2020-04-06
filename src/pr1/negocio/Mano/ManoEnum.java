package pr1.negocio.Mano;


/**
 * 
 * @author victor
 * Tipos de manos que  se �eden completar
 */
public enum ManoEnum // implements Comparable<ManoEnum>

{

	straight_flush	("escalera de color",8),
	four_of_a_kind  ("poker",			7), //(or quads)
	full_house  	("full",			6), //(or boat)
	flush			("color",			5),
	straight		("escalera",		4),
	three_of_a_kind	("tr�o",			3),
	two_pair		("doblepareja",		2),
	pair			("pareja o par",	1),
	high_card		("carta alta",		0);
	

	private String esp;
	private int valor;
	
	ManoEnum(String s,int i)
	{
		esp=s;
		valor=i;
	}

	public String getEsp() {
		return esp;
	}
	public int getValor() {
		return valor;
	}

	/*
	@Override
	public int compareTo(ManoEnum e)
	{
		return 0;
	}*/
	
	
	
}
