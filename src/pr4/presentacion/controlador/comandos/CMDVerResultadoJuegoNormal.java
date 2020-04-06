package pr4.presentacion.controlador.comandos;

import pr4.FactSAImpJuegoNormal;
import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;

public class CMDVerResultadoJuegoNormal implements CMD {

	@Override
	public RespuestaCMD ejecuta(Object objeto) {
		// TODO Auto-generated method stub
		
		FactSAImpJuegoNormal.dameSA().valorar();
		
		return  new RespuestaCMD(EnumComandos.VER_RESULTADO_JUEGO_NORMAL, null);
	}

}
