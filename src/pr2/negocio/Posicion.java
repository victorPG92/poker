package pr2.negocio;

public enum Posicion 
{
	UTG,
	UTG_1,   // tambien llamado MP o LO
	CO,
	btn, 
	SB,
	BB  // preguntar rango a manuel 
	
	;
	
	public static  Posicion parse(String s)
	{
	
		String mayus= s.toUpperCase();
		for(Posicion p: Posicion.values())
		{
			if(p.name().equalsIgnoreCase(mayus)) return p;
		}
		
		
		return null;
	}
	
	
}
