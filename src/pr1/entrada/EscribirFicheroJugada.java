package pr1.entrada;

import java.io.FileWriter;
import java.io.PrintWriter;

import poker.negocio.constantes.ConstantesPR1;

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
		
		 if(ConstantesPR1.FICHERO_SALIDA!=null)  	nombre = ConstantesPR1.FICHERO_SALIDA;
		 else 					nombre = ConstantesPR1.NOMBRE_FICHERO_SALIDA;
		 
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
			fichero = new FileWriter(nombre);
			pw = new PrintWriter(fichero);
         
         } catch (Exception e) {
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
