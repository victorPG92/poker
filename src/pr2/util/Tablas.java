package pr2.util;

import java.util.HashMap;

import pr2.constantes.Constantes;
import pr2.negocio.rangos.Rango;
import pr2.negocio.ranking.LeeRango;
import pr2.negocio.ranking.Ranking;

/**
 * 
 * @author victor
 * Estructura global que contiene los ranking y los rangos
 *
 */
public class Tablas
{
	
	private static Tablas inst;
	
	public static Tablas getInst()
	{
		if(inst==null) inst=new Tablas();
		return inst;
	}
	private Tablas() {
		super();
		 rankings= new  HashMap<String ,Ranking >();//SC;...
		 rangos = new  HashMap<String , Rango>();//MA, Janda,... POdriamos incluir la inst singleton aqui
		
	}


	private HashMap<String ,Ranking > rankings;//SC;...
	private HashMap<String , Rango> rangos;//MA, Janda,... POdriamos incluir la inst singleton aqui
	
	
	public void insertaRanking(String s, Ranking r)
	{
		 rankings.put(s,r);
	}
	
	
	public void insertaRango(String s,Rango r)
	{
		 rangos.put(s,r);
	}
	
	
	
	public Ranking dameRanking(String s)
	{
		
		Ranking r;
		if(!rankings.containsKey(s))
		{
			//System.out.println("damerankign");
			r= LeeRango.dameRanking();
			rankings.put(Constantes.FICHERO_RANGO, r);
		}
		else 
			r = rankings.get(s);;
		return r;
	}
	
	
	public Rango dameRango(String s)
	{
		Rango r;
		if(!rangos.containsKey(s))
		{
		//	System.out.println("damerankign");
			r= LeeRango.dameRango(s);
			rangos.put(Constantes.FICHERO_RANGO, r);
		}
		else 
			r= rangos.get(s);
		
		return r;
	}
	

}
