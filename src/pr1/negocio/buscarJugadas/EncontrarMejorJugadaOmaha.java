package pr1.negocio.buscarJugadas;

import java.util.ArrayList;

import pr1.negocio.Mano.manos.Mano;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.ParTipo;
import pr1.util.comb.CombinacionesMultiples;

public class EncontrarMejorJugadaOmaha 
{

	
	private ArrayList<Carta> cartasJug;
	private ArrayList<Carta> cartasComunes;
	
	private ArrayList<Carta> manoTemp;
	
	private Mano manoMejor;//cambiado
	     
	public EncontrarMejorJugadaOmaha(ArrayList<Carta> cartasJug,ArrayList<Carta> cartasComunes)
	{
		
		/*
		 * mano de Omaha se forma con exactamente 2 cartas propias y exactamente 3 cartas comunes.
		 *  Dadas 4 cartas propias y 3/4/5 cartas comunes, indica la mejor jugada y los posibles draws.
		 */
            
                 
		if(cartasJug.size()==4  && cartasComunes.size()<=5  && cartasComunes.size()>=3)
		{
			this.cartasJug=cartasJug;
			this.cartasComunes=cartasComunes;
			
			buscar();
						
		}
			
		
	}
	
	/**
	 * Busco la mejor mano dado unas cartas
	 * @param cartas
	 */
	public void buscar()
	{
		
		CombinacionesMultiples cmb = new CombinacionesMultiples(cartasJug.size(), 2, cartasComunes.size(), 3);///
		
		ArrayList<ParTipo<ArrayList<Integer>>> combinaciones = cmb.dameTodasLasCombinaciones();//
		
		
		//System.out.println(combinaciones.size());// 6 * (4 3) = 6*4=24 correcto 
		for(ParTipo<ArrayList<Integer>> indices : combinaciones)///
		{
			manoTemp = new  ArrayList<Carta >();
			
			for(Integer i : indices.getElem1())
				manoTemp.add(cartasJug.get(i));
			
			for(Integer i : indices.getElem2())//
				manoTemp.add(cartasComunes.get(i));///

			SaberJugada sj = new SaberJugada(manoTemp);
			//System.out.println(manoTemp);
			Mano m= sj.dameMano();
			
			//System.out.println(m);
			
			//comparo manos 
			if(manoMejor==null)						manoMejor = m;
			else if (manoMejor.compareTo(m)==-1)	manoMejor =  sj.dameMano();
			
			
		}
	}

	
	//cambiado
	public Mano getManoMejor() {
		return manoMejor;
	}

	


	
	/*
	//METODO PRUEBA
	public static void main (String args[])
	{
		Mazo m = new Mazo();
		
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
		for(int i=0;i<7;i++)
			cartas.add(m.dameCartaAleatoria());
		
		System.out.println(cartas);
		EncontrarMejorJugada e = new EncontrarMejorJugada(cartas);
		Mano manoMejor = e.getManoMejor();
		System.out.println(manoMejor);
	}
*/
	
}
