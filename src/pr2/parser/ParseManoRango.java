package pr2.parser;

import pr2.negocio.rangos.ManoRango;


/**
 * Parsea una amno de un rango 
 * @author victor
 *
 */
public class ParseManoRango
{

	public static ManoRango parse(String s)
	{
		
		if(s.length()==2) return parse(s.charAt(0),s.charAt(1));
		else if(s.length()==3) return parse(s.charAt(0),s.charAt(1),s.charAt(2));
		else return null;
	}
	
	
	public static ManoRango parse(char c1,char c2)
	{
		ManoRango m=null;
		LetraNumRango l = new LetraNumRango();
		if(c1==c2)
		{
			m =  new ManoRango(l.num(c1));
		}
		
		
		return m;
	}
	
	
	public static ManoRango parse(char c1,char c2,char c3)
	{
		ManoRango m=null;
		//int n1=parseNumero(c1);
		//int n2=parseNumero(c2);
		
		LetraNumRango l = new LetraNumRango();
		
		int n1=l.num(c1);
		int n2=l.num(c2);
		
		//if(n1>n2)
		//{
			if(c3=='s' || c3=='o' )
			m =  new ManoRango(n1,n2,c3=='s');
		//}
		
		
		return m;
		
	}
	
	
	
	public static int parseNumero(char c1)
	{
		
		int n=0;
		
		
		//parsear numero
			 if(c1== 'A')	n= 14;
		else if(c1== 'K')	n= 13;
		else if(c1== 'Q')	n= 12;
		else if(c1== 'J')	n= 11;
		else if(c1== 'T')	n= 10;
		else if(esNumero(c1))n = Character.getNumericValue(c1);//n=c1;	 
			 
		return n;
		
	}
	
	public static boolean esNumero(char c)
	{
		return c=='1' ||  c=='2' ||c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' ;
	}
	
	/*
	public static void  main(String args[])
	{
		
		String s;
		s= "AA";
		
		ManoRango m = ParseManoRango.parse(s);
		
		System.out.println(m.toString());
		
	}*/
	
	
}
