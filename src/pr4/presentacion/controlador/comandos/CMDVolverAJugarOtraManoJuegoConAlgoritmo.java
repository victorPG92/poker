package pr4.presentacion.controlador.comandos;

import pr4.FactSAImpJuegoConAlgoritmo;
import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;

public class CMDVolverAJugarOtraManoJuegoConAlgoritmo implements CMD {

	@Override
	public RespuestaCMD ejecuta(Object objeto) {
		// TODO Auto-generated method stub	
		
		FactSAImpJuegoConAlgoritmo.dameSA().getM().reinicia();	
		
		FactSAImpJuegoConAlgoritmo.dameSA().apuestaInicial();
		
        return  new RespuestaCMD(EnumComandos.VOLVER_A_JUGAR_OTRA_MANO_JUEGO_CON_ALGORITMO, null);	

	}

}
