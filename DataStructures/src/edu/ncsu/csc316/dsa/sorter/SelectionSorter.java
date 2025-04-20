package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Aida Fatima
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
    
    /**
     * Constructs a new `SelectionSorter` instance with the default natural order comparator.
     */
    public SelectionSorter() {
        super(null);
    }
    
    /**
     * Constructs a new `SelectionSorter` instance with the specified comparator.
     * 
     * @param comparator the comparator to be used for element comparisons
     */
    public SelectionSorter(Comparator<E> comparator) {
    	super(comparator);
    }
    
    /**
     * Sorts the given array of elements using the Selection Sort algorithm.
     * 
     * @param data the array of elements to be sorted
     */
    public void sort(E[] data) {
        for(int i = 0; i <= data.length - 1; i++) {
        	int min = i;
        	for(int j = i + 1; j <= data.length - 1; j++) {
        		if(super.compare(data[j], data[min]) < 0) {
        			min = j;
        		}
        	}
        	if(i != min) {
        		E x = data[i];
        		data[i] = data[min];
        		data[min] = x;
        	}
        }
    }
    
}
