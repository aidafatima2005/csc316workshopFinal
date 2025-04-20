package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
import java.util.Arrays;

/**
 * MergeSorter sorts arrays of comparable elements using the merge sort
 * algorithm. This implementation ensures O(nlogn) worst-case runtime to sort an
 * array of n elements that are comparable.
 * 
 * @author Dr. King
 * @author Aida Fatima 
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

    /**
     * Constructs a new MergeSorter with a specified custom Comparator
     * 
     * @param comparator a custom Comparator to use when sorting
     */
    public MergeSorter(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * Constructs a new MergeSorter with comparisons based on the element's natural
     * ordering
     */ 
    public MergeSorter() {
        this(null);
    }

    /**
     * Sorts the given array using the merge sort algorithm.
     *
     * @param data the array to be sorted
     */
	@Override
	public void sort(E[] data) {
		mergeSort(data);
	}
	
	/**
     * Recursively sorts the given array using the merge sort algorithm.
     *
     * @param data the array to be sorted
     */
	private void mergeSort(E[] data) {
		int n = data.length;
		
		if (n < 2) {
			return;
		}
		
		int mid = n / 2;
		
		E[] left = Arrays.copyOfRange(data, 0, mid);
		E[] right = Arrays.copyOfRange(data, mid, n);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left, right, data);
		
	}
	
	/**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param left  the left sorted array
     * @param right the right sorted array
     * @param data  the array to store the merged result
     * @return the merged and sorted array
     */
	private E[] merge(E[] left, E[] right, E[] data) {
		int leftIndex = 0;
		int rightIndex = 0;
		
		int n = data.length;
		
		while (leftIndex + rightIndex < n) {
			if (rightIndex == right.length || (leftIndex < left.length && compare(left[leftIndex], right[rightIndex]) < 0)) {
				data[leftIndex + rightIndex] = left[leftIndex];
				leftIndex = leftIndex + 1;
			} else {
				data[leftIndex + rightIndex] = right[rightIndex];
				rightIndex = rightIndex + 1;
			}
		}
		
		return data;		
	}
}