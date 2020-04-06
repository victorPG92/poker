package pr4;

import pr4.presentacion.ventanas.VentanaJuegoNormal;

public class SAPR4ImpJuegoNormal implements SAPr4JuegoNormal {

	private MesaJuegoCaribeanNormal m;
	private VentanaJuegoNormal v;
	
	public SAPR4ImpJuegoNormal()
	{
		m= MesaJuegoCaribeanNormal.dameInst();
		v= VentanaJuegoNormal.obtenerInstancia();
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
	public void apuestaFlop() 
	{
		m.apuestaFlop();
		v.getCanvas().setCartasComunes(m.getComunes());
		actualizaVentana();
	}

	@Override
	public void apuestaTurn() 
	{
		m.apuestaTurn();
		v.getCanvas().setCartasComunes(m.getComunes());
		actualizaVentana();
		
	}

	@Override
	public void apuestaRiver()
	{
		m.apuestaRiver();
		actualizaVentana();
		
	}

	@Override
	public void valorar() 
	{
		m.valorar();
		actualizaVentana();
		
	}

	@Override
	public void perder()
	{
		m.retirarse();
		actualizaVentana();
	}
	
	public void actualizaVentana()
	{
		
		v.getTxtBote().setText(Integer.toString(m.getJ().getBet()) + " €");// o get bet?
		v.getTxtStackjug().setText(Integer.toString(m.getJ().getFondo()) + " €");
		
		v.repaint();
		
	}

	@Override
	public void simular()
	{
		@SuppressWarnings("unused")
		String mano= "AA";
		//if(TablaAcceso.dameInst().damePos(mano) <=50)
		
	}
	
	public MesaJuegoCaribeanNormal getM() 
	{
		
		return m;
		
	}

	public void setM(MesaJuegoCaribeanNormal m) 
	{
		
		this.m = m;
	
	}
	
}
