package hw1;

import java.util.*;
//Tiempo empleado: 20 minutos

import ehu.RankListPunto2D;


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
	
public static void main(String[] args){
	int n = 100000;
	Punto2D[] pts = new Punto2D[n];
/*
	pts[0] = new Punto2D(9, 9); // 5
	pts[1] = new Punto2D(4, 2); // 0
	pts[2] = new Punto2D(6, 8); // 3
	pts[3] = new Punto2D(7, 6); // 3
	pts[4] = new Punto2D(10, 1); // 0
	pts[5] = new Punto2D(5, 4); // 2
	pts[6] = new Punto2D(2, 3); // 0
	*/
	for(int i = 0; i<n; i++){
		int num1 = (int)Math.floor(Math.random()*(1-100)+100);
		int num2 = (int)Math.floor(Math.random()*(1-100)+100);
		pts[i] = new Punto2D(num1, num2);
	}

	AlgPunto2D rp = new AlgPunto2D();
	int[] v = rp.compute(pts);

	for (int i = 0; i < n; i++) {
		System.out.println(v[i]);
	}

}
	
}