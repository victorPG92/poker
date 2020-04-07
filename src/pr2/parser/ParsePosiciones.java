package pr2.parser;

import java.util.ArrayList;
import java.util.StringTokenizer;

import poker.negocio.dtos.Posicion;


/**
 * 
 * @author victor
 * no necesario ya ùesto que maesa de 6 jugadores.
 */
public class ParsePosiciones {

	
	public static ArrayList<Posicion> parse(String s)
	{
		ArrayList<Posicion> l = new ArrayList<Posicion>();
		
		try{
			StringTokenizer st = new StringTokenizer(s,"/");
			String tokens[] = new String[st.countTokens()];
			
			int nt=0;
			while(st.hasMoreTokens())
			{
				tokens[nt]= st.nextToken();
				nt++;
			}
			
			for(int i=0;i<nt;i++)
			{
				Posicion p= Posicion.parse(tokens[i]);
				if(p!=null) l.add(p);
			}
			
			
		} catch(NullPointerException e){
			//System.err.println("linea null");
		
		} catch(Exception e){
			e.printStackTrace();
		}
		return l;
			
	}
}
