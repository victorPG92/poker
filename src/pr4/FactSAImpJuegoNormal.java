package pr4;

public class FactSAImpJuegoNormal 
{

	private static  SAPr4JuegoNormal sa;
	public static SAPr4JuegoNormal dameSA()
	{
		if(sa==null)sa = new SAPR4ImpJuegoNormal();
		return sa;
	}
}
