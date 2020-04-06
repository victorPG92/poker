package pr1.negocio.Mano.manos;

import java.util.ArrayList;

import pr1.negocio.Mano.ManoEnum;
import pr1.negocio.cartas.carta.Carta;


/**
 * 
 * @author victor
 * Estruvtura de mano
 *
 */
public abstract class Mano implements Comparable<Mano>
{
	
	
	
	protected ManoEnum tipo;
	protected ArrayList<Carta> cartas;
	
	
	
	public ManoEnum dameTipo()
	{
		return tipo;
	}
	
	
	
	/// nuevo
	public ArrayList<Carta> dameMano()
	{
		return cartas;
	}
	
	
	
	public String manoReducida()
	{
		StringBuffer sb = new StringBuffer();
		for(Carta c : cartas)
		sb.append(c.dameLetras());	
		
		return sb.toString();
	}
	
	
	/**
	 * Sera sobreeescrito en las clases hijas
	 */
	 @Override
	public int compareTo(Mano m2)
	{
		
		
		int r=0;
		
		if(tipo.getValor()		<	m2.tipo.getValor())  r = -1;
		else if(tipo.getValor()	>	m2.tipo.getValor())  r =  1;
				
		else if(tipo.getValor()	==	m2.tipo.getValor())
		{
			int i=0;
			
			while(r==0 && i< cartas.size() )
			{
				r = cartas.get(i).compareTo(m2.cartas.get(i));
				i++;
			}
			
			
		}
		
		return r;
		
	}
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	// Constructor de poker
	public Mano(ManoEnum mano, int h,Carta k1 )
	{
		if( mano.equals(ManoEnum.four_of_a_kind))
		{
			tipo=mano;
			hc=h;
			Kicker1 = k1;
			
		}
		
	}
	
	
	// Constructor de trio
	public Mano(ManoEnum mano, int h,Carta k1,Carta k2 )
	{
		if( mano.equals(ManoEnum.three_of_a_kind))
		{
			tipo=mano;
			hc=h;
			Kicker1 = k1;
			Kicker2 = k2;
			
		
		}
			
	}
		
	// Constructor de pareja
	public Mano(ManoEnum mano, int h,Carta k1,Carta k2,Carta k3 )
	{
		if( mano.equals(ManoEnum.pair))
		{
			tipo=mano;
			hc=h;
			Kicker1 = k1;
			Kicker2 = k2;
			Kicker3 = k3;
			
		
		}
			
	}
	
	// Constructor de carta mas alta
	public Mano(ManoEnum mano, int h,Carta k1,Carta k2,Carta k3, ,Carta k4 )
	{
		if( mano.equals(ManoEnum.high_card))
		{
			tipo=mano;
			hc=h;
			Kicker1 = k1;
			Kicker2 = k2;
			Kicker3 = k3;
			Kicker4 = k4;
			
		
		}
			
	}
	
	// Constructor de doble pareja
	public Mano(ManoEnum mano , int h1, int h2, Carta k1 )
	{
		if(mano.equals(ManoEnum.two_pair))
		{
			tipo=mano;
			hc=h1;
			hc2=h2;
			Kicker1 = k1;
		}
		
	}
	
	// Constructor de full
	public Mano(ManoEnum mano , int h1, int h2 )
	{
		if(mano.equals(ManoEnum.full_house))
		{
			tipo=mano;
			hc=h1; 	//trio
			hc2=h2; // pareja
			
		}
		
	}
	
	// Constructor de full
		public Mano(ManoEnum mano , int h1 )
		{
			if(mano.equals(ManoEnum.straight) || mano.equals(ManoEnum.straight_flush) || mano.equals(ManoEnum.flush))
			{
				tipo=mano;
				hc=h1; 	//carta mas alta del color o de la escalera
				
				
			}
			
		}
	
	
	
	*/
	
	
	
	
}
