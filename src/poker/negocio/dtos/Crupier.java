package poker.negocio.dtos;

import java.util.ArrayList;
import java.util.Random;

import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.cartas.Palo;
import poker.negocio.dtos.mazos.Mazo;
import poker.negocio.dtos.mesas.Board;
import poker.negocio.dtos.mesas.CartasJugador;
import poker.negocio.dtos.mesas.CartasMesa;
import poker.negocio.util.ParTipo;

/**
 * Estrcutura que reparte las cartas  con un mazo
 * @author victor
 *
 */
public class Crupier 
{

	private Mazo mazo ;
	
	public Crupier()
	{
		mazo = new Mazo();
	}
	
	/**
	 * Devuelve una unica carta
	 * @return
	 */
	public Carta  dameCarta()
	{
		Carta c = mazo.dameCartaAleatoria();
		this.pedirCarta(c);
		return c;
	}
	
	
	/**
	 * Por definicion en el juego, una mano se compone de 5 cartas 
	 * @return
	 */
	public ArrayList<Carta>  dameMano()
	{
		return dameCartas(5);
	}
	
	/**
	 * Devuelve n cartas aleatorias
	 * @return
	 */
	public ArrayList<Carta>  dameCartas(int n)
	{
		ArrayList<Carta> mano = new ArrayList<Carta>();
		
		for(int i=0;i<n;i++)
			mano.add(dameCarta());
		
		return mano;
	}
	
	/**
	 * Por definicion en el juego, una mano de un jugador se compone de 2 cartas 
	 * @return
	 */
	public ArrayList<Carta>  dameManoJugador()
	{
		return dameCartas(2);
	}
	
	/**
	 * Devuelve una mano perteneciente a un rango dado;
	 * @param rango
	 * @return ParTipo<Carta>
	 */
	public ParTipo<Carta>  dameManoJugadorRango(Rango rango) // ArrayList<Carta>
	{
		
		//veo de que manos dispongo
		ArrayList<ManoRango> cartasRango = rango.dameManos();
		Random r = new Random();
			
		ParTipo<Carta> mano=null;
		
		while(cartasRango !=null && !cartasRango.isEmpty() && mano==null)
		{
			// entre esas manos, escojo una al azar
			int index= r.nextInt(cartasRango.size());
			ManoRango mr = cartasRango.get(index);
			
			//la mano escogida , la trasnformo si puedo en dos cartas 
			ArrayList<ParTipo<Carta>> manosPosibles= dameParesPosiblesManoRango(mr);
			
			if(!manosPosibles.isEmpty())
			{
				int j= r.nextInt(manosPosibles.size());
				mano= manosPosibles.get(j);
				
				//descarto las cartas del mazo
				this.pedirCarta(mano.getElem1());
				this.pedirCarta(mano.getElem2());
			}
			
		}
				
		return mano;
		
	}
	
	public CartasJugador dameCartasJugador(int numComunes)
	{
		CartasJugador m = null;
		if(numComunes>=3 && numComunes <=5)
		{
			ParTipo<Carta> cartasJug = new ParTipo<Carta>( dameCarta(), dameCarta());
			ArrayList<Carta> cartasComunes = new ArrayList<Carta>();
			for(int i=0; i< numComunes;i++)
			{
				cartasComunes.add(dameCarta());
			}
			
			m = new CartasJugador(cartasJug,cartasComunes );
		}
		
		return m;
	}
	
	public CartasMesa dameCartasMesa(int numJug,int numComunes )
	{
		CartasMesa m = null;
		if(numJug >=2 && numJug <=9 && numComunes>=3 && numComunes <=5)
		{
			//cartas comunes
			ArrayList<Carta> cartasComunes = new ArrayList<Carta>();
			for(int i=0; i< numComunes;i++)
			{
				cartasComunes.add(dameCarta());
			}
			
			
			
			ArrayList<ParTipo<Carta>> cartasJugadores = new ArrayList<ParTipo<Carta>>();
			for(int jug=0; jug<numJug;jug++)
			{
				ParTipo<Carta> cartasJug = new ParTipo<Carta>( dameCarta(), dameCarta());
				
				cartasJugadores.add(cartasJug);
				
				
			}
			
			m = new CartasMesa(cartasComunes,cartasJugadores );
		}
		
		return m;
	}
	
	
	public boolean estaCarta(Carta c )
	{
		return mazo.estaCarta(c);
	}
	
	/**
	 * Devuelve un board aleatorio de 5 cartas
	 * @return
	 */
	public Board dameBoardAleatorio()
	{
		return dameBoardAleatorio(5);
	}
	
	/**
	 * Devuelve un board aleatorio de flop -> 3 cartas
	 * @return
	 */
	public Board dameBoardAleatorioFlop()
	{
		return dameBoardAleatorio(3);
	}
	
