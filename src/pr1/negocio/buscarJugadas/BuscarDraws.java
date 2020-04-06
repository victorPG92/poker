package pr1.negocio.buscarJugadas;

import java.util.ArrayList;

import pr1.negocio.cartas.carta.Carta;
import pr1.negocio.cartas.carta.Palo;
import pr1.util.comb.Combinaciones;
//import pr1.util.mesas.CartasMesaOmaha;
import pr1.util.ordenar.OrdenarCartas;

public class BuscarDraws 
{
	
	private ArrayList<Carta> cartas;
	
	private boolean proyectoEscaleraAbierta;
	private boolean proyectoEscaleraInterrumpida;
	private boolean proyectoColor;
	
	
	public BuscarDraws(ArrayList<Carta> manos)
	{
		proyectoEscaleraAbierta = false;
		proyectoEscaleraInterrumpida = false;
		proyectoColor = false;
		
                //asi estaba antes; suponiendo que se calcula el draw sobre la mano actiual
		if(manos.size()==5)
		{
			this.cartas=manos;
			comprobarProyectoColor();
			comprobarProyectoEscalera();
			
		}
                else if(manos.size()==6 )
                {
                    
                    Combinaciones cmb = new Combinaciones(6, 5);
		
                    ArrayList<ArrayList<Integer>> combinaciones = cmb.dameTodasLasCombinaciones();

                    for(ArrayList<Integer> indices : combinaciones)
                    {
                            ArrayList<Carta > manoTemp = new  ArrayList<Carta >();
                            for(Integer i : indices)
                                    manoTemp.add(manos.get(i));

                        this.cartas=manoTemp;
			comprobarProyectoColor();
			comprobarProyectoEscalera();;
                    }
                }
		
	}
	
       /* 
        public BuscarDraws(CartasMesaOmaha cartas)
	{
            CombinacionesMultiples cmb = new CombinacionesMultiples(cartas.dameCartasJugador().size(), 2, cartas.dameCartasComunes().size(), 3);///
            ArrayList<ParTipo<ArrayList<Integer>>> combinaciones = cmb.dameTodasLasCombinaciones();//

            //System.out.println(combinaciones.size());// 6 * (4 3) = 6*4=24 correcto 
            for(ParTipo<ArrayList<Integer>> indices : combinaciones)///
            {
                ArrayList<Carta >manoTemp = new  ArrayList<Carta >();

               for(Integer i : indices.getElem1())
                       manoTemp.add(cartas.dameCartasJugador().get(i));

               for(Integer i : indices.getElem2())//
                       manoTemp.add(cartas.dameCartasComunes().get(i));///

                 this.cartas=manoTemp;
		comprobarProyectoColor();
		comprobarProyectoEscalera();;

            }
        }
	*/
	/**
	 * Comprueba si tenemos 4 cartas  del mismo palo
	 * el objetivo es saber si tenemos proyecto de  color (se usa para proyecto de la escalera de color)
	 */
	public void comprobarProyectoColor()
	{
		
		for(int i=0;i<5;i++)
		{
			ArrayList<Carta> manoTemp = new  ArrayList<Carta >();
			for(int j=0;j<5;j++)
			if(i!=j)manoTemp.add(cartas.get(j));
			comprobarFragColor(manoTemp);
		}
		
		
		
			
		
	}
	

	
	public void comprobarFragColor(ArrayList<Carta> manoTemp)
	{
		int color=1;
		Palo p = manoTemp.get(0).getPalo();
		for(int j=1;j<4;j++)
		{
			if(p.equals(manoTemp.get(j).getPalo())) color++;
		}
		if(color==4)proyectoColor=true;
	}
	
	
	
	
	
