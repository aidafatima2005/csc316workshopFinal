package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SplayTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a splay tree data structure 
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class SplayTreeMapTest {

	/** Tree variable testing */
    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a splay tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new SplayTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        // Insert into an empty tree
        tree.put(10, "A");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(10, (int) tree.root().getElement().getKey());

        // Insert a node with no splaying required (Zig case)
        tree.put(20, "B");
        assertEquals(2, tree.size());
        assertEquals(20, (int) tree.root().getElement().getKey());
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());

        // Insert a node with Zig-Zig case
        tree.put(30, "C");
        assertEquals(3, tree.size());
        assertEquals(30, (int) tree.root().getElement().getKey());
        assertEquals(20, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(10, (int) tree.left(tree.left(tree.root())).getElement().getKey());

        // Insert a node with Zig-Zag case
        tree.put(15, "D");
        assertEquals(4, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(30, (int) tree.right(tree.root()).getElement().getKey());
    }
    
    /**
     * Test the output of the get(k) behavior
     */ 
    @Test
    public void testGet() {
        tree.put(10, "A");
        tree.put(20, "B");
        tree.put(30, "C");

        // Test get on existing keys
        assertEquals("A", tree.get(10));
        assertEquals(10, (int) tree.root().getElement().getKey());

        assertEquals("B", tree.get(20));
        assertEquals(20, (int) tree.root().getElement().getKey());

        assertEquals("C", tree.get(30));
        assertEquals(30, (int) tree.root().getElement().getKey());

        // Test get on non-existent key
        assertNull(tree.get(40));
        assertEquals(30, (int) tree.root().getElement().getKey());
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
    	// Insert some nodes
        tree.put(10, "A");
        tree.put(20, "B");
        tree.put(30, "C");
        tree.put(40, "D");
        tree.put(50, "E");

        // Remove a node with no children
        tree.remove(10);
        assertEquals(4, tree.size());
        assertEquals(20, (int) tree.root().getElement().getKey());
        assertEquals(30, (int) tree.left(tree.right(tree.root())).getElement().getKey());

        // Remove a node with one child
        tree.remove(30);
        assertEquals(3, tree.size());
        assertEquals(50, (int) tree.root().getElement().getKey());
        assertEquals(40, (int) tree.right(tree.left(tree.root())).getElement().getKey());

        // Remove a node with two children
        tree.remove(20);
        assertEquals(2, tree.size());
        assertEquals(50, (int) tree.root().getElement().getKey());
        assertEquals(40, (int) tree.left(tree.root()).getElement().getKey());

        // Remove the root
        tree.remove(40);
        assertEquals(1, tree.size());
        assertEquals(50, (int) tree.root().getElement().getKey());

        // Remove the last node
        tree.remove(50);
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }
}
