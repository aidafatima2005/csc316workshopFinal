package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for RedBlackTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a red-black tree data structure 
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class RedBlackTreeMapTest {

    /** Tree Variable for testing */
	private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a red-black tree-based map before each test case executes
     */  
    @Before
    public void setUp() {
        tree = new RedBlackTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        // You should create test cases to check all the
        // rules for red-black trees. The textbook has examples
        // that you can use to create your test cases

        // You should check the specific keys in each node after adding or
        // removing from the tree. For example, you might use:
        //  assertEquals(4, (int)tree.root().getElement().getKey());
        //  assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());  
        
     // Insert into an empty tree
        tree.put(10, "A");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(10, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));

        // Insert a node with a black uncle (Case 1: trinode restructuring)
        tree.put(20, "B");
        tree.put(30, "C");
        assertEquals(3, tree.size());
        assertEquals(20, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(1, tree.getProperty(tree.right(tree.root())));

        // Insert a node with a red uncle (Case 2: recoloring)
        tree.put(40, "D");
        assertEquals(4, tree.size());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
    	// Insert some nodes
        tree.put(10, "A");
        tree.put(20, "B");
        tree.put(30, "C");

        // Test get on existing keys
        assertEquals("A", tree.get(10));
        assertEquals("B", tree.get(20));
        assertEquals("C", tree.get(30));

        // Test get on non-existent key
        assertNull(tree.get(40));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        
        // Insert some nodes
        tree.put(10, "A");
        tree.put(20, "B");
        tree.put(30, "C");
        tree.put(40, "D");
        tree.put(50, "E");

        // Remove a red node (no violation)
        tree.remove(20);
        assertEquals(4, tree.size());
        assertEquals(30, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.root())));

        // Remove a black node with a red child
        tree.remove(10);
        assertEquals(3, tree.size());
        assertEquals(40, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.root())));

        // Remove a black node with black children and black sibling (Case 2: recoloring)
        tree.remove(40);
        assertEquals(2, tree.size());
        assertEquals(50, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(1, tree.getProperty(tree.left(tree.root())));

        // Remove the root
        tree.remove(30);
        assertEquals(1, tree.size());
        assertEquals(50, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));

        // Remove the last node
        tree.remove(50);
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }
  
    /**
     * Test resolveRed where grandparent is not root
     */
    @Test
    public void testResolveRedGrandparentNotRoot() {
        tree.put(40, "D");
        tree.put(20, "B");
        tree.put(50, "E");
        tree.put(10, "A");
        tree.put(30, "C");

        // Verify the initial structure
        assertEquals(40, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        assertEquals(1, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.root()))));

        // Insert a new node to trigger a double-red violation
        tree.put(25, "F"); // Insert 25 as a left child of 30
        assertEquals(40, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(0, tree.getProperty(tree.left(tree.right(tree.root()))));
        assertEquals(0, tree.getProperty(tree.right(tree.right(tree.root()))));
    }
    
    /**
     * Test remedyDoubleBlack with multiple removals
     */
    @Test
    public void testRemedyDoubleBlackCase2() {
        tree.put(40, "D");
        tree.put(20, "B");
        tree.put(50, "E");
        tree.put(10, "A");
        tree.put(30, "C");
        tree.put(25, "D");
        tree.put(9, "E");
        tree.put(15, "F");
        tree.put(6, "G");
        tree.put(4, "H");
        
        tree.remove(6);
        tree.remove(10);
        
        assertEquals(20, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(1, tree.getProperty(tree.right(tree.root())));
    }
    
    /**
     * Test remedyDOubleBlack where a black node is deleted, and its sibling is red
     */
    @Test
    public void testRemedyDoubleBlackCase3() {
        tree.put(40, "D");
        tree.put(20, "B");
        tree.put(50, "E");
        tree.put(10, "A");
        tree.put(30, "C");

        assertEquals(40, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        assertEquals(1, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.root()))));

        tree.remove(10);

        assertEquals(40, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.root()))));
    }
}
