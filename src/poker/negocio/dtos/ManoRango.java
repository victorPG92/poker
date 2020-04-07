package poker.negocio.dtos;

import poker.negocio.util.PosicionXY;
import pr2.parser.LetraNumRango;

/**
 * Representa una mano compuesta por dos numeros y u booleano indicando si son del mismo color(palo)
 * @author victor
 *
 */
public class ManoRango implements Comparable<ManoRango>
{
	
	private int n1;
	private int n2;
	private boolean suited;
	private boolean incluido;
	
	
	
	/**
	 * Constructor de desa
	 * @param a
	 * @param b
	 * @param s
	 */
	public ManoRango(int a, int b, boolean s)
	{
		n1=a;
		n2=b;
		suited=s;
		incluido=false;
		
		
		
	}
	
	/**
	 * Constructor de par
	 * @param a
	 */
	public ManoRango(int a)
	{
		n1=a;
		n2=a;
		suited=false;
		incluido=false;
		
	}

	public boolean isIncluido() {
		return incluido;
	}

	public void setIncluido(boolean incluido)
	{
		//if(incluido && this.incluido) this.incluido=false;
		//else 
		this.incluido = incluido;
	}

	public int formas()
	{
		if(n1==n2) return 13;
		else return 78;
			
		
	}
	
	public int valor()
	{
		int v;
		if(n1!=n2)
		{
			if(suited) v=4;
			else v=12; 
		}
		else v=6;
		
		return v;//*formas();
	}
	
	
	
	public String toString()
	{
		LetraNumRango l= new LetraNumRango();
		char c;
		if(suited)	c='s';
		else 		c='o';
		
		String s1=String.valueOf(l.letra(n1)) ;
		String s2= String.valueOf(l.letra(n2));
		
		String s;
		if(n1<n2)	 s = s2 +s1 ;
		else 		 s = s1 + s2;
		if(n1!=n2)s+= String.valueOf(c);
		//System.out.println(s);
		return s;
	}

	
	public PosicionXY damePos()
	{
		
		if(n1==n2)return new PosicionXY(n1,n2); 
		LetraNumRango l = new LetraNumRango();
		
		int p1=l.pos(n1);
		int p2=l.pos(n2);
		
		if(p1==-1&& p2==-1) System.out.println(this + " "+ n1+" "+n2);
		else if(p1==-1) System.out.println(this +" "+ n1);
		else if(p2==-1) System.out.println(this+"  "+n2);
		
		return new PosicionXY(p1,p2);
	}
	
	
	@Override
	public int compareTo(ManoRango arg0) 
	{
		int r= Integer.compare(n1, arg0.n1);
		if(r==0)r=Integer.compare(n2, arg0.n2);
		if(r==0)r=Boolean.compare(suited, arg0.suited);
		return r;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public boolean isSuited() {
		return suited;
	}

	public void setSuited(boolean suited) {
		this.suited = suited;
	}
	
	
	public boolean isPar()
	{
		return n1==n2;
	}
	
	
}
