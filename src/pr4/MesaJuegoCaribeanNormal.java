package pr4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pr1.negocio.Mano.manos.Mano;
import pr1.negocio.buscarJugadas.EncontrarMejorJugada;
import pr1.negocio.cartas.Mazo;
import pr1.negocio.cartas.carta.Carta;
import pr4.presentacion.ventanas.VentanaJuegoNormal;

public class MesaJuegoCaribeanNormal 
{
	private static MesaJuegoCaribeanNormal inst;
	
	private Jugador j;
	private ArrayList<Carta> banca;
	private ArrayList<Carta> comunes;
	private Carta cartaTurn;
	private Carta cartaRiver;
	
	
	private Mazo mazo;
	private Mano manoJugador;
	private Mano manoBanca;
	
	
	@SuppressWarnings("unused")
	private boolean apostarInicial=true;
	@SuppressWarnings("unused")
	private boolean apostarFlop=true;
	@SuppressWarnings("unused")
	private boolean apostarTurn=true;
	@SuppressWarnings("unused")
	private boolean apostarRiver=true;
	
	private int estado;

	//constantes
	protected final int APUESTA_INICIAL=1;
	protected final int APUESTA_FLOP=2;
	protected final int APUESTA_TURN=1;
	protected final int APUESTA_RIVER=1;
	
	protected static final int PEOR_TRIO = 4;
	protected static final int MEJOR_TRIO = 5;
	
	public MesaJuegoCaribeanNormal()
	{
		
		j = new Jugador();
		mazo = new Mazo();
		banca = new ArrayList<Carta>();
		comunes = new ArrayList<Carta>();
		estado = 0;
	}
	
	/*
	public void jugar()
	{
		 apuestaInicial();
		if(apostarFlop)
		{
			apuestaFlop() ;
			if(apostarTurn)
			{
				apuestaTurn();
				if(apostarRiver)
				{
					apuestaRiver();
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
		
		
	}*/

	/**
	 * Al perder, el jugador pierde lo que ha apostado.
	 */
	public void retirarse()
	{
		j.perder();
	}

	public void apuestaInicial()
	{

		estado++;
		manoJugador=null;
		manoBanca=null;
		
		//apuesta inicial
		j.apostar(APUESTA_INICIAL);
		
		//reparte cartas
		banca= mazo.dameNCartas(2) ;
		//System.out.println(banca.get(0).dameLetras());
		//System.out.println(banca.get(1).dameLetras() + "\n");
		j.setCartas(mazo.dameNCartas(2));
		//System.out.println(j.getCartas().get(0).dameLetras());
		//System.out.println(j.getCartas().get(1).dameLetras());
		
		System.out.println("estado: " + estado + " --> Preflop");
		
	}

