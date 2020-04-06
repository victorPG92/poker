package pr2.negocio.ranking;

import pr2.constantes.Constantes;
import pr2.fichero.LeerFichero;
import pr2.negocio.rangos.Rango;
import pr2.parser.ParseaLIneaRanking;
import pr2.util.ManoPrio;

/**
 * Lee el ranking de un fichero de texto
 * @author victor
 *
 */
public class LeeRango 
{
	
	 public static Ranking dameRanking()
	 {
		 System.out.println("lee rango "+ Constantes.FICHERO_RANGO);
		 LeerFichero lf= new  LeerFichero(Constantes.FICHERO_RANGO);
		 
		 Ranking r = new Ranking();
		 
		 String linea = lf.leeLinea();//la primera linea es de descripcion
		 
		@SuppressWarnings("unused")
		int i=0;
		 do
		 {
			 
			
			// System.out.println(linea);
			 ManoPrio mp= ParseaLIneaRanking.parse(linea);
			 if(mp!=null)
			 {
				 i++;
				 r.inserta(mp);
			 }
			 linea = lf.leeLinea();
		 }
		 while(linea !=null);
		 lf.close();
		// System.out.println("lineas "+ i);
		 return r;
	 }
	 
	 public static Rango dameRango(String s )
	 {
		 System.out.println("lee rango "+s);
		 LeerFichero lf= new  LeerFichero(s);
		 
		 Rango r = new Rango();
		 
		 String linea = lf.leeLinea();//la primera linea es de descripcion
		 //System.out.println(linea);
		 
		@SuppressWarnings("unused")
		int i=0;
		 do
		 {
			r.insertaRangoLinea(linea);
			linea = lf.leeLinea();
		 }
		 while(linea !=null);
		 lf.close();
		
		 return r;
	 }

}
