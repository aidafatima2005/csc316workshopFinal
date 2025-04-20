package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 * 
 * @author Dr. King
 * @author Aida Fatima 
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {

    /**
     * The initial capacity of the list if the client does not provide a capacity
     * when constructing an instance of the array-based list
     **/
    private final static int DEFAULT_CAPACITY = 0;

    /** The array in which elements will be stored **/
    private E[] data;

    /** The number of elements stored in the array-based list data structure **/
    private int size;

    /**
     * Constructs a new instance of an array-based list data structure with the
     * default initial capacity of the internal array
     */
    public ArrayBasedList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new instance of an array-based list data structure with the
     * provided initial capacity
     * 
     * @param capacity the initial capacity of the internal array used to store the
     *                 list elements
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    
    /**
	 * To ensure amortized O(1) cost for adding to the end of the array-based list,
	 * use the doubling strategy on each resize. Here, we add +1 after doubling to
	 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
	 * still produce a capacity of 0).
	 * 
	 * @param minCapacity the minimium capacity that must be supported by the
	 *                    internal array
	 */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = data.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 2) + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }
    
    /**
     * Adds an element to the array at a specified index, ensures that the array size
     * can accommodate the index.
     * 
     * @param idx index where to add the new element
     * @param ele element to add the the array
     */
    public void add(int idx, E ele) {
    	checkIndexForAdd(idx);
		ensureCapacity(size + 1);
		
		for(int i = data.length - 1; i > idx; i--) {
    		data[i] = data[i - 1];
    	}
    	
    	data[idx] = ele;
    	size++;
    	
    }
    
    /**
     * Removes and returns the element at the specified index in the list.
     * 
     * @param idx the index of the element to be removed
     * @return the element that was removed from the list
     */
    @Override
    public E remove(int idx) {
    	
    	if (idx < 0 || idx >= size) {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	E elementRemoved = data[idx];
    	
    	for(int i = idx; i < data.length - 1; i++) {
    		data[i] = data[i + 1];
    	}
    	
    	size--;
    	return elementRemoved;
    	
    }

    /**
     * Returns the element at the specified index in the list.
     * 
     * @param idx the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		return data[idx];
	}

	/**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * 
     * @param idx index of the element to replace
     * @param ele element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
	@Override
	public E set(int idx, E ele) {
		checkIndex(idx);
		E elementReplaced = data[idx];
		data[idx] = ele;
		
		return elementReplaced;
	}

	/**
     * Returns the number of elements in this list.
     * 
     * @return the number of elements in this list
     */
	@Override
	public int size() {
		return this.size;
	}

	/**
     * Returns an iterator over the elements in this list in proper sequence.
     * 
     * @return an iterator over the elements in this list in proper sequence
     */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	/**
     * An iterator for the elements in the ArrayBasedList.
     */
	private class ElementIterator implements Iterator<E> {
		
		/** position of the iterator in the list */
	    private int position;
	    
	    /** A flag indicating whether it's okay to perform a remove operation */
	    private boolean removeOK;

	    /**
	     * Construct a new element iterator where the cursor is initialized 
	     * to the beginning of the list.
	     */
	    public ElementIterator() {
	        position = 0;
	    }

	    /**
         * Returns true if the iteration has more elements.
         * 
         * @return true if the iteration has more elements
         */
	    @Override
	    public boolean hasNext() {
	        return position < size;
	    }

	    /**
         * Returns the next element in the iteration.
         * 
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
	    @Override
	    public E next() {
	        if(!hasNext()) {
	        	throw new NoSuchElementException();
	        }
	        
	        E ele = ArrayBasedList.this.get(position);
	        position++;
	        removeOK = true;
	        return ele;
	    }
	
	    /**
         * Removes from the underlying collection the last element returned
         * by this iterator.
         * 
         * @throws IllegalStateException if the next method has not yet been called,
         *         or the remove method has already been called after the last call
         *         to the next method
         */
	    @Override
	    public void remove() {
	        if(!removeOK) {
	        	throw new IllegalStateException();
	        }
	        
	        position--;
	        ArrayBasedList.this.remove(position);
	        removeOK = false;
	    }
	}
    
}
