package pr4.presentacion.ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import pr4.presentacion.controlador.ApplicationController;
import pr4.presentacion.controlador.EnumComandos;
 
@SuppressWarnings("serial")
public class VentanaIntroduccionEurosVirtualesParaJugador extends JFrame implements KeyListener {
       
    JPanel jpanel = (JPanel) this.getContentPane();
    JLabel jlabel1 = new JLabel();
    JLabel jlabel2 = new JLabel();
    JTextField jtextfield = new JTextField(); 
    private JButton botonConfirmarSeleccion;
    
    private static VentanaIntroduccionEurosVirtualesParaJugador ventanaIntroduccionEurosVirtualesParaJugador; 
	

	public static VentanaIntroduccionEurosVirtualesParaJugador obtenerInstancia() {

		if (ventanaIntroduccionEurosVirtualesParaJugador == null)
			ventanaIntroduccionEurosVirtualesParaJugador = new VentanaIntroduccionEurosVirtualesParaJugador();

		return ventanaIntroduccionEurosVirtualesParaJugador;
	}

    
    public VentanaIntroduccionEurosVirtualesParaJugador()
    {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    	jpanel.setLayout(null);
    	//jpanel.setBackground(Color.lightGray);
           
    	jlabel1.setBounds(new Rectangle(5, 15, 220, 21));
    	jlabel1.setText("Introduzca la cantidad de dinero inicial");
    	jlabel2.setBounds(new Rectangle(5, 30, 220, 21));
    	jlabel2.setText("(NO letras NI caracteres)");
    	jtextfield.setBounds(new Rectangle(225, 15, 80, 21));
    	
    	jtextfield.addKeyListener(this); 
      
    	jpanel.add(jlabel1, null);
    	jpanel.add(jlabel2, null);
    	jpanel.add(jtextfield, null);
     
    	setBounds(580, 300, 0, 0);
    	setSize(380, 150);        
    	setTitle("Fondo inicial jugador "); 
    	
    	botonConfirmarSeleccion = new JButton("ACEPTAR");
    	botonConfirmarSeleccion.setBounds(130, 66, 100, 25); 
    	jpanel.add(botonConfirmarSeleccion);
    	
    	botonConfirmarSeleccion.addActionListener(new ActionListener()
        {
      	  
  			public void actionPerformed(ActionEvent arg0)
  			{
  				
  				if(jtextfield.getText().compareTo("") != 0) {
  					
  					if(VentanaSeleccionModoJuego.seleccion.compareTo("JUEGO NORMAL") == 0) {
  	  					
  	  	  				ApplicationController.obtenerInstancia().handleRequest(EnumComandos.INICIAR_VISTA_JUEGO_NORMAL, null);

  	  				} else if(VentanaSeleccionModoJuego.seleccion.compareTo("JUEGO CON ROBOT") == 0) {
  	  					
  	  	  				ApplicationController.obtenerInstancia().handleRequest(EnumComandos.INICIAR_VISTA_JUEGO_CON_ALGORITMO, null);
  	  					
  	  				}
  	  				
  	  				setVisible(false);
  	  						
  				} else {
  					
  					JOptionPane.showMessageDialog(null, "PARA PODER JUGAR, ANTES DEBE INTRODUCIR UNA CANTIDAD DE EUROS VIRTUALES");
  					
  				}
  						
  			}
  			
  		});
    	
    }
    
    @SuppressWarnings("static-access")
	@Override 
    public void keyTyped(KeyEvent e) { 

    	int k = (int) e.getKeyChar(); 

    	if(k >= 1 && k <= 47 || k >= 58 && k <= 950 && (k != e.VK_BACK_SPACE)) { 

    		e.consume(); 
    		//JOptionPane.showMessageDialog(null, "�No puede ingresar Letras ni caracteres!", "Error Datos", JOptionPane.ERROR_MESSAGE); 
    	
    	} 

    } 

    @Override 
    public void keyPressed(KeyEvent e)
    { 

    } 
    @Override 
    public void keyReleased(KeyEvent e) 
    { 	

    }

	public JTextField getJtextfield() 
	{
		
		return jtextfield;
	
	}


	public void setJtextfield(JTextField jtextfield)
	{
		
		this.jtextfield = jtextfield;
	
	} 

}   
