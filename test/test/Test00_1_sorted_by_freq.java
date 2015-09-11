package test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import student.HW00_0;

public class Test00_1_sorted_by_freq {
	int[] array_empty = new int[] {};

	@Test
	public void freqs_empty() {
		int v = HW00_0.freqs(array_empty, array_empty, array_empty);
		assertTrue("Number of different values should be 0", v == 0);
	}

	@Test
	public void freqs_one_value() {
		int[] data = new int[] { -1 };
		int difs = 1;
		int[] buffer = new int[difs];
		int[] freqs = new int[difs];
		int v = HW00_0.freqs(data, buffer, freqs);
		assertTrue("Number of different values should be " + difs, v == difs);
		assertTrue(Arrays.equals(new int[] { -1 }, buffer));
		assertTrue(Arrays.equals(new int[] { 1 }, freqs));
	}

	@Test
	public void freqs_one_value_alt() {
		int[] data = new int[] { -1, -1 };
		int difs = 1;
		int[] buffer = new int[difs];
		int[] freqs = new int[difs];
		int v = HW00_0.freqs(data, buffer, freqs);
		assertTrue("Number of different values should be " + difs, v == difs);
		assertTrue(Arrays.equals(new int[] { -1 }, buffer));
		assertTrue(Arrays.equals(new int[] { 2 }, freqs));
	}

	@Test
	public void freqs() {
		int[] data = new int[] { 2, 3, 2, 3, 3, 1 };
		int difs = 4;
		int[] buffer = new int[difs];
		int[] freqs = new int[difs];
		int v = HW00_0.freqs(data, buffer, freqs);
		assertTrue("Number of different values should be " + difs, v == difs);
		assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, buffer));
		assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, freqs));
	}

	@Test
	public void freqs_example_init_error() {
		int[] data = new int[] { 2, 3, 2, 3, 3, 1 };
		int difs = 4;
		int[] buffer = { -1, -1, -1, -1 };
		int[] freqs = { -1, -1, -1, -1 };
		int v = HW00_0.freqs(data, buffer, freqs);
		assertTrue("Number of different values should be " + difs, v == difs);
		assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, buffer));
		assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, freqs));
	}
}
