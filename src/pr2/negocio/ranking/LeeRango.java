package pr2.negocio.ranking;

import poker.negocio.constantes.ConstantesPR2;
import poker.negocio.dtos.ManoPrio;
import poker.negocio.dtos.Rango;
import poker.negocio.dtos.Ranking;
import pr2.fichero.LeerFichero;
import pr2.parser.ParseaLIneaRanking;

/**
 * Lee el ranking de un fichero de texto
 * @author victor
 *
 */
public class LeeRango 
{
	
	 public static Ranking dameRanking()
	 {
		 System.out.println("lee rango "+ ConstantesPR2.FICHERO_RANGO);
		 LeerFichero lf= new  LeerFichero(ConstantesPR2.FICHERO_RANGO);
		 
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
