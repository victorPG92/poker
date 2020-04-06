package pr1.util.mesas;

import java.util.ArrayList;

import pr1.negocio.cartas.carta.Carta;

public class Board
{
	
	private ArrayList<Carta> board;
	
	public Board()
	{
		board= new ArrayList<Carta>();
	}
	
	public boolean insertaCartas(ArrayList<Carta> l)
	{
		boolean exito=false;
		if(l.size()>=3 && l.size()<=5)
		{
			if(board.isEmpty())
			{
				board=l;
				exito=true;
			}
			else if(board.size()+ l.size()<=5)
			{
				board.addAll(l);
				exito=true;
			}
			
		}
	 return  exito;
	}
	
	public boolean insertaCarta(Carta c)
	{
		boolean exito=false;
		
		
		if(board.size()<=4)
		{
			board.add(c);
			exito=true;
		}
			
		
	 return  exito;
	}
	
	
	
	public ArrayList<Carta> getBoard() {
		return board;
	}



	public String toString()
	{
		return board.toString();
	}
	
	
	public boolean esVacio()
	{
		return board.isEmpty();
		
	}
	
	public boolean esCompleto()
	{
		return board.size()==5;
		
	}

}
