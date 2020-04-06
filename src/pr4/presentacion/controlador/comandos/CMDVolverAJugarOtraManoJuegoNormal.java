package pr4.presentacion.controlador.comandos;

import pr4.FactSAImpJuegoNormal;
import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;

public class CMDVolverAJugarOtraManoJuegoNormal implements CMD {

	@Override
	public RespuestaCMD ejecuta(Object objeto) {
		// TODO Auto-generated method stub
		
		FactSAImpJuegoNormal.dameSA().getM().reinicia();	
		
		FactSAImpJuegoNormal.dameSA().apuestaInicial();
		
        return  new RespuestaCMD(EnumComandos.VOLVER_A_JUGAR_OTRA_MANO_JUEGO_NORMAL, null);	
	}

}
