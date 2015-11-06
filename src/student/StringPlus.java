package student;

/**
 * Tiempo empleado: 
 *
 */
public class StringPlus {

	private final int size;
	private String txt;
	private StringPlus left;
	private StringPlus right;
	
	public StringPlus(String s){
		txt = s;
		size = s.length();
	}
	
	private StringPlus(StringPlus sp1, StringPlus sp2){
		
	}
	
	public int size(){
		return size;
	}
	
	/**
	 * Devuelve un nuevo objeto que representa la secuencia de este StringPlus concatenada al especificado
	 * @param otro StringPlus que se concatena
	 * @return nuevo StringPlus
	 */
	public StringPlus concat(StringPlus otro){
		return new StringPlus(this, otro);
	}
	
	/**
	 * Devuelve true si la cadena de caracteres representada por este StringPlus es un prefijo de la secuencia de caracteres por el StringPlus especificado
	 * @param s StringPlus especificado
	 * @return true si 'this' es prefijo de 's'
	 */
	public boolean isPrefix(StringPlus s){
		return false;
	}
	
	
	/**
	 * Devuelve una subsecuencia de la secuencia de caracteres representada por este StringPlus.
	 * @param beginIndex
	 * @param endIndex
	 * @return StringPlus que representa una subsecuencia de caracteres.
	 * @throws IndexOutOfBoundsException 
	 */
	public StringPlus substring(int beginIndex, int endIndex) throws IndexOutOfBoundsException{
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return null;
	}
}
