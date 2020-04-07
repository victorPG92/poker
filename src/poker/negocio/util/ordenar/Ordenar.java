package poker.negocio.util.ordenar;

import java.util.ArrayList;

/**
 * 
 * @author victor
 * Ordenacion por burbuja general para cualquier ovbjeto comparable
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class Ordenar <T extends  Comparable>// Comparable<Carta>>
{
	@SuppressWarnings("unchecked")
	public ArrayList<T> ordenar( ArrayList<T> l)
	{
		ArrayList<T> a = new ArrayList<T>();
		a.add(l.get(0));
		
		
		for(int j=1;j<l.size();j++)
		{
			T elem = l.get(j);
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
	
	
	/*
	public ArrayList<Carta> ordenar()
	{
		ArrayList<Carta> cartasAux = new ArrayList<Carta>();
		/*for(Carta c1: cartas)
		{
			//cartas.remove(c1);
			if(cartasAux.isEmpty())cartasAux.add(c1);
			else
			for(int i=0; i< cartasAux.size();i++)
			{	
				Carta c2 = cartasAux.get(i);
				if(c1.getNum()< c2.getNum())
				{
					cartasAux.add(i, c1);
				}
			
			}
		}*/
		/*
		HashSet<Carta> ordenarMano= new HashSet<Carta>();
		ordenarMano.addAll(cartas);
		
		return cartasAux;
	}*/
}
