package test01;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import student.AlgPunto2D;
import student.Punto2D;

public abstract class Test01_0_compute_abstract {
	AlgPunto2D alg;
	Punto2D x_0 = new Punto2D(0, 0);
	Punto2D x_1 = new Punto2D(1, 1);
	Punto2D x_2 = new Punto2D(2, 2);
	Punto2D x_3 = new Punto2D(3, 3);

	@Test
	public void empty() {
		int[] v = newAlg().apply(new Punto2D[] {});
		assertTrue("compute*({}) should be {}", Arrays.equals(new int[] {}, v));
	}

	@Test
	public void one() {
		int[] v = newAlg().apply(new Punto2D[] { x_0 });
		assertTrue("compute*({(0, 0)}) should be {0}",
				Arrays.equals(new int[] { 0 }, v));
	}

	@Test
	public void two() {
		int[] v = newAlg().apply(new Punto2D[] { x_0, x_1 });
		assertTrue("compute*({(0, 0}, (1, 1)}) should be {0, 1}",
				Arrays.equals(new int[] { 0, 1 }, v));
	}

	@Test
	public void three() {
		int[] v = newAlg().apply(new Punto2D[] { x_0, x_1, x_2 });
		assertTrue("compute*({(0, 0}, (1, 1), (2, 2)}) should be {0, 1, 2}",
				Arrays.equals(new int[] { 0, 1, 2 }, v));
	}

	public abstract Function newAlg();

	protected static interface Function {
		int[] apply(Punto2D[] points);
	}
}
