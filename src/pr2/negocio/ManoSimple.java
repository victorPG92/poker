package pr2.negocio;

import pr1.negocio.cartas.carta.Carta;
import pr2.negocio.rangos.ManoRango;

public class ManoSimple 
{
	private Carta[] cartas;
	
	
	public ManoSimple(Carta c1, Carta c2)
	{
		cartas = new Carta[2];
		cartas[0]=c1;
		cartas[1]=c2;
	}
	
	public ManoSimple(Carta[] c2)
	{
		if(c2.length==2) cartas= c2;
		else
		{
			cartas = new Carta[2];
		}
		
	}
	
	public ManoRango toManoRango()
	{
		
		ManoRango m ;
		
		Carta c1= cartas[0];
		Carta c2= cartas[1];
		
		
		int n1= c1.getNum()-2;
		int n2= c2.getNum()-2;
		
		
		if(n1==-1)n1=12;
		if(n2==-1)n2=12;
		
		if(n1 == n2) m = new ManoRango(n1);
		else
		{
			boolean suited = c1.getPalo().equals(c2.getPalo());
			m = new ManoRango(n1,n2,suited);
		}
			
			
			
		return m;
		
	}
	
	

	
	
}
