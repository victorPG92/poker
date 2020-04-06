package pr2.parser;

/**
 * Parsea los valores , las posiciones, y las letras de la manos
 * @author victor
 *
 */
public class LetraNumRango
{

	private char letras[];
	private int Tam=13;
	
	public LetraNumRango()
	{
		letras= new char[Tam];
		for(int i=0;i<Tam;i++)
		{
			if(i>=0 && i <8)
				letras[i]= Integer.toString(i+2).charAt(0);
			if(i==8)letras[i]='T';
			if(i==9)letras[i]='J';
			if(i==10)letras[i]='Q';
			if(i==11)letras[i]='K';
			if(i==12)letras[i]='A';
				
		}
	}
	
	public char letra(int i)
	{
		return letras[i];
		
		
	}
	
	public int num(char c)
	{
		int n=-1;
		
		if(c== 'A')	n= 12;
		else if(c== 'K')	n= 11;
		else if(c== 'Q')	n= 10;
		else if(c== 'J')	n= 9;
		else if(c== 'T')	n= 8;
		else if(Character.isDigit(c))n = Character.getNumericValue(c)-2 ;	
		
		return n;
	}
	
	
	public int numCristian(char c)
	{
		int n=-1;
		
		if(c== 'A')	n= 14;
		else if(c== 'K')	n= 13;
		else if(c== 'Q')	n= 12;
		else if(c== 'J')	n= 11;
		else if(c== 'T')	n= 10;
		else if(Character.isDigit(c))n = Character.getNumericValue(c) ;	
		
		return n;
	}
	
	
	
	public int pos(int c)
	{
		/*
		int n=-1;
		
		n = 14 - c;	
		
		return n;*/
		
		return c;
	}

}
