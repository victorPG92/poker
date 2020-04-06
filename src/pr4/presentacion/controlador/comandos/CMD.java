/**
 * Interfaz de Comando
 */

package pr4.presentacion.controlador.comandos;

import pr4.presentacion.controlador.RespuestaCMD;

public interface CMD {

	public RespuestaCMD ejecuta(Object objeto);

}