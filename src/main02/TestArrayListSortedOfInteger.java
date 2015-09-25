package main02;

import student.ArrayListSortedOfInteger;
import student.SortedList;

public class TestArrayListSortedOfInteger extends Test_abstract_integer {
	private static final int DEFAULT = 10;

	@Override
	protected int defaultCapacity() {
		return DEFAULT;
	}

	@Override
	protected SortedList<Integer> newSortedList() {
		return new ArrayListSortedOfInteger();
	}

	public static void main(String[] args) {
		new TestArrayListSortedOfInteger().runAllTests();
	}
}
