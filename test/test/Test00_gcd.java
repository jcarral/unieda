package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import student.HW00_0;

public class Test00_gcd {

	@Test
	public void gcd_one_value() {
		int v = HW00_0.gcd(new int[] { 1 });
		assertTrue("gcd({ 1 }) != 1", v == 1);
	}

	@Test
	public void gcd_pair_equals() {
		int v = HW00_0.gcd(new int[] { 1, 1 });
		assertTrue("gcd({ 1, 1 }) != 1", v == 1);
	}

	@Test
	public void gcd_pair_equals_alt() {
		int v = HW00_0.gcd(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE });
		assertTrue(
				"gcd({Integer.MAX_VALUE, Integer.MAX_VALUE}) != Integer.MAX_VALUE",
				v == Integer.MAX_VALUE);
	}

	@Test
	public void gcd_pair_fib() {
		int v = HW00_0.gcd(new int[] { 21, 34 });
		assertTrue("gcd({ 21, 34 }) != 1", v == 1);
	}

}
