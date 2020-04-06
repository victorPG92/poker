package pr2.parser;

import pr2.negocio.ManoSimple;
import pr2.negocio.rangos.ManoRango;

/**
 * Parser que ahce de fachada de los otros
 * @author victor
 *
 */
public class ParserGlobal 
{
	private static  ParserGlobal inst ;
	
	private ParserGlobal()
	{}
	
	public static ParserGlobal getInst()
	{
		if(inst==null)inst = new ParserGlobal();
		return inst;
	}
	
	public ManoSimple parseaMnoSimple(String s)
	{
		return ParseCartaP2.getInst().parseManoSimple(s);
		
	}
	
	public ManoRango parseaManoRango(String s)
	{
		ManoRango m = ParseManoRango.parse(s);
		
		if(m ==null)
		{	ManoSimple mn= parseaMnoSimple(s);
			if(mn!=null)m = mn.toManoRango();
			
		}
		
		return m; 
	}

}
