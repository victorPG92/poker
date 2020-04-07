package pr2.fichero;

import java.io.FileWriter;
import java.io.PrintWriter;

import poker.negocio.constantes.ConstantesPR2;



/**
 * 
 * @author victor
 * Escribe en un fichero de texto .txt
 *
 */
public class EscribirFicheroJugada
{

	
	 private FileWriter fichero ;
	 private PrintWriter pw ;
	 private String nombre;
	 
	 private static EscribirFicheroJugada inst;
	 
	 public  static EscribirFicheroJugada getInst()
	 {
		 if(inst ==null) inst = new EscribirFicheroJugada();
		 return inst;
	 }
	 
	 private EscribirFicheroJugada()
	 {
		
		 if(ConstantesPR2.FICHERO_SALIDA!=null)  	nombre = ConstantesPR2.FICHERO_SALIDA;
		 else 									nombre = ConstantesPR2.NOMBRE_FICHERO_SALIDA;
		 
		 open();
		 
		 
     }
	 
	 public void escribeLinea(String linea)
	 {
		// open();
		 pw.println(linea);
		 //close();
	 }
	 
	 
	 public void open()
	 {
		 try
		 {
			 System.out.println(nombre);
			fichero = new FileWriter(nombre);
			pw = new PrintWriter(fichero);
			 System.out.println(pw);
         
         } catch (Exception e)
         {
             e.printStackTrace();
         } 
	 }
	 
	 public void close()
	 { 
		 try 
		 {
			 fichero.close();
		 
		 } catch (Exception e) 
		 {
             e.printStackTrace();
         }
	 }
	 
    
	
	
}
