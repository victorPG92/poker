package poker.negocio.dtos;



/**
 * Estructra que almacena una mano de rango y la prioridad que tiene en un ranking 
 * @author victor
 *
 */
public class ManoPrio implements Comparable<ManoPrio>
{
	private ManoRango mano;
	private double prio;
	
	
	public ManoPrio(ManoRango mano, Double prio) 
	{
		super();
		this.mano = mano;
		this.prio = prio;
	}


	public ManoRango getMano() {
		return mano;
	}


	public void setMano(ManoRango mano) {
		this.mano = mano;
	}


	public double getPrio() {
		return prio;
	}


	public void setPrio(double prio) {
		this.prio = prio;
	}


	@Override
	public int compareTo(ManoPrio mp)
	{
		int r=Double.compare(prio,mp.prio);
		if(r==0) r = -this.mano.compareTo(mp.mano);
		
		/*if(r==0)
		{
			r=1;
			System.out.println(this+" igual a "+ mp );
			
		}*/
		return r;
	}
	
	
	public String toString()
	{
		return mano.toString() + " "+ prio;
		
		
	}
	
	 
	
	
	
}
