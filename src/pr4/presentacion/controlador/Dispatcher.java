/**
 * 
 * Factoria del Dispatcher
 * 
 * @author Marco Gonz�lez, Juan Carlos * @author Mart�nez Dotor, Jes�s * @author Picado �lvarez, Mar�a * @author Rojas Mor�n, Amy Alejandra * @author Serrano �lvarez, Jos� * @author Vargas Paredes, Jhonny
 *  
 */

package pr4.presentacion.controlador;

import pr4.presentacion.controlador.imp.DispatcherImp;


public abstract class Dispatcher {

	// Atributos

	private static Dispatcher dispatcher; //instancia singleton

	// Metodos

	public static Dispatcher obtenerInstancia() {

		if (dispatcher == null)
			dispatcher = new DispatcherImp();

		return dispatcher;
	}

	public abstract void despachaRespuesta(RespuestaCMD respuestaComando);

}
