package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * 
 * @author Dr. King
 * @author Aida Fatima
 * 
 * @param <E> The type of elements to be sorted.
 * 
 */
public interface Sorter<E> {
	
    /**
     * Sorts the given array of elements in ascending order.
     * 
     * @param data the array of elements to be sorted
     */
	void sort(E[] data);
}
