package pr1.entrada;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr1.negocio.cartas.carta.Carta;
import pr1.negocio.cartas.carta.Palo;
import pr1.util.ParTipo;
import pr1.util.mesas.CartasJugador;
import pr1.util.mesas.CartasMesa;

/**
 * 
 * @author victor
 * Parsea una carta a partir de un String
 *
 */
public class ParseCarta
{
	
	private static  ParseCarta inst ;
	
	private ParseCarta()
	{
		
	}
	public static ParseCarta getInst()
	{
		if(inst==null)inst = new ParseCarta();
		
		return inst;
	}
	
	/**
	 * Si solo parseamos (5) cartas 
	 * @param s
	 * @return
	 */
	public ArrayList<Carta> parseMano(String s)
	{
		ArrayList<Carta> a = new ArrayList<Carta>();
		if(s==null) return a;
		s = s.trim();
		
		
		if(s.length()%2==0)
		{
			//System.out.println(" long par : ");
			for(int i=0;i<s.length()-1;i+=2)
			{
				//System.out.println(s.charAt(i)+" "+ s.charAt(i+1));
				Carta c = parseCarta(s.charAt(i), s.charAt(i+1));
				if(c!=null)a.add(c);
				//System.out.println(c);
			}
			
		}// else System.out.println(" long impar : ");
		
		
		return a;
		
		
	}
	
	/**
	 * Si  parseamos 2 cartas de un jugador y n  comunes
	 * @param s formato : Carta_1Carta_2;n;CartasComunes
	 * @return
	 */
	public CartasJugador parseManoJugador(String linea)
	{
		
		ArrayList<Carta> comun = new ArrayList<Carta>();//sera de longitud 3 a 5
		ParTipo<Carta> cartasJugador = null;
		
		if(linea == null) return new CartasJugador(cartasJugador,comun);
		linea = linea.trim();
				
		//separamos con ;
		StringTokenizer st = new  StringTokenizer(linea,";"); //';'
		String tokens[] = new String[st.countTokens()];
		
		int nt=0;
		while(st.hasMoreTokens())
		{
			tokens[nt]= st.nextToken();//";"
			nt++;
		}
		
		//tratamos los tokens extraidos
		
		//System.out.println("token 0: "+ tokens[0]);
		ArrayList<Carta> mano= parseMano(tokens[0]);
		if(mano.size()==2) cartasJugador =  new ParTipo<Carta>(mano.get(0),mano.get(1));
		comun = parseMano(tokens[2]);
		int numcomunes= Integer.valueOf(tokens[1]);
			
		if(comun.size()!=numcomunes) System.err.println("Error en formato"); 
				
		return new CartasJugador(cartasJugador,comun);
		
		
	}
	
	/**
	 * Si parseamos  2 cartas de n jugadores (n= 2 a 9)  y despues cartas comunes(de 3 a 5)  
	 * @param s con formato : N;CartasJug1;CartasJug2;�;CartasJugN;CartasComunes
	 * @return
	 */
	public CartasMesa parseManoComun(String linea)
	{
		
		ArrayList<Carta> comun = new ArrayList<Carta>();//sera de longitud 3
		ArrayList<ParTipo<Carta>> cartasJugador = new ArrayList<ParTipo<Carta>>();
		
		
		if(linea == null) return new CartasMesa(comun,cartasJugador);
		linea = linea.trim();
		
		StringTokenizer st = new  StringTokenizer(linea,";"); //';'
		String tokens[] = new String[st.countTokens()];
		
		int nt=0;
		while(st.hasMoreTokens())
		{
			tokens[nt]= st.nextToken();//";"
			nt++;
		}
		
		
		int numJugadores= Integer.valueOf(tokens[0]);
		
		for(int j=1;j<=numJugadores;j++)
		{
			 //System.out.println("token "+ j +":" +tokens[j]);
			ArrayList<Carta> a = parseMano(tokens[j]);
			if(a.size()==2)
			cartasJugador.add(new ParTipo<Carta>(a.get(0),a.get(1)));
			
			
		}
		
		comun = parseMano(tokens[numJugadores+1]);
		
		if(cartasJugador.size()!=numJugadores) System.err.println("Error en formato"); 
		
		
		return new CartasMesa(comun,cartasJugador);
		
		
	}
	
	
	/**
	 * OPCIONAL MODALIDAD OMAHA
	 * Si parseamos  4 cartas de 1 jugador y despues cartas comunes(de 3 a 5)  
	 * @param s con formato : Carta_1Carta_2Carta_3Carta_4;n;CartasComunes
	 * @return
	 */
	
	public Carta parseCarta(char c1, char c2)
	{
		Carta c=null;
		int n=0;
		Palo p=null ;
		
		//parsear numero
			 if(c1== 'A')	n= 1;
		else if(c1== 'K')	n= 13;
		else if(c1== 'Q')	n= 12;
		else if(c1== 'J')	n= 11;
		else if(c1== 'T')	n= 10;
		else if(esNumero(c1))n = Character.getNumericValue(c1);//n=c1;	 
			 
		//parsear palo
			  if(c2== 'c')	p = Palo.TREBOLES;
		 else if(c2== 's')	p = Palo.PICAS;
		 else if(c2== 'h')	p = Palo.CORAZONES;
		 else if(c2== 'd')	p = Palo.DIAMANTES;
		
		if( n!=0 && p!=null)
			c = new Carta(n,p); 
		
		return c;
		
	}
	
	public boolean esNumero(char c)
	{
		return c=='1' ||  c=='2' ||c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' ;
	}
	
/*
	
	public static void main(String args[])
	{
		
		ParseCarta p = ParseCarta.getInst();
		
		String s1="AsJcJh"; 									//apartado 2.1
		String s2="AhAc;3;QhJhTh";
		String s3="AhAc;5;As2s3h4dJd";							//apartado 2.2
		String s4="4;J1AhAc;J2JsJh;J37c8c;J44sKc;5dKs6cTh9h";	//apartado 2.3
		
		ArrayList<Carta> a = p.parseMano(s1);
		CartasJugador cj = p.parseManoJugador(s2);
		CartasJugador cj2 = p.parseManoJugador(s3);
		CartasMesa cm = p.parseManoComun(s4);
		
		
		
		 //System.out.println("Mano 1: " + a.toString());
		 //System.out.println("Mano 2: " + cm.toString());
		// System.out.println("Mano 3: " + cm2.toString());
		
		System.out.println("Mano " + s4 + "\n" + cm.toString());
		
		
		
	}*/
}
