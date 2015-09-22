package test01;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import student.Alg2D;
import student.Tuple;

public class TestAlg2D {

	@Test
	public void singleExists() {
		int v = -1;
		int[][] m = { { v } };
		Tuple<Integer, Integer> t = Alg2D.indexOf(m, v);
		assertNotNull("must not be null", t);
		assertTrue("must be {0, 0}", t._1() == 0 && t._2() == 0);
	}

	@Test
	public void singleLess() {
		int[][] m = { { 0 } };
		Tuple<Integer, Integer> t = Alg2D.indexOf(m, Integer.MIN_VALUE);
		assertNull("must be null", t);
	}

	@Test
	public void singleGreater() {
		int[][] m = { { 0 } };
		Tuple<Integer, Integer> t = Alg2D.indexOf(m, Integer.MAX_VALUE);
		assertNull("must be null", t);
	}

	@Test
	public void contains() {
		int[][] m = { { 10, 20, 30 }, { 100, 200, 300 }, { 1000, 2000, 3000 } };
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				int[][] clone = m.clone();
				int x = m[i][j];
				Tuple<Integer, Integer> t = Alg2D.indexOf(clone, x);
				assertTrue("matrix should not change", clone[i][j] == x);
				assertNotNull("indexOf(" + x + ") must not be null", t);
				assertTrue("must be {" + i + ", " + j + "}",
						t._1() == i && t._2() == j);
			}
		}
	}

	@Test
	public void absent() {
		int[][] m = { { 10, 20, 30 }, { 100, 200, 300 }, { 1000, 2000, 3000 } };
		int[] v = { 0, 15, 25, 30000 };
		for (int x : v) {
			Tuple<Integer, Integer> t = Alg2D.indexOf(m, x);
			assertNull("indexOf(" + x + ") must be null", t);
		}
	}
}
