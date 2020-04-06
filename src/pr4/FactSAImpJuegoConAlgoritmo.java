package pr4;

public class FactSAImpJuegoConAlgoritmo {
	
	private static SAPR4ImpJuegoConAlgoritmo sa;
	
	public static SAPR4ImpJuegoConAlgoritmo dameSA()
	{
		if(sa==null) 
		{
			
			sa = new SAPR4ImpJuegoConAlgoritmo();
		
		}
		
		return sa;
	
	}
	
}
