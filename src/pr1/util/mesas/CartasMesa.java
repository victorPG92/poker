package pr1.util.mesas;
/**
 * 
 * @author victor
 * Estructura que permite agrupar conjuntamente las cartas de todos los jugadores de la partida  y las de las mesa
  */
import java.util.ArrayList;

import pr1.negocio.cartas.carta.Carta;
import pr1.util.ParTipo;

public class CartasMesa
{

	ArrayList<Carta> comun;// = new ArrayList<Carta>();//sera de longitud 3
	ArrayList<ParTipo<Carta>> cartasJugador;// = new ArrayList<ParTipo<Carta>>();
	
	public CartasMesa(ArrayList<Carta> comun, ArrayList<ParTipo<Carta>> cartasJugador)
	{
		this.comun= comun;
		this.cartasJugador=cartasJugador;
	}
	
	public ArrayList<Carta> dameCartasComunes()
	{
		return comun;
	}
	
	public ParTipo<Carta> dameCartasJugador(int i)
	{
		return cartasJugador.get(i);
	}
	
	public int numJug()
	{
		return cartasJugador.size();
	}
	
	public ArrayList<Carta> dameManosJugador(int i)
	{
		ArrayList<Carta> manos = new ArrayList<Carta>();
		manos.addAll(comun);
		ParTipo<Carta> cartasJug= cartasJugador.get(i);
		manos.add(cartasJug.getElem1());
		manos.add(cartasJug.getElem2());
		return manos;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Comun :   \t  " );
		sb.append(comun.toString());
		sb.append("\n" );
		int i=1;
		for(ParTipo<Carta> par : cartasJugador)
		{
			sb.append("Jugador " );
			sb.append(i );
			sb.append(": \t  " );//"\n"
			sb.append(par.toString());
			sb.append("\n" );
			i++;
		}
		
		return  sb.toString(); 
	}
	
	
	
	
}
