package poker.negocio.dtos.mazos;

import java.util.ArrayList;

import poker.negocio.dtos.cartas.Carta;

public interface MazoOpt 
{
	
	public Carta dameCartaAleatoria();
	public ArrayList<Carta> dameNCartas(int n);
	
	public void insertaCarta(Carta c);
	public void insertaCarta(ArrayList<Carta> l);
	
	

}
