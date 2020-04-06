package pr4.presentacion.ventanas;

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 

@SuppressWarnings("serial")
public class VentanaSeleccionModoJuego extends JFrame 
{ 
   @SuppressWarnings("rawtypes")
   private JComboBox cboOpciones; 
   private JLabel lblMensaje; 
   private JButton botonConfirmarSeleccion;
   
   public static String seleccion;
   
   private static VentanaSeleccionModoJuego ventanaSeleccionModoJuego; 
	

	public static VentanaSeleccionModoJuego obtenerInstancia() {

		if (ventanaSeleccionModoJuego == null)
			ventanaSeleccionModoJuego = new VentanaSeleccionModoJuego();

		return ventanaSeleccionModoJuego;
	}

   @SuppressWarnings({ "rawtypes", "unchecked" })
   public VentanaSeleccionModoJuego() 
   { 
	   
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   cboOpciones = new JComboBox(); 
      
	   lblMensaje = new JLabel("USTED ELIGIO: MODO JUEGO NORMAL"); 
      
	   botonConfirmarSeleccion = new JButton("ACEPTAR");
 
	   setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
	   setBounds(580, 300, 0, 0);

	   cboOpciones.setModel(new DefaultComboBoxModel(new String[] {"JUEGO NORMAL", "JUEGO CON ROBOT", "SIMULACION"})); 
	   lblMensaje.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0))); 

	   cboOpciones.addItemListener(new ItemListener() { 
         
		   public void itemStateChanged(ItemEvent e) { 
            
			   lblMensaje.setText("USTED ELIGIO: MODO " + cboOpciones.getSelectedItem().toString()); 
         } 
      
	   }); 

	   add(cboOpciones); 
	   add(lblMensaje);
      
	   botonConfirmarSeleccion.setBounds(400, 60, 100, 30); 
	   add(botonConfirmarSeleccion);
      
	   botonConfirmarSeleccion.addActionListener(new ActionListener()
	   {
    	  
		   public void actionPerformed(ActionEvent arg0)
		   {
				
			   if(cboOpciones.getSelectedItem().toString().compareTo("JUEGO NORMAL") == 0) {
					
				   seleccion = "JUEGO NORMAL";
					
				   VentanaIntroduccionEurosVirtualesParaJugador.obtenerInstancia().setVisible(true);
					
						
			   } else if(cboOpciones.getSelectedItem().toString().compareTo("JUEGO CON ROBOT") == 0) {
					
				   seleccion = "JUEGO CON ROBOT";
					
				   VentanaIntroduccionEurosVirtualesParaJugador.obtenerInstancia().setVisible(true);
					
				} else if(cboOpciones.getSelectedItem().toString().compareTo("SIMULACION") == 0) {
					
				   seleccion = "SIMULACION";
				   VentanaSimulacion2.obtenerInstancia().setVisible(true);

				   
					
				}
				
			   setVisible(false);
				
		   }
	   });

	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	   setSize(310, 165); 
 
   } 
   
}