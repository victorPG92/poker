package poker.negocio.algoritmos.buscarjugadas;

import java.util.ArrayList;

import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.cartas.Palo;
import poker.negocio.dtos.manos.Mano;
import poker.negocio.dtos.manos.ManoEnum;
import poker.negocio.dtos.manos.fact.FactoriaMano;
import poker.negocio.util.ordenar.OrdenarCartas;

/**
 * 
 * @author victor
 * Dadas 5 cartas, permite saber que mano  disponemos
 *
 */
public class SaberJugada 
{
	
	private ArrayList<Carta> cartas;
	
	private boolean hayPareja;
	private boolean hayDoblePareja;
	private boolean hayTrio;
	private boolean hayFull;
	private boolean hayPoker;
	private boolean hayColor;
	private boolean hayEscalera;
	private boolean hayEscaleraColor;
	
		
	private int hc1;
	
	@SuppressWarnings("unused")
	private int hc2;
	
	
	
	private Mano mano;
	
	
	
	public SaberJugada(ArrayList<Carta> manos)
	{
		if(manos.size()==5)
		{
			this.cartas=manos;
			
			hayPareja=false;
			hayTrio=false;
			hayPoker=false;
			hayColor=false;
			hayEscalera=false;
			
			
			
			comprobarIguales();
			comprobarColor();
			
			if(!(hayPareja || hayTrio || hayPoker))//ya calculado 
				comprobarEscalera();
			
			
			if(hayPareja && hayTrio) 	hayFull=true;
			if(hayEscalera && hayColor) hayEscaleraColor=true;
			
			//System.out.println("parsea  algo con  de "+hc1+" y "+ hc2) ;
			
			FactoriaMano f = new FactoriaMano();
			
			//metodo antiguo
			/*
			if(hayEscaleraColor)	mano = f.creaMano(ManoEnum.straight_flush, 	hc1,hc2);
			else if(hayPoker)		mano = f.creaMano(ManoEnum.four_of_a_kind, 	hc1,hc2);
			else if(hayFull)		mano = f.creaMano(ManoEnum.full_house, 		hc1,hc2);
			else if(hayColor)		mano = f.creaMano(ManoEnum.flush, 			hc1,hc2);
			else if(hayEscalera)	mano = f.creaMano(ManoEnum.straight, 		hc1,hc2);
			else if(hayTrio)		mano = f.creaMano(ManoEnum.three_of_a_kind, hc1,hc2);
			else if(hayDoblePareja)	mano = f.creaMano(ManoEnum.two_pair, 		hc1,hc2);
			else if(hayPareja)		mano = f.creaMano(ManoEnum.pair, 			hc1,hc2);
			else 					mano = f.creaMano(ManoEnum.high_card, 		hc1,hc2);
			*/
			
			//metodo mejor para comparar
			if(hayEscaleraColor)	mano = f.creaMano(cartas, 	ManoEnum.straight_flush);
			else if(hayPoker)		mano = f.creaMano(cartas, 	ManoEnum.four_of_a_kind);
			else if(hayFull)		mano = f.creaMano(cartas, 		ManoEnum.full_house);
			else if(hayColor)		mano = f.creaMano(cartas, 			ManoEnum.flush);
			else if(hayEscalera)	mano = f.creaMano(cartas, 		ManoEnum.straight);
			else if(hayTrio)		mano = f.creaMano(cartas, ManoEnum.three_of_a_kind);
			else if(hayDoblePareja)	mano = f.creaMano(cartas, 		ManoEnum.two_pair);
			else if(hayPareja)		mano = f.creaMano(cartas, 			ManoEnum.pair);
			
			//else if(proyectoEscalera)		mano = f.creaMano(cartas, 			ManoEnum.proyectoEscalera);
			//else if(proyectoEscalera)		mano = f.creaMano(cartas, 			ManoEnum.proyectoEscalera);
			//else if(proyectoColor)		mano = f.creaMano(cartas, 			ManoEnum.proyectoColor);
						
			else 					mano = f.creaMano(cartas, 		ManoEnum.high_card);
			
		}
		else System.err.println("Mano mal hecha");
	}
	
	
	
	/**
	 * Comprueba si existen cartas de misma numeracion
	 * el objetivo es saber si tenemos pareja, trio ,full o poker,
	 */
	public void comprobarIguales()
	{
		int n;
		int i=0;
		for(Carta c : cartas)
		{
			
			n= c.getNum();
			if(n!=hc1)
			{
				i=1;
				for(Carta c2 : cartas)
				{
					if(c!=c2) // mismo objeto, no con equals
					{
						if(c2.getNum()==n)i++;
					}
					
					
				}
				
				if(i==2)
				{
					if(!hayPareja ) //!hayTrio puesto despues de que full no coja bien el valor de trio y pareja
					{
						hayPareja=true;
						if(!hayTrio)hc1 = c.getNum();
						else 		hc2 = c.getNum();
						
					}
					else if(hayPareja && c.getNum()!=hc1) //
					{
						
						hayDoblePareja=true;
						int hc = c.getNum();
						if(hc ==1 || (hc > hc1  && hc1!=1))
						{
							hc2=hc1;
							hc1=hc;
						}
						else //if(hc <= hc1)
							hc2=hc;
						
						//System.out.println("doble pareja de "+hc1 +" y "+ hc2);
						
					}
					/*else
					{
						hayPareja=true;
						hc1 = c.getNum();
					}*/
					
					
				}
				else if(i == 3 )
				{	
					hayTrio=true;
					if(hayPareja)hc2=hc1;
					hc1= c.getNum();
				}
				else if(i == 4 ){	hayPoker=true;hc1= c.getNum();}
			}
		}
		
	}
	
