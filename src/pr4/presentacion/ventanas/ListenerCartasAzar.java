package pr4.presentacion.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerCartasAzar implements ActionListener {
	

	private Tapete ta;
	public ListenerCartasAzar(Tapete t)
	{
		ta=t;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{

		//ta.repartir();
		ta.repaint();
		}

	

}
