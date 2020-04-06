package pr4;

public interface SAPr4JuegoConAlgoritmo {
	
	/**
	 * se apuesta lo inicial y se muestran als cartas del jugador
	 */
	public void apuestaInicial();
	
	/**
	 *  se apuesta lo del flop y se muestran las 3 primeras cartas comunes del board
	 * @return 
	 */
	public boolean apuestaFlop();
	
	/**
	 * /**
	 *  se apuesta lo del turn y se muestran las  carta comun correspondiente al turn
	 */ 
	public boolean apuestaTurn();
	
	/**
	 * /**
	 *  se apuesta lo del river y se muestran las  carta comun correspondiente al river
	 */
	public boolean apuestaRiver();	
	
	/**
	 * cuando se acaba el juego y salen las jugadas , se valora quien gana
	 */
	public void valorar();
	
	/**
	 * el jugador pierde, por lo que el bote se reduce, y la bet del jugador se pone a 0
	 */
	public void perder();
	
	/**
	 * se simula n manos para saber quien gana , si el jugador con su mano, u otro con una random mano
	 */
	public void simular();
	
	public MesaJuegoCaribeanConAlgoritmo getM();

	void setM(MesaJuegoCaribeanConAlgoritmo m);

}