	/**
	 * Comprueba si tenemos 4 cartas  del consecutivas 
	 * el objetivo es saber si tenemos proyecto de  escalera (se usa para proyecto de la escalera de color)
	 */
	public void comprobarProyectoEscalera()
	{
		
		OrdenarCartas o = new OrdenarCartas();
		ArrayList<Carta > cartasOrdenadas= o.ordenarPorNumero(cartas);
		
		
		//Combinaciones cmb = new Combinaciones(5, 4);
		//eijo que carta saco del mano
		for(int i=0;i<5;i++)
		{
			ArrayList<Carta> manoTemp = new  ArrayList<Carta >();
			for(int j=0;j<5;j++)
                            if(i!=j)
                                manoTemp.add(cartasOrdenadas.get(j));
                        
			comprobarFragEscalera(manoTemp);
		}
		
		
		
		
	}

	
	public void comprobarFragEscalera(ArrayList<Carta> manoTemp)
	{
		int esc=1;
		
		boolean hueco=false;
		
		//tomo los ases como 14s/////////////////
		for(int i=0;i<3;i++)
		{
                    //siempre c1>=c2
                    Carta c1 = manoTemp.get(i);
                    Carta c2 = manoTemp.get(i+1);

                    int n1=c1.getNum();
                    int n2=c2.getNum();

                    if(n1==1)n1=14;
                    if(n2==1)n2=14;

                    int dif= n1 - n2;

                    if(dif==1)esc++;
                    else if(dif==2 && !hueco)
                    {
                            hueco=true;
                            esc++;
                    }
                    /*else
                    {
                        esc--;
                    }*/
		}
		if(esc ==4 && hueco) proyectoEscaleraInterrumpida=true;
		else if(esc ==4) proyectoEscaleraAbierta=true;
		
		
		
		/*esc=1;
		hueco=false;*/
		
		//tomo los ases como 1s////////////////////////////
		ArrayList<Carta> manoTemp1 = new ArrayList<Carta>();
		manoTemp1.addAll(manoTemp);
		
		// si la primera carta es un as, la muevo al final 
		Carta as= manoTemp1.get(0);
		if(as.getNum()==1)
		{
			manoTemp1.add(as);
			manoTemp1.remove(0);
			
		}
		hueco=false;
		esc=1;
		
		for(int i=0;i<3;i++)
		{
			Carta c1 = manoTemp.get(i);
			Carta c2 = manoTemp.get(i+1);
			
			int n1=c1.getNum();
			int n2=c2.getNum();
			
			int dif= n1 - n2;
								
			if(dif==1)esc++;
			else if(dif==2 && !hueco)
			{
				hueco=true;
				esc++;
			}
                       /*   else
                        {
                            esc--;
                        }*/
                        
		}
		if(esc ==4 && hueco) proyectoEscaleraInterrumpida=true;
		else if(esc ==4) proyectoEscaleraAbierta=true;
		
	}
	

	public boolean isProyectoEscaleraAbierta() {
		return proyectoEscaleraAbierta;
	}


	public boolean isProyectoEscaleraInterrumpida() {
		return proyectoEscaleraInterrumpida;
	}


	public boolean isProyectoColor() {
		return proyectoColor;
	}
	
	
	
	

	/**
	 * Comprueba si tenemos 4 cartas  del mismo palo
	 * el objetivo es saber si tenemos proyecto de  color (se usa para proyecto de la escalera de color)
	 */
	public void comprobarProyectoColor1()
	{
		int i=1;
		Palo p1 = cartas.get(0).getPalo();
		Palo p2 = p1;
		int cc=1;
		while(p2.equals(p1) && i<5)
		{
			p2 = cartas.get(i).getPalo();
			i++;
		}
		if(i>2) cc=i+1;
		
		//ahora que tenemos dos palos distintos, comparamos si el tercero concide
		int j;
		for(j=i;j<5;j++ )
		{
			Palo p3=cartas.get(j).getPalo(); 
			if(i == 2 && (!p3.equals(p1) || !p3.equals(p2))) break;
			else if(i > 2 && !p3.equals(p1)  ) break;
			else cc++;
		}
		
		
		if(cc==4 )//if(i>=4 || j >=4)
		{
			
			proyectoColor=true;
			
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Comprueba si tenemos 4 cartas  del consecutivas 
	 * el objetivo es saber si tenemos proyecto de  escalera (se usa para proyecto de la escalera de color)
	 */
	public void comprobarProyectoEscalera1()
	{
		/*
		OrdenarCartas o = new OrdenarCartas();
		ArrayList<Carta > cartasOrdenadas= o.ordenarPorNumero(cartas);
		
		System.out.println(cartasOrdenadas);
		
		boolean as=false;
		
		int esc =1;
		int j=-1;// indica donde se interrumpe 
		
		int n1,n2=0;
		
		//si la ultima carta es un as , la pongo delante por si hay escalera con reyes
		if(cartas.get(cartasOrdenadas.size()-1).getNum()==1)
			cartasOrdenadas.add(0,new Carta(14,null));
		
		for(int i=0;i<cartasOrdenadas.size()-1;i++)
		{
			Carta c1 = cartasOrdenadas.get(i);
			n1= c1.getNum();
			Carta c2 = cartasOrdenadas.get(i+1);
			n2 = c2.getNum();
			
			if(n1==1)n1=14;
			if(n2==1)n2=14;
			
			if(n1-n2 == 1	) esc++;   //if(n2-n1 == 1	) esc++;
			else
			{
				j=i;
			}
				
			/*else 
			{
				if(n1!=1) j=i;
				else as=true;
			}*//*
		}
		
		
		
		if(esc ==3 )
		{
			if(as && n2==12) esc++;
		}
		
		
		if(esc==4 ) //&& esc!=5  asi sie s escalera no repite draws 
		{
			if(j==0 || j>= 3)
				proyectoEscaleraAbierta=true;
			else
				proyectoEscaleraInterrumpida=true;
			
		}
		
		*/
	}
	
}
