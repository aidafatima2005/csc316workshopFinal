package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 * @author Aida Fatima 
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

    /** A reference to the dummy/sentinel node at the front of the list **/
    private LinkedListNode<E> front;
    
    /** A reference to the last/final node in the list **/
    private LinkedListNode<E> tail;
    
    /** The number of elements stored in the list **/
    private int size;
        
    /**
     * Constructs an empty singly-linked list
     */     
    public SinglyLinkedList() {
    	// Let front be a dummy (sentinel) node
        front = new LinkedListNode<E>(null);
        tail = null;
        size = 0;
 
    }
    
    /**
     * Adds the specified element at the specified index in the list.
     *
     * @param index the index at which to add the element
     * @param value the element to add
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    public void add(int index, E value) {
    	if (index < 0 || index > size) {
    		throw new IndexOutOfBoundsException();
    	}
    	
       	LinkedListNode<E> current = front;
    	for(int i = 0; i < index; i++) {
    		current = current.getNext();
    	}
    	
		LinkedListNode<E> newNode = new LinkedListNode<E>(value, current.getNext());
		current.next = newNode;
    	
    	if (index == size) {
    		tail = newNode;
    	}
    	
    	size++;
    }
    
    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index) {
    	if (index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException();
    	}
    	    	
       	LinkedListNode<E> current = front.getNext();
    	for(int i = 0; i < index; i++) {
    		current = current.getNext();
    	}
    	    	
    	return current.getElement();
    }
    
    /**
     * Removes and returns the element at the specified index in the list.
     *
     * @param index the index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E remove(int index) {
    	if (index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	LinkedListNode<E> current = front;
    	LinkedListNode<E> previous = front;
    	E elementRemoved = null;

    	for(int i = 0; i < size; i++) {
    		current = current.getNext();
    		if (i == index) {
    			elementRemoved = current.getElement();
    			previous.next = current.getNext();
    			break;
    		}
    		previous = current;
    	}
    	
    	size--;
    	return elementRemoved;
    }
    
    /**
     * Replaces the element at the specified index in the list with the specified element.
     *
     * @param index the index of the element to replace
     * @param value the new element to store at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E set(int index, E value) {
    	if (index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	LinkedListNode<E> current = front;
    	LinkedListNode<E> previous = front;
    	E elementRemoved = null;
    	
    	for(int i = 0; i < size; i++) {
    		current = current.getNext();
    		if (i == index) {
    			LinkedListNode<E> newNode = new LinkedListNode<E>(value, current.getNext());
    			elementRemoved = current.getElement();
    			previous.next = newNode;
    		}
    		previous = current;
    	}
    	
    	return elementRemoved;
    }
    
    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
    	return size;
    }
    
    /**
     * {@inheritDoc} For a singly-linked list, this behavior has O(1) worst-case
     * runtime.
     */
    @Override
    public E last() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return tail.getElement();
    }

    /**
     * {@inheritDoc}
     * For this singly-linked list, addLast(element) behavior has O(1) worst-case runtime.
     */    
    @Override
    public void addLast(E element) {
        // TODO your code here
    	LinkedListNode<E> newNode = new LinkedListNode<E>(element);
    	if (isEmpty()) {
    		front.next = newNode;
    	} else {
    		tail.next = newNode;
    	}
    	tail = newNode;
    	size++;
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
     * Represents a node in the linked list.
     * 
     * @param <E> generic data type
     */
    private static class LinkedListNode<E> {
        
    	/** The element stored in this node. */
        private E element;
        
        /**  A reference to the next node in the linked list. */
        private LinkedListNode<E> next;
        
        /**
         * Constructs a new node with the given element and null next reference.
         *
         * @param element the element to store in this node
         */
        public LinkedListNode(E element) {
        	this(element, null);
        }
        
        /**
         * Constructs a new node with the given element and next node reference.
         *
         * @param element the element to store in this node
         * @param next the next node in the list
         */
        public LinkedListNode(E element, LinkedListNode<E> next) {
        	this.element = element;
        	this.next = next;
        }
        
        /**
         * Returns the element stored in this node.
         *
         * @return the element stored in this node
         */
        public E getElement() {
        	return element;
        }
        
        /**
         * Returns the next node in the list.
         *
         * @return the next node in the list
         */
        public LinkedListNode<E> getNext() {
        	return next;
        }  
        
    }
    
    /**
     * An iterator for the elements in the SinglyLinkedList.
     */
    private class ElementIterator implements Iterator<E> {
    	
        /**
         * Keep track of the next node that will be processed
         */
        private LinkedListNode<E> current;
        
        
        /**
         * Construct a new element iterator where the cursor is initialized 
         * to the beginning of the list.
         */
        public ElementIterator() {
        	this.current = front;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
        	return current.getNext() != null;
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
        	current = current.getNext();
        	return current.getElement();
        }
         
        /**
         * Removes from the underlying collection the last element returned by this iterator.
         * This operation is not supported by this implementation.
         *
         * @throws UnsupportedOperationException as this operation is not supported
         */
        @Override    
        public void remove() {
    	    // DO NOT CHANGE THIS METHOD
            throw new UnsupportedOperationException(
                "This SinglyLinkedList implementation does not currently support removal of elements when using the iterator.");
        }
    }
    
}
