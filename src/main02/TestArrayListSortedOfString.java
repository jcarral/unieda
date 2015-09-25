package main02;

import student.ArrayListSortedOfString;
import student.SortedList;

public class TestArrayListSortedOfString extends Test_abstract_string {
	private static final int DEFAULT = 10;

	@Override
	protected int defaultCapacity() {
		return DEFAULT;
	}

	@Override
	protected SortedList<String> newSortedList() {
		return new ArrayListSortedOfString();
	}

	public static void main(String[] args) {
		new TestArrayListSortedOfString().runAllTests();
	}
}
