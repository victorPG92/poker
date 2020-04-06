/**
 * 
 * Controlador de Aplicacion
 * 
 * @author Marco Gonz�lez, Juan Carlos * @author Mart�nez Dotor, Jes�s * @author Picado �lvarez, Mar�a * @author Rojas Mor�n, Amy Alejandra * @author Serrano �lvarez, Jos� * @author Vargas Paredes, Jhonny
 *  
 */

package pr4.presentacion.controlador.imp;

import pr4.presentacion.controlador.ApplicationController;
import pr4.presentacion.controlador.Dispatcher;
import pr4.presentacion.controlador.EnumComandos;
import pr4.presentacion.controlador.FactoriaCMD;
import pr4.presentacion.controlador.comandos.CMD;


public class ApplicationControllerImp extends ApplicationController {

	// Metodos
	
	public void handleRequest(EnumComandos nombreComando, Object objeto) {

		CMD comando = FactoriaCMD.obtenerInstancia().generaComando(nombreComando);

		Dispatcher.obtenerInstancia().despachaRespuesta(comando.ejecuta(objeto));

	}

}