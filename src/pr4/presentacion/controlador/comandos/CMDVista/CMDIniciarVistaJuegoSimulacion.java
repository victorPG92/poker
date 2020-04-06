
package pr4.presentacion.controlador.comandos.CMDVista;


import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;
import pr4.presentacion.controlador.comandos.CMD;


public class CMDIniciarVistaJuegoSimulacion implements CMD {
	
	 @Override
	    public RespuestaCMD ejecuta(Object objeto) { 
		 
		 
	        return  new RespuestaCMD(EnumComandos.SIMULAR, null);	

	    }

}
