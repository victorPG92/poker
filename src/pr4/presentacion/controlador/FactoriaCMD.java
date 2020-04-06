/**
 * 
 * Factoria de la factoria de Comandos
 * 
 * @author Marco Gonz�lez, Juan Carlos * @author Mart�nez Dotor, Jes�s * @author Picado �lvarez, Mar�a * @author Rojas Mor�n, Amy Alejandra * @author Serrano �lvarez, Jos� * @author Vargas Paredes, Jhonny
 *  
 */

package pr4.presentacion.controlador;

import pr4.presentacion.controlador.comandos.CMD;
import pr4.presentacion.controlador.imp.FactoriaCMDImp;



public abstract class FactoriaCMD {

	// Atributos

	private static FactoriaCMD factoria; //instancia singleton

	// Metodos

	public static FactoriaCMD obtenerInstancia() {

		if (factoria == null)
			factoria = new FactoriaCMDImp();

		return factoria;
	}

	public abstract CMD generaComando(EnumComandos nombreComando);

}
