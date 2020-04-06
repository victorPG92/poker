package pr1.util.comb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author victor
 * Calcula todas las combinaciones posibles de N elementos cogidos de M en M
 *
 */
public class Combinaciones 
{
	
	private int n;
	
	@SuppressWarnings("unused")
	private int m;
	ArrayList<boolean[]> combsPosibles;
	
	public Combinaciones(int n, int m)
	{
		
		this.n=n;
		this.m=m;
		combsPosibles = new ArrayList<boolean[]>();
		boolean[] elegidas = new boolean[n];
		if(n>=m)
			comb( m,  0, elegidas);
		//else error
	}
	
	
	
	/**
	 * 
	 * @param restantes: numeros que aun puedo coger
	 * @param pri :  numero que elegimos  coger o no
	 * @param elegidas elegidos hasta el momento 
	 * 
	 */
	public  void comb(int restantes, int i, boolean[] eleg)
	{
		boolean[] elegidas=	Arrays.copyOf(eleg, n);// copio el array porque si no, se queda todo a false
		
		//System.out.println(Arrays.toString(elegidas));
		if(restantes ==0 )
		{
			//System.out.println("Meter :" + Arrays.toString( elegidas));
			combsPosibles.add(elegidas);
			//return elegidas;
		}
		else if(i < n )
		{
				
			
			//elegimos meter i
			elegidas[i]=true;
			comb(restantes-1, i+1, elegidas);
			
			//elegimos no meter i
			elegidas[i]=false;
			comb(restantes, i+1, elegidas);
			
			
			//return elegidas;
		}
	
		
	}
	
	public ArrayList<ArrayList<Integer>> dameTodasLasCombinaciones()
	{
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		for(boolean comb[] : combsPosibles)
		{
			//System.out.println(Arrays.toString(comb));
			ArrayList<Integer> c= new ArrayList<Integer>();
			for(int i=0;i<comb.length;i++)
			{
				if(comb[i]) c.add(i);
			}
			r.add(c);
		}
		
		
		
		return r;
		
	}
	
	
	
	public static void main(String args[])
	{
		ArrayList<ArrayList<Integer>> cp = (new Combinaciones(5,2)).dameTodasLasCombinaciones();
		
		System.out.println(cp);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Combinacion de m elementos sobre n
	 * precond : 0<=m <= n
	 */
	/*public ArrayList<ArrayList<Integer>> combinacion(int n, int m)
	{
		if(m>n)return null;
		
		ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> noSePuede= new ArrayList<Integer>();
		
		for(int i=0;i< n ; i++)
		{
			
		}
		
		
		return combs;
	}
	*/
	
	/*
	public ArrayList<Integer> comb(int n, int m,ArrayList<Integer> noSePuede)
	{
		if(m>n)return null;
		
		ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
		
		
		
		for(int i=0;i< n ; i++)
		{
			
		}
		
		
		return combs;
	}
	*/
	
	/**
	 * 
	 * @param restantes: numeros que aun puedo coger
	 * @param pri : primer numero que puedo coger
	 * @param elegidas elegidos hasta el momento 
	 * @returnboolean[]
	 */
/*	public  void comb(int restantes, int pri, boolean[] elegidas)
	{
		
		
		if(restantes==0)
		{
			combsPosibles.add(elegidas);
			//return elegidas;
		}
		else
		{
		
			int n= elegidas.length;//coger m de n
			for(int i= pri;i<n;i++)
			{
				//elegimos meter i
				elegidas[i]=true;
				comb(restantes-1, i+1, elegidas);
				
				//elegimos no meter i
				elegidas[i]=false;
				comb(restantes, i+1, elegidas);
			}
			
			//return elegidas;
		}
	
		
	}*/
	
	
}
