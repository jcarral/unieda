package main02;

import java.util.Comparator;

public abstract class Test_abstract_integer extends Test_abstract<Integer> {

	protected static final Comparator<Integer> Comparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}

	};

	@Override
	protected Integer[] makeSortedArray(int n) {
		Integer[] v = new Integer[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = i + 100;
		}
		return v;
	}

	@Override
	protected Comparator<Integer> newComparator() {
		return Comparator;
	}
}
