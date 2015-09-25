package main02;

import student.SortedLinkedListOfInteger;
import student.SortedList;

public class TestSortedLinkedListOfInteger extends Test_abstract_integer {

	@Override
	protected SortedList<Integer> newSortedList() {
		return new SortedLinkedListOfInteger();
	}

	public static void main(String[] args) {
		new TestSortedLinkedListOfInteger().runAllTests();
	}
}