	public void apuestaFlop() 
	{
		estado++;
		j.apostar(APUESTA_FLOP);
		comunes.addAll(mazo.dameNCartas(3));
		
		System.out.println("estado: " + estado + " --> Flop");
	}

	
	public void apuestaTurn() {
		estado++;
		j.apostar(APUESTA_TURN);
		cartaTurn= mazo.dameCartaAleatoria();
		comunes.add(cartaTurn);
		
		System.out.println("estado: " + estado + " --> Turn");
	}

	
	public void apuestaRiver()
	{
		estado++;
		j.apostar(APUESTA_RIVER);
		cartaRiver=mazo.dameCartaAleatoria();
		comunes.add(cartaRiver);
		
		System.out.println("estado: " + estado + " --> River");
		
	}

	
	public void valorar()
	{
		estado++;
		
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
		
		VentanaJuegoNormal.obtenerInstancia().getTxtManoJugador().setText(manoJugador.toString());
		VentanaJuegoNormal.obtenerInstancia().getTxtManoBanca().setText(manoBanca.toString());
		
		int r= manoJugador.compareTo(manoBanca);
		System.out.println("MANO JUGADOR: " + manoJugador);
	
		if(r==-1)
		{
			j.setNumJugadasPerdidas(j.getNumJugadasPerdidas() + 1);
			j.perder(); //perdemos lo apostado
			System.out.println("PERDISTE");
			VentanaJuegoNormal.obtenerInstancia().getTxtNumManosPerdidas().setText(Integer.toString(j.getNumJugadasPerdidas()));
			VentanaJuegoNormal.obtenerInstancia().getLblResultado().setText("   Gana banca - pierde jugador " + VentanaJuegoNormal.obtenerInstancia().getTxtBote().getText());
			JOptionPane.showMessageDialog(null, "              PERDISTE :(");

		}
		
		else if(r==0)
		{
			j.setNumJugadasEmpatadas(j.getNumJugadasEmpatadas() + 1);
			j.ganarBote();//recupera lo apostado
			System.out.println("EMPATASTE");
			VentanaJuegoNormal.obtenerInstancia().getTxtNumManosEmpatadas().setText(Integer.toString(j.getNumJugadasEmpatadas()));
			VentanaJuegoNormal.obtenerInstancia().getLblResultado().setText("   Empate ");
			JOptionPane.showMessageDialog(null, "              EMPATASTE ;)");
			
			}
			else if(r==1)
			{
				
				j.setNumJugadasGanadas(j.getNumJugadasGanadas() + 1);
				VentanaJuegoNormal.obtenerInstancia().getTxtNumManosGanadas().setText(Integer.toString(j.getNumJugadasGanadas()));
				
				int valorMano = manoJugador.dameTipo().getValor();
				int valorTrio = 3;
				if(valorMano<valorTrio) {
					
					j.ganarBote(PEOR_TRIO);
					System.out.println("GANASTE PEOR TRIO");
					VentanaJuegoNormal.obtenerInstancia().getLblResultado().setText(" Gana jugador - 5 € (apuesta) + 4 € (ganancia)");
					JOptionPane.showMessageDialog(null, "   GANASTE CON UNA MANO PEOR QUE UN TRIO :)");
					
				} else {
					
					j.ganarBote(MEJOR_TRIO);
					System.out.println("GANASTE MEJOR TRIO");
					VentanaJuegoNormal.obtenerInstancia().getLblResultado().setText(" Gana jugador - 5 € (apuesta) + 5 € (ganancia)");
					JOptionPane.showMessageDialog(null, "   GANASTE CON UNA MANO MEJOR QUE UN TRIO :)");

					
				}
				
			}
		
		VentanaJuegoNormal.obtenerInstancia().repaint();
		System.out.println("estado: " + estado + " --> Showdown");
}

	
	public void perder() 
	{
	
		
	}

	
	public static MesaJuegoCaribeanNormal dameInst()
	{
		if(inst==null) inst= new MesaJuegoCaribeanNormal();
		return inst;	}
	public Jugador getJ() {
		return j;	}
	public void setJ(Jugador j) {
		this.j = j;	}
	public ArrayList<Carta> getBanca() {
	return banca;	}

	public void setBanca(ArrayList<Carta> banca) {
		this.banca = banca;	}
	public ArrayList<Carta> getComunes() {
		return comunes;	}
	public void setComunes(ArrayList<Carta> comunes) {
		this.comunes = comunes;	}
	public Carta getCartaTurn() {
		return cartaTurn;	}
	public void setCartaTurn(Carta cartaTurn) {
		this.cartaTurn = cartaTurn;	}
	public Carta getCartaRiver() {
		return cartaRiver;	}
	public void setCartaRiver(Carta cartaRiver) {
		this.cartaRiver = cartaRiver;	}

	public Mazo getMazo() {
		return mazo;
	}
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}

	public Mano getManoJugador() {
		return manoJugador;
	}

	public void setManoJugador(Mano manoJugador) {
		this.manoJugador = manoJugador;
	}

	public Mano getManoBanca() {
		return manoBanca;
	}

	public void setManoBanca(Mano manoBanca) {
		this.manoBanca = manoBanca;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void reinicia() 
	{
		mazo=new Mazo();
	
		FactSAImpJuegoNormal.dameSA().getM().getComunes().clear();
		FactSAImpJuegoNormal.dameSA().getM().getBanca().clear();
		FactSAImpJuegoNormal.dameSA().getM().getJ().getCartas().clear();
		
		FactSAImpJuegoNormal.dameSA().getM().setEstado(0);
		FactSAImpJuegoNormal.dameSA().getM().getJ().setBet(0);
		
	}
	
}


