package poker.negocio.util.comb;

import java.util.ArrayList;

import poker.negocio.util.ParTipo;


/**
 * 
 * @author victor
 * Calcula todas las combinaciones posibles de N1 elementos cogidos de M1 en M1 
 * combinado con todas las combinaciones posibles de N2 elementos cogidos de M2 en M2
 * usar para omaha
 *
 */
public class CombinacionesMultiples
{

	private int n1;
	private int m1;
	private int n2;
	private int m2;
	//ArrayList<ParTipo<boolean[]>> combsPosibles;
	ArrayList<ParTipo<ArrayList<Integer>>> combsPosibles;
	
	public CombinacionesMultiples(int n1, int m1,int n2, int m2)
	{
		
		this.n1=n1;
		this.m1=m1;
		this.n2=n2;
		this.m2=m2;
		
		creaCombinaciones();
		/*
		 4 sobre 2 =  6  = (4! / 2!*2!)= ( 4*3*2 /2*2)
		 5 sobre 3 = 10  = (5! / 3!*2!)= (5*4*3*2/ 3*2*2)
		 en total 60
		 
		 
		 
		*/
	}
	
	public void creaCombinaciones()
	{
		combsPosibles = new ArrayList<ParTipo<ArrayList<Integer>>>();//new ArrayList<ParTipo<Integer>>();
		
		
		
		if(n1>=m1 && n2 >=m2)
		{
			Combinaciones c1 = new Combinaciones(n1,m1);
			Combinaciones c2 = new Combinaciones(n2,m2);
			
			ArrayList<ArrayList<Integer>> combs1= c1.dameTodasLasCombinaciones();
			ArrayList<ArrayList<Integer>> combs2= c2.dameTodasLasCombinaciones();
			for(ArrayList<Integer> p1: combs1)
			{
				for(ArrayList<Integer> p2: combs2)
				{
					combsPosibles.add(new ParTipo<ArrayList<Integer>>(p1,p2));
				}
			}
		}
	}
	
	public ArrayList<ParTipo<ArrayList<Integer>>> dameTodasLasCombinaciones()
	{
		return combsPosibles;
	}
	
	/*
	public static void main(String args[])
	{
		ArrayList<ParTipo<ArrayList<Integer>>> cp = (new CombinacionesMultiples(4,2, 5,3)).dameTodasLasCombinaciones();
		
		for(int i=0; i< cp.size();i++)
		System.out.println(cp.get(i));
		System.out.println(cp.size());
	}*/
}
