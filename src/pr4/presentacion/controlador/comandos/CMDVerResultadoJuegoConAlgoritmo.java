package pr4.presentacion.controlador.comandos;

import pr4.FactSAImpJuegoConAlgoritmo;
import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;

public class CMDVerResultadoJuegoConAlgoritmo implements CMD {

	@Override
	public RespuestaCMD ejecuta(Object objeto) {
		// TODO Auto-generated method stub
			
		FactSAImpJuegoConAlgoritmo.dameSA().getM().valorar();
		
		return  new RespuestaCMD(EnumComandos.VER_RESULTADO_JUEGO_CON_ALGORITMO, null);
	}

}
