package pr4.presentacion.controlador;

import pr4.presentacion.controlador.imp.ApplicationControllerImp;



public abstract class ApplicationController {

	// Atributos

	private static ApplicationController controladorAplicacion; //instancia singleton

	// Metodos

	public static ApplicationController obtenerInstancia() {

		if (controladorAplicacion == null)
			controladorAplicacion = new ApplicationControllerImp();

		return controladorAplicacion;
	}

	public abstract void handleRequest(EnumComandos nombreComando, Object objeto);

}