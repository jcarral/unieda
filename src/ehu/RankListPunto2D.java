package ehu;

import java.util.Arrays;
import java.util.Comparator;

import hw1.Punto2D;

/**
 * Tiempo utilizado: 2h
 * 
 * Calcula el rango de cada elemento del array utilizando un algoritmo recursivo
 * con coste O(nlogn). El funcionamiento es el siguiente: primero se ordena el
 * array inicial según la abscisa y posteriormente se empieza a dividir en
 * subarrays más pequeños de tamaño n/2 cada vez hasta que se llega al caso base
 * donde el tamaño es 1. A partir de ahí se vuelven a fusionar en el mismo orden
 * pero esta vez ordenandolo según la ordenada y luego se calcula el rango de
 * cada elemento contando los elementos que vienen por su izquierda y además una
 * vez ordenados sobre el eje Y siguen a la izquierda del array.
 *
 */
public class RankListPunto2D {

	/**
	 * @param points
	 * @return Un nuevo array con el rango del punto i-esimo en la posiciÛn
	 *         i-esima
	 */
	@SuppressWarnings("unchecked")
	public int[] compute(Punto2D[] points) {
		Punto2DExtended[] v = new Punto2DExtended[points.length];

		// Para que cada punto mantenga la informaciÛn de su rango y grupo.
		// TambiÈn su posociÛn original en points
		for (int i = 0; i < v.length; i++)
			v[i] = new Punto2DExtended(points[i], i);

		Arrays.sort(v, new Comparator<Punto2DExtended>(){

			public int compare(Punto2DExtended o1, Punto2DExtended o2) {
				if(o1.point.getX()< o2.point.getX())
					return -1;
				else if(o1.point.getX() > o2.point.getX())
					return 1;
				else
					return 0;
						
			}
			
		});

		computeInternal(v, 0, v.length - 1);

		int[] r = new int[v.length];
		// Copiar el rango de cada punto en la posiciÛn correspondiente del
		// array a devolver
		for (int i = 0; i < v.length; i++) {
			Punto2DExtended p = v[i];
			r[p.originalIndex] = p.rank;
		}
		return r;
	}

	private void computeInternal(Punto2DExtended[] points, int from, int to) {
		int size = to - from + 1;
		if (size == 1 || size == 0)
			return;
		int mid = from + to - ((from + to) / 2);

		if (size == 2) {
			computeInternal(points, from, from);
			computeInternal(points, to, to);
			marcarIzquierda(points, from, from);
			ordenarY(points, from, mid, to);
			calcularRank(points, from, to);
		} else {
			computeInternal(points, from, mid - 1);
			computeInternal(points, mid, to);
			marcarIzquierda(points, from, mid - 1);
			ordenarY(points, from, mid, to);
			calcularRank(points, from, to);
		}

	}

	/**
	 * Pre: Secuencia ordenada segun la ordenada Calcula el rango de los
	 * elementos que estan en la parte derecha. Para calcularlo cada vez que
	 * pasa por un elemento que tiene marcado isLeft añade uno a la variable
	 * addRank, si no tiene isLeft entoces aumenta su rango con addRank puesto
	 * que son los cantidad de numeros que estan a la izquierda y con menor
	 * ordenada.
	 * 
	 * @param points
	 *            Array con todos los puntos
	 * @param from
	 *            Indice desde el que empezar a contar
	 * @param to
	 *            Indice del último que se cuenta
	 */
	private void calcularRank(Punto2DExtended[] points, int from, int to) {
		int addRank = 0;

		for (int i = from; i <= to; i++) {
			if (points[i].isLeft) {
				addRank++;
				points[i].isLeft = false;
			} else {
				points[i].rank += addRank;
			}
		}

	}

	/**
	 * Marca como isLeft todos los elementos que en ese momento estan en la
	 * parte izquierda
	 * 
	 * @param points
	 *            Array con todos los puntos
	 * @param from
	 *            Indice desde el que empezar a contar
	 * @param to
	 *            Indice hasta el que contar
	 */
	private void marcarIzquierda(Punto2DExtended[] points, int from, int to) {

		for (int i = from; i <= to; i++)
			points[i].isLeft = true;
	}

	/**
	 * Ordena según la ordenada fusionando todos los elementos que van desde
	 * from hasta mid con los que van desde mid hasta to
	 * 
	 * @param points
	 *            Array con todos los puntos
	 * @param from
	 *            Indice desde el que empezar a contar
	 * @param mid
	 *            Indice del segundo subarray
	 * @param to
	 *            Indice del último elemento
	 */
	private void ordenarY(Punto2DExtended[] points, int from, int mid, int to) {

		Punto2DExtended[] aux = new Punto2DExtended[to - from + 1];
		int i = 0;
		int auxFrom = from, auxMid = mid;
		while (auxFrom < mid && auxMid <= to && i < aux.length) {
			if (points[auxFrom].point.getY() < points[auxMid].point.getY()) {
				aux[i] = points[auxFrom];
				auxFrom++;
			} else {
				aux[i] = points[auxMid];
				auxMid++;
			}
			i++;
		}
		while (auxFrom < mid && i < aux.length) {
			aux[i] = points[auxFrom];
			auxFrom++;
			i++;
		}
		while (auxMid <= to && i < aux.length) {
			aux[i] = points[auxMid];
			auxMid++;
			i++;
		}

		copiarArray(points, aux, from);
	}

	/**
	 * Copia todos los elementos del array aux en points empezando desde front
	 * 
	 * @param points
	 *            Array con todos los puntos
	 * @param aux
	 *            Array con los elementos ordenados
	 * @param from
	 *            Indice desde el que empezar a copiar
	 */
	private void copiarArray(Punto2DExtended[] points, Punto2DExtended[] aux, int from) {
		for (int i = from, j = 0; j < aux.length; i++, j++)
			points[i] = aux[j];
	}

	private static class Punto2DExtended {
		Punto2D point;
		int originalIndex;
		boolean isLeft;
		int rank = 0;

		Punto2DExtended(Punto2D point, int index) {
			this.point = point;
			this.originalIndex = index;
		}
	}

	/**
	 * Tests
	 */
	public static void main(String[] args) {
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

		RankListPunto2D rp = new RankListPunto2D();
		int[] v = rp.compute(pts);

		for (int i = 0; i < n; i++) {
			System.out.println(v[i]);
		}
	}
}