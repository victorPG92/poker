package poker.negocio.dtos.mazos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.cartas.Palo;

public class MazoOpt1 implements MazoOpt
{
	private LinkedList<Carta> mazo;
	
	private List<Carta> cartasUsadas;

	
	public MazoOpt1()
	{
		mazo = new LinkedList<>();
		cartasUsadas = new LinkedList<>();
		for(Palo p : Palo.values())
		{
			for(int i=1;i<14;i++)//cambiado
				mazo.add(new Carta(i,p));
		}
	
	}
	
	
	
	public Carta dameCartaAleatoria()
	{
		Random r= new Random(System.currentTimeMillis());
		int n= r.nextInt(mazo.size());
		Carta carta = mazo.remove(n);
		cartasUsadas.add(carta);
		return carta;
		
	}



	@Override
	public ArrayList<Carta> dameNCartas(int n) 
	{
		
		 ArrayList<Carta> a = new  ArrayList<Carta>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		
		 
		 return a;
	}



	@Override
	public void insertaCarta(Carta c)
	{
		mazo.add(c);
		
	}



	@Override
	public void insertaCarta(ArrayList<Carta> l)
	{
		for(Carta c: l)
			insertaCarta(c);
		
	}
	
	
	
}
