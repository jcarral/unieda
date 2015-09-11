package student;

import java.util.*;

public class AlgPunto2D {
	
	// Devuelve un nuevo array con el rango de cada uno de los puntos
	// especificados.
	public int[] compute(Punto2D[] points) {
		int[] res = new int[points.length];
		
		for(int i = 0; i<points.length; i++){
			int num = 0;
			for(int j = 0; j<points.length; j++){
				if (i == j)
					continue;
			}
		}
		
		return res;
	}
	
	
	/*
	 * Devuelve un nuevo array con el rango-x de cada uno de los puntos
	 * especificados. Precondición: los puntos están ordenados según abscisa
	 */

	//public int[] compute_x(Punto2D[] points) {
	//}
	
	
	/*
	 * Devuelve un nuevo array con el rango-y de cada uno de los puntos
	 * especificados. Precondición: los puntos están ordenados según ordenada
	 */

	//public int[] compute_y(Punto2D[] points) {
	//}
}