package pr2.parser;

import pr2.negocio.Posicion;


/**
 * Tampoco necesaria si metemos, laposicion en el nombre del fichero
 * @author victor
 */
public class LineaRango
{

	private Posicion p;
	private String linea;
	
	
	public Posicion getP() {
		return p;
	}
	public void setP(Posicion p) {
		this.p = p;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public LineaRango(Posicion p, String linea) {
		super();
		this.p = p;
		this.linea = linea;
	}
	
	
	
	
	
}
