/**
 * 
 * Despachador de vistas
 *  
 */

package pr4.presentacion.controlador.imp;

import javax.swing.JFrame;

import pr4.presentacion.controlador.Dispatcher;
import pr4.presentacion.controlador.RespuestaCMD;

import pr4.presentacion.ventanas.VentanaJuegoNormal;
import pr4.presentacion.ventanas.VentanaJuegoConAlgoritmo;

public class DispatcherImp extends Dispatcher {

    @SuppressWarnings("incomplete-switch")
    public void despachaRespuesta(RespuestaCMD respuestaCMD) {
        
    	if(respuestaCMD==null)
    	{
    		
    		System.err.println("no hay respuesta comando");
    		return;
    	}
    	
        switch (respuestaCMD.getEvento())
        {
                   
            //Juego normal 
        
        	case INICIAR_VISTA_JUEGO_NORMAL:
        		VentanaJuegoNormal.obtenerInstancia().setExtendedState(JFrame.MAXIMIZED_BOTH);
        		//FactSAImp.dameSA().getM().getJ().setFondo(Integer.parseInt(VentanaIntroduccionEurosVirtualesParaJugador.obtenerInstancia().getJtextfield().getText())); 
        		VentanaJuegoNormal.obtenerInstancia().setVisible(true);
        	
        	break; 
            
        	case VER_RESULTADO_JUEGO_NORMAL:
            	VentanaJuegoNormal.obtenerInstancia().setExtendedState(JFrame.MAXIMIZED_BOTH);
         
            	VentanaJuegoNormal.obtenerInstancia().repaint();
            	
            break; 
            
        	case VOLVER_A_JUGAR_OTRA_MANO_JUEGO_NORMAL:
            	VentanaJuegoNormal.obtenerInstancia().setExtendedState(JFrame.MAXIMIZED_BOTH);
         
            	VentanaJuegoNormal.obtenerInstancia().getCanvas().repaint();
            	VentanaJuegoNormal.obtenerInstancia().repaint();
            	
            break; 
            
            // Juego con algoritmo
            
        	case INICIAR_VISTA_JUEGO_CON_ALGORITMO:
        		VentanaJuegoConAlgoritmo.obtenerInstancia().setExtendedState(JFrame.MAXIMIZED_BOTH);
        		VentanaJuegoConAlgoritmo.obtenerInstancia().setVisible(true);
        	
        	break; 
            
        	case VER_RESULTADO_JUEGO_CON_ALGORITMO:
            	VentanaJuegoConAlgoritmo.obtenerInstancia().setExtendedState(JFrame.MAXIMIZED_BOTH);
         
            	VentanaJuegoConAlgoritmo.obtenerInstancia().repaint();
            	
            break; 
            
        	case VOLVER_A_JUGAR_OTRA_MANO_JUEGO_CON_ALGORITMO:
            	VentanaJuegoConAlgoritmo.obtenerInstancia().setExtendedState(JFrame.MAXIMIZED_BOTH);
         
            	VentanaJuegoConAlgoritmo.obtenerInstancia().getCanvas().repaint();
            	VentanaJuegoConAlgoritmo.obtenerInstancia().repaint();
            	
            break; 
        	
        }
    }

}
