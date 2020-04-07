package pr4;

import java.util.ArrayList;

import poker.negocio.algoritmos.buscarjugadas.EncontrarMejorJugada;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.manos.Mano;
import poker.negocio.dtos.mazos.Mazo;

public class JugadaPrueba
{

	
	private Jugador j;
	private ArrayList<Carta> banca;
	private ArrayList<Carta> comunes;
	private Mazo mazo;
	
	
	
	private boolean apostarInicial=true;
	private boolean apostarFlop=true;
	private boolean apostarTurn=true;
	private boolean apostarRiver=true;
	
	
	//constantes
	private final int APUESTA_INICIAL=1;
	private final int APUESTA_FLOP=2;
	private final int APUESTA_TURN=1;
	private final int APUESTA_RIVER=1;
	
	private static final int PEOR_TRIO = 4;
	private static final int MEJOR_TRIO = 5;
	
	
	
	JugadaPrueba()
	{
		
		j= new Jugador();
		mazo= new Mazo();
		banca= new ArrayList<Carta>();
		comunes= new ArrayList<Carta>();
	}
	
	
	public void jugar()
	{
		
		Mano manoJugador=null;
		Mano manoBanca=null;
		
		//apuesta inicial
		j.apostar(APUESTA_INICIAL);
		banca= mazo.dameNCartas(2);
		j.setCartas(mazo.dameNCartas(2));
		
		if(apostarFlop)
		{
			j.apostar(APUESTA_FLOP);
			comunes.addAll(mazo.dameNCartas(3));
			
			if(apostarTurn)
			{
				j.apostar(APUESTA_TURN);
				comunes.add(mazo.dameCartaAleatoria());
				
				
				if(apostarRiver)
				{
					j.apostar(APUESTA_RIVER);
					comunes.add(mazo.dameCartaAleatoria());
					
					
					//saber si ganamos o no:
					//coger las cartas
					ArrayList<Carta> cartasJugador= j.getCartas();
					banca.addAll(comunes);
					cartasJugador.addAll(comunes);
					
					//valorar las cartas y obtener la mejor mano
					EncontrarMejorJugada emj = new EncontrarMejorJugada(cartasJugador);
					manoJugador= emj.getManoMejor();
					emj = new EncontrarMejorJugada(banca);
					manoBanca= emj.getManoMejor();
					
					int r= manoJugador.compareTo(manoBanca);
					if(r==-1)
					{
						j.perder(); //perdemos lo apostado
					}
					
					else if(r==0)
					{
						j.ganarBote();//recupera lo apostado
					}
					else if(r==1)
					{
						int valorMano=manoJugador.dameTipo().getValor();
						int valorTrio=3;
						if(valorMano<valorTrio)
							j.ganarBote(PEOR_TRIO);
						else
							j.ganarBote(MEJOR_TRIO);
					}
					
				}
				
			}
		}
		//pierde lo que haya apostado en cualquier momento si se ha rendido
		if(! apostarFlop || ! apostarInicial || !apostarRiver || !apostarTurn)
			j.perder();
		
		
		System.out.println("Mano de jugador: ");
		System.out.println(manoJugador);
		System.out.println("Mano de banca: ");
		System.out.println(manoBanca);
		System.out.println("Fondo final del jugador");
		System.out.println(j.getFondo());
		
		
	}

	/**
	 * Al perder, el jugador pierde lo que ha apostado.
	 */
	public void retirarse()
	{
		j.perder();
	}

	public static void main(String[] args)
	{
		JugadaPrueba jug= new JugadaPrueba();
		jug.jugar();
		
	}
}
