package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * This abstract class provides a foundation for sorting algorithms that rely on comparisons between elements.
 * It implements the `Sorter` interface and requires a `Comparator` object to be provided during construction.
 * 
 * @param <E> The type of elements to be sorted.
 * 
 * @author Aida Fatima
 * 
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	/**
     * The comparator used for element comparisons during sorting.
     */
    private Comparator<E> comparator;
    
    /**
     * Constructs a new `AbstractComparisonSorter` instance with the specified comparator.
     * If a null comparator is provided, a default natural order comparator (`NaturalOrder`) is used.
     * 
     * @param comparator the comparator to be used for element comparisons
     */
    public AbstractComparisonSorter(Comparator<E> comparator) {
        setComparator(comparator);
    }
    
    /**
     * Sets the comparator to be used for element comparisons.
     * If a null comparator is provided, a default natural order comparator is used.
     * 
     * @param comparator the comparator to be used
     */    
    private void setComparator(Comparator<E> comparator) {
        if(comparator == null) {
            this.comparator = new NaturalOrder();
        } else {
            this.comparator = comparator;
        }
    }   
       
    private class NaturalOrder implements Comparator<E> {
        public int compare(E first, E second) {
            return ((Comparable<E>) first).compareTo(second);
        }
    }
    
    /**
     * Compares two elements using the currently set comparator.
     * 
     * @param first the first element to be compared
     * @param second the second element to be compared
     * @return a negative integer if the first element is less than the second element,
     *         a positive integer if the first element is greater than the second element,
     *         and 0 if the elements are equal.
     */
    public int compare(E first, E second) {
        return comparator.compare(first,  second);
    }
}
