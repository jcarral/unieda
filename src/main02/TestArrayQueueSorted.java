package main02;

import student.ArrayQueueSorted;
import student.SortedList;

public class TestArrayQueueSorted extends Test_abstract_integer {
	private static final int DEFAULT = 10;

	@Override
	protected int defaultCapacity() {
		return DEFAULT;
	}

	@Override
	protected SortedList<Integer> newSortedList() {
		return new ArrayQueueSorted<Integer>(Comparator);
	}

	public static void main(String[] args) {
		new TestArrayQueueSorted().runAllTests();
	}
}