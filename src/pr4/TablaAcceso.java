package pr4;

import java.util.HashMap;

public class TablaAcceso
{

	private static TablaAcceso inst;
	private HashMap<String,Double> prob;
	
	public static TablaAcceso dameInst()
	{
		if(inst==null) inst= new TablaAcceso();
		return inst;
	}
	
	private TablaAcceso()
	{
		prob= new HashMap<String, Double>();
		
		prob.put("AA", 85.204);
		//seguir
		
		
		
	}
	
	
	public double damePos(String nombre)
	{
		if(prob.containsKey(nombre)) return prob.get(nombre);
		else return 0.01; 
	}
	
	
	
}
