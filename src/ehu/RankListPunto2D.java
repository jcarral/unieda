package ehu;

import java.util.*;

import student.Punto2D;

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

		computeInternal(v, 0, v.length);

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
		if (from >= to)
			return;
		int mid = (from + to) / 2;
		computeInternal(points, from, mid);
		computeInternal(points, mid + 1, to);
		
		if(to>=points.length)
			to--;
		marcarIzquierda(points, from, mid);
		ordenarY(points, from, mid + 1, to);
		calcularRank(points, from, to);

	}

	private void calcularRank(Punto2DExtended[] points, int from, int to) {
		int addRank = 0;
		
		for (int i = from; i <= to && i<points.length-1; i++) {
			if (points[i].isLeft) {
				addRank++;
				points[i].isLeft = false;
			} else {
				points[i].rank += addRank;
			}
		}

	}

	private void marcarIzquierda(Punto2DExtended[] points, int from, int to) {

		for (int i = from; i <= to; i++)
			points[i].isLeft = true;
	}

	private void ordenarY(Punto2DExtended[] points, int from, int mid, int to) {
		if (mid >= points.length)
			return;
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

	private void copiarArray(Punto2DExtended[] points, Punto2DExtended[] aux, int from) {
		for (int i = from, j = 0; i < aux.length; i++, j++)
			points[i] = aux[j];
	}

	private static Punto2DExtended[] ordenarAbscisa(Punto2DExtended[] list) {
		if (list.length <= 1) {
			return list;
		}

		// Split the array in half
		Punto2DExtended[] first = new Punto2DExtended[list.length / 2];
		Punto2DExtended[] second = new Punto2DExtended[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);

		// Sort each half
		ordenarAbscisa(first);
		ordenarAbscisa(second);

		// Merge the halves together, overwriting the original array
		ordenarAbscisa(first, second, list);
		return list;
	}

	private static void ordenarAbscisa(Punto2DExtended[] first, Punto2DExtended[] second, Punto2DExtended[] result) {
		// Merge both halves into the result array
		// Next element to consider in the first array
		int iFirst = 0;
		// Next element to consider in the second array
		int iSecond = 0;

		// Next open position in the result
		int j = 0;
		// As long as neither iFirst nor iSecond is past the end, move the
		// smaller element into the result.
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
		// copy what's left
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

		// Para que cada punto mantenga la informaciÛn de su rango y grupo.
		// TambiÈn su posociÛn original en points

		RankListPunto2D rp = new RankListPunto2D();
		int[] v = rp.compute(pts);

		for (int i = 0; i < 7; i++) {
			System.out.println(v[i]);
		}
	}
}