	/**
	 * Comprueba si las cartas son del mismo palo
	 * el objetivo es saber si tenemos color (se usa para la escalera de color)
	 */
	public void comprobarColor()
	{
		
		boolean posible = true;
		int max=0;
		int i=0;
		
		Palo p = cartas.get(0).getPalo();
		
		for(Carta c : cartas)
		{
			
			if(!c.getPalo().equals(p))
			{
				
				posible=false;
				break;
			}
			else
			{
				i++;
				if(c.getNum()>max) max=c.getNum();
			}
		}
		
		if(posible && i==5)
		{
			hc1=max;
			hayColor=true;
			//System.out.println("color con "+hc1);
		}
		
		/*if(i==4)
		{
			hc1=max;
			proyectoColor=true;
			//System.out.println("color con "+hc1);
		}*/
			
		
	}
	
	/*
	public void comprobarEscalera()
	{
		
		ArrayList<Integer> esc = new ArrayList<Integer>();
		int max=0;
		
		for(Carta c : cartas)
		{
			if(esc.isEmpty()){esc.add(c.getNum());if(c.getNum()>max) max=c.getNum();}
			else
			{
				int j= c.getNum();
				if		(j== esc.get(0)-1)				{esc.add(0, j);if(c.getNum()>max) max=c.getNum();}
				else if	(j== esc.get(esc.size()-1)+1)	{esc.add(j);if(c.getNum()>max) max=c.getNum();}
				else 									break;
			}
			
			
		}
		
		if(esc.size()==5)
		{
			//System.out.println("escalera con "+hc1);
			hc1=max;
			hayEscalera=true;
		}
			
		
		
	}*/
	
	
	/**
	 * Comprueba si las cartas son consecutivas, 
	 * el objetivo es saber si tenemos escalera (se usa para la escalera de color)
	 */
	public void comprobarEscalera()
	{
		OrdenarCartas o = new OrdenarCartas();
		//ArrayList<Carta > cartasOrdenadas= o.ordenarPorEscalera(cartas);
                ArrayList<Carta > cartasOrdenadas= o.ordenarPorNumero(cartas);
		
		boolean as=false;
		
		//tomar los 1s como 14s
		int i=0;
		
		int esc=1;
		while(i<cartasOrdenadas.size()-1)
		{
			Carta c = cartasOrdenadas.get(i);
			Carta c1 = cartasOrdenadas.get(i+1);
			int n1= c.getNum();
			int n2 = c1.getNum();
			
			if(n1==1)
			{
				n1=14;
				as=true;
			}
			if(n2==1)
			{
				n2=14;
				as=true;
			}
						
			if(n1-n2 == 1	) esc++;
			
			i++;
		}
				
		if(esc==5)
		{
			hayEscalera=true;
			hc1=cartasOrdenadas.get(cartasOrdenadas.size()-1).getNum();
		}
		
		
		//tomar los ases como 1s
		if(as)
		{
			//System.out.println("Hay as");
			ArrayList<Carta> manoTemp1 = new ArrayList<Carta>();
			manoTemp1.addAll(cartasOrdenadas);
			esc=1;
			
                       
			// si la primera carta es un as, la muevo al final 
			Carta cAs= manoTemp1.get(0);
			if(cAs.getNum()==1)
			{
				manoTemp1.add(cAs);
				manoTemp1.remove(0);
				
			}
                        
			// System.out.println(manoTemp1);
                         i=0;
			while(i<manoTemp1.size()-1)
			{
                            Carta c = manoTemp1.get(i);
                            Carta c1 = manoTemp1.get(i+1);
                            int n1= c.getNum();
                            int n2 = c1.getNum();


                            if(n1-n2 == 1) esc++;

                            i++;
			}
					
			if(esc==5)
			{
				hayEscalera=true;
				hc1=manoTemp1.get(cartasOrdenadas.size()-1).getNum();
			}
		}
	}
	public void comprobarEscalera1()
	{
		/*
		OrdenarCartas o = new OrdenarCartas();
		ArrayList<Carta > cartasOrdenadas= o.ordenarPorNumero(cartas);
		
		boolean as=false;
		int esc =0;
		Carta c = cartasOrdenadas.get(0);
		for(int i=1;i<cartasOrdenadas.size();i++)
		{
			int n1= c.getNum();
			c = cartasOrdenadas.get(i);
			int n2 = c.getNum();
			if(n1-n2 == 1	) esc++;   //if(n2-n1 == 1	) esc++;
			else 
			{
				if(n1==1)as=true;
				else break;
			}
		}
		
		if(esc==5)
		{
			hayEscalera=true;
			hc1=cartasOrdenadas.get(cartasOrdenadas.size()-1).getNum();
		}
		/*else if(esc==4)
		{
			proyectoEscalera=true;
			if(as)
				hc1=13;
		}*/
	}
	
	
	public Mano dameMano()
	{
		return mano;
	}
	
	
	
	
	
	/*
	public void comprobarOpenEnded() // 4 consecutivas
	{	
	}*/
	
		
}
