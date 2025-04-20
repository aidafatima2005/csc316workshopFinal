package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * 
 * @author Dr. King
 * @author Aida Fatima
 * 
 * @param <E> The type of elements to be sorted. This class assumes elements implement the `Comparable E` interface.
 */

public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
    
	/**
     * Constructs a new `InsertionSorter` instance with the default natural order comparator.
     */
    public InsertionSorter() {
    	this(null);
    }
    
    /**
     * Constructs a new `InsertionSorter` instance with the specified comparator.
     * 
     * @param comparator the comparator to be used for element comparisons
     */
    public InsertionSorter(Comparator<E> comparator) {
        super(comparator);
    }
    
    /**
     * Sorts the given array of elements using the Insertion Sort algorithm.
     * 
     * @param data the array of elements to be sorted
     */
    public void sort(E[] data) {
    	for (int i = 1; i <= data.length - 1; i++) {
			E x = data[i];
			int j = i - 1;
			while (j >= 0 && super.compare(data[j], x) > 0) {
				data[j + 1] = data[j];
				j = j - 1;
	
			}
			data[j + 1] = x;
		}
    }
}
