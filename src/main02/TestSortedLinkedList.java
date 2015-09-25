package main02;

import student.SortedLinkedList;
import student.SortedList;

public class TestSortedLinkedList extends Test_abstract_integer {

	@Override
	protected SortedList<Integer> newSortedList() {
		return new SortedLinkedList<Integer>(Comparator);
	}

	public static void main(String[] args) {
		new TestSortedLinkedList().runAllTests();
	}
}
