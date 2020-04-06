package pr4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pr1.negocio.Mano.manos.Mano;
import pr1.negocio.buscarJugadas.EncontrarMejorJugada;
import pr1.negocio.cartas.carta.Carta;
import pr4.presentacion.ventanas.VentanaJuegoConAlgoritmo;

public class MesaJuegoCaribeanConAlgoritmo extends MesaJuegoCaribeanNormal {
	
	private static MesaJuegoCaribeanConAlgoritmo inst;
	
	private MazoOpt mazo;
	
	public static boolean apostarInicial = true;
	public static boolean apostarFlop = true;
	public static boolean apostarTurn = true;
	public static boolean apostarRiver = true;

	//ira a constantes
	public final static double probFlop = 4.0/9.0;
	public final static double probTurn = 2.0/9.0;
	public final static double probRiver = 1.0/9.0;
	
	public final static int n = (int)Math.pow(10, 4);
	public final static int intervalo = 50;
	
	//public final static int MARGEN = DINERO/10;
	
	public static MesaJuegoCaribeanConAlgoritmo dameInst()
	{
		
		if(inst==null) 
		{
			
			inst= new MesaJuegoCaribeanConAlgoritmo();
		
		}
		
		return inst;	
	
	}
	
	public MesaJuegoCaribeanConAlgoritmo() {
		
		super();
		
		//mazo = new MazoOpt1(); //elegir entre mazo 1 y 2

	}
	
	public void inicia()
	{
		
		setComunes(new ArrayList<Carta>());
		
		mazo = new MazoOpt1(); //elegir entre mazo 1 y 2
		
	}
	
	public void apuestaInicial()
	{
		
		inicia(); //tengo que hacer un inicia despues de valorar OJO con esto no olvidar
		
		setEstado(getEstado() + 1);
		
		setManoJugador(null);
		setManoBanca(null);
		
		//apuesta inicial
		getJ().apostar(APUESTA_INICIAL);
		
		//reparte cartas
		setBanca(mazo.dameNCartas(2));
		//System.out.println(banca.get(0).dameLetras());
		//System.out.println(banca.get(1).dameLetras() + "\n");
		getJ().setCartas(mazo.dameNCartas(2));
		//System.out.println(j.getCartas().get(0).dameLetras());
		//System.out.println(j.getCartas().get(1).dameLetras());
		
		//System.out.println("estado: " + getEstado() + " --> Preflop");
		
	}
	
	public boolean apostarFlop() 
	{
		
		double equity =  dameProb();
		
		apostarFlop = equity > probFlop ;
		
		if(apostarFlop)
		{
		
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblProbabilidad().setText("Equity = " + equity + " > " + "(4/9)" + " : robot decidió apostar el flop");
			setEstado(2);
			
			getJ().apostar(APUESTA_FLOP);
			getComunes().addAll(mazo.dameNCartas(3));
			
		} else {
			
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblProbabilidad().setText("Equity = " + equity + " <= " + "(4/9)" + " : robot decidió abandonar en el preflop");
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblProbabilidad().setVisible(true);

		}
		
		return apostarFlop;
		
	}

	public boolean apostarTurn() {
		
		double equity =  dameProb();
		
		apostarTurn = equity > probTurn ;
		
		if(apostarTurn)
		{
			
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblProbabilidad().setText("Equity = " + equity + " > " + "(2/9)" + " : robot decidió apostar el turn");
			setEstado(3);
			
			getJ().apostar(APUESTA_TURN);
			getComunes().add(mazo.dameCartaAleatoria());
		
		} else {
			
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblProbabilidad().setText("Equity = " + equity + " <= " + "(2/9)" + " : robot decidió abandonar en el flop");
			
		}
		
		return apostarTurn;
		
	}

	public boolean apostarRiver()
	{
		
		double equity =  dameProb();
		
		apostarRiver = equity > probRiver ;
		
		if(apostarRiver)
		{
			
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblProbabilidad().setText("Equity = " + equity + " > " + "(1/9)" + " : robot decidió apostar el river");
			setEstado(4);
			
			getJ().apostar(APUESTA_RIVER);
			getComunes().add(mazo.dameCartaAleatoria());
			
		} else {
			
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblProbabilidad().setText("Equity = " + equity + " <= " + "(1/9)" + " : robot decidió abandonar en el turn");
			
		}
		
		return apostarRiver;
		
	}
	
