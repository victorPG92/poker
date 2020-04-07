package poker.negocio.dtos;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import poker.negocio.constantes.ConstantesPR2;
import poker.negocio.dtos.manojugador.ManoSimple;
import poker.negocio.util.PosicionXY;
import pr2.parser.LetraNumRango;

/**
 * Representa la instancia del rango actual
 * Un rango es conjunto de manos que un jugador usa
 * esta estructura estara compuesta por todas la manos posible, cada una con un atributo incluido
 *  o no en el rango
 * @author victor
 *
 */
public class Rango 
{
	private int Tam=ConstantesPR2.TAM;
	
	private ManoRango[][] matriz = new ManoRango[Tam][Tam];
	private LetraNumRango l = new LetraNumRango();
	private ArrayList<ManoRango> manos= new ArrayList<ManoRango>();
	
	//private Set<ManoRango> insertados = new TreeSet<ManoRango>();
	
	
	//singleton????? si uso tablas y apartado 2.3 noo
	//private static Rango inst;
	/*public static  Rango getInst()
	{
		if(inst==null) inst= new Rango();
		return inst;
	}
*/

	public Rango()//columnas
	{
		for(int i=0;i<Tam;i++)//filas
		{
			for(int j=0;j<Tam;j++)//filas
			{
				boolean suited= j>i; 
				matriz[i][j]= new ManoRango(i,j,suited);
			}
		}
	}
	

	
	public void insertaRango(char cadena[])
	{
		if (cadena==null) return ;
		
		int n1= l.num(cadena[0]);
		int n2= l.num(cadena[1]);
		if(n1>=n2)//por convenio se escribe el mayor el primero 
		{
		
			if(cadena.length==2 && cadena[0]==cadena[1])//pareja
			{
				insertaRango(n1, n1);//matriz[n1][n1].setIncluido(true);
			}
			else if(cadena.length==3 && cadena[0]==cadena[1] && cadena[2]=='+')//pareja subir
			{
				for(int i=n1;i<Tam;i++)
					insertaRango(i, i);//	matriz[i][i].setIncluido(true);
			}
			
			else if(cadena.length==3 && cadena[0]!=cadena[1] && (cadena[2]=='o' || cadena[2]=='s') )
			{
				//INVERTIR N1 Y N2
				if(cadena[2]=='s') 
					insertaRango(n1, n2);//matriz[n1][n2].setIncluido(true);
				else if(cadena[2]=='o') 
					insertaRango(n2, n1);//matriz[n2][n1].setIncluido(true);
			}
			
			else if(cadena.length==4 && cadena[0]!=cadena[1] && (cadena[2]=='o' || cadena[2]=='s') && cadena[3]=='+' )//pareja subir
			{
				if(cadena[2]=='s') 
				{
					for(int i=n2;i<n1;i++)
					{
						if(i<=n1)	insertaRango(n1, i);//matriz[n1][i].setIncluido(true);
						else 		insertaRango(i, n1);//matriz[i][n1].setIncluido(true);
					}
				}
				else if(cadena[2]=='o') 
				{
					for(int i=n2;i<Tam;i++)
					{
						if(i<=n1)	insertaRango(i, n1);//matriz[i][n1].setIncluido(true);
						else 		insertaRango(n1, i);//matriz[n1][i].setIncluido(true);
					}
				}
			}
			
			else if(cadena.length==5 && cadena[0]==cadena[1] && cadena[3]==cadena[4]&&  cadena[2]=='-')//pareja subir
			{
				if(n1<l.num(cadena[3]))
						n2=l.num(cadena[3]);
				else 
				{
					n2=n1;
					n1=l.num(cadena[3]);
				}
				for(int i=n1;i<=n2;i++)
					insertaRango(i, i);//matriz[i][i].setIncluido(true);
			}
			
			//else if(cadena.length==7 && cadena[0]==cadena[1] && cadena[4]==cadena[5] &&  cadena[2]==cadena[6] &&  cadena[3]=='-' && (cadena[2]== 'o' || cadena[2]=='s') )//pareja subir
				
			else if(cadena.length==7 && cadena[0]==cadena[4] &&  cadena[2]==cadena[6] &&  cadena[3]=='-' && (cadena[2]== 'o' || cadena[2]=='s') )
			{
				if(n1<l.num(cadena[3]))
						n2=l.num(cadena[3]);
				else 
				{
					n2=n1;
					n1=l.num(cadena[3]);
				}
				
				
				
				if(cadena[2]=='s') 
				{
					for(int i=n2;i<n1;i++)
					{
						if(i<=n1)	insertaRango(n1,i);//matriz[n1][i].setIncluido(true);
						//else 		matriz[i][n1].setIncluido(true);
					}
				}
				else if(cadena[2]=='o') 
				{
					for(int i=n2;i<Tam;i++)
					{
						if(i<=n1)	insertaRango(i, n1);//matriz[i][n1].setIncluido(true);
						//else 		matriz[n1][i].setIncluido(true);
					}
				}
			}
		}
		
	}
	
	

