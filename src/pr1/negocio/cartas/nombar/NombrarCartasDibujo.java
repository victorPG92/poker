package pr1.negocio.cartas.nombar;

import pr1.negocio.cartas.carta.Carta;
import pr1.negocio.cartas.carta.Palo;

public class NombrarCartasDibujo extends Nombrar
{

	
	
	public  String nombreFoto(Carta c)
	{   
                String ruta="";
		String numero="";
		int n= c.getNum();
		Palo p = c.getPalo();
		if(n >=2 && n <= 10)numero = Integer.toString(n);
		else if(n==1) 		numero = "ace";
		else if(n==11) 		numero = "jack";
		else if(n==12) 		numero = "queen";
		else if(n==13) 		numero = "king";
		
		boolean figura=false;
		if(n==11 || n==12 || n==13)figura=true; 
		
		//System.err.println(p +": "+ p.ing());
		
		String nombre =ruta +  numero +"_of_" +p.ing();//+".png";
		if(figura) nombre+="2";
		nombre+=".png";
		return nombre;
		
	}

}
