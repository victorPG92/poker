package poker.negocio.dtos.mazos;

import java.util.ArrayList;
import java.util.Random;

import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.cartas.Palo;

public class MazoOpt2 implements MazoOpt
{
	private Carta mazo[][];
	private boolean seleccionada[][];
	private int cont;
	
	private final static int NUM_PALOS=  Palo.values().length;
	private final static int NUM_CARTAS= 13;
	
	public MazoOpt2()
	{
		mazo =  new Carta[NUM_PALOS][NUM_CARTAS];
		seleccionada= new boolean[NUM_PALOS][NUM_CARTAS];
		cont = NUM_PALOS*NUM_CARTAS;
		for(Palo p : Palo.values())
		{
			for(int i=0;i<NUM_CARTAS;i++)//cambiado
				mazo[p.ordinal()][i]= new Carta(i+1,p);
		}
	}
	
	
	
	
	/**
	 * Extrae una carta del mazo
	 * @return carta aleatoria
	 */
	public Carta dameCartaAleatoria()
	{
		if(cont==0){
			return null;
		}else{
		
			Random r = new Random(System.currentTimeMillis());
					
			int nPalo = r.nextInt(NUM_PALOS);
			int nCarta = r.nextInt(NUM_CARTAS);
			
			Palo p =  Palo.values()[nPalo];
			Carta c = new Carta(nCarta+1,p);
			
			while(estaSeleccionada(c))
			{
				nPalo = r.nextInt(NUM_PALOS);
				nCarta = r.nextInt(NUM_CARTAS);
				
				p =  Palo.values()[nPalo];
				c = new Carta(nCarta+1,p);
			}
			
			cont--;
			seleccionarCarta(c);
			return c;
		}
		
	}
	
	
	
	
	/**
	 * Extrae n cartas del mazo
	 * @return cartas aleatorias
	 */
	public ArrayList<Carta> dameNCartas(int n)
	{
		 ArrayList<Carta> a = new  ArrayList<>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		
		 
		 return a;
	}
	

	@Override
	public void insertaCarta(Carta c) 
	{
		int p = c.getPalo().ordinal();// Palo.values()[nPalo];
		int n= c.getNum()-1;
		if(n==NUM_CARTAS)n=0;
		
		//si ya esta en el mazo, se inserta de nuevo, pero no repite
		seleccionada[p][n]=true;
		
	}




	@Override
	public void insertaCarta(ArrayList<Carta> l) {

		for(Carta c: l)
			insertaCarta(c);
	}
	
	/**
	 * Devuelve si hay cartas en el mazo
	 * @return
	 */
	public boolean estaVacio()
	{
		return cont==0;//mazo.isEmpty();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Devuelve si la carta c , está en el mazo
	 * @param c
	 * @return
	 */
	public boolean estaCarta(Carta c)
	{
		return !estaSeleccionada(c);//mazo.contains(c);
	}
	
	
	
	
	
	public void seleccionarCarta(Carta c )
	{
		if(c==null) return ;
		int n= c.getNum()-1;
		if(n==13)n=1; // si es as
		int p= c.getPalo().ordinal();
		if(!estaSeleccionada(c))
		{
			seleccionada[p][n]=true;
			cont--;
		}
		
	}
	
	public boolean estaSeleccionada(Carta c)
	{
		if(c==null) return false;
		
		
		int n= c.getNum()-1;
		if(n==13)n=1; // si es as
		int p= c.getPalo().ordinal();
		boolean b=false;
		try
		{
			b= this.seleccionada[p][n];
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+c + " "+ n +" "+ p );
			
			System.exit(-1);
		}
		return b;
	}




	
	
	
	
}
