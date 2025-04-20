package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for PositionalLinkedList.
 * Checks the expected outputs of the Positional List abstract data type behaviors when using
 * an doubly-linked positional list data structure
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class PositionalLinkedListTest {

	/**  A positional list of strings */
    private PositionalList<String> list;
    
    /**
     * Create a new instance of an positional linked list before each test case executes
     */ 
    @Before
    public void setUp() {
        list = new PositionalLinkedList<String>();
    }
    
    /**
     * Test the output of the first() behavior, including any expected exceptions
     */
    @Test
    public void testFirst() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        assertNull(list.first());
        
        Position<String> first = list.addFirst("one");
        assertEquals(1, list.size());
        assertEquals(first, list.first());
        
        list.addFirst("zero");
        assertEquals("zero", list.first().getElement());
    }
    
    /**
     * Test the output of the last() behavior, including any expected exceptions
     */
    @Test
    public void testLast() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        assertNull(list.last());

        Position<String> first = list.addFirst("one");
        Position<String> last = list.addLast("two");
        assertEquals(2, list.size());
        assertEquals(first, list.first());
        assertEquals(last, list.last());

        list.addLast("three");
        assertEquals("three", list.last().getElement());
    }
    
    /**
     * Test the output of the addFirst(element) behavior
     */ 
    @Test
    public void testAddFirst() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addFirst("one");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        
        assertEquals("one", first.getElement());
        assertEquals(first, list.first());
    }
    
    /**
     * Test the output of the addLast(element) behavior
     */ 
    @Test
    public void testAddLast() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        Position<String> first = list.addLast("one");
        assertEquals(1, list.size());
        
        assertFalse(list.isEmpty());
        assertEquals("one", first.getElement());
        assertEquals(first, list.last());
    }
    
    /**
     * Test the output of the before(position) behavior, including any expected exceptions
     */ 
    @Test
    public void testBefore() {
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");
        Position<String> third = list.addLast("three");

        assertNull(list.before(first));
        assertEquals(first, list.before(second));
        assertEquals(second, list.before(third));
    }
    
    /**
     * Test the output of the after(position) behavior, including any expected exceptions
     */     
    @Test
    public void testAfter() {
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");
        Position<String> third = list.addLast("three");

        assertNull(list.after(third));
        assertEquals(third, list.after(second));
        assertEquals(second, list.after(first));
    }
    
    /**
     * Test the output of the addBefore(position, element) behavior, including any expected exceptions
     */     
    @Test
    public void testAddBefore() {
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");

        Position<String> newPos = list.addBefore(second, "zero");
        assertEquals(3, list.size());
        assertEquals("zero", newPos.getElement());
        assertEquals(newPos, list.before(second));
        assertEquals(newPos, list.after(first));
    }
    
    /**
     * Test the output of the addAfter(position, element) behavior, including any expected exceptions
     */     
    @Test
    public void testAddAfter() {
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");

        Position<String> newPos = list.addAfter(first, "zero");
        assertEquals(3, list.size());
        assertEquals("zero", newPos.getElement());
        assertEquals(newPos, list.after(first));
        assertEquals(newPos, list.before(second));
    }
    
    /**
     * Test the output of the set(position, element) behavior, including any expected exceptions
     */     
    @Test
    public void testSet() {
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");

        assertEquals("one", list.set(first, "zero"));
        assertEquals("zero", first.getElement());

        assertEquals("two", list.set(second, "three"));
        assertEquals("three", second.getElement());
    }
    
    /**
     * Test the output of the remove(position) behavior, including any expected exceptions
     */     
    @Test
    public void testRemove() {
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");
        Position<String> third = list.addLast("three");

        assertEquals("one", list.remove(first));
        assertEquals(2, list.size());
        assertNull(list.before(second));
        assertEquals(second, list.first());

        assertEquals("three", list.remove(third));
        assertEquals(1, list.size());
        assertEquals("two", list.remove(second));
        assertEquals(0, list.size());
    }
    
    /**
     * Test the output of the iterator behavior for elements in the list, 
     * including any expected exceptions
     */     
    @Test
    public void testIterator() {
        // Use your ArrayBasedList and SinglyLinkedList test cases as a guide
        list.addFirst("one");
        list.addLast("two");
        list.addLast("three");

        Iterator<String> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertTrue(it.hasNext());
        assertEquals("two", it.next());
        assertTrue(it.hasNext());
        assertEquals("three", it.next());
        assertFalse(it.hasNext());
        
        Iterator<String> it2 = list.iterator();
        assertTrue(it2.hasNext());
        assertThrows(IllegalStateException.class, () -> it2.remove());

        assertEquals("one", it2.next());
        assertTrue(it2.hasNext());        
        assertEquals("two", it2.next());
        it2.remove();
        assertFalse(it.hasNext());
    }
    
    /**
     * Test the output of the positions() behavior to iterate through positions
     * in the list, including any expected exceptions
     */     
    @Test
    public void testPositions() {
        assertEquals(0, list.size());
        Position<String> first = list.addFirst("one");
        Position<String> second = list.addLast("two");
        Position<String> third = list.addLast("three");
        assertEquals(3, list.size());
        
        Iterator<Position<String>> it = list.positions().iterator();
        assertTrue(it.hasNext());
        assertEquals(first, it.next());
        assertTrue(it.hasNext());
        assertEquals(second, it.next());
        assertTrue(it.hasNext());
        assertEquals(third, it.next());
        assertFalse(it.hasNext());
        
    }

}