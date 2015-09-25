package test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import student.HW00_0;

public class Test00_freqs {
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
		assertTrue("Number of different values should be 1", v == 1);
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
		assertTrue("Number of different values should be 1", v == 1);
		assertTrue(Arrays.equals(new int[] { -1 }, buffer));
		assertTrue(Arrays.equals(new int[] { 2 }, freqs));
	}

	@Test
	public void freqs_example() {
		int[] data = new int[] { 9, 7, 7, 2, 1 };
		int[] buffer = { 0, 0, 0, 0 };
		int[] freqs = { 0, 0, 0, 0 };
		int v = HW00_0.freqs(data, buffer, freqs);
		validate(new int[] { 1, 2, 7, 9 }, new int[] { 1, 1, 2, 1 }, v, buffer,
				freqs);
	}

	@Test
	public void freqs_example_init_error() {
		int[] data = new int[] { 9, 7, 7, 2, 1 };
		int[] buffer = { 2, 2, 2, 2 };
		int[] freqs = { 2, 2, 2, 2 };
		int v = HW00_0.freqs(data, buffer, freqs);
		validate(new int[] { 1, 2, 7, 9 }, new int[] { 1, 1, 2, 1 }, v, buffer,
				freqs);
	}

	private void validate(int[] valuesOrdered, int[] freqsOfValues, int n,
			int[] buffer, int[] freqs) {
		assertTrue(
				"Number of different values should be " + valuesOrdered.length,
				valuesOrdered.length == n);
		for (int i = 0; i < valuesOrdered.length; i++) {
			int v = buffer[i];
			int index = Arrays.binarySearch(valuesOrdered, v);
			assertTrue("Wrong value: " + v, index != -1);
			int f = freqs[i];
			int freqOfValue = freqsOfValues[index];
			assertTrue("Wrong frequency[" + f + " -> " + v + "] should be: "
					+ freqOfValue, f == freqOfValue);
		}
	}

}
