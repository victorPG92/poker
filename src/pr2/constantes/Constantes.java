package pr2.constantes;


/**
 * Constantes isadas en el pgroama y variables globales con acceso estatico 
 * @author victor
 *
 */
public class Constantes 
{

	// por defecto
		public static final String NOMBRE_FICHERO_ENTRADA = "entrada.txt";
		public static final String NOMBRE_FICHERO_SALIDA  = "salida.txt";
		
		public static String FICHERO_ENTRADA = null;
		public static String FICHERO_SALIDA  = null;
		
		
		// informativos
		public static final String MEJOR_JUGADA_ESP= "Mejor jugada: ";
		public static final String MEJOR_JUGADA= " - Best Hands: ";
		public static final String DRAW= " - Draw: ";
		
		//manos
		public static final String CARTA_MAS_ALTA= "High card";
		public static final String PAREJA= "Pair";
		public static final String DOBLES_PAREJAS= "Double pair ";
		public static final String TRIO= "Three of kind of ";
		public static final String ESCALERA= "Straight";
		public static final String COLOR= "Flush";
		public static final String FULL= "Full house";
		public static final String POKER= "Four of kind";
		public static final String ESCALERA_COLOR= "Flush Straight";
		
		
		//proyectos
		public static final String PROYECTO_COLOR= "Flush ";
		public static final String PROYECTO_ESCALERA_ABIERTA= ESCALERA +" Open ended ";
		public static final String PROYECTO_ESCALERA_INTERRUMPIDA= ESCALERA +" Gutshot ";
		
		
		public static final String IDIOMA_ESP= "ESP";
		public static final String IDIOMA_ING= "ING";
		public static  String IDIOMA="ING";
		
	
	
	//public static final String FICHERO_SALIDA = null;
	//public static final String NOMBRE_FICHERO_SALIDA = null;
	
	public static final int NUM_JUG=10;
	public static final int TAM=13;
	
	public static final int T=8;
	
	//parser
	public static final String RANDOM="Random";
	public static final String SUITED="suited";
	
	public static final String BROADWAY_SUITED="broadway-suited";
	public static final String BROADWAY_OFFSUITED="broadway-offsuited";
	public static final String BROADWAY="broadway";
	
	public static final String NO_BROADWAY_SUITED="no-broadway-suited";
	public static final String NO_BROADWAY_OFFSUITED="no-broadway-offsuited";
	public static final String NO_BROADWAY="no-broadway";
	
	public static final String ALL="all";
	public static final String SUITED_CONECTORS="suited-conectors";
	public static final String BROADWAY_CONECTORS="broadway-conectors";
	
	//apartado 3
	
	public static final String DATOS="Faltan datos";
	public static final String FICHERO_NO="Fichero no encontrado";
	public static final String NO_MANO="Mano mala";
	public static final String CORRECTO="Correcto";
	public static final String INCORRECTO="Erróneo";
	
	//FICHEROS RANKOING DE RANGOS
	
	public static final String RUTA="/ficheros/";
	public static final String FICHERO_SC = "rankingSC_2.txt"; //SKLANSKY-CHUBUKOV
	
	public static final String JUGADOR="Jugador";
	
	public static final String OFFSUITED = "offsuited";
	
	public static final int NUM_PRUEBAS =2;// (int) Math.pow(10, 5);
	
	
	
	public static String FICHERO_RANGO = FICHERO_SC; //por defecto usamos SC
	

}