	public void insertaRango(String cadena)
	{
		if(cadena==null) return;
		
		cadena = cadena.trim();//elimina los espacios en blanco
		
		//System.out.println(cadena);
		
		if(cadena.equalsIgnoreCase(ConstantesPR2.RANDOM))
		{
			Random r = new Random();
			matriz[r.nextInt(Tam)][r.nextInt(Tam)].setIncluido(true);
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.SUITED))
		{
			this.anySuited();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.OFFSUITED))
		{
			this.anyOffSuited();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.BROADWAY))
		{
			this.broadway();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.BROADWAY_SUITED))
		{
			this.broadwaySuited();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.BROADWAY_OFFSUITED))
		{
			this.broadwayOffSuited();
			return;
		}
		
		else if(cadena.equalsIgnoreCase(ConstantesPR2.NO_BROADWAY))
		{
			this.nobroadway();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.NO_BROADWAY_SUITED))
		{
			this.nobroadwaySuited();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.NO_BROADWAY_OFFSUITED))
		{
			this.nobroadwayOffSuited();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.ALL))
		{
			this.all();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.SUITED_CONECTORS))
		{
			this.suitedConectors();
			return;
		}
		else if(cadena.equalsIgnoreCase(ConstantesPR2.BROADWAY_CONECTORS))
		{
			this.offSuitedConectors();
			return;
		}
		
		
		
		int n1= l.num(cadena.charAt(0));
		int n2= l.num(cadena.charAt(1));
		
	//	System.out.println(n1);
		
		if(n1>=n2)//por convenio se escribe el mayor el primero 
		{
		
			if(cadena.length()==2 && cadena.charAt(0)==cadena.charAt(1))//pareja
			{
				matriz[n1][n1].setIncluido(true);
			}
			else if(cadena.length()==3 && cadena.charAt(0)==cadena.charAt(1) && cadena.charAt(2)=='+')//pareja subir
			{
				for(int i=n1;i<Tam;i++)
					insertaRango(i, i);//matriz[i][i].setIncluido(true);
			}
			
			else if(cadena.length()==3 && cadena.charAt(0)!=cadena.charAt(1) && (cadena.charAt(2)=='o' || cadena.charAt(2)=='s') )
			{
				if(cadena.charAt(2)=='s') 
					insertaRango(n1, n2);//matriz[n1][n2].setIncluido(true);
				else if(cadena.charAt(2)=='o') 
					insertaRango(n2, n1);//matriz[n2][n1].setIncluido(true);
			}
			
			else if(cadena.length()==4 && cadena.charAt(0)!=cadena.charAt(1) && (cadena.charAt(2)=='o' || cadena.charAt(2)=='s') && cadena.charAt(3)=='+' )//pareja subir
			{
				if(cadena.charAt(2)=='s') 
				{
					for(int i=n2;i<n1;i++)
					{
						if(i<n1)	insertaRango(n1, i);//matriz[n1][i].setIncluido(true);
						//else 		matriz[i][n1].setIncluido(true);
					}
				}
				else if(cadena.charAt(2)=='o') 
				{
					for(int i=n2;i<Tam;i++)
					{
						if(i<n1)	insertaRango(i, n1);//matriz[i][n1].setIncluido(true);
						//else 		matriz[n1][i].setIncluido(true);
					}
				}
			}
			
			else if(cadena.length()==5 && cadena.charAt(0)==cadena.charAt(1) && cadena.charAt(3)==cadena.charAt(4)&&  cadena.charAt(2)=='-')//pareja subir
			{
				if(n1<l.num(cadena.charAt(3)))
						n2=l.num(cadena.charAt(3));
				else 
				{
					n2=n1;
					n1=l.num(cadena.charAt(3));
				}
				for(int i=n1;i<=n2;i++)
					insertaRango(i, i);//matriz[i][i].setIncluido(true);
			}
			
			//else if(cadena.length==7 && cadena.charAt(0]==cadena.charAt(1] && cadena.charAt(4]==cadena.charAt(5] &&  cadena.charAt(2]==cadena.charAt(6] &&  cadena.charAt(3]=='-' && (cadena.charAt(2]== 'o' || cadena.charAt(2]=='s') )//pareja subir
				
			else if(cadena.length()==7 && cadena.charAt(0)==cadena.charAt(4) &&  cadena.charAt(2)==cadena.charAt(6) &&  cadena.charAt(3)=='-' && (cadena.charAt(2)== 'o' || cadena.charAt(2)=='s') )
			{
				
				/*
				if(n1<l.num(cadena.charAt(3)))
						n2=l.num(cadena.charAt(3));
				else 
				{
					n2=n1;
					n1=l.num(cadena.charAt(3));
				}
				*/
				//System.out.println("n1= "+ n1);
				//System.out.println("n2= "+ n2);
				
				if(cadena.charAt(2)=='s') 
				{
					for(int i=l.num(cadena.charAt(5));i<=n2;i++)
					{
						if(i<=n1)	insertaRango(n1, i);//matriz[n1][i].setIncluido(true);
						//else 		matriz[i][n1].setIncluido(true);
					}
				}
				else if(cadena.charAt(2)=='o') 
				{
					for(int i=l.num(cadena.charAt(5));i<=n2;i++)
					{
						if(i<=n1)	insertaRango(i, n1);//matriz[i][n1].setIncluido(true);
						//else 		matriz[n1][i].setIncluido(true);
					}
				}
			}
		}
		
	}
	
	
	public void insertaRangoLinea(String cadena)
	{
		if(cadena!=null)
		{
			StringTokenizer st = new StringTokenizer(cadena, ",");
			
			int n= st.countTokens();
			
			String tokens[] = new String[n];
			
			/*
			while(st.hasMoreTokens())
			  insertaRango(st.nextToken());
			 
			 */
			
			
			for(int  i=0; i< n;i++)
			{
				
				tokens[i]= st.nextToken();
				insertaRango(tokens[i]);
				
				//System.out.println(tokens[i]);
				
			}
		
		}
		
		
		
		
	}
	
	
	public void insertaRango(int i, int j)
	{
		if( !matriz[i][j].isIncluido())
		{
			matriz[i][j].setIncluido(true);
			manos.add(matriz[i][j]);
		}
			
		
	}
	
	private void insertaRango(int i, int j,boolean s)
	{
		if(i>=0  && j>=0 && i<13 && j<13)
		{
			if(s) matriz[i][j].setIncluido(true);
			else  matriz[j][i].setIncluido(true);
		}
	}
	
	public void insertaRango(ArrayList<ManoRango> l)
	{
		for(ManoRango m : l)
		{
			 insertaRango( m);
		}
		
	}
	
	public void insertaRango(ManoRango m)
	{
		if(m!=null)
		{
			
			PosicionXY p = m.damePos();
			int i=p.getX();
			int j=p.getY();
			
			//System.out.println("inserta "+m +" en "+ i+" " +j);
			//System.out.println("inserta "+m +" en "+ i+j);
			
			//if(i==-1 || j==-1)	System.out.println(m);
			
			
			
			insertaRango(i,j,m.isSuited());
			//matriz[i][j].setIncluido(true);
		}
		
	}
	
	public boolean isActivo(int i, int j)
	{
		return matriz[i][j].isIncluido();
	}
	
	
	public ManoRango dameMano(int i, int j)
	{
		return matriz[i][j];
	}
	
	public double porcentaje()
	{
		double p=0;
		double pt=0;
		for(int i=Tam-1;i>=0;i--)//filas
		{
			for(int j=Tam-1;j>=0;j--)//filas
			{
				pt+=matriz[i][j].valor();
			if(matriz[i][j].isIncluido())
				p+=matriz[i][j].valor();
			
			}
			
			
		}
		System.out.println(p+" "+pt);
		
		// System.out.println(p);
		// System.out.println(pt);
		
		return (p/pt)*100;
	}
	
	
	
	
	public ManoRango[][] getMatriz() {
		return matriz;
	}


	public  String toString()
	{
		ArrayList<ManoRango> m = new ArrayList<ManoRango>();
		
		StringBuffer sb = new StringBuffer();
		for(int i=Tam-1;i>=0;i--)//filas
		{
			for(int j=Tam-1;j>=0;j--)//filas
			{
			
			if(matriz[i][j].isIncluido())
			{
				sb.append("X");
				m.add(matriz[i][j]);
			}
			else sb.append("-");
			}
			sb.append("\n");
		}
		
		//System.out.println(m);
		
		return sb.toString();
	}
	
	public ArrayList<String> dameCoordNombre()
	{
		ArrayList<String> l=new ArrayList<String>();
		for(int i=Tam-1;i>=0;i--)//filas
		{
			for(int j=Tam-1;j>=0;j--)//filas
			{
				if(matriz[i][j].isIncluido())
					l.add(matriz[i][j].toString());
					//l.add(Integer.toString(i) + Integer.toString(j));
			}
		
		}
		return l;
	}
	
	public ArrayList<String> dameCoordNumero()
	{
		ArrayList<String> l=new ArrayList<String>();
		for(int i=Tam-1;i>=0;i--)//filas
		{
			for(int j=Tam-1;j>=0;j--)//filas
			{
				if(matriz[i][j].isIncluido())
				{
					System.out.println();
					l.add((i+2)+""+(j+2));
					
				}
			}
		
		}
		return l;
	}
	
	
	public boolean isIncluido(ManoSimple m)
	{
		
		if(m==null)
		{
			System.err.println("mano null a en comprobar incluido");
			return false;
			
		}
		return isIncluido(m.toManoRango());
	}
	
	public boolean isIncluido(ManoRango m)
	{
		boolean b=false;
		if(m!=null)
		{
			if(m.isSuited() ) b= isActivo(m.getN1(),m.getN2());
			else 			  b= isActivo(m.getN2(),m.getN1());	
		}
		return b; 
	}
	
	public void quitarMano(ManoRango m)
	{

		if(m!=null)
		{
			if(m.isSuited() )  this.dameMano(m.getN1(),m.getN2()).setIncluido(false);
			else 			  this.dameMano(m.getN2(),m.getN1()).setIncluido(false);	
		}
	}
	
	public void clearAll()
	{
		 manos= new ArrayList<ManoRango>();
		for(int i=0;i<Tam;i++)//filas
		{
			for(int j=0;j<Tam;j++)//filas
			{
				
				matriz[i][j].setIncluido(false);
			}
		}
		
	}
	
	
	public void todo()
	{
		for(int i=0;i<Tam;i++)//filas
		{
			for(int j=0;j<Tam;j++)//filas
			{
				
				insertaRango(i,j);//matriz[i][j].setIncluido(true);
				
			}
		}
	}
	
	public void all()
	{
		//clearAll();
		 todo();
		
	}
	
	public void suited()
	{
		for(int i=0;i<Tam;i++)//filas
		{
			for(int j=0;j<Tam;j++)//filas
			{
				boolean suited= j<i;
				if(suited)
				{
					insertaRango(i,j);//matriz[i][j].setIncluido(true);
					if(!matriz[i][j].isIncluido())	insertaRango(i,j);//matriz[i][j].setIncluido(true);
				}
				//else matriz[i][j].setIncluido(false);
			}
		}
	}
	
	public void anySuited()
	{
		//clearAll();
		suited();
		
	}
	
	
	public void broadway()
	{
		broadwaySuited();
		broadwayOffSuited();
	}
	
	public void broadwaySuited()
	{
		for(int i=ConstantesPR2.T;i<Tam;i++)
		{
			int j= i;//+1;
			for(;j<Tam;j++)
				insertaRango(j,i);//matriz[j][i].setIncluido(true);
		}
	}
	
	public void broadwayOffSuited()
	{
		for(int i=ConstantesPR2.T;i<Tam;i++)//filas
		{
			int j=i;//+1;
			for(;j<Tam;j++)//filas
				insertaRango(i,j);//matriz[i][j].setIncluido(true);
		}
	}
	
	public void nobroadway()
	{
		nobroadwaySuited();
		nobroadwayOffSuited();
	}
	
	public void nobroadwaySuited()
	{
		for(int i=0 ; i<ConstantesPR2.T;i++)//filas
		{
			int j=i;//+1;
			for(;j<ConstantesPR2.T;j++)//filas
				insertaRango(j,i);//matriz[j][i].setIncluido(true);
		}
	}
	
	public void nobroadwayOffSuited()
	{
		for(int i=0 ; i<ConstantesPR2.T;i++)//filas
		{
			int j=i;//+1;
			for(;j<ConstantesPR2.T;j++)//filas
				insertaRango(i,j);//matriz[i][j].setIncluido(true);
		}
	}
	
	
	public void off()
	{
		for(int i=0;i<Tam;i++)//filas
		{
			for(int j=0;j<Tam;j++)//filas
			{
				if(i!=j)
				{
					boolean suited= j<i;
					if(!suited)
					{
						insertaRango(i,j);//matriz[i][j].setIncluido(true);
						if(!matriz[i][j].isIncluido())	insertaRango(i,j);//matriz[i][j].setIncluido(true);
					}
					//else 		matriz[i][j].setIncluido(false);
				}
			}
		}
	}
	
	public void anyOffSuited()
	{
		//clearAll();
		off();
		
	}
	
	
	public void pair()
	{
		for(int i=0;i<Tam;i++)//filas
		{
			insertaRango(i,i);//matriz[i][i].setIncluido(true);
			if(!matriz[i][i].isIncluido())	insertaRango(i,i);//matriz[i][i].setIncluido(true);
		}
	}
	
	public void anyPair()
	{
		//clearAll();
		pair();
			
	}
	
	public void suitedConectors()
	{
		
		
		for(int i=0;i<Tam-1;i++)//filas
		{
			insertaRango(i+1,i);//matriz[i+1][i].setIncluido(true);
			
		}
		
	}
	
	public void offSuitedConectors()
	{
		for(int i=0;i<Tam-1;i++)//filas
		{
			insertaRango(i,i+1);//matriz[i][i+1].setIncluido(true);
			if(!matriz[i][i+1].isIncluido())	insertaRango(i,i+1);//matriz[i][i+1].setIncluido(true);
		}
	}
	
	public ArrayList<ManoRango> dameManos()
	{
		return manos;
	}
	
	
	
	
}
