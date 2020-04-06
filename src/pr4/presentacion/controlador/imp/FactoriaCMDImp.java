package pr4.presentacion.controlador.imp;

import java.util.HashMap;
import java.util.Map;

import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.FactoriaCMD;
import pr4.presentacion.controlador.comandos.*;
import pr4.presentacion.controlador.comandos.CMDVista.*;

public class FactoriaCMDImp extends FactoriaCMD {
    
    private Map<EnumComandos, CMD> map_cmd;

    public FactoriaCMDImp() {

    map_cmd = new HashMap<EnumComandos, CMD>();
	
    // COMANDO...
    
    //juego normal
    
    map_cmd.put(EnumComandos.INICIAR_VISTA_JUEGO_NORMAL, (CMD) new CMDIniciarVistaJuegoNormal());
    map_cmd.put(EnumComandos.VER_RESULTADO_JUEGO_NORMAL, (CMD) new CMDVerResultadoJuegoNormal());
    map_cmd.put(EnumComandos.VOLVER_A_JUGAR_OTRA_MANO_JUEGO_NORMAL, (CMD) new CMDVolverAJugarOtraManoJuegoNormal());

    //juego con algoritmo
    
    map_cmd.put(EnumComandos.INICIAR_VISTA_JUEGO_CON_ALGORITMO, (CMD) new CMDIniciarVistaJuegoConAlgoritmo());
    map_cmd.put(EnumComandos.SEGUIR_EJECUTANDO_ALGORITMO, (CMD) new CMDSeguirEjecutandoAlgoritmo());
    map_cmd.put(EnumComandos.VER_RESULTADO_JUEGO_CON_ALGORITMO, (CMD) new CMDVerResultadoJuegoConAlgoritmo());
    map_cmd.put(EnumComandos.VOLVER_A_JUGAR_OTRA_MANO_JUEGO_CON_ALGORITMO, (CMD) new CMDVolverAJugarOtraManoJuegoConAlgoritmo());

    
	}

	// Metodos

	public CMD generaComando(EnumComandos nombreComando) {

		return map_cmd.get(nombreComando);

	}

}
