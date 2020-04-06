package pr2.parser;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr2.negocio.Posicion;
import pr2.negocio.rangos.Rango;
import pr2.util.Tablas;
/**
 * modificar segun formato de fichero
 * ahora el formato sera 
 *      nombrefichero = RankingPosicion.txt
 *      rango,...
 * 
 * 
 * de hecho la clase sobra porque solo es parsear lineas con el metodo parsear
 * @author victor
 */
public class ParseLineaRangoPosicion
{
	public static void parse(String s)
	{
		
		@SuppressWarnings("unused")
		LineaRango l = null;
		
		try{
			StringTokenizer st = new StringTokenizer(s,"\t");
			
			String tokens[] = new String[st.countTokens()];
			
			int nt=0;
			while(st.hasMoreTokens())
			{
				tokens[nt]= st.nextToken();
				nt++;
			}
			
			if(nt==3)
			{
                            /************************************************************/
                            // nodificar, la posicion se da en el nombre de fichero
				ArrayList<Posicion> pos = ParsePosiciones.parse(tokens[0]);
				//String rangos= tokens[1];
				Rango r = new Rango();
				r.insertaRango(tokens[2]);
				//System.out.println(m+ " "+ prio);
				
				for(Posicion p:pos)
				{
					Tablas.getInst().insertaRango(p.name(), r);
					//l = new LineaRango(p,rangos);
				}
			}
		} catch(NullPointerException e){
			//System.err.println("linea null");
		
		} catch(Exception e){
			e.printStackTrace();
		}
		//return mp;
			
	}
}
