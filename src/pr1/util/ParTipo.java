package pr1.util;


/**
 * 
 * @author victor
 * Estructura que permite emparejar dos elementos del mismo tipo
  */
public class ParTipo<T>
{
	
	private T elem1;
	private T elem2;
	
	public ParTipo(T e1, T e2)
	{
		elem1=e1;
		elem2=e2;
	}

	public T getElem1() {
		return elem1;
	}

	public void setElem1(T elem1) {
		this.elem1 = elem1;
	}

	public T getElem2() {
		return elem2;
	}

	public void setElem2(T elem2) {
		this.elem2 = elem2;
	}
	
	public String toString()
	{
		return "[" + elem1.toString() + ", " + elem2.toString() +"]"; 
	
	}
}
