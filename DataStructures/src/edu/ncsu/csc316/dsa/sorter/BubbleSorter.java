package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * BubbleSorter uses the bubble sort algorithm to sort data.
 * 
 * @param <E> The type of elements to be sorted. This class assumes elements implement the `Comparable E` interface.
 * 
 * @author Aida Fatima
 * 
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

    /**
     * Constructs a new `BubbleSorter` instance with the default natural order comparator.
     */
    public BubbleSorter() {
    	this(null);
    }
    
    /**
     * Constructs a new `BubbleSorter` instance with the specified comparator.
     * 
     * @param comparator the comparator to be used for element comparisons
     */
    public BubbleSorter(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * Sorts the given array of elements using the Bubble Sort algorithm.
     * 
     * @param data the array of elements to be sorted
     */
    public void sort(E[] data) {
    	boolean r = true;
    	while (r) {
    		r = false;
    		for(int i = 1; i <= data.length - 1; i++) {
    			if (super.compare(data[i], data[i - 1]) < 0) {
    				E x = data[i - 1];
    				data[i - 1] = data[i];
    				data[i] = x;
    				r = true;
    			}
    		}
    	}
    }

}
