package main02;

import java.util.Comparator;

import student.SortedList;

public abstract class Test_abstract<T> {
	T[] data = makeSortedArray();
	Comparator<T> comparator = newComparator();

	public void emptySize() {
		SortedList<T> lst = newSortedList();
		assertTrue("size({}) == 0", lst.size() == 0);
	}

	public void singletonSize() {
		SortedList<T> lst = newSortedList();
		lst.add(data[0]);
		assertTrue("size({x}) == 1", lst.size() == 1);
	}

	public void singletonNoDuplicates() {
		SortedList<T> lst = newSortedList();
		T x = data[0];
		lst.add(x);
		lst.add(x);
		assertTrue("size({x}) == 1", lst.size() == 1);
	}

	public void singletonFirst() {
		SortedList<T> lst = newSortedList();
		T x = data[0];
		lst.add(x);
		T tmp = lst.removeFirst();
		assertTrue("size({}) == 0", lst.size() == 0);
		assertTrue("first({x}) == " + x, comparator.compare(x, tmp) == 0);
	}

	public void singletonLast() {
		SortedList<T> lst = newSortedList();
		T x = data[data.length - 1];
		lst.add(x);
		T tmp = lst.removeLast();
		assertTrue("size({}) == 0", lst.size() == 0);
		assertTrue("last({x}) == " + x, comparator.compare(x, tmp) == 0);
	}

	public void bigSize() {
		SortedList<T> lst = newSortedList();
		int l = bigSizeLength();
		for (int i = 0, j = l - 1; i <= j; i++, j--) {
			lst.add(data[i]);
			lst.add(data[j]);
		}
		assertTrue("size({...}) == " + l, lst.size() == l);
		for (int index = 0, items = l; items > 0; index++, items = items - 2) {
			T a = lst.removeFirst();
			T b = lst.removeLast();
			assertTrue("first({...})", comparator.compare(data[index], a) == 0);
			assertTrue("last({...})",
					comparator.compare(data[l - index - 1], b) == 0);
		}
	}

	public void checkAddFirst() {
		SortedList<T> lst = newSortedList();
		T x1 = data[1];
		T x2 = data[2];
		T x3 = data[3];
		T x4 = data[4];
		lst.add(x4);
		lst.add(x3);
		T tmp = lst.removeFirst();
		assertTrue("first({" + x3 + ", " + x4 + "}) == " + x3,
				comparator.compare(x3, tmp) == 0);
		lst.add(x2);
		lst.add(x1);
		tmp = lst.removeFirst();
		assertTrue("first({" + x1 + ", " + x2 + ", " + x4 + "}) == " + x1,
				comparator.compare(x1, tmp) == 0);
		tmp = lst.removeLast();
		assertTrue("first({" + x2 + ", " + x4 + "}) == " + x4,
				comparator.compare(x4, tmp) == 0);
	}

	public void checkAddLast() {
		SortedList<T> lst = newSortedList();
		for (int i = 0; i < defaultCapacity(); i++)
			lst.add(data[i]);
		T tmp = lst.removeFirst();
		tmp = lst.removeFirst();
		assertTrue("first({...}) == ", comparator.compare(data[1], tmp) == 0);
		lst.add(data[defaultCapacity() + 2]);
		lst.add(data[defaultCapacity() + 1]);
		tmp = lst.removeLast();
		assertTrue("last({...}) == " + defaultCapacity() + 2,
				comparator.compare(data[defaultCapacity() + 2], tmp) == 0);
	}

	protected abstract int defaultCapacity();

	protected abstract SortedList<T> newSortedList();

	protected abstract T[] makeSortedArray();

	protected abstract Comparator<T> newComparator();

	protected int bigSizeLength() {
		return data.length;
	}

	protected void assertTrue(String msg, boolean b) {
		if (!b) {
			System.out.println("Error..." + msg);
			throw new RuntimeException(msg);
		}
	}

	public void runAllTests() {
		System.out.println("Test[" + getClass().getSimpleName() + "]...");
		System.out.println("emptySize...");
		emptySize();
		System.out.println("singletonSize...");
		singletonSize();
		System.out.println("singletonNoDuplicates...");
		singletonNoDuplicates();
		System.out.println("singletonFirst...");
		singletonFirst();
		System.out.println("singletonLast...");
		singletonLast();
		System.out.println("bigSize...");
		bigSize();
		System.out.println("checkAddFirst...");
		checkAddFirst();
		System.out.println("checkAddLast...");
		checkAddLast();
		System.out.println("Done!");
	}
}
