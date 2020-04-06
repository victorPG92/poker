package pr4;

import pr4.presentacion.ventanas.VentanaJuegoConAlgoritmo;

public class SAPR4ImpJuegoConAlgoritmo implements SAPr4JuegoConAlgoritmo {
	
	private MesaJuegoCaribeanConAlgoritmo m;
	private VentanaJuegoConAlgoritmo v;
	
	public SAPR4ImpJuegoConAlgoritmo() {
		// TODO Auto-generated constructor stub	
		m = MesaJuegoCaribeanConAlgoritmo.dameInst();
		v = VentanaJuegoConAlgoritmo.obtenerInstancia();
		
	}

	@Override
	public void apuestaInicial()
	{
		m.apuestaInicial();
		
		v.getCanvas().setCartasJugador(m.getJ().getCartas());
		v.getCanvas().setCartasBanca(m.getBanca());
		//v.getCanvas().setCartasComunes(m.getComunes());
		
		actualizaVentana();
		
	}

	@Override
	public boolean apuestaFlop() {
		// TODO Auto-generated method stub
		boolean b;
		
		b = m.apostarFlop();
		v.getCanvas().setCartasComunes(m.getComunes());
		actualizaVentana();
		
		return b;
		
	}

	@Override
	public boolean apuestaTurn() {
		// TODO Auto-generated method stub
		boolean b;
		
		b = m.apostarTurn();
		v.getCanvas().setCartasComunes(m.getComunes());
		actualizaVentana();
		
		return b;
		
	}

	@Override
	public boolean apuestaRiver() {
		// TODO Auto-generated method stub
		
		boolean b;
		
		b = m.apostarRiver();
		actualizaVentana();
		
		return b;
		
	}

	@Override
	public void valorar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simular() {
		// TODO Auto-generated method stub
		//m.simula();
		actualizaVentana();
	}

	@Override
	public MesaJuegoCaribeanConAlgoritmo getM() {
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public void setM(MesaJuegoCaribeanConAlgoritmo m) {
		// TODO Auto-generated method stub
		this.m = m;
	}
	
	public void actualizaVentana()
	{
		
		v.getTxtBote().setText(Integer.toString(m.getJ().getBet()) + " €");// o get bet?
		v.getTxtStackRobot().setText(Integer.toString(m.getJ().getFondo()) + " €");
		
		v.repaint();
		
	}
	
	/*public void juega() 
	{
		
		m.jugar();
		actualizaVentana();
		
	}*/

}
