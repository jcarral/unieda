package main02;

import java.util.Arrays;
import java.util.Comparator;

import student.ArrayQueueSorted;
import student.SortedList;

public class TestArrayQueueSortedOfString extends Test_abstract<String> {
	private static final int DEFAULT = 10;
	private static final Comparator<String> Comparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	};

	@Override
	protected int defaultCapacity() {
		return DEFAULT;
	}

	@Override
	protected SortedList<String> newSortedList() {
		return new ArrayQueueSorted<String>(Comparator);
	}

	@Override
	protected String[] makeSortedArray() {
		String[] v = new String[2 * DEFAULT];
		for (int i = 0; i < v.length; i++) {
			v[i] = String.valueOf(i);
		}
		Arrays.sort(v);
		return v;
	}

	@Override
	protected Comparator<String> newComparator() {
		return Comparator;
	}

	public static void main(String[] args) {
		new TestArrayQueueSortedOfString().runAllTests();
	}
}
