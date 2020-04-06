package pr2.fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import pr2.constantes.Constantes;


/**
 * 
 * @author victor
 * Lee de un fichero de texto .txt
 *
 */
public class LeerFichero
{
	
	private BufferedReader bd;
	private FileReader fr;
	private String nombreFichero;
	//private int numLineas; //num no corresponde a longitud de lineas , ya que puede haber incorrectas
	//private int numLineasLeidas;  
	
	//si suponemos fichero peque�o, renta guardar todo en un String y no volver a leer
	//private ArrayList<String> lineas; //poco eficiente
	
	public boolean ficheroCorrecto;
	
	private static LeerFichero inst;
	
	//private 
	public  LeerFichero(String nombre)
	{
		 try
		 {
			//numLineas=0;
			//numLineasLeidas=0;
			//lineas= new  ArrayList<String> ();
			ficheroCorrecto=true;
			nombreFichero= nombre;
			
			
			File f = new File(nombreFichero);
			fr = new FileReader(f);
			bd = new BufferedReader(fr);
			
			//leerTodo();
			
			
			//fr.close();
			//bd.close();
		 }
		 catch (FileNotFoundException e)
		 {
			 System.err.println("Fichero no encontrado: " +nombreFichero);
			// e.printStackTrace();
		
		 }
		 catch (@SuppressWarnings("hiding") IOException e)
		 {
			// no cierra bien  	
			e.printStackTrace();
		 }	
		
		
		
		 
		 
	}
	
        public void close()
        {
            try
            {
               fr.close();
               bd.close();
            }  catch(Exception e){}
        }
	/*
	private void leerTodo() //poco eficiente
	{
		try 
		{
			if(bd.ready())
			{
				String s="";
				while(s!=null)
				{
					
					s=bd.readLine();
					if(s!= null)// && lineaCorrecta( s))
					{
						lineas.add(s);
						//numLineas++;
					}
					else ficheroCorrecto=false;
					
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	*/
	/*
	public boolean lineaCorrecta(String s)
	{
		boolean b= true;
		
		if(s.length()!=10) b=false;
		
		
		return b;
			
	}*/
	
	/*
	public ArrayList<String> dameLineas()
	{
		return lineas;
	}*/
	
	/*
	public boolean ficheroCorrecto()
	{
		boolean b= true;
		
		
	}*/
	public String leeLinea()
        {
            try{
            return bd.readLine();
            }catch(Exception e)
               {
               return null;}
        }
	
	public static LeerFichero getInst()
	{
		String n;
		n= Constantes.FICHERO_RANGO ;
		
		if(inst==null)inst = new LeerFichero(n);
		return inst;
	}

}
