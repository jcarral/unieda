package student;

import java.util.*;
//Tiempo empleado: 20 minutos


public class AlgPunto2D {

	// Devuelve un nuevo array con el rango de cada uno de los puntos
	// especificados.
	public int[] compute(Punto2D[] points) {
		int[] res = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			iteraCompute(points, res, i);
		}

		return res;
	}
	
	private static void iteraCompute(Punto2D[] points, int[] res, int i){
		for (int j = 0; j < points.length; j++) {
			if (i == j)
				continue;
			if (points[i].getX() > points[j].getX() && points[i].getY() > points[j].getY())
				res[i]++;
		}
	}

	/*
	 * Devuelve un nuevo array con el rango-x de cada uno de los puntos
	 * especificados. Precondición: los puntos están ordenados según abscisa
	 */

	public int[] compute_x(Punto2D[] points) {
		int[] res = new int[points.length];
		for(int i = 0; i<res.length; i++)
			res[i] = i;
		return res;
	}

	/*
	 * Devuelve un nuevo array con el rango-y de cada uno de los puntos
	 * especificados. Precondición: los puntos están ordenados según ordenada
	 */

	public int[] compute_y(Punto2D[] points) {
		int[] res = new int[points.length];
		for(int i = 0; i<res.length; i++)
			res[i] = i;
		return res;
	}
	

	
}