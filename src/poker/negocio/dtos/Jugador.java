package poker.negocio.dtos;

import java.util.ArrayList;

import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.manos.Mano;
import pr4.presentacion.ventanas.VentanaIntroduccionEurosVirtualesParaJugador;

/**
 * Estructura jugador que contiene los datos, nombre, fondo, estadisticas,...
 * @author victor
 *
 */
public class Jugador {
	
	//Atributos
	
	private	String nombre; 	// Nombre del jugador

	private Mano manoJugador; //Mano del jugador
	private	int apuesta; //Apuesta que hace
	private int fondo; //Dinero total del que dispone el jugador
	private	int bet;		// apuesta que hace
	private	int numJugadasGanadas;
	private	int numJugadasPerdidas;
	private	int numJugadasEmpatadas;
	private	int numJugadasAbandonadas;
	
	public void setBet(int bet) {
		this.bet = bet;
	}

	//public static final int FONDO_INICIAL=10;
	private final String NOMBRE_DEFECTO= "jugador";
	
	private ArrayList<Carta> cartas; //cartas iniciales,despues se consigue la mano
	
	//Constructores
	
	public Jugador() 
	{
		
		nombre = NOMBRE_DEFECTO;
		fondo = Integer.parseInt(VentanaIntroduccionEurosVirtualesParaJugador.obtenerInstancia().getJtextfield().getText());
		
	}
	
	 public Jugador( int fondo)
	 {
		this.fondo = fondo;
	 }
	
	public Jugador(String nombre, Mano manoJugador,int apuesta, int fondo)
	{
		
		this.nombre = nombre;
		this.manoJugador = manoJugador;
		this.apuesta = apuesta;
		this.fondo = fondo;
		this.numJugadasGanadas = 0;
		this.numJugadasPerdidas = 0;
		this.numJugadasEmpatadas = 0;
		
	}
	
	//Metodos
	
	public boolean sePuedeApostar(int b) {
		
		return b<= fondo;
	
	}
	
	public void apostar(int b)
	{
		fondo -=b;
		bet +=b;
	
	}
	
	/*public boolean apostar(int b)
	{
		boolean sePuede=false;
		
		if(b<= fondo)
		{
			fondo -=b;
			bet +=b;
			sePuede=true;
		}
		return sePuede;
	}*/
	
	/*
	public boolean apostar(int cantidadApostada)
	{
		boolean seApuesta = false;
		
		if(cantidadApostada == 1) {
			
			if(fondo >= 1) {
				
				seApuesta=true;
				fondo -= 1;	
				
			}
			
		} else if(fondo == 2) {
			
			if(fondo >= 2) {
				
				seApuesta=true;
				fondo -= 1;	
				
			}
			
		}
		
		return seApuesta;
		
	}*/
	
	//Mutadores y accedentes
	
	public String getNombre() 
	{
		
		return nombre;
	
	}

	public void setNombre(String nombre) 
	{
		
		this.nombre = nombre;
	
	}
	
	public Mano getManoJugador() 
	{
	
		return manoJugador;
	
	}

	public void setManoJugador(Mano manoJugador) 
	{
		
		this.manoJugador = manoJugador;
	
	}

	public int getApuesta() 
	{
		
		return apuesta;
	
	}

	public void setApuesta(int apuesta) 
	{
		
		this.apuesta = apuesta;
	
	}
	
	public int getFondo() {
		return fondo;
	}

	public void setFondo(int fondo) 
	{
		
		this.fondo = fondo;
		
	}
	
/*
	public boolean all_in()
	{
		boolean sePuede=false;
		
		if(fondo>0)
		{
			bet +=fondo;
			fondo =0;
			sePuede=true;
		}
		return sePuede;
	}
	*/
	
	public void ganarBote()
	{
		
		fondo += bet;
		bet =0;
	}
	
	
	public void ganarBote(int b)
	{
		fondo +=b;
		fondo += bet;
		bet =0;
	}
	
	
	public void perder()
	{
		
		bet =0;
	}

	
	public boolean vivo()
	{
		return fondo >0;
	}
	
	/*
	public void reenganche(int r)
	{
		if(!vivo())
		{
			fondo=r;
		}
	}

*/

	public int getBet() 
	{
		
		return bet;
	
	}
		
	public ArrayList<Carta> getCartas()
	{
		
		return cartas;
		
	}

	public void setCartas(ArrayList<Carta> cartas) 
	{
		
		this.cartas = cartas;
	
	}
	
	public int getNumJugadasGanadas() 
	{
		
		return numJugadasGanadas;
	
	}

	public void setNumJugadasGanadas(int numJugadasGanadas)
	{
		
		this.numJugadasGanadas = numJugadasGanadas;
	
	}

	public int getNumJugadasPerdidas() 
	{
		
		return numJugadasPerdidas;
	
	}

	public void setNumJugadasPerdidas(int numJugadasPerdidas)
	{
		
		this.numJugadasPerdidas = numJugadasPerdidas;
	
	}

	public int getNumJugadasEmpatadas() 
	{
		
		return numJugadasEmpatadas;
	
	}

	public void setNumJugadasEmpatadas(int numJugadasEmpatadas)
	{
		
		this.numJugadasEmpatadas = numJugadasEmpatadas;
	
	}
	
	public int getNumJugadasAbandonadas() 
	{
		
		return numJugadasAbandonadas;
	
	}

	public void setNumJugadasAbandonadas(int numJugadasAbandonadas) 
	{
		
		this.numJugadasAbandonadas = numJugadasAbandonadas;
	
	}

	public String toString()
	{
		//return  getNombre() +"\t"+ getRol() +"\t"+ getFondo() +"\t"+ getBet();
		
		return  getNombre() +"  "+  getFondo() +"  "+ getBet() + "\n";
	}
	
}
