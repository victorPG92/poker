package poker.negocio.dtos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
/**
 * 
 * @author victor
 *
 *Es como una cola de priooridad en la que meto las manos segun su valoracion
 *
 */
public class Ranking
{
	
	double valorMax=Double.MAX_VALUE;
	TreeSet<ManoPrio> c= new TreeSet<ManoPrio>();
	 ArrayList<ManoPrio>  l;
	
	public  void inserta(ManoPrio m )
	{
		
		//System.out.println("Inserto mano "+ m);
		c.add(m);
		
		
	}
	
	
	public ArrayList<ManoPrio> damePorc(int porc)
	{
		
		//if(c.size()== 13*13)
		//{
			l = new  ArrayList<ManoPrio> ();
			l.addAll(c);
		//}
		
		
		 ArrayList<ManoPrio> p=new  ArrayList<ManoPrio> ();
		 if(porc<0 || porc >100) return p;
		 
		if(l!=null && !l.isEmpty())
		{
			if(porc==100) return l;
			int numElem=porc*l.size()/100;
			
			 System.out.println("el "+ porc +"% de "+ l.size()+" es "+numElem);
			
			for(int i=0;i<numElem;i++)
				p.add(l.get(i));
		}
			
		return p;
	}
	
	public  ArrayList<ManoPrio> damePorcValor(int porc)
	{
		
		double pt=0;
		
		l = new  ArrayList<ManoPrio> ();
		l.addAll(c);
			
		this.valorMax=1326;	//calculaMax();
		
		double tope = porc*valorMax/100;
		ArrayList<ManoPrio> r=new  ArrayList<ManoPrio> ();
		 
		for(ManoPrio m : l)
		{
			System.out.println(pt + " < "+ tope );
			if(pt < tope)
			{
				pt+=m.getMano().valor();
				if(pt< tope)
				{
					r.add(m);
				}
			}
			else break;
			
			
		}
		
		return r;
	}
	
	public ArrayList<ManoPrio> rangoPorcentaje(double porcentaje)
	{
		
		ArrayList<ManoPrio> a =new ArrayList<ManoPrio>();
		
		double valor=0;
		double max= (1365*porcentaje)/100;
		
		
		Rango r = new Rango();
		
		Iterator<ManoPrio> it = c.iterator();
		while(it.hasNext() && valor <max && r.porcentaje()< porcentaje)
		{
			ManoPrio m = it.next();
			r.insertaRango(m.getMano());
			if(valor + m.getMano().valor()< max && r.porcentaje()< porcentaje )
			{
				
				valor = valor + m.getMano().valor();
				a.add(m);
			}
		}
		
		
		return a;
		
	}
	
	
	/*
	private double calculaMax()
	{
		
		double pt=0;
		
		for(ManoPrio m : l)
			pt+=m.getMano().valor();
		
		return pt;
	}*/


	public ArrayList<ManoRango> damePorcentaje(double porc)
	{
		ArrayList<ManoPrio> l ;
		
		//cual de los dos está bien??
		//l= damePorc(porc); 
		//l= damePorcValor(porc);
		
		l= rangoPorcentaje(porc);
		
		ArrayList<ManoRango> r = new ArrayList<ManoRango>();
		for(ManoPrio m: l)
		{
			r.add(m.getMano());
		}
		return r;
	}
	
	public String toString()
	{
		if(c==null || c.isEmpty()) return "vacio";
		
		StringBuffer sb= new StringBuffer();
		for(ManoPrio m: c)
		{
			sb.append(m.toString());
			sb.append("\n");
		}
		return sb.toString();
		
	}
}
