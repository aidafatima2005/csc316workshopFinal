package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Aida Faitma
 *
 * @param <E> the generic type of data to sort
 */

public class CountingSorter<E extends Identifiable> implements Sorter<E> {
    
	/**
     * Sorts the given array of Identifiable objects using the Counting Sort algorithm.
     * 
     * @param data the array of Identifiable objects to be sorted
     */
    public void sort(E[] data) {
    	
    	int[] a = new int[data.length];
    	for (int i = 0; i < data.length; i++) {
    		a[i] = data[i].getId();
    	}
    	
    	int min = a[0];
    	int max = a[0];
    	
    	for (int i = 0; i <= a.length  -  1; i++) {
    		min = Math.min(a[i], min);
    		max = Math.max(a[i], max);
    	}
    	
    	int k = max  -  min + 1;
    	
    	int[] b = new int[k];
    	for (int i = 0; i <= a.length  -  1; i++) {
    		b[a[i] - min] = b[a[i] - min] + 1;
    	}
    	
    	for (int i = 1; i <= k  -  1; i++) {
    		b[i] = b[i  -  1] + b[i];
    	}
    	
    	int[] f = new int[a.length];
    	for (int i = a.length  -  1; i >= 0; i--) {
    		f[b[a[i] - min]  -  1] = a[i];
    		b[a[i] - min] = b[a[i] - min]  -  1;
    	}
    	    	
    	@SuppressWarnings("unchecked")
    	E[] sorted = (E[]) new Identifiable[data.length];
    	for (int i = 0; i < data.length; i++) {
    		for(int j = 0; j < data.length; j++) {
    			if (data[j].getId() == f[i]) {
    				sorted[i] = data[j];
    			}
    		}
    	}
    	
    	for(int i = 0; i < data.length; i++) {
    		data[i] = sorted[i];
    	}
 
    }
}
