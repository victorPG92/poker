package pr4;

import java.util.ArrayList;

import javax.swing.JOptionPane;





import poker.negocio.algoritmos.buscarjugadas.EncontrarMejorJugada;
import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.manos.Mano;
import pr4.presentacion.ventanas.VentanaJuegoConAlgoritmo;


public class Simular
{
	
	@SuppressWarnings("unused")
	private VentanaJuegoConAlgoritmo v;
	
	private Jugador j;
	//private String msj=""; 

	private ArrayList<Carta> banca; // cartas reales que tendr� la banca
	private ArrayList<Carta> comunes;
	private MazoOpt mazo;
	
	private boolean apostarInicial=true;
	private boolean apostarFlop=true;
	private boolean apostarTurn=true;
	private boolean apostarRiver=true;
	
	//constantes
	private final static int APUESTA_INICIAL=1;
	private final static int APUESTA_FLOP=2;
	private final static int APUESTA_TURN=1;
	private final static int APUESTA_RIVER=1;
	
	private static final int PEOR_TRIO = 4;
	private static final int MEJOR_TRIO = 5;
	
	//ira a constantes
	public final static double probFlop= 4.0/9.0;
	public final static double probTurn= 2.0/9.0;
	public final static double probRiver= 1.0/9.0;
	
	public  int n;//= (int)Math.pow(10, 4);
	//public final static int intervalo=50;

	public  int DETENER;
	public  int DINERO;//= (APUESTA_INICIAL+APUESTA_FLOP+ APUESTA_TURN + APUESTA_RIVER )*n;
	public  int MARGEN;
	
	
	//variables contadoras:
	private int contAbandonaPreFlop=0;
	private int contAbandonaFlop=0;
	private int contAbandonaTurn=0;
	//private int contSigue=0;
	private int contGana=0;
	private int contPierde=0;

	private int minimoBote=4;

	private int contEmpate;
	
	
	
	
	
	public Simular(int dinero, int interaciones, int detener)
	{
		this.DETENER=detener;
		this.n=interaciones;
		this.DINERO=dinero;
		this.MARGEN= DINERO/10;
		
		j = new Jugador(DINERO);
		banca = new ArrayList<Carta>();
		//v = VentanaJuegoConAlgoritmo.obtenerInstancia();
		
	}
	
	public void inicia()
	{
		
		comunes= new ArrayList<Carta>();
		mazo= new MazoOpt1(); //elegir entre mazo 1 y 2
		
	}

	public String simula()
	{
		
		String msj="Iniciamos:";
		msj=msj+"\nFondo inicial: "+ DINERO;
		//System.out.println("Fondo inicial: "+ DINERO);
		msj=msj+"\nnumero de iteraciones: "+ n;
		//System.out.println("Numero de iteraciones: "+ n);
		msj=msj+"\nFondo Actual del jugador - iteracion actual ";
		//System.out.println("Fondo Actual del jugador - iteracion actual ");
		for(int i=0;i< n  && j.getFondo()>=minimoBote;i++)
		//	for(int i=0;i<n/intervalo;i++)
		{
		//	for(int k=0;k<intervalo;k++)			{
				
				inicia();
				jugar();
				
			//}
				if ((i!=0) && ( i % DETENER == 0)) {
					if(j.getFondo()>=DINERO) 
						JOptionPane.showMessageDialog(null, "Van "+i+" manos y el resultado hasta ahora es una Estrategia CORRECTA");
					//else if (j.getFondo()>=(DINERO- MARGEN)) 
						//JOptionPane.showMessageDialog(null, "Van "+i+" manos y el resultado hasta ahora es una Estrategia en el margen");
					else //if(j.getFondo()< (DINERO- MARGEN)) 
						JOptionPane.showMessageDialog(null, "Van "+i+" manos y el resultado hasta ahora es una Estrategia MALA");

				}
			msj=msj+"\nFondo actual del jugador: " + Integer.toString(j.getFondo())+" - "+(i+1);
			//System.out.println("Fondo actual del jugador: " + Integer.toString(j.getFondo())+" - "+(i+1));
			
		}
		
		if(j.getFondo()>=DINERO) {
			//System.out.println("Estrategia CORRECTA ");
			msj=msj+"\nEstrategia CORRECTA ";
		}
		else if(j.getFondo()>=(DINERO- MARGEN)) {
			//System.out.println("Estrategia en el margen ");
			msj=msj+"\nEstrategia en el margen";
		}
		else if(j.getFondo()< (DINERO- MARGEN)) {
			//System.out.println("Estrategia MALA ");
			msj=msj+"\nEstrategia MALA";
		}
		
		
		JOptionPane.showMessageDialog(null, "Estadisticas:\n"
				+ "victorias: " + contGana + "\n"+
				"derrotas al final: " + contPierde + "\n"+ 
				"empates al final: " + contEmpate + "\n"+ 
				"abandona antes del flop: " + contAbandonaPreFlop + "\n"+
				"abandona antes del turn: " + contAbandonaFlop +"\n"+
				"abandona antes del river: " + contAbandonaTurn 
				
				) ;
		
		return msj;
		
		
		
	}
	
