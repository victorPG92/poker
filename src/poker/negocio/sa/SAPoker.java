package poker.negocio.sa;

import poker.negocio.dtos.Draws;
import poker.negocio.dtos.manos.Mano;
import poker.negocio.dtos.mazos.Mazo;

public interface SAPoker 
{
	
	public Mazo dameMazo();
	
	public Mano encontrarMejorJugada();
	
	public Draws detectarDraws();

}
