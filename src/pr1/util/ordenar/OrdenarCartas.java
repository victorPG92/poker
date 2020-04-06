package pr1.util.ordenar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import pr1.negocio.cartas.carta.Carta;


/**
 * 
 * @author victor
 * Ordenacion por burbuja  para cartas 
 * Incluye ordenar por numero, por color, por escalera
 * 
 */
public class OrdenarCartas 
{
	/**
	 * Ordena de mayor a menor
	 * @param l
	 * @return
	 */
	public ArrayList<Carta> ordenarPorNumero( ArrayList<Carta> l)
	{
		ArrayList<Carta> a = new ArrayList<Carta>();
		a.add(l.get(0));
		
		
		for(int j=1;j<l.size();j++)
		{
			Carta elem = l.get(j);
			int i=0;
			while(i < a.size() && elem.compareTo(a.get(i))<0)
			{
				i++;
			}
			a.add(i,elem);
			i=0;
			
		}
		return a;
	}
	
	
	public ArrayList<Carta> ordenarPorNumeroAscendente( ArrayList<Carta> l)
	{
		TreeSet<Carta> ts= new TreeSet<Carta>();
		ts.addAll(l);
		ArrayList<Carta> r = new ArrayList<Carta>();
		r.addAll(ts); 
		return r;
	}
	
	/**
	 * Agrupa por color
	 * @param l
	 * @return
	 */
	public ArrayList<Carta> ordenarPorColor( ArrayList<Carta> l)
	{
		ArrayList<Carta> a = new ArrayList<Carta>();
		a.add(l.get(0));
		
		
		for(int j=1;j<l.size();j++)
		{
			Carta elem = l.get(j);
			int i=0;
			while(i < a.size() && elem.getPalo().compareTo(a.get(i).getPalo())<0)
			{
				i++;
			}
			a.add(i,elem);
			i=0;
			
		}
		return a;
	}
	
	/**
	 * Ordena por escalera desdendentemente /// ascendentemente
	 * VA MAL, DEBERIA ORDENAR DE OTRA FORMA 
	 * @param l
	 * @return
	 */
	public ArrayList<Carta> ordenarPorEscalera( ArrayList<Carta> l)
	{
		ArrayList<Carta> a = ordenarPorNumero(l);
		ArrayList<Carta> r = new ArrayList<Carta>();
		 
		
		for(int i=0;i<a.size()-1;i++)
		{
			int dif=0;
			
			Carta e1 = a.get(i);
			Carta e2 = a.get(i+1);
			
			dif = e2.getNum()-e1.getNum();
			
			if(dif == 1 )
			{
				if(r.isEmpty())
				{
					r.add(e1);
					r.add(e2);
				}
				else
				{
					// si continuio la escalera
					if(r.get(r.size()-1).equals(e1))
					{
						r.add(e2);//meto la carta siguiente
					}
					else if(r.size()<3)// si no tengo escalera de 3 cartas, empiezo con una nueva 
					{
						r = new ArrayList<Carta>();
						r.add(e1);
						r.add(e2);
					}
				}
				
			}
			
			
		}
		
		
		for(Carta c : a)
		{
			if(!r.contains(c)) r.add(c);
		}
		return r;
	}
	
	public ArrayList<Carta> ordenarPorIguales( ArrayList<Carta> l)
	{
		return ordenarPorIguales2(l);
	}
	
	public ArrayList<Carta> ordenarPorIguales1( ArrayList<Carta> l)
	{
		/*ArrayList<Carta> a = ordenarPorNumero(l);
		
		ArrayList<Carta> r = new ArrayList<Carta>();
		 
		
		
		for(int i=0;i<a.size();i++)
		{
			
			
		}*/
		
		return null;//r
		
		
	}
	
	//sin ordenar
	/**
	 * 
	 * Hace algo mal con las restantes
	 * @param l
	 * @return
	 */
	public ArrayList<Carta> ordenarPorIguales2( ArrayList<Carta> l)
	{
		
		
		ArrayList<Carta> r = new ArrayList<Carta>();
		ArrayList<Carta> aux = new ArrayList<Carta>();
		
		for(Carta c : l)
		{
			aux.add(c);
		}
		
		
		HashMap<Integer,Integer> m = new  HashMap<Integer,Integer>();
		
		for(Carta c : l)
		{
			int i = c.getNum();
			int v= 1;
			if(m.containsKey(i)) v += m.get(i);
			m.put(i, v);
		}
		int max=0;
		//como solo son 5, puede ser que sean (2 2 1), o (3  2) o  o (4 1) o (1..2 ) o (1..1)
		for( Integer i : m.keySet())
		{
			int v= m.get(i);
			if(v > max) max=v;
			
			ArrayList<Carta> coinc= new ArrayList<Carta>();
			for(Carta c : l)
			{
				if(c.getNum()==i) coinc.add(c);
				
			}
			if(v==2)
			{
				if(max>2) // como mucho ==3
				{
					for(Carta c :coinc)
					{
						r.add(3,c);
						aux.remove(c);
					}
				}
				else
				{
					for(Carta c :coinc)
					{
						r.add(0,c);
						aux.remove(c);
					}
					
				}
			}
			else if(v>2 )
			{
				
				for(Carta c :coinc)
				{
					r.add(0,c);
					aux.remove(c);
				}
			}
		}
		if(!aux.isEmpty())// si hay cartas sueltas 
		{
			aux= (new OrdenarCartas()).ordenarPorNumero(aux); //ordena descendentemente
			
			
		}
		
		for(Carta c:aux)
			r.add(c);
		
		return r;
	}
	
	
/*
	public ArrayList<Carta> ordenarPorEscalera( ArrayList<Carta> l)
	{
		ArrayList<Carta> a = ordenarPorNumero(l);
		ArrayList<Carta> r = new ArrayList<Carta>();
		 
		
		for(int i=0;i<l.size()-1;i++)
		{
			int dif=0;
			int j=0;
			while(dif != 1 && j < l.size())
			{
				Carta e1 = l.get(i);
				Carta e2 = l.get(i+1);
				dif = e2.getNum()-e1.getNum();
				//MAALs
				// si la diferencia entre el primer elemento y el siguiente no es 1 
				// muevo el primer elemento al final 
				if(dif !=1)  
				{
					
				}
				j++;
			}
			
			
		}
		return a;
	}*/

}
