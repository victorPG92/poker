package pr1.entrada;

import java.io.FileWriter;
import java.io.PrintWriter;

import pr1.constantes.Constantes;

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
		
		 if(Constantes.FICHERO_SALIDA!=null)  	nombre = Constantes.FICHERO_SALIDA;
		 else 					nombre = Constantes.NOMBRE_FICHERO_SALIDA;
		 
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
