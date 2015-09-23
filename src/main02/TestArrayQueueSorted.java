package main02;

import java.util.Comparator;

import student.ArrayQueueSorted;
import student.SortedList;

public class TestArrayQueueSorted extends Test_abstract<Integer> {
	private static final int DEFAULT = 10;
	private static final Comparator<Integer> Comparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}

	};

	@Override
	protected int defaultCapacity() {
		return DEFAULT;
	}

	@Override
	protected SortedList<Integer> newSortedList() {
		return new ArrayQueueSorted<Integer>(Comparator);
	}

	@Override
	protected Integer[] makeSortedArray() {
		Integer[] v = new Integer[2 * DEFAULT];
		for (int i = 0; i < v.length; i++) {
			v[i] = i;
		}
		return v;
	}

	@Override
	protected Comparator<Integer> newComparator() {
		return Comparator;
	}

	public static void main(String[] args) {
		new TestArrayQueueSorted().runAllTests();
	}
}
