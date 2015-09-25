package main02;

import java.util.Comparator;

public abstract class Test_abstract_string extends Test_abstract<String> {

	protected static final Comparator<String> Comparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	};

	@Override
	protected String[] makeSortedArray(int n) {
		String[] v = new String[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = String.format("%032d", i);
		}
		return v;
	}

	@Override
	protected Comparator<String> newComparator() {
		return Comparator;
	}
}
