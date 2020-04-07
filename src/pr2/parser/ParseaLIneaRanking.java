package pr2.parser;

import java.util.StringTokenizer;

import poker.negocio.dtos.ManoPrio;
import poker.negocio.dtos.ManoRango;

/**
 * Parsea una linea de un ranking con el formato establecido 
 * @author victor
 *
 */
public class ParseaLIneaRanking 
{

	
	public static ManoPrio parse(String s)
	{
		ManoPrio mp= null;
		
		try{
			StringTokenizer st = new StringTokenizer(s,"\t");
			
			String tokens[] = new String[st.countTokens()];
			
			int nt=0;
			while(st.hasMoreTokens())
			{
				tokens[nt]= st.nextToken();
				nt++;
			}
			
			if(nt>=2)
			{
				ManoRango m = ParseManoRango.parse(tokens[0]);
				Double prio;
				if(tokens[1]=="-")
					prio= Double.MIN_VALUE;
				else prio= -Double.valueOf(tokens[1]);
				
				//System.out.println(m+ " "+ prio);
				
				if(m!=null)
					mp = new ManoPrio(m,prio);
				
				//System.out.println(s);
				//System.out.println(mp);
				
			}
		} catch(NullPointerException e){
			//System.err.println("linea null");
		
		} catch(Exception e){
			e.printStackTrace();
		}
		return mp;
			
	}
	
}
