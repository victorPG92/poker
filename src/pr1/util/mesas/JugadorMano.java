package pr1.util.mesas;

import pr1.negocio.Mano.manos.Mano;

public class JugadorMano implements Comparable<JugadorMano>
{

	private int i;
	private Mano m;
	public JugadorMano(int i, 	Mano m)
	{
		this.i=i;
		this.m=m;
	}
	
	public String toString()
	{
		return "J"+i +": "+ m.manoReducida() + " ("+ m.toString() +")";
	}

	
	

	@Override
	public int compareTo(JugadorMano o) 
	{
		if(m==null) return -1;
		
		int r= m.compareTo(o.m);
		if(r==0) r = Integer.compare(this.i, o.i);
		return r;
	
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	public Mano getMano() {
		return m;
	}
	public void setM(Mano m) {
		this.m = m;
	}
}
