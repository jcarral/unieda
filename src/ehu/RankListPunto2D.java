package ehu;

import java.util.*;

import student.Punto2D;

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
	public int[] compute(Punto2D[] points) {
		Punto2DExtended[] v = new Punto2DExtended[points.length];

		// Para que cada punto mantenga la informaciÛn de su rango y grupo.
		// TambiÈn su posociÛn original en points
		for (int i = 0; i < v.length; i++)
			v[i] = new Punto2DExtended(points[i], i);
		v = ordenarAbscisa(v);

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

	/**
	 * Ordena el array de entrada según la abscisa usando un algoritmo mergesort
	 * con coste O(nlogn)
	 * 
	 * @param list
	 *            Array con todos los elementos de la lista
	 * @return Devuelve una lista ordenada según la abscisa
	 */
	private static Punto2DExtended[] ordenarAbscisa(Punto2DExtended[] list) {
		if (list.length <= 1) {
			return list;
		}

		Punto2DExtended[] first = new Punto2DExtended[list.length / 2];
		Punto2DExtended[] second = new Punto2DExtended[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);

		ordenarAbscisa(first);
		ordenarAbscisa(second);

		ordenarAbscisa(first, second, list);
		return list;
	}

	// Función auxiliar
	private static void ordenarAbscisa(Punto2DExtended[] first, Punto2DExtended[] second, Punto2DExtended[] result) {
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;

		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].point.getX() < second[iSecond].point.getX()) {
				result[j] = first[iFirst];
				iFirst++;
			} else {
				result[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}

		System.arraycopy(first, iFirst, result, j, first.length - iFirst);
		System.arraycopy(second, iSecond, result, j, second.length - iSecond);
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
		Punto2D[] pts = new Punto2D[7];

		pts[0] = new Punto2D(9, 9); // 5
		pts[1] = new Punto2D(4, 2); // 0
		pts[2] = new Punto2D(6, 8); // 3
		pts[3] = new Punto2D(7, 6); // 3
		pts[4] = new Punto2D(10, 1); // 0
		pts[5] = new Punto2D(5, 4); // 2
		pts[6] = new Punto2D(2, 3); // 0

		RankListPunto2D rp = new RankListPunto2D();
		int[] v = rp.compute(pts);

		for (int i = 0; i < 7; i++) {
			System.out.println(v[i]);
		}
	}
}