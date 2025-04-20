package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Aida Fatima
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {
	
    /**
     * Sorts the given array of Identifiable objects using the Radix Sort algorithm.
     *
     * @param data the array of Identifiable objects to be sorted
     */
	public void sort(E[] data) {
		
		int[] a = new int[data.length];
    	for (int i = 0; i < data.length; i++) {
    		a[i] = data[i].getId();
    	}
    	
    	int k = 0;
    	
    	for(int i = 0; i <= a.length - 1; i++) {
    		k = Math.max(k, a[i]);
    	}
    	
    	double x = Math.ceil(Math.log(k + 1) / Math.log(10));
    	
    	int p = 1;
    	
    	for(int j = 1; j <= x; j++) {
    		
    		int[] b = new int[10];
    		for(int i = 0; i <= a.length - 1; i++) {
    			b[a[i] / p % 10] = b[a[i] / p % 10] + 1;
    		}
    		
    		for(int i = 1; i <= 9; i++) {
    			b[i] = b[i - 1] + b[i];
    		}
    		
        	int[] f = new int[a.length];
        	for (int i = a.length - 1; i >= 0; i--) {
        		f[b[a[i] / p % 10] - 1] = a[i];
        		b[a[i] / p % 10] = b[a[i] / p % 10] - 1;
        	}
        	
        	for (int i = 0; i <= a.length - 1; i++) {
        		a[i] = f[i];
        	}
        	
        	p = p * 10;
    	}
    	
    	@SuppressWarnings("unchecked")
    	E[] sorted = (E[]) new Identifiable[data.length];
    	for (int i = 0; i < data.length; i++) {
    		for(int j = 0; j < data.length; j++) {
    			if (data[j].getId() == a[i]) {
    				sorted[i] = data[j];
    			}
    		}
    	}
    	
    	for(int i = 0; i < data.length; i++) {
    		data[i] = sorted[i];
    	}
    	
	}
}
