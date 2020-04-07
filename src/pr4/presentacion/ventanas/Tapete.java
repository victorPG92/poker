package pr4.presentacion.ventanas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;

import poker.negocio.dtos.cartas.Carta;
import pr1.negocio.cartas.nombar.Nombrar;
import pr4.FactSAImpJuegoConAlgoritmo;
import pr4.FactSAImpJuegoNormal;


@SuppressWarnings("serial")
public class Tapete extends Canvas
{
	private int anchoTapete;
	private int altoTapete;
	private int anchoCarta;
	private int altoCarta;
	
	private ArrayList<Carta> cartasJugador;
	private ArrayList<Carta> cartasBanca;
//	private Carta turn;
	//private Carta river;
	private ArrayList<Carta> cartasComunes;	
	
	@SuppressWarnings("unused")
	private JLabel lblMano;
	
	private boolean mostrarBanca;
	
	public Tapete()
	{
		
		super();
		
		/*lblFlop = new JLabel("Stack Jugador");
		lblFlop.setBounds(150, 580, 89, 14);
		Canvas.
		add(lblFlop);*/
		
		
		inicializa();
		
	}
	
	
	
	
	public Tapete(ArrayList<Carta> cartasJugador,ArrayList<Carta> cartasBanca, ArrayList<Carta> cartasComunes) 
	{
		super();
		this.cartasJugador = cartasJugador;
		this.cartasBanca = cartasBanca;
		this.cartasComunes = cartasComunes;
	}




	public void inicializa()
	{
		setVisible(true);
		altoTapete= this.getHeight();
		anchoTapete= this.getWidth();
		anchoCarta = 60;
		altoCarta= (3*anchoCarta)/2;
		mostrarBanca=false;
		 
	}
	
	
/*
	public void repartir()
	{
		Mazo m = new Mazo(); 	
		cartas = m.dameNCartas(10);

	}
	*/
	@Override
	public void paint(Graphics g)
	{
		pintarFondo(g);
		pintarCartas(g);	
	}
	
	
	public void pintarFondo(Graphics g)
	{
		g.fillRect(0, 0,anchoTapete, altoTapete);
		Toolkit t= Toolkit.getDefaultToolkit();
		  // Image img = t.getImage("Fondo1.jpg"); //**cuidado con el .formato


	 Image	 img = t.getImage("Fondo1.jpg" );
		g.drawImage(img, 0, 0,anchoTapete,altoTapete, this);	
		//t.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/panelInfer.jpg"))); // NOI18N
	}
	
	public void pintarCartas(Graphics g)
	{
		pintarTodasCartas(g);
		
	}
	
	public void pintarCarta(Graphics g, int x, int y, Carta c)// CARTAS COMUNES
	{
		Toolkit t= Toolkit.getDefaultToolkit();
		Image img=t.getImage("reverso.png");
		
		if(c != null)
		{
			
			img = t.getImage(Nombrar.getInstancia().nombreFoto(c));
			
		}
			
		g.drawImage(img, x, y,anchoCarta,altoCarta, this); 
		
	}
	
	public void pintarCartaBanca(Graphics g, int x, int y, Carta c)// CARTAS COMUNES
	{
		Toolkit t= Toolkit.getDefaultToolkit();
		Image img=t.getImage("reverso.png");
		
		if(c != null)
		{
			
			
			//img=t.getImage("reverso.png");
			
			if(FactSAImpJuegoNormal.dameSA().getM().getEstado() == 4) {
				
				img=t.getImage(Nombrar.getInstancia().nombreFoto(c));
				
			} else if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 4) {
				
				img=t.getImage(Nombrar.getInstancia().nombreFoto(c));
				
			}
			//img=t.getImage(Nombrar.getInstancia().nombreFoto(c));
			
		}
			
		g.drawImage(img, x, y,anchoCarta,altoCarta, this); 
		
	}
	
	
	public void pintarTodasCartas(Graphics g) //***SEPARACION CARTAS COMUNES ( 10)
	{
		
		pintarCartasComunes(g);
		pintarCartasBanca(g);
		pintarCartasJugador(g);
		
	}
	
	public void pintarCartasJugador(Graphics g)
	{
		if(cartasJugador !=null && cartasJugador.size()==2)
		{
			int i=0;
			for(Carta c: cartasJugador)
			{
				pintarCarta(g, (anchoCarta  + 10)*i+15, 390, c);
				i++;
			}
		}
		else
		{
			for(int i=0;i<2;i++)
			{
				pintarCarta(g, (anchoCarta  + 10)*i+15, 200, null);
				
			}
		}
		
	}

	public void pintarCartasBanca(Graphics g) //***SEPARACION CARTAS COMUNES ( 10)
	{
		if(cartasBanca !=null && cartasBanca.size()==2)
		{
			int i=0;
			for(Carta c: cartasBanca)
			{
				pintarCartaBanca(g, (anchoCarta  + 10)*i+15, 280, c);
				i++;
			}
		}
		else
		{
			for(int i=0;i<2;i++)
			{
				pintarCartaBanca(g, (anchoCarta  + 10)*i+15, 0, null);
				
			}
		}
	}
	
	public void pintarCartasBancaViradas(Graphics g) //***SEPARACION CARTAS COMUNES ( 10)
	{
		if(cartasBanca !=null && cartasBanca.size()==2)
		{
			int i=0;
			for(Carta c: cartasBanca)
			{
				
				pintarCarta(g, (anchoCarta  + 10)*i+15, 280, c);
				i++;
			}
		}
		else
		{
			for(int i=0;i<2;i++)
			{
				pintarCarta(g, (anchoCarta  + 10)*i+15, 0, null);
				
			}
		}
	}
	
	public void pintarCartasComunes(Graphics g) //***SEPARACION CARTAS COMUNES ( 10)
	{
		
		for(int i=0;i<5;i++)
		{
			Carta c;
			
			try{
			 c= cartasComunes.get(i);
			}catch(Exception e)
			{
				c=null;
				
			}
			
			pintarCarta(g, (anchoCarta  + 10)*i+15, 50, c);
			
		}
	}
	
	public ArrayList<Carta> getCartasJugador(){
		return cartasJugador;	}
	public void setCartasJugador(ArrayList<Carta> cartasJugador) {
		this.cartasJugador = cartasJugador;	}
	public ArrayList<Carta> getCartasBanca() {
		return cartasBanca;	}
	public void setCartasBanca(ArrayList<Carta> cartasBanca) {
		this.cartasBanca = cartasBanca;	}
	public ArrayList<Carta> getCartasComunes() {
		return cartasComunes;	}
	public void setCartasComunes(ArrayList<Carta> cartasComunes) {
		this.cartasComunes = cartasComunes;	}
	public boolean isMostrarBanca() {
		return mostrarBanca;	}
	public void setMostrarBanca(boolean mostrarBanca) {
		this.mostrarBanca = mostrarBanca;	}




	public void setBounds(int x, int y, int altoTapete, int anchoTapete)
	{
		super.setBounds(x,y,altoTapete,anchoTapete);
		this.anchoTapete=altoTapete;
		this.altoTapete=anchoTapete;	
	}
}
