package pr2.parser;

import java.util.ArrayList;

import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.cartas.Palo;
import poker.negocio.dtos.manojugador.ManoSimple;


/**
 * 
 * @author victor
 * Parsea una carta a partir de un String
 *
 */
public class ParseCartaP2
{
	
	private static  ParseCartaP2 inst ;
	
	private ParseCartaP2()
	{
		
	}
	public static ParseCartaP2 getInst()
	{
		if(inst==null)inst = new ParseCartaP2();
		
		return inst;
	}
	
	/**
	 * Si solo parseamos (5) cartas 
	 * @param s
	 * @return
	 */
	public ArrayList<Carta> parseMano(String s)
	{
		
		ArrayList<Carta> a = new ArrayList<Carta>();
		
		if(s.length()%2==0)
		{
			//System.out.println(" long par : ");
			for(int i=0;i<s.length()-1;i+=2)
			{
				//System.out.println(s.charAt(i)+" "+ s.charAt(i+1));
				Carta c = parseCarta(s.charAt(i), s.charAt(i+1));
				if(c!=null)a.add(c);
				//System.out.println(c);
			}
			
		}// else System.out.println(" long impar : ");
		
		
		return a;
		
		
	}
	
	/**
	 * Si solo parseamos 2 cartas , es decir la mano del jugador
	 * @param s
	 * @return
	 */
	public ManoSimple parseManoSimple(String s)
	{
		
		ManoSimple m= null;
		try{
		
		if(s.length()==4)
		{
			ArrayList<Carta> a = parseMano(s);
			if(a.size()==2)
			{
				Carta c1 = a.get(0);
				Carta c2= a.get(1);
				m = new ManoSimple(c1,c2 );
			}
			
		}// else System.out.println(" long impar : ");
		
		}
		catch(Exception e)
		{
			m=null;
		}
		return m;
		
		
	}
	
	
	
	public Carta parseCarta(char c1, char c2)
	{
		Carta c=null;
		int n=0;
		Palo p=null ;
		
		//parsear numero
			 if(c1== 'A')	n= 1;
		else if(c1== 'K')	n= 13;
		else if(c1== 'Q')	n= 12;
		else if(c1== 'J')	n= 11;
		else if(c1== 'T')	n= 10;
		else if(esNumero(c1))n = Character.getNumericValue(c1);//n=c1;	 
			 
		//parsear palo
			  if(c2== 'c')	p = Palo.TREBOLES;
		 else if(c2== 's')	p = Palo.PICAS;
		 else if(c2== 'h')	p = Palo.CORAZONES;
		 else if(c2== 'd')	p = Palo.DIAMANTES;
		
		if( n!=0 && p!=null)
			c = new Carta(n,p); 
		
		return c;
		
	}
	
	public boolean esNumero(char c)
	{
		return c=='1' ||  c=='2' ||c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' ;
	}
	

}
