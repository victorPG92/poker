package pr2.negocio.rangos;

import pr2.constantes.Constantes;
import pr2.fichero.LeerFichero;
import pr2.negocio.ranking.Ranking;
import pr2.parser.ParseaLIneaRanking;
import pr2.util.ManoPrio;

public class LeeRangoPosicion 
{
	
	 public static Ranking daemRango()
	 {
		 LeerFichero lf= new  LeerFichero(Constantes.FICHERO_RANGO);
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
