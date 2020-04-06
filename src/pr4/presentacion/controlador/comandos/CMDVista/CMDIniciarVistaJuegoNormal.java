package pr4.presentacion.controlador.comandos.CMDVista;

import pr4.FactSAImpJuegoNormal;
import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;
import pr4.presentacion.controlador.comandos.CMD;


public class CMDIniciarVistaJuegoNormal implements CMD {
	
	 @Override
	    public RespuestaCMD ejecuta(Object objeto) { 
		 
		 	FactSAImpJuegoNormal.dameSA().getM().setEstado(0);
			FactSAImpJuegoNormal.dameSA().apuestaInicial();
			
	        return  new RespuestaCMD(EnumComandos.INICIAR_VISTA_JUEGO_NORMAL, null);	

	    }

}
