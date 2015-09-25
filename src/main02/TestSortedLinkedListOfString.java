package main02;

import student.SortedLinkedListOfString;
import student.SortedList;

public class TestSortedLinkedListOfString extends Test_abstract_string {

	@Override
	protected SortedList<String> newSortedList() {
		return new SortedLinkedListOfString();
	}

	public static void main(String[] args) {
		new TestSortedLinkedListOfString().runAllTests();
	}
}
