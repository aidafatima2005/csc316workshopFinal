package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * Test class for BinarySearchTreeMap
 * Checks the expected outputs of the Map and Tree abstract data type behaviors when using
 * an linked binary tree data structure 
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class BinarySearchTreeMapTest {

	/** Test variable tree */
    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a binary search tree map before each test case executes
     */
    @Before
    public void setUp() {
        tree = new BinarySearchTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(1, (int)tree.root().getElement().getKey());
        assertEquals("one", tree.get(1));
        
        // Insert second element (left child)
        tree.put(0, "zero");
        assertEquals(2, tree.size());
        assertEquals(0, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals("zero", tree.get(0));
        
        // Insert third element (right child)
        tree.put(2, "two");
        assertEquals(3, tree.size());
        assertEquals(2, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals("two", tree.get(2));
        
        // Update existing key
        assertEquals("one", tree.put(1, "uno"));
        assertEquals(3, tree.size());
        assertEquals("uno", tree.get(1));
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        assertEquals("one", tree.get(1));
        
        // Test getting a non-existent key
        assertNull(tree.get(10));
        
        // Add more elements and test
        tree.put(0, "zero");
        tree.put(2, "two");
        assertEquals("zero", tree.get(0));
        assertEquals("two", tree.get(2));
    }

    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        
        assertNull(tree.remove(10));
        assertEquals(1, tree.size());
        
        assertEquals("one", tree.remove(1));
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        // Test removing a node with only a left child
        tree.put(2, "two");
        tree.put(1, "one");
        assertEquals(2, tree.size());
        assertEquals("one", tree.remove(1));
        assertEquals(1, tree.size());
        assertEquals("two", tree.get(2));
        
        // Test removing a node with only a right child
        tree.put(3, "three");
        assertEquals(2, tree.size());
        assertEquals("three", tree.remove(3));
        assertEquals(1, tree.size());
        assertEquals("two", tree.get(2));
        
        // Test removing a node with both children
        tree.put(1, "one");
        tree.put(3, "three");
        tree.put(4, "four");
        assertEquals(4, tree.size());
        assertEquals("two", tree.remove(2));
        assertEquals(3, tree.size());
        assertEquals("three", tree.get(3));
        assertEquals("one", tree.get(1));
        assertEquals("four", tree.get(4));
        
        // Test removing the root with both children
        tree.put(2, "two");
        assertEquals(4, tree.size());
        assertEquals("three", tree.remove(3));
        assertEquals(3, tree.size());
        assertEquals("two", tree.get(2));
        assertEquals("one", tree.get(1));
        assertEquals("four", tree.get(4));
    }
    
    /**
     * Test the output of the iterator behavior, including expected exceptions
     */ 
    @Test
    public void testIterator() {
        tree.put(3, "string3");
        tree.put(5, "string5");
        tree.put(2, "string2");
        tree.put(4, "string4");
        tree.put(1, "string1");
        
        Iterator<Entry<Integer, String>> iterator = tree.entrySet().iterator();
        assertTrue(iterator.hasNext());
        
        // Test iterator order
        Entry<Integer, String> entry = iterator.next();
        assertEquals(1, (int) entry.getKey());
        assertEquals("string1", entry.getValue());
        
        entry = iterator.next();
        assertEquals(2, (int) entry.getKey());
        assertEquals("string2", entry.getValue());
        
        entry = iterator.next();
        assertEquals(3, (int) entry.getKey());
        assertEquals("string3", entry.getValue());
        
        entry = iterator.next();
        assertEquals(4, (int) entry.getKey());
        assertEquals("string4", entry.getValue());
        
        entry = iterator.next();
        assertEquals(5, (int) entry.getKey());
        assertEquals("string5", entry.getValue());
        
        assertFalse(iterator.hasNext());
        
        // Test exception when removing without calling next()
        assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
    }
    
    /**
     * Test toString
     */
    @Test
    public void testToString() {
    	tree.put(3, "string3");
        tree.put(5, "string5");
        tree.put(2, "string2");
        tree.put(4, "string4");
        tree.put(1, "string1");
        
        // Get the actual output from the toString method
        String actualOutput = tree.toString();
        
        // Verify the number of lines in the output
        String[] lines = actualOutput.split("\n");
        assertEquals(13, lines.length);
        
        assertEquals("BalanceableBinaryTree[", lines[0]);
        assertEquals("]", lines[12]);
        
        assertTrue( lines[1].contains("edu.ncsu.csc316.dsa.map.AbstractMap$MapEntry@"));
        assertTrue( lines[2].contains("edu.ncsu.csc316.dsa.map.AbstractMap$MapEntry@"));
        assertTrue( lines[3].contains("edu.ncsu.csc316.dsa.map.AbstractMap$MapEntry@"));
        assertTrue( lines[7].contains("edu.ncsu.csc316.dsa.map.AbstractMap$MapEntry@"));
        assertTrue( lines[8].contains("edu.ncsu.csc316.dsa.map.AbstractMap$MapEntry@"));
        
        assertTrue( lines[4].contains("null"));
        assertTrue( lines[5].contains("null"));
        assertTrue( lines[6].contains("null"));
        assertTrue( lines[9].contains("null"));
        assertTrue( lines[10].contains("null"));
        assertTrue( lines[11].contains("null"));
    }
    
}
