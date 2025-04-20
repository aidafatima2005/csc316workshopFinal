package edu.ncsu.csc316.dsa.list;

/**
 * A skeletal implementation of the List abstract data type. This class provides
 * implementation for common methods that can be implemented the same no matter
 * what specific type of concrete data structure is used to implement the list
 * abstract data type.
 * 
 * @author Dr. King
 * @author Aida Fatima 
 *
 * @param <E> the type of elements stored in the list
 */
public abstract class AbstractList<E> implements List<E> {

    @Override
    public void addFirst(E element) {
        add(0, element);
    }

    @Override
    public void addLast(E element) {
        add(size(), element);
    }

    /**
     * Checks whether the provided index is a legal index based on the current state
     * of the list. This check should be performed when accessing any specific
     * indexes within the list.
     * 
     * @param index the index for which to check whether it is valid/legal in the
     *              current list or not
     */
    protected void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
        }
    }

    /**
     * Checks whether the provided index is a legal index based on the current state
     * of the list. This check should be performed when adding elements at specific
     * indexes within the list.
     * 
     * @param index the index for which to check whether it is valid/legal in the
     *              current list or not
     */
    protected void checkIndexForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
        }
    }

    /**
     * Returns the first element in the list.
     * 
     * @return the first element in the list
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E first() {
        return get(0);
    }

    /**
     * Checks whether the list is empty.
     * 
     * @return {@code true} if the list contains no elements; {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the last element in the list.
     * 
     * @return the last element in the list
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E last() {
        return get(size() - 1);
    }

    /**
     * Removes and returns the first element in the list.
     * 
     * @return the removed first element
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Removes and returns the last element in the list.
     * 
     * @return the removed last element
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public E removeLast() {
        return remove(size() - 1);
    }
}
