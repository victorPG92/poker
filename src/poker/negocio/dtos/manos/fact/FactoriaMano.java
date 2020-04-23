package poker.negocio.dtos.manos.fact;

import java.util.ArrayList;

import poker.negocio.dtos.cartas.Carta;
import poker.negocio.dtos.manos.CartaMasAlta;
import poker.negocio.dtos.manos.Color;
import poker.negocio.dtos.manos.DoblesParejas;
import poker.negocio.dtos.manos.Escalera;
import poker.negocio.dtos.manos.EscaleraColor;
import poker.negocio.dtos.manos.Full;
import poker.negocio.dtos.manos.Mano;
import poker.negocio.dtos.manos.ManoEnum;
import poker.negocio.dtos.manos.Pareja;
import poker.negocio.dtos.manos.Poker;
import poker.negocio.dtos.manos.Trio;


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
	
	public Mano creaMano(ArrayList<Carta> cartas,ManoEnum me)
	{
		//System.out.println("fabricar "+ me.getEsp() +" con  de "+hc1+" y "+ hc2) ;
		
		Mano mano = null;
		
		if	   (me.equals(ManoEnum.pair)) 			 mano = new Pareja			(cartas);
		else if(me.equals(ManoEnum.three_of_a_kind)) mano = new Trio			(cartas);
		else if(me.equals(ManoEnum.two_pair)) 		 mano = new DoblesParejas	(cartas);
		else if(me.equals(ManoEnum.straight)) 		 mano = new Escalera		(cartas);
		else if(me.equals(ManoEnum.flush)) 			 mano = new Color			(cartas);
		else if(me.equals(ManoEnum.full_house)) 	 mano = new Full			(cartas);
		else if(me.equals(ManoEnum.four_of_a_kind))  mano = new Poker			(cartas);
		else if(me.equals(ManoEnum.straight_flush))  mano = new EscaleraColor	(cartas);
		else if(me.equals(ManoEnum.high_card)) 		 mano = new CartaMasAlta	(cartas);
		
		
		
		return 	mano;
	}

}
