package pr1.negocio.Mano.manos;

import java.util.ArrayList;

import pr1.negocio.Mano.ManoEnum;
import pr1.negocio.cartas.carta.Carta;
import pr1.util.ordenar.OrdenarCartas;
import pr1.constantes.Constantes;


public class Pareja extends Mano
{
	
	
	
	
	public Pareja(ArrayList<Carta> mano )
	{
		
			
			tipo=ManoEnum.pair;
			ArrayList<Carta> manoOrd =  (new OrdenarCartas()).ordenarPorIguales(mano);
			this.cartas=manoOrd;
			
		
	}

	@Override
	public ManoEnum dameTipo() {
		
		return ManoEnum.pair;
	}
	
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append(Constantes.PAREJA);
		sb.append(" of ");
		sb.append(cartas.get(0).dameNombre());
		sb.append("s");	//\n
		return sb.toString();
		
		
	}
	
	

}
