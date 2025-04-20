package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley & Sons, 2014
 * 
 * @author Dr. Kings
 * @author Aida Fatima
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

	/** A dummy/sentinel node representing at the front of the list **/
	private PositionalNode<E> front;

	/** A dummy/sentinel node representing at the end/tail of the list **/
	private PositionalNode<E> tail;

	/** The number of elements in the list **/
	private int size;

	/**
	 * Constructs an empty positional linked list
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}

	/**
     * An iterator for the positions in the PositionalLinkedList.
     * 
     * @param <E> generic data type
     */
	private static class PositionalNode<E> implements Position<E> {

		/** The element stored at this position in the linked list.  */
		private E element;
		
		/** The reference to the next node in the linked list. */
		private PositionalNode<E> next;
		
		/** The reference to the previous node in the linked list.  */
		private PositionalNode<E> previous;

		/**
         * Constructs a new PositionIterator.
         * 
         * @param value to add at the position
         */
		public PositionalNode(E value) {
			this(value, null);
		}

		/**
		 * Constructs a new node with the given element and next node.
		 * 
		 * @param value the element to store in the node
		 * @param next the next node in the list
		 */
		public PositionalNode(E value, PositionalNode<E> next) {
			this(value, next, null);
		}

		/**
         * Constructs a new node with the given element, next node, and previous node.
         * 
         * @param value the element to store in the node
         * @param next  the next node in the list
         * @param prev  the previous node in the list
         */
		public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
			setElement(value);
			setNext(next);
			setPrevious(prev);
		}

		/**
		 * Sets the previous node reference for this node.
		 * 
		 * @param prev the node to be set as the previous node
		 */
		public void setPrevious(PositionalNode<E> prev) {
			previous = prev;
		}

		/**
		 * Retrieves the previous node reference for this node.
		 * 
		 * @return the previous node reference
		 */
		public PositionalNode<E> getPrevious() {
			return previous;
		}

		/**
		 * Sets the next node reference for this node.
		 *
		 * @param next the node to be set as the next node
		 */
		public void setNext(PositionalNode<E> next) {
			this.next = next;
		}

		/**
		 * Retrieves the next node reference for this node.
		 *
		 * @return the next node reference, or {@code null} if none exists
		 */
		public PositionalNode<E> getNext() {
			return next;
		}

		/**
		 * Retrieves the element stored at this position.
		 *
		 * @return the element stored at this position
		 */
		@Override
		public E getElement() {
			return element;
		}

		/**
		 * Sets the element to be stored at this position.
		 *
		 * @param element the element to store at this position
		 */
		public void setElement(E element) {
			this.element = element;
		}
	}

	/**
	 * Safely casts a Position, p, to be a PositionalNode.
	 * 
	 * @param p the position to cast to a PositionalNode
	 * @return a reference to the PositionalNode
	 * @throws IllegalArgumentException if p is null, or if p is not a valid
	 *                                  PositionalNode
	 */
	private PositionalNode<E> validate(Position<E> p) {
		if (p instanceof PositionalNode) {
			return (PositionalNode<E>) p;
		}
		throw new IllegalArgumentException("Position is not a valid positional list node.");
	}

	/**
	 * Helper method to add between
	 * 
	 * @param element to be added
	 * @param next    next node of the new node to be added
	 * @param prev    previous node of the new node to be added
	 * @return the new position created for the added elementr
	 */
	private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {
		// TODO your code here
		PositionalNode<E> newNode = new PositionalNode<>(element, next, prev);
		prev.setNext(newNode);
		next.setPrevious(newNode);
		size++;
		return newNode;
	}

	/**
	 * Returns an iterator over the elements in this list.
	 *
	 * @return an iterator of the elements in the list
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/**
	 * Adds a new element after the given position.
	 *
	 * @param p       the position after which the new element will be added
	 * @param element the element to add
	 * @return the position of the newly added element
	 * @throws IllegalArgumentException if the position is invalid
	 */
	@Override
	public Position<E> addAfter(Position<E> p, E element) {
		PositionalNode<E> node = validate(p);
		return addBetween(element, node.getNext(), node);
	}

	/**
	 * Adds a new element before the given position.
	 *
	 * @param p       the position before which the new element will be added
	 * @param element the element to add
	 * @return the position of the newly added element
	 * @throws IllegalArgumentException if the position is invalid
	 */
	@Override
	public Position<E> addBefore(Position<E> p, E element) {
		PositionalNode<E> node = validate(p);
		return addBetween(element, node, node.getPrevious());
	}

	/**
	 * Adds a new element to the beginning of the list.
	 *
	 * @param element the element to add
	 * @return the position of the newly added element
	 */
	@Override
	public Position<E> addFirst(E element) {
		return addBetween(element, front.getNext(), front);
	}

	/**
	 * Adds a new element to the end of the list.
	 *
	 * @param element the element to add
	 * @return the position of the newly added element
	 */
	@Override
	public Position<E> addLast(E element) {
		return addBetween(element, tail, tail.getPrevious());
	}

	/**
	 * Returns the position immediately after the given position.
	 *
	 * @param p the position whose successor is to be returned
	 * @return the position after the given position, or null if none exists
	 * @throws IllegalArgumentException if the position is invalid
	 */
	@Override
	public Position<E> after(Position<E> p) {
		PositionalNode<E> node = validate(p);
		PositionalNode<E> nextNode = node.getNext();
		return nextNode == tail ? null : nextNode;
	}

	/**
	 * Returns the position immediately before the given position.
	 *
	 * @param p the position whose predecessor is to be returned
	 * @return the position before the given position, or null if none exists
	 * @throws IllegalArgumentException if the position is invalid
	 */
	@Override
	public Position<E> before(Position<E> p) {
		PositionalNode<E> node = validate(p);
		PositionalNode<E> prevNode = node.getPrevious();
		return prevNode == front ? null : prevNode;
	}

	/**
	 * Returns the first position in the list.
	 *
	 * @return the first position in the list, or null if the list is empty
	 */
	@Override
	public Position<E> first() {
		return isEmpty() ? null : front.getNext();
	}

	/**
	 * Checks whether the list is empty.
	 *
	 * @return true if the list is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the last position in the list.
	 *
	 * @return the last position in the list, or null if the list is empty
	 */
	@Override
	public Position<E> last() {
		return isEmpty() ? null : tail.getPrevious();
	}

	/**
	 * Returns an iterable collection of all positions in the list.
	 *
	 * @return an iterable collection of positions
	 */
	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/**
	 * Removes the element at the given position from the list.
	 *
	 * @param p the position to remove
	 * @return the element that was removed
	 * @throws IllegalArgumentException if the position is invalid
	 */
	@Override
	public E remove(Position<E> p) {
		PositionalNode<E> node = validate(p);
		PositionalNode<E> prevNode = node.getPrevious();
		PositionalNode<E> nextNode = node.getNext();

		prevNode.setNext(nextNode);
		nextNode.setPrevious(prevNode);

		size--;

		E element = node.getElement();
		node.setElement(null); // Help garbage collection
		node.setNext(null);
		node.setPrevious(null);

		return element;
	}

	/**
	 * Replaces the element at the given position with a new element.
	 *
	 * @param p       the position to update
	 * @param element the new element to set
	 * @return the old element that was replaced
	 * @throws IllegalArgumentException if the position is invalid
	 */
	@Override
	public E set(Position<E> p, E element) {
		PositionalNode<E> node = validate(p);
		E oldElement = node.getElement();
		node.setElement(element);
		return oldElement;
	}

	/**
	 * Returns the number of elements in the list.
	 *
	 * @return the size of the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Inner Class
	 * 
	 * Iterator for traversing positions in the list.
	 */
	private class PositionIterator implements Iterator<Position<E>> {

		/** The current position */
		private Position<E> current;
		
		/** The previous position to the current */
		private Position<E> previous;
		
		/**  A flag indicating whether it is safe to remove the current position. */
		private boolean removeOK;

		/**
	     * Initializes the iterator starting at the first position.
	     */
		public PositionIterator() {
			current = front.getNext();
	        previous = null;
	        removeOK = false;
		}

		/**
		 * Checks if there is another element to iterate over.
		 * 
		 * @return true if there is a next position, false otherwise
		 */
		@Override
		public boolean hasNext() {
			return current != null && current != tail;
		}

		/**
		 * Returns the next position in the iteration.
		 * 
		 * @return the next position in the list
		 * @throws NoSuchElementException if there are no more positions to iterate over
		 */
		@Override
		public Position<E> next() {
			if (!hasNext()) {
	            throw new NoSuchElementException("No more positions to iterate.");
	        }
	        previous = current;
	        current = after(current);
	        removeOK = true;
	        return previous;  
		}

		/**
		 * Removes the last position returned by next()
		 * This method can only be called after a successful call to next()
		 * 
		 * @throws IllegalStateException if next() has not been called before remove()
		 */
		@Override
		public void remove() {
			if (!removeOK) {
	            throw new IllegalStateException("Must call next() before remove.");
	        }
	        PositionalLinkedList.this.remove(previous);  // Delegate to outer class's remove method
	        removeOK = false;
		}
	}

	/**
	 * Iterator for traversing elements in the list.
	 */
	private class ElementIterator implements Iterator<E> {

		/** Iterator for traversing positions in the list. */
		private Iterator<Position<E>> it;

		/**
	     * Initializes the iterator using a position iterator.
	     */
		public ElementIterator() {
			it = new PositionIterator();
		}

		/**
		 * Checks if there are more elements to iterate over.
		 * 
		 * @return true if there are more elements, false otherwise
		 */
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return the next element in the list
		 * @throws NoSuchElementException if no more elements exist
		 */
		@Override
		public E next() {
			return it.next().getElement();
		}

		/**
		 * Removes the last element returned by the iterator.
		 * 
		 * @throws IllegalArgumentException if it is called out without a preceding call.
		 */
		@Override
		public void remove() {
			it.remove();
		}
	}

	/**
	 * Iterable collection of positions in the list.
	 */
	private class PositionIterable implements Iterable<Position<E>> {

		/**
		 * Returns an iterator over the positions in the list.
		 * 
		 * @return an iterator that traverses the positions in the list
		 */
		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}

}