	public void jugar()
	{
		
		Mano manoJugador=null;
		Mano manoBanca=null;
		
		//apuesta inicial
		j.apostar(APUESTA_INICIAL);
		banca = mazo.dameNCartas(2);
		j.setCartas(mazo.dameNCartas(2));
		
		//v.getCanvas().setCartasJugador(j.getCartas());
		//v.getCanvas().setCartasBanca(banca);
		
		apostarFlop= dameProb() > probFlop ;
		if(apostarFlop)
		{
			j.apostar(APUESTA_FLOP);
			comunes.addAll(mazo.dameNCartas(3));
			
			apostarTurn= dameProb() > probTurn ;
			if(apostarTurn)
			{
				j.apostar(APUESTA_TURN);
				comunes.add(mazo.dameCartaAleatoria());
				
				apostarRiver= dameProb() > probRiver ;
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
						contPierde++;
						//return false;
					}
					
					else 
					{
						if(r==0)
						{
							contEmpate++;
							j.ganarBote();//recupera lo apostado
						}
						else if(r==1)
						{
							contGana++;
							int valorMano=manoJugador.dameTipo().getValor();
							int valorTrio=3;
							if(valorMano<valorTrio)
								j.ganarBote(PEOR_TRIO);
							else
								j.ganarBote(MEJOR_TRIO);
						}
						
						//return true;
					}
					
				}
				else
				{
					contAbandonaTurn++;
				}
				
			}
			else
			{
				contAbandonaFlop++;
			}
		}
		else
		{
			contAbandonaPreFlop++;
		}
		//pierde lo que haya apostado en cualquier momento si se ha rendido
		if(! apostarFlop || ! apostarInicial || !apostarRiver || !apostarTurn)
		{
			j.perder();
			//return false;
		}
		//return true;
		
		/*
		System.out.println("Mano de jugador: ");
		System.out.println(manoJugador);
		System.out.println("Mano de banca: ");
		System.out.println(manoBanca);
		System.out.println("Fondo final del jugador");
		System.out.println(j.getFondo());
		*/
		
	}
	
	/**
	 * Devuelve la equity del  jugador, respecto a la banca(aleatoria)
	 
	 * @return
	 */
	public double dameProb()
	{
		int cont=0;
		//int empate=0;
		ArrayList<Carta> jug= j.getCartas();
			
		int NUM_PRUEBAS = 100; //cambiar
		for(int i=0;i< NUM_PRUEBAS;i++)
		{
			
			ArrayList<Carta> cartasBanca= new ArrayList<Carta>();
			ArrayList<Carta> cartasJug = new ArrayList<Carta>() ;
								 
			cartasJug.addAll(jug);
			//las guardo, para devolverlas al mazo
			ArrayList<Carta> aleatoriasBanca = mazo.dameNCartas(2);//para simular
			cartasBanca.addAll(aleatoriasBanca);
			
			cartasJug.addAll(comunes);
			cartasBanca.addAll(comunes);
			
			int restantes=5-comunes.size();
			ArrayList<Carta> aleatorias = mazo.dameNCartas(restantes);
					
			cartasJug.addAll(aleatorias);
			cartasBanca.addAll(aleatorias);
			
			/*
			System.out.println("num cartas comunes "+ comunes.size());
			System.out.println("num cartas banca "+ cartasBanca.size());
			System.out.println("num cartas jug "+ cartasJug.size());
			*/
			
			EncontrarMejorJugada mejorJugador= new EncontrarMejorJugada(cartasJug);
			EncontrarMejorJugada mejorBanca= new EncontrarMejorJugada(cartasBanca);
			
			if(mejorJugador.getManoMejor().compareTo(mejorBanca.getManoMejor())>=0) 
				cont++;	
			
			//devuelvo las cartas aleatorias, al mazo
			mazo.insertaCarta(aleatorias);
			mazo.insertaCarta(aleatoriasBanca);
		}
		
		return (double)cont/ NUM_PRUEBAS; // Equity
		 		
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
		
		Simular jug= new Simular(500, 800,200);
		jug.simula();
		
	}
	
	
}
