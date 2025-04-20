package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for ArrayBasedList.
 * Checks the expected outputs of the List abstract data type behaviors when using
 * an linkedList-based list data structure
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class SinglyLinkedListTest {

	/** A list of Strings */
    private List<String> list;

    /**
     * Create a new instance of an LinkedList-based list before each test case executes
     */
    @Before
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }

    /**
     * Test the output of the add(index, e) behavior, including expected exceptions
     */
    @Test
    public void testAddIndex() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.add(0, "one");
        assertEquals(1, list.size());
        assertEquals("one", list.get(0));
        assertFalse(list.isEmpty());
        
        // Use the statements above to help guide your test cases
        // for data structures: Start with an empty data structure, then
        // add an element and check the accessor method return values.
        // Then add another element and check again. Continue to keep checking
        // for special cases. For example, for an linked-based list, you should
        // continue adding until you trigger a resize operation to make sure
        // the resize operation worked as expected.
        
        try{
            list.add(15,  "fifteen");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
    }

    /**
     * Test the output of the addLast behavior
     */
    @Test
    public void testAddLast() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	assertEquals("zero", list.get(0));
    	assertEquals("zero", list.last());

    	list.add(1, "one");
    	assertEquals("one", list.get(1));


    	list.add(2, "two");
    	assertEquals("two", list.get(2));


    	
    	// Add an element at the end
    	list.addLast("last");

    	
    	// Test that new size is correct
    	assertEquals(4, list.size());
    	
    	// Ensure elements are in correct order
    	assertEquals("zero", list.get(0));
    	assertEquals("one", list.get(1));
    	assertEquals("two", list.get(2));
    	assertEquals("last", list.get(3));

    }

    /**
     * Test the output of the last() behavior, including expected exceptions
     */
    @Test
    public void testLast() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	// Get the last element
    	assertEquals("two", list.last());
    }

    /**
     * Test the output of the addFirst behavior
     */
    @Test
    public void testAddFirst() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	// Add an element at the beginning
    	list.addFirst("first");
    	
    	// Test that new size is correct
    	assertEquals(4, list.size());
    	
    	// Ensure elements are in correct order
    	assertEquals("first", list.get(0));
    	assertEquals("zero", list.get(1));
    	assertEquals("one", list.get(2));
    	assertEquals("two", list.get(3));
    }

    /**
     * Test the output of the first() behavior, including expected exceptions
     */
    @Test
    public void testFirst() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	// Get the first element
    	assertEquals("zero", list.first());
    }

    /**
     * Test the iterator behaviors, including expected exceptions
     */
    @Test
    public void testIterator() {
        // Start with an empty list
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        // Create an iterator for the empty list
        Iterator<String> it = list.iterator();
        
        // Try different operations to make sure they work
        // as expected for an empty list (at this point)
        try{
            it.remove();
            fail("An IllegalStateException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
        assertFalse(it.hasNext());

        // Now add an element
        list.addLast("one");
        
        // Use accessor methods to check that the list is correct
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals("one", list.get(0));
        
        // Create an iterator for the list that has 1 element
        it = list.iterator();
        
        // Try different iterator operations to make sure they work
        // as expected for a list that contains 1 element (at this point)
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertFalse(it.hasNext());
        try{
            it.next();
            fail("A NoSuchElementException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
       
    }

    /**
     * Test the output of the remove(index) behavior, including expected exceptions
     */
    @Test
    public void testRemoveIndex() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	// Remove the element at specific index 
    	list.remove(1);
    	
    	// Test that new size is correct
    	assertEquals(2, list.size());
    	
    	// Ensure elements are in correct order
    	assertEquals("zero", list.get(0));
    	assertEquals("two", list.get(1));
    	
    }

    /**
     * Test the output of the removeFirst() behavior, including expected exceptions
     */
    @Test
    public void testRemoveFirst() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	// Remove first element
    	list.removeFirst();
    	
    	// Test that new size is correct
    	assertEquals(2, list.size());
    	
    	// Ensure elements are in correct order
    	assertEquals("one", list.get(0));
    	assertEquals("two", list.get(1));
    }

    /**
     * Test the output of the removeLast() behavior, including expected exceptions
     */
    @Test
    public void testRemoveLast() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	// Remove last element
    	list.removeLast();
    	
    	// Test that new size is correct
    	assertEquals(2, list.size());
    	
    	// Ensure elements are in correct order
    	assertEquals("zero", list.get(0));
    	assertEquals("one", list.get(1));
    }

    /**
     * Test the output of the set(index, e) behavior, including expected exceptions
     */
    @Test
    public void testSet() {
    	
    	//Add some test data
    	list.add(0, "zero");
    	list.add(1, "one");
    	list.add(2, "two");
    	
    	// Set the element at specific index 
    	list.set(1, "yondu");
    	
    	// Test that new size is correct
    	assertEquals(3, list.size());
    	
    	// Ensure elements are in correct order
    	assertEquals("zero", list.get(0));
    	assertEquals("yondu", list.get(1));
    	assertEquals("two", list.get(2));

    }
}