	public void valorar()
	{
		
		Mano manoRobot=null;
		Mano manoBanca=null;
		
		//saber si ganamos o no:
		//coger las cartas
		ArrayList<Carta> cartasJugador= getJ().getCartas();
		getBanca().addAll(getComunes());
		cartasJugador.addAll(getComunes());
		
		//valorar las cartas y obtener la mejor mano
		EncontrarMejorJugada emj = new EncontrarMejorJugada(cartasJugador);
		manoRobot= emj.getManoMejor();
		emj = new EncontrarMejorJugada(getBanca());
		manoBanca= emj.getManoMejor();
		
		VentanaJuegoConAlgoritmo.obtenerInstancia().getTxtManoRobot().setText(manoRobot.toString());
		VentanaJuegoConAlgoritmo.obtenerInstancia().getTxtManoBanca().setText(manoBanca.toString());
		
		int r = manoRobot.compareTo(manoBanca);
		if(r==-1)
		{
			
			getJ().setNumJugadasPerdidas(getJ().getNumJugadasPerdidas() + 1);
			getJ().perder(); //perdemos lo apostado
			//System.out.println("PERDISTE");
			VentanaJuegoConAlgoritmo.obtenerInstancia().getTxtNumManosPerdidas().setText(Integer.toString(getJ().getNumJugadasPerdidas()));
			VentanaJuegoConAlgoritmo.obtenerInstancia().getTxtNumManosPerdidas().setText(Integer.toString(getJ().getNumJugadasPerdidas()));
			VentanaJuegoConAlgoritmo.obtenerInstancia().getLblResultado().setText("     Gana banca - pierde robot " + VentanaJuegoConAlgoritmo.obtenerInstancia().getTxtBote().getText());
			JOptionPane.showMessageDialog(null, "        ROBOT PERDIO :(");
			FactSAImpJuegoConAlgoritmo.dameSA().actualizaVentana();
			
		}
		
		else 
		{
			if(r==0)
			{
				getJ().setNumJugadasEmpatadas(getJ().getNumJugadasEmpatadas() + 1);
				getJ().ganarBote();//recupera lo apostado
				//System.out.println("EMPATASTE");
				VentanaJuegoConAlgoritmo.obtenerInstancia().getTxtNumManosEmpatadas().setText(Integer.toString(getJ().getNumJugadasEmpatadas()));
				VentanaJuegoConAlgoritmo.obtenerInstancia().getLblResultado().setText("   Empate ");
				JOptionPane.showMessageDialog(null, "      ROBOT EMPATO ;)");
				FactSAImpJuegoConAlgoritmo.dameSA().actualizaVentana();
				
			}
			else if(r==1)
			{
				
				getJ().setNumJugadasGanadas(getJ().getNumJugadasGanadas() + 1);
				VentanaJuegoConAlgoritmo.obtenerInstancia().getTxtNumManosGanadas().setText(Integer.toString(getJ().getNumJugadasGanadas()));
				
				int valorMano = manoRobot.dameTipo().getValor();
				int valorTrio = 3;
				if(valorMano < valorTrio) {
					getJ().ganarBote(PEOR_TRIO); 
					//System.out.println("GANASTE PEOR TRIO");
					VentanaJuegoConAlgoritmo.obtenerInstancia().getLblResultado().setText("   Gana robot - 5 € (apuesta) + 4 € (ganancia)");
					JOptionPane.showMessageDialog(null, "   ROBOT GANO CON UNA MANO PEOR QUE UN TRIO :)");
					FactSAImpJuegoConAlgoritmo.dameSA().actualizaVentana();
					
				} else {
					getJ().ganarBote(MEJOR_TRIO);
					//System.out.println("GANASTE MEJOR TRIO");
					VentanaJuegoConAlgoritmo.obtenerInstancia().getLblResultado().setText("   Gana robot - 5 € (apuesta) + 5 € (ganancia)");
					JOptionPane.showMessageDialog(null, "   ROBOT GANO CON UNA MANO MEJOR QUE UN TRIO :)");
					FactSAImpJuegoConAlgoritmo.dameSA().actualizaVentana();
					
				}
					
			}
			
			//return true;
		}
		
		VentanaJuegoConAlgoritmo.obtenerInstancia().repaint();

		//System.out.println("estado: " + getEstado() + " --> Showdown");
		
	}
	
	
	

	
	/**
	 * Devuelve la equity del  jugador(robot en este caso), respecto a la banca(aleatoria)
	 
	 * @return
	 */
	public double dameProb()
	{
		int cont=0;
		//int empate=0;
		ArrayList<Carta> jug= getJ().getCartas();
			
		int NUM_PRUEBAS = 100; //cambiar
		for(int i=0;i< NUM_PRUEBAS;i++)
		{
			
			ArrayList<Carta> cartasBanca= new ArrayList<Carta>();
			ArrayList<Carta> cartasRobot= new ArrayList<Carta>() ;
								 
			cartasRobot.addAll(jug);
			//las guardo, para devolverlas al mazo
			ArrayList<Carta> aleatoriasBanca = mazo.dameNCartas(2);//para simular
			cartasBanca.addAll(aleatoriasBanca);
			
			cartasRobot.addAll(getComunes());
			cartasBanca.addAll(getComunes());
			
			int restantes=5-getComunes().size();
			ArrayList<Carta> aleatorias = mazo.dameNCartas(restantes);
					
			cartasRobot.addAll(aleatorias);
			cartasBanca.addAll(aleatorias);
				
			/*System.out.println("num cartasllooojoihj comunes "+ getComunes().size());
			System.out.println("num cartas banca "+ cartasBanca.size());
			System.out.println("num cartas jug "+ cartasJug.size());*/
			
			EncontrarMejorJugada mejorJugador= new EncontrarMejorJugada(cartasRobot);
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
	 * Al perder, el jugador(robot en este caso) pierde lo que ha apostado.
	 */
	public void retirarse()
	{
		getJ().perder();
	}
	
	public void reinicia() 
	{
		mazo = new MazoOpt1();
	
		FactSAImpJuegoConAlgoritmo.dameSA().getM().getComunes().clear();
		FactSAImpJuegoConAlgoritmo.dameSA().getM().getBanca().clear();
		FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().getCartas().clear();
		
		FactSAImpJuegoConAlgoritmo.dameSA().getM().setEstado(0);
		FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().setBet(0);
		
		apostarInicial = true;
		apostarFlop = true;
		apostarTurn = true;
		apostarRiver = true;
		
	}

	/*public static void main(String[] args)
	{
		
		MesaJuegoCaribeanConAlgoritmo.dameInst().simula();
		
		
	}*/
}

