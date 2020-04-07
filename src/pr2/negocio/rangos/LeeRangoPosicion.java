package pr2.negocio.rangos;

import poker.negocio.constantes.ConstantesPR2;
import poker.negocio.dtos.ManoPrio;
import poker.negocio.dtos.Ranking;
import pr2.fichero.LeerFichero;
import pr2.parser.ParseaLIneaRanking;

public class LeeRangoPosicion 
{
	
	 public static Ranking daemRango()
	 {
		 LeerFichero lf= new  LeerFichero(ConstantesPR2.FICHERO_RANGO);
                 Ranking r =  new Ranking();
		 
        @SuppressWarnings("unused")
		int i=0;
		 String linea ;
		 do
		 {
			 linea = lf.leeLinea();
			// System.out.println(linea);
			 ManoPrio mp= ParseaLIneaRanking.parse(linea);
			 if(mp!=null)
			 {
				 i++;
				 r.inserta(mp);
			 }
		 }
		 while(linea !=null);
		 lf.close();
		// System.out.println("lineas "+ i);
		 return r;
	 }
	

}
