package pr1.util.mesas;

import java.util.ArrayList;

import pr1.negocio.cartas.carta.Carta;
import pr1.util.ParTipo;


/**
 * 
 * @author victor
 * Estructura que permite agrupar conjuntamente las cartas de un jugador y la de las mesa
  */
public class CartasJugador
{
	ParTipo<Carta>  cartasJugador;// cada jugador tiene 2 cartas en la mano 
	ArrayList<Carta> comun;// = new ArrayList<Carta>();//sera de longitud 3 a 5
	
	
	public CartasJugador(ParTipo<Carta> cartasJugador,ArrayList<Carta> comun )
	{
		this.comun= comun;
		this.cartasJugador=cartasJugador;
	}
	
	public ArrayList<Carta> dameCartasComunes()
	{
		return comun;
	}
	
	public ParTipo<Carta> dameCartasJugador()
	{
		return cartasJugador;
	}
	
	public ArrayList<Carta> dameManosJugador()
	{
		ArrayList<Carta> manos = new ArrayList<Carta>();
		
		manos.addAll(comun);
		manos.add(cartasJugador.getElem1());
		manos.add(cartasJugador.getElem2());
		
		return manos;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(cartasJugador.toString());
		sb.append("\n" );
		sb.append(comun.toString());
		sb.append("\n" );
		
		
		
		return  sb.toString(); 
	}
	
}
