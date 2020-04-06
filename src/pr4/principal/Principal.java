/**
 * 
 * Clase principal que ejecutara la aplicacion
 *  
 */

package pr4.principal;

import pr4.presentacion.ventanas.VentanaSeleccionModoJuego;

public class Principal {

	// Metodos

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) 
    {
         
        new Principal().ejecuta();
      
    }     
       

    public void ejecuta()
    {
    	
    	VentanaSeleccionModoJuego.obtenerInstancia().setVisible(true);
       
    }   
    
}