	/**
	 * Devuelve un board aleatorio de n cartas
	 * @return
	 */
	public Board dameBoardAleatorio(int n)
	{
		Board b= new Board();
		
		@SuppressWarnings("unused")
		ArrayList<Carta> l = new ArrayList<Carta>();
		if(n>=3 && n<=5)
		{
			for(int i=0;i<n;i++)
			{
				Carta c= dameCarta();
				b.insertaCarta(c);
			}
			
		}
		return b; 
	}
	/**
	 * devuelve un board con las cartas dadas
	 * @param cartas
	 * @return
	 */
	public Board dameBoard(ArrayList<Carta> cartas)
	{
		Board b= new Board();
		b.insertaCartas(cartas);
		
		pedirCartas(cartas);
		
		return b;
	}
	
	/**
	 * MALO
	 * devuelve un board con las cartas dadas
	 * @param cartas
	 * @return
	 */
	public Board dameBoard(Carta carta)
	{
		Board b= new Board();
		b.insertaCarta(carta);
		
		pedirCarta(carta);
		
		return b;
	}
	
	/**
	 * HAsta que el board no esté completo, inserta cartas en el board
	 * @param b
	 */
	public void llenarBoardAleatorio(Board b)
	{
		while(!b.esCompleto())
		{
			Carta c= dameCarta();
			b.insertaCarta(c);
		}
	}
	
	/**
	 * quita del mazo la lista de cartas indicadas
	 * @param cartas
	 */
	public void pedirCartas(ArrayList<Carta> cartas)
	{
		for(Carta c : cartas)
			mazo.quitaCarta(c);
	}
	
	/**
	 * Quita la carta del mazo
	 * @param c
	 * @return
	 */
	public boolean pedirCarta(Carta c)
	{
		return mazo.quitaCarta(c);
	}
	
	/**
	 * Quita la carta del mazo
	 * @param c
	 * @return
	 */
	public Carta  pedirCarta(Palo p, int num)
	{
		Carta c= new Carta(num,p);
		if(mazo.quitaCarta(c)) return c;
		else return null;
	}
	
	/**
	 * inserto carta en el board
	 * @param b
	 * @param cartas
	 * @return
	 */
	public Board insertaBoard(Board b,ArrayList<Carta> cartas )
	{
		
		for(Carta c: cartas)
			b= insertaBoard(b,c);
		return b;
	}
	
	/**
	 * inserto carta en el board
	 * @param b
	 * @param cartas
	 * @return
	 */
	public Board insertaBoard (Board b,Carta carta )
	{
		
		if(!estaCarta(carta))return b;
		if(b==null)
			b=dameBoard(carta);
		else
		{
			if(b.insertaCarta(carta))
				pedirCarta(carta);
		}
		return b;
	}
	
	/**
	 * Devuelve todas las manos posibles de una mano rango
	 * @param mr
	 * @return ArrayList<ParTipo<Carta>>
	 */
	public ArrayList<ParTipo<Carta>> dameParesPosiblesManoRango(ManoRango mr)
	{
		ArrayList<ParTipo<Carta>>  a = new ArrayList<ParTipo<Carta>> ();
		if(mr.isPar())
		{
			for(int i=0;i<4;i++)
				for(int j=i+1;j<4;j++)
				{
					Palo p1= Palo.values()[i];
					Palo p2= Palo.values()[j];
					int n= mr.getN1();
					
					Carta c1=new Carta(n,p1);//this.pedirCarta(p1, n);
					Carta c2=new Carta(n,p2);// this.pedirCarta(p2, n);
					ParTipo<Carta> par = new ParTipo<Carta>(c1,c2);
					if(!estaCarta(c1) && !estaCarta(c2))
						a.add(par);
					
				}
				
		}
		else
		{
			if(mr.isSuited())
			{
				for(int i=0;i<4;i++)
					for(int n1=1;n1<14;n1++)
					{
						for(int n2=n1+1;n2<14;n2++)
						{
							Palo p= Palo.values()[i];
												
							Carta c1=new Carta(n1,p);//this.pedirCarta(p, n1);
							Carta c2=new Carta(n2,p);// this.pedirCarta(p, n2);
							ParTipo<Carta> par = new ParTipo<Carta>(c1,c2);
							if(!estaCarta(c1) && !estaCarta(c2))
								a.add(par);
						}
					}
			}
			else
			{
				
				
				for(int n1=1;n1<14;n1++)
				{
					for(int n2=n1+1;n2<14;n2++)
					{
						for(int i=0;i<4;i++)
						{
							for(int j=i+1;j<4;j++)
							{
								Palo p1= Palo.values()[i];
								Palo p2= Palo.values()[j];					
								Carta c1=new Carta(n1,p1);//this.pedirCarta(p1, n1);
								Carta c2=new Carta(n2,p2);// this.pedirCarta(p2, n2);
								ParTipo<Carta> par = new ParTipo<Carta>(c1,c2);
								if(!estaCarta(c1) && !estaCarta(c2))
									a.add(par);
							}
						}
					}
				}
				
			}
		}
		
		
		return a;
	}
	
	
	public Mazo getMazo() {
		return mazo;
	}

	private void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}

	public Crupier clonar()
	{
		
		Crupier c = new Crupier();
		Mazo m = this.mazo.clonar();
		
		c.setMazo(m);
		
		return c;
	}
	
	
}
