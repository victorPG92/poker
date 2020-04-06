package pr4.presentacion.controlador.comandos.CMDVista;

import pr4.FactSAImpJuegoConAlgoritmo;
import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;
import pr4.presentacion.controlador.comandos.CMD;

public class CMDIniciarVistaJuegoConAlgoritmo implements CMD {

	@Override
	public RespuestaCMD ejecuta(Object objeto) {
		// TODO Auto-generated method stub
		
		FactSAImpJuegoConAlgoritmo.dameSA().apuestaInicial();
		
		return  new RespuestaCMD(EnumComandos.INICIAR_VISTA_JUEGO_CON_ALGORITMO, null);	
		
	}

}
