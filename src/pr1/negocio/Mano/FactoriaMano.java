package pr1.negocio.Mano;

import java.util.ArrayList;

import pr1.negocio.Mano.manos.CartaMasAlta;
import pr1.negocio.Mano.manos.Color;
import pr1.negocio.Mano.manos.DoblesParejas;
import pr1.negocio.Mano.manos.Escalera;
import pr1.negocio.Mano.manos.EscaleraColor;
import pr1.negocio.Mano.manos.Full;
import pr1.negocio.Mano.manos.Mano;
import pr1.negocio.Mano.manos.Pareja;
import pr1.negocio.Mano.manos.Poker;
import pr1.negocio.Mano.manos.Trio;
import pr1.negocio.cartas.carta.Carta;


/**
 * 
 * @author victor
 * Segun unos parametros ya calculados, devuelve una mano
 *
 */
public class FactoriaMano 
{
	
	
	/*public Mano creaMano(ManoEnum me,int hc1, int hc2)
	{
		//System.out.println("fabricar "+ me.getEsp() +" con  de "+hc1+" y "+ hc2) ;
		
		Mano m = null;
		
		if	   (me.equals(ManoEnum.pair)) 			 m = new Pareja(me,hc1, null, null, null);
		else if(me.equals(ManoEnum.three_of_a_kind)) m = new Trio(me,hc1, null, null);
		else if(me.equals(ManoEnum.two_pair)) 		 m = new DoblesParejas(me,hc1,hc2, null);
		else if(me.equals(ManoEnum.straight)) 		 m = new Escalera(me,hc1);
		else if(me.equals(ManoEnum.flush)) 			 m = new Color(me,hc1);
		else if(me.equals(ManoEnum.full_house)) 	 m = new Full(me,hc1,hc2);
		else if(me.equals(ManoEnum.four_of_a_kind))  m = new Poker(me,hc1,null);
		else if(me.equals(ManoEnum.straight_flush))  m = new EscaleraColor(me,hc1);
		else if(me.equals(ManoEnum.high_card)) 		 m = new CartaMasAlta(me,hc1,null,null,null,null);
		
		
		
		return 	m;
	}
	*/
	
	public Mano creaMano(ArrayList<Carta> mano,ManoEnum me)
	{
		//System.out.println("fabricar "+ me.getEsp() +" con  de "+hc1+" y "+ hc2) ;
		
		Mano m = null;
		
		if	   (me.equals(ManoEnum.pair)) 			 m = new Pareja			(mano);
		else if(me.equals(ManoEnum.three_of_a_kind)) m = new Trio			(mano);
		else if(me.equals(ManoEnum.two_pair)) 		 m = new DoblesParejas	(mano);
		else if(me.equals(ManoEnum.straight)) 		 m = new Escalera		(mano);
		else if(me.equals(ManoEnum.flush)) 			 m = new Color			(mano);
		else if(me.equals(ManoEnum.full_house)) 	 m = new Full			(mano);
		else if(me.equals(ManoEnum.four_of_a_kind))  m = new Poker			(mano);
		else if(me.equals(ManoEnum.straight_flush))  m = new EscaleraColor	(mano);
		else if(me.equals(ManoEnum.high_card)) 		 m = new CartaMasAlta	(mano);
		
		
		
		return 	m;
	}

}
