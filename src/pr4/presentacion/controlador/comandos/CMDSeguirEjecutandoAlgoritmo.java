package pr4.presentacion.controlador.comandos;

import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.RespuestaCMD;

public class CMDSeguirEjecutandoAlgoritmo implements CMD {

	@Override
	public RespuestaCMD ejecuta(Object objeto) {
		// TODO Auto-generated method stub
		 return  new RespuestaCMD(EnumComandos.SEGUIR_EJECUTANDO_ALGORITMO, null);
	}

}
