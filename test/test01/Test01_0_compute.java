package test01;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import ehu.RankListPunto2D;
import student.AlgPunto2D;
import student.Punto2D;

public class Test01_0_compute extends Test01_0_compute_abstract {

	@Test
	public void threeExt() {
		int[] v = newAlg().apply(new Punto2D[] { x_2, x_0, x_1 });
		assertTrue("compute*({(0, 0}, (1, 1), (2, 2)})",
				Arrays.equals(new int[] { 2, 0, 1 }, v));
	}

	@Test
	public void noDomina() {
		int[] v = newAlg().apply(new Punto2D[] { x_0, new Punto2D(-1, 1) });
		assertTrue("compute*({(0, 0}, (-1, 1))})",
				Arrays.equals(new int[] { 0, 0 }, v));
	}

	@Override
	public Function newAlg() {
		return new Function() {
			@Override
			public int[] apply(Punto2D[] points) {
				return new RankListPunto2D().compute(points);
			}
		};
	}
}
