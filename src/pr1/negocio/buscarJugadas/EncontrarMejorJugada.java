package pr1.negocio.buscarJugadas;

import java.util.ArrayList;

import pr1.negocio.Mano.manos.Mano;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.comb.Combinaciones;


/**
 * 
 * @author victor
 * 
 * implementacion del problema de la mochila de 2 niveles (elijo solo las 2 que no entran )
 * sacar de 7 cartas 5 , que den la jugada mayor
 *
 */
public class EncontrarMejorJugada {
	
	
	private ArrayList<Carta> cartas;
	
	private ArrayList<Carta> manoTemp;
	//private int valor;
	//private int valorMejor;
	//private ArrayList<Carta> manoMejor;
	private Mano manoMejor;//cambiado
	
	
	
	
	public EncontrarMejorJugada(ArrayList<Carta> cartas)
	{
		if(cartas.size()>=5  && cartas.size()<=7)
		{
			this.cartas=cartas;
			//valorMejor = -1;
			manoMejor=null;
			buscar();
						
		}
			
		
	}
	
	/**
	 * Busco la mejor mano dado unas cartas
	 * @param cartas
	 */
	public void buscar()
	{
		//Combinaciones cmb = new Combinaciones(7, 5);
		Combinaciones cmb = new Combinaciones(cartas.size(), 5);
		
		ArrayList<ArrayList<Integer>> combinaciones = cmb.dameTodasLasCombinaciones();
		
		for(ArrayList<Integer> indices : combinaciones)
		{
			manoTemp = new  ArrayList<Carta >();
			for(Integer i : indices)
				manoTemp.add(cartas.get(i));

			SaberJugada sj = new SaberJugada(manoTemp);
			Mano m= sj.dameMano();
			
			
			if (manoMejor==null) manoMejor=m;
			else
			{
				if(manoMejor.compareTo(m)==-1)
				{
					manoMejor=m;
				}
			}
			
			/*
			valor = sj.dameMano().dameTipo().getValor();
			
			if(valor > valorMejor) 
			{
				valorMejor = valor;
				manoMejor =  sj.dameMano();
			}*/
			
		}
	}

	
	//cambiado
	public Mano getManoMejor() {
		return manoMejor;
	}

	

	
	
	//METODO PRUEBA
	/*public static void main (String args[])
	{
		Mazo m = new Mazo();
		
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
		for(int i=0;i<7;i++)
			cartas.add(m.dameCartaAleatoria());
		
		System.out.println(cartas);
		EncontrarMejorJugada e = new EncontrarMejorJugada(cartas);
		Mano manoMejor = e.getManoMejor();
		System.out.println(manoMejor);
	}*/









































	/*
	public EncontrarMejorJugada(ArrayList<Carta> manos)
	{
		if(manos.size()==7)
		{
			this.manos=manos;
			elegir = new boolean[7];
			
			
			for(int i=0;i<7;i++)
				for(int j=0;j<7;j++)
				{
					manoTemp = new ArrayList<Carta>();
					for(int k=0;k<7;k++)
					{
						if(k!= i && k != j) 
						{
							elegir[k]=true;
							manoTemp.add(manos.get(k));
							
							
						}
						else 	elegir[k]=false;
					}
					
					SaberJugada sj = new SaberJugada(manoTemp);
					valor = sj.dameMano().dameTipo().getValor();
					
					if(valor > valorMejor) 
					{
						valorMejor = valor;
						manoMejor = manoTemp;
					}
					
					
				}
			
		}
	}*/
	

}
