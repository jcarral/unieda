package main02;

import student.BoundedArrayQueueSorted;
import student.SortedList;

public class TestBoundedArrayQueueSorted extends Test_abstract_integer {
	private static final int DEFAULT = 10;

	@Override
	protected int defaultCapacity() {
		return DEFAULT;
	}

	@Override
	protected SortedList<Integer> newSortedList() {
		return new BoundedArrayQueueSorted<Integer>(newComparator(), DEFAULT);
	}

	@Override
	protected int bigSizeLength() {
		return DEFAULT;
	}

	public static void main(String[] args) {
		new TestBoundedArrayQueueSorted().runAllTests();
	}
}
