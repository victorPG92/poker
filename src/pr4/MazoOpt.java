package pr4;

import java.util.ArrayList;

import pr1.negocio.cartas.carta.Carta;

public interface MazoOpt 
{
	
	public Carta dameCartaAleatoria();
	public ArrayList<Carta> dameNCartas(int n);
	
	public void insertaCarta(Carta c);
	public void insertaCarta(ArrayList<Carta> l);
	
	

}
