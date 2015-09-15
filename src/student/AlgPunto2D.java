package student;

import java.util.*;

public class AlgPunto2D {

	// Devuelve un nuevo array con el rango de cada uno de los puntos
	// especificados.
	public int[] compute(Punto2D[] points) {
		int[] res = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			int num = 0;
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				if (points[i].getX() > points[j].getX() && points[i].getY() > points[j].getY())
					res[i]++;
			}
		}

		return res;
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

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < i; j++) {
				if (points[i].getY() > points[j].getY())
					res[i]++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		AlgPunto2D alg = new AlgPunto2D();
		//Punto2D [] puntos = { new Punto2D(3, 4), new Punto2D(5,6), new Punto2D(8,9), new Punto2D(2,1) };
		//System.out.println(Arrays.toString(alg.compute(puntos)));
		Punto2D[] puntos2 = new Punto2D[1000];
		for(int i = 0; i<1000; i++){
			puntos2[i]= new Punto2D(Math.random(), Math.random());			
		}
		System.out.println(Arrays.toString(puntos2));
		System.out.println(Arrays.toString(alg.compute(puntos2)));
	}
}