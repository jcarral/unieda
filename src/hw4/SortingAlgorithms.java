package hw4;

import java.util.Random;

/**
 * SortingAlgorithms.java A class representing the GUI used in sorting
 * algorithms.
 * 
 * <pre>
 * Hours:        4 hours
 * Created on:   May 18, 2012
 * Revised on:   February 06, 2015
 * </pre>
 *
 * @author: Machunde S. Tandasi
 * @see: java.awt.Toolkit
 * @see java.util.Random
 */
public class SortingAlgorithms extends javax.swing.JFrame {

	// Instance variables and constants
	private final int MAX_NUMBER = 15000; // Number of integers to be generated
	private final int RANGE = 100;
	Random rand = new Random();
	private long startTime, stopTime, elapsedTime;
	private Integer[] integerArray = new Integer[MAX_NUMBER];
	private static int heapSize;

	/**
	 * Creates new form SortingAlgorithms
	 */
	public SortingAlgorithms() {
		initComponents();
		this.getRootPane().setDefaultButton(createJButton); // set buttonAdd as
															// default
		setLocationRelativeTo(null); // centers the form at start.
		binarySearch();
	}

	private void initComponents() {

		sortingButtonGroup = new javax.swing.ButtonGroup();
		searchingButtonGroup = new javax.swing.ButtonGroup();
		originalJPanel = new javax.swing.JPanel();
		originalJScrollPane = new javax.swing.JScrollPane();
		originalJList = new javax.swing.JList();
		originalJLabel = new javax.swing.JLabel();
		sortingAlgorithmJPanel = new javax.swing.JPanel();
		sortingAlgorithmlJLabel = new javax.swing.JLabel();
		sortingJPanel = new javax.swing.JPanel();
		bubbleJRadioButton = new javax.swing.JRadioButton();
		selectionJRadioButton = new javax.swing.JRadioButton();
		insertionJRadioButton = new javax.swing.JRadioButton();
		quickJRadioButton = new javax.swing.JRadioButton();
		mergeJRadioButton = new javax.swing.JRadioButton();
		heapJRadioButton = new javax.swing.JRadioButton();
		searchingJPanel = new javax.swing.JPanel();
		linearJRadioButton = new javax.swing.JRadioButton();
		linearJTextField = new javax.swing.JTextField();
		binaryJRadioButton = new javax.swing.JRadioButton();
		binaryJTextField = new javax.swing.JTextField();
		timeJLabel = new javax.swing.JLabel();
		timeJTextField = new javax.swing.JTextField();
		searchingAlgorithmlJLabel = new javax.swing.JLabel();
		sortedJPanel = new javax.swing.JPanel();
		sortedJScrollPane = new javax.swing.JScrollPane();
		sortedJList = new javax.swing.JList();
		sortedJLabel = new javax.swing.JLabel();
		controlJPanel = new javax.swing.JPanel();
		createJButton = new javax.swing.JButton();
		sortJButton = new javax.swing.JButton();
		createJButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		originalJScrollPane.setViewportView(originalJList);

		originalJLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		originalJLabel.setText("Original Values:");

		javax.swing.GroupLayout originalJPanelLayout = new javax.swing.GroupLayout(originalJPanel);
		originalJPanel.setLayout(originalJPanelLayout);
		originalJPanelLayout
				.setHorizontalGroup(originalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(originalJPanelLayout.createSequentialGroup()
								.addGroup(originalJPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												originalJPanelLayout.createSequentialGroup()
														.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(originalJLabel))
								.addGroup(originalJPanelLayout.createSequentialGroup().addGap(18, 18, 18)
										.addComponent(originalJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap()));
		originalJPanelLayout.setVerticalGroup(originalJPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(originalJPanelLayout.createSequentialGroup().addContainerGap().addComponent(originalJLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(originalJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
						.addContainerGap()));

		getContentPane().add(originalJPanel, java.awt.BorderLayout.WEST);

		sortingAlgorithmlJLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		sortingAlgorithmlJLabel.setText("Sorting Algorithm:");

		sortingJPanel.setLayout(new java.awt.GridLayout(6, 1, 5, 5));

		sortingButtonGroup.add(bubbleJRadioButton);
		bubbleJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		bubbleJRadioButton.setMnemonic('B');
		bubbleJRadioButton.setText("Bubble");
		sortingJPanel.add(bubbleJRadioButton);

		sortingButtonGroup.add(selectionJRadioButton);
		selectionJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		selectionJRadioButton.setText("Selection");
		sortingJPanel.add(selectionJRadioButton);

		sortingButtonGroup.add(insertionJRadioButton);
		insertionJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		insertionJRadioButton.setMnemonic('O');
		insertionJRadioButton.setText("Insertion");
		sortingJPanel.add(insertionJRadioButton);

		sortingButtonGroup.add(quickJRadioButton);
		quickJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		quickJRadioButton.setMnemonic('Q');
		quickJRadioButton.setText("Quick");
		sortingJPanel.add(quickJRadioButton);

		sortingButtonGroup.add(mergeJRadioButton);
		mergeJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		mergeJRadioButton.setMnemonic('M');
		mergeJRadioButton.setText("Merge");
		sortingJPanel.add(mergeJRadioButton);

		sortingButtonGroup.add(heapJRadioButton);
		heapJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		heapJRadioButton.setMnemonic('H');
		heapJRadioButton.setText("Heap");
		sortingJPanel.add(heapJRadioButton);

		searchingJPanel.setLayout(new java.awt.GridLayout(6, 1));

		searchingButtonGroup.add(linearJRadioButton);
		linearJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		linearJRadioButton.setMnemonic('L');
		linearJRadioButton.setText("Linear Search");
		linearJRadioButton.setEnabled(false);
		searchingJPanel.add(linearJRadioButton);

		linearJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		linearJTextField.setToolTipText("Press Enter to perform search");
		linearJTextField.setEnabled(false);
		searchingJPanel.add(linearJTextField);

		searchingButtonGroup.add(binaryJRadioButton);
		binaryJRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		binaryJRadioButton.setMnemonic('L');
		binaryJRadioButton.setText("Binary Search");
		binaryJRadioButton.setEnabled(false);
		searchingJPanel.add(binaryJRadioButton);

		binaryJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		binaryJTextField.setToolTipText("Press Enter to perform search");
		binaryJTextField.setEnabled(false);
		searchingJPanel.add(binaryJTextField);

		timeJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		timeJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		timeJLabel.setText("Time: nanoseconds");
		searchingJPanel.add(timeJLabel);

		timeJTextField.setEditable(false);
		searchingJPanel.add(timeJTextField);

		searchingAlgorithmlJLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		searchingAlgorithmlJLabel.setText("Searching Algorithm:");

		javax.swing.GroupLayout sortingAlgorithmJPanelLayout = new javax.swing.GroupLayout(sortingAlgorithmJPanel);
		sortingAlgorithmJPanel.setLayout(sortingAlgorithmJPanelLayout);
		sortingAlgorithmJPanelLayout
				.setHorizontalGroup(
						sortingAlgorithmJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(sortingAlgorithmJPanelLayout.createSequentialGroup()
										.addGroup(sortingAlgorithmJPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(sortingJPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												sortingAlgorithmJPanelLayout.createSequentialGroup()
														.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(sortingAlgorithmlJLabel))
								.addGroup(sortingAlgorithmJPanelLayout.createSequentialGroup().addContainerGap()
										.addComponent(searchingAlgorithmlJLabel))
								.addComponent(searchingJPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));
		sortingAlgorithmJPanelLayout.setVerticalGroup(
				sortingAlgorithmJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(sortingAlgorithmJPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(sortingAlgorithmlJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sortingJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
										javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(searchingAlgorithmlJLabel).addGap(1, 1, 1)
						.addComponent(searchingJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addContainerGap()));

		getContentPane().add(sortingAlgorithmJPanel, java.awt.BorderLayout.CENTER);

		sortedJScrollPane.setViewportView(sortedJList);

		sortedJLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		sortedJLabel.setText("Sorted Values:");

		javax.swing.GroupLayout sortedJPanelLayout = new javax.swing.GroupLayout(sortedJPanel);
		sortedJPanel.setLayout(sortedJPanelLayout);
		sortedJPanelLayout.setHorizontalGroup(sortedJPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(sortedJPanelLayout.createSequentialGroup()
						.addGroup(sortedJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(sortedJPanelLayout.createSequentialGroup().addContainerGap()
										.addComponent(sortedJLabel))
								.addGroup(sortedJPanelLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(
										sortedJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		sortedJPanelLayout.setVerticalGroup(sortedJPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(sortedJPanelLayout.createSequentialGroup().addContainerGap().addComponent(sortedJLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(sortedJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
						.addContainerGap()));

		getContentPane().add(sortedJPanel, java.awt.BorderLayout.EAST);

		controlJPanel.setMinimumSize(new java.awt.Dimension(325, 40));
		controlJPanel.setPreferredSize(new java.awt.Dimension(325, 40));
		controlJPanel.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

		createJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		createJButton.setMnemonic('C');
		createJButton.setText("Create Data");
		createJButton.setToolTipText("Generate random integers set");
		createJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createJButtonActionPerformed(evt);
			}
		});
		controlJPanel.add(createJButton);

		sortJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		sortJButton.setMnemonic('S');
		sortJButton.setText("Sort");
		sortJButton.setToolTipText("Sort data with chosen algorithm");
		sortJButton.setEnabled(false);
		sortJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sortJButtonActionPerformed(evt);
			}
		});
		controlJPanel.add(sortJButton);

		createJButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		createJButton1.setMnemonic('x');
		createJButton1.setText("Exit");
		createJButton1.setToolTipText("Generate random integers set");
		createJButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createJButton1ActionPerformed(evt);
			}
		});
		controlJPanel.add(createJButton1);

		getContentPane().add(controlJPanel, java.awt.BorderLayout.SOUTH);

		pack();
	}

	private void createJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		for (int i = 0; i < MAX_NUMBER; i++) {
			integerArray[i] = rand.nextInt(RANGE);
		}
		originalJList.setListData(integerArray);
		sortJButton.setEnabled(true);
		linearJRadioButton.setEnabled(true);
		binaryJRadioButton.setEnabled(true);
	}

	private void sortJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int radButton = whichSortRadioButton();
		// Create an array of primitive int types
		int[] dataArray = new int[integerArray.length];
		// Copy objects into primitive array
		for (int i = 0; i < dataArray.length; i++) {
			dataArray[i] = integerArray[i].intValue();
		}
		switch (radButton) {
		case 0:
			// do bubbleSort
			startTime = System.nanoTime();
			bubbleSort(dataArray);
			stopTime = System.nanoTime();
			elapsedTime = stopTime - startTime;
			timeJTextField.setText(String.valueOf(elapsedTime));
			break;
		case 1:
			// do selectionSort
			startTime = System.nanoTime();
			selectionSort(dataArray);
			stopTime = System.nanoTime();
			elapsedTime = stopTime - startTime;
			timeJTextField.setText(String.valueOf(elapsedTime));
			break;
		case 2:
			// do insertionSort
			startTime = System.nanoTime();
			insertionSort(dataArray);
			stopTime = System.nanoTime();
			elapsedTime = stopTime - startTime;
			timeJTextField.setText(String.valueOf(elapsedTime));
			break;
		case 3:
			// do quickSort
			startTime = System.nanoTime();
			quickSort(dataArray);
			stopTime = System.nanoTime();
			elapsedTime = stopTime - startTime;
			timeJTextField.setText(String.valueOf(elapsedTime));
			break;
		case 4:
			// do mergeSort
			startTime = System.nanoTime();
			mergeSort(dataArray);
			stopTime = System.nanoTime();
			elapsedTime = stopTime - startTime;
			timeJTextField.setText(String.valueOf(elapsedTime));
			break;
		case 5:
			// do heap
			startTime = System.nanoTime();
			heapSort(dataArray);
			stopTime = System.nanoTime();
			elapsedTime = stopTime - startTime;
			timeJTextField.setText(String.valueOf(elapsedTime));
			break;
		}
		display(dataArray);
		linearJTextField.setText("");
		binaryJTextField.setText("");
		linearJRadioButton.setEnabled(true);
		binaryJRadioButton.setEnabled(true);
	}// GEN-LAST:event_sortJButtonActionPerformed

	// exits the program
	private void createJButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_createJButton1ActionPerformed
		System.exit(0);
	}// GEN-LAST:event_createJButton1ActionPerformed

	// returns the integer value of the radioButton selected to perform the
	// appropriate sort method;
	private int whichSortRadioButton() {
		if (selectionJRadioButton.isSelected())
			return 1;
		else if (insertionJRadioButton.isSelected())
			return 2;
		else if (quickJRadioButton.isSelected())
			return 3;
		else if (mergeJRadioButton.isSelected())
			return 4;
		else if (heapJRadioButton.isSelected())
			return 5;
		else {
			bubbleJRadioButton.setSelected(true);
			return 0;
		}
	}

	// displays the result of the sorting
	private void display(int[] intArray) {
		Integer[] integerArray = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++)
			integerArray[i] = intArray[i];
		sortedJList.setListData(integerArray);
	}

	// Bubble Sort
	private void bubbleSort(int[] array) {
		int n = array.length;
		for (int passedNum = 1; passedNum < n; passedNum++) // Count how many
															// times
		{
			// This next loop becomes shorter and shorter
			for (int i = 0; i < n - passedNum; i++) {
				if (array[i] > array[i + 1]) {
					// exchange elements
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}

	// Selection Sort
	private void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minPosition = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minPosition] > array[j])
					minPosition = j; // position of the new minimum number
			}
			if (minPosition != i) {
				// Exchange the current element with the smallest remaining
				int temp = array[i];
				array[i] = array[minPosition];
				array[minPosition] = temp;
			}
		}
	}

	// Insertion Sort
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int B = array[i];
			while ((j > 0) && (array[j - 1] > B)) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = B;
		}
	}

	// Merge Sort
	private static void mergeSort(int[] array) {

		merge(array, 0, array.length);
	}

	// Quick Sort
	private static void quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		quick(array, 0, array.length - 1);
	}

	// Heap Sort
	private static void heapSort(int[] array) {
		heapSize = array.length;
		BuildMaxHeap(array); // first we build max heap
		for (int i = array.length - 1; i > 0; i--) {
			// exchange biggest number with the current last one
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			// reduce the heap size
			heapSize--;
			// find new biggest
			MaxHeapify(array, 0);
		}
	}

	// Method to merge data for merge sort
	private static void merge(int[] array, int low, int high) {
		if (high - low == 1)
			return; // only one element in the array, return.
		int mid = low + (high - low) / 2; // find middle
		merge(array, low, mid); // sort first part
		merge(array, mid, high); // sort second part
		MergeNumber(array, new int[array.length], low, mid, high); // merge both
																	// parts
	}

	// Merges two arrays into one.
	private static void MergeNumber(int[] array, int[] temp, int low, int middle, int high) {
		int i = low;
		int j = middle;
		for (int k = low; k < high; k++) {
			if (i == middle)
				temp[k] = array[j++]; // if lo-mid array is empty
			else if (j == high)
				temp[k] = array[i++]; // if mid-hi array is empty
			else if (array[j] > array[i])
				temp[k] = array[i++]; // i is lower so we put it in the array
										// first
			else
				temp[k] = array[j++]; // j is lower or equal to i, so we put it
										// in the array first.
		}
		// Now we need to copy back temp array to its place in A array
		for (int k = low; k < high; k++)
			array[k] = temp[k]; // we are copying only the numbers we just
								// merged.
	}

	private static void quick(int[] array, int low, int high) {

		if (high <= low)
			return;
		int j = partition(array, low, high);
		sort(array, low, high);
		assert isSorted(array, low, high);
	}

	// partition the subarray a[lo .. hi] by returning an index j
	// so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	private static int partition(int[] array, int low, int high) {
		int i = low;
		int j = high + 1;
		Comparable v = array[low];
		while (true) {

			// find item on lo to swap
			while (less(array[++i], v))
				if (i == high)
					break;

			// find item on hi to swap
			while (less(v, array[--j]))
				if (j == low)
					break; // redundant since a[lo] acts as sentinel

			// check if pointers cross
			if (i >= j)
				break;

			swap(array, i, j);
		}

		// put v = a[j] into position
		swap(array, low, j);

		// with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(int[] array, int low, int high) {
		if (high <= low)
			return;
		int j = partition(array, low, high);
		sort(array, low, j - 1);
		sort(array, j + 1, high);
		assert isSorted(array, low, high);
	}

	private static boolean isSorted(int[] array, int low, int high) {
		for (int i = low + 1; i <= high; i++)
			if (less(array[i], array[i - 1]))
				return false;
		return true;
	}

	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	// swap the numbers
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	// Builds MaxHeap (runs in linear time so: O(n) )
	private static void BuildMaxHeap(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			MaxHeapify(array, i);
		}
	}

	private static void MaxHeapify(int[] array, int i) {
		int l = Left(i); // find left child of the given index.
		int r = Right(i);// find right child of the given index.
		int max;
		if (l < heapSize) // check if left child is an existing child
		{
			// if it is an existing child
			if (array[l] > array[i]) { // if left child is bigger than parent
				max = l; // left child becomes maximum
			} else {
				max = i; // otherwise parent is maximum
			}
		} else // if this index does not have left child
		{
			max = i;
		}
		if (r < heapSize)// check if the right child is an existing child
		{
			// if it is existing child
			if (array[r] > array[max])// if right child is bigger than our
										// current maximum
			{
				max = r; // right child becomes our new maximum
			}
		}
		if (max != i)// if our parent is not maximum
		{
			// we need to swap max with parent
			int temp = array[i];
			array[i] = array[max];
			array[max] = temp;

			// at the end we need to run MinHeapify on the child that was just
			// swapped
			// and see if it is supposed to go even further down the list
			MaxHeapify(array, max);
		}
	}

	// Returns Left child index of the given parent index
	private static int Left(int i) {
		return 2 * i;
	}

	//// Returns right child index of the given parent index
	private static int Right(int i) {
		return (2 * i) + 1;
	}

	public void binarySearch() {
		if (linearJRadioButton.isSelected())
			linearJTextField.isEnabled();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SortingAlgorithms.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SortingAlgorithms.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SortingAlgorithms.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SortingAlgorithms.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new SortingAlgorithms().setVisible(true);
			}
		});
	}

	private javax.swing.JRadioButton binaryJRadioButton;
	private javax.swing.JTextField binaryJTextField;
	private javax.swing.JRadioButton bubbleJRadioButton;
	private javax.swing.JPanel controlJPanel;
	private javax.swing.JButton createJButton;
	private javax.swing.JButton createJButton1;
	private javax.swing.JRadioButton heapJRadioButton;
	private javax.swing.JRadioButton insertionJRadioButton;
	private javax.swing.JRadioButton linearJRadioButton;
	private javax.swing.JTextField linearJTextField;
	private javax.swing.JRadioButton mergeJRadioButton;
	private javax.swing.JLabel originalJLabel;
	private javax.swing.JList originalJList;
	private javax.swing.JPanel originalJPanel;
	private javax.swing.JScrollPane originalJScrollPane;
	private javax.swing.JRadioButton quickJRadioButton;
	private javax.swing.JLabel searchingAlgorithmlJLabel;
	private javax.swing.ButtonGroup searchingButtonGroup;
	private javax.swing.JPanel searchingJPanel;
	private javax.swing.JRadioButton selectionJRadioButton;
	private javax.swing.JButton sortJButton;
	private javax.swing.JLabel sortedJLabel;
	private javax.swing.JList sortedJList;
	private javax.swing.JPanel sortedJPanel;
	private javax.swing.JScrollPane sortedJScrollPane;
	private javax.swing.JPanel sortingAlgorithmJPanel;
	private javax.swing.JLabel sortingAlgorithmlJLabel;
	private javax.swing.ButtonGroup sortingButtonGroup;
	private javax.swing.JPanel sortingJPanel;
	private javax.swing.JLabel timeJLabel;
	private javax.swing.JTextField timeJTextField;
}
