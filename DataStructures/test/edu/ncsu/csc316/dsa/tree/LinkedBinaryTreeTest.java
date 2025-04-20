package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.tree.LinkedBinaryTree.BinaryTreeNode;

/**
 * Test class for LinkedBinaryTree
 * Checks the expected outputs of the BinaryTree abstract data type behaviors when using
 * a linked data structure to store elements
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class LinkedBinaryTreeTest {

	/** Test variable for tree */
    private LinkedBinaryTree<String> tree;
    
    /** Test variable at position one */
    private Position<String> one;
    
    /** Test variable at position two */
    private Position<String> two;
    
    /** Test variable at position three */
    private Position<String> three;
    
    /** Test variable at position four */
    private Position<String> four;
    
    /** Test variable at position five */
    private Position<String> five;
    
    /** Test variable at position six */
    private Position<String> six;
    
    /** Test variable at position seven */
    private Position<String> seven;
    
    /** Test variable at position eight */
    private Position<String> eight;
    
    /** Test variable at position nine */
    private Position<String> nine;
    
    /** Test variable at position ten */
    private Position<String> ten;

    /**
     * Create a new instance of a linked binary tree before each test case executes
     */       
    @Before
    public void setUp() {
        tree = new LinkedBinaryTree<String>(); 
    }
    
    /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */  
    private void createTree() {
        one = tree.addRoot("one");
        two = tree.addLeft(one, "two");
        three = tree.addRight(one, "three");
        six = tree.addLeft(two, "six");
        ten = tree.addRight(two, "ten");
        four = tree.addLeft(three, "four");
        seven = tree.addLeft(ten, "seven");
        five = tree.addRight(ten, "five");
        eight = tree.addLeft(four, "eight");
        nine = tree.addRight(four, "nine");
    }
    
    /**
     * Test the output of the set(p,e) behavior
     */     
    @Test
    public void testSet() {
        createTree();
        assertEquals("one", tree.set(one, "ONE"));
        assertEquals("ONE", one.getElement());
        assertEquals("two", tree.set(two, "TWO"));
        assertEquals("TWO", two.getElement());
    }
    
    /**
     * Test the output of the size() behavior
     */     
    @Test
    public void testSize() {
        assertTrue(tree.isEmpty());
        createTree();
        assertEquals(10, tree.size());
    }
    
    /**
     * Test the output of the numChildren(p) behavior
     */     
    @Test
    public void testNumChildren() {
        createTree();
        assertEquals(2, tree.numChildren(one));
        assertEquals(2, tree.numChildren(two));
        assertEquals(1, tree.numChildren(three));
        assertEquals(2, tree.numChildren(four));
        assertEquals(0, tree.numChildren(six));
        assertEquals(2, tree.numChildren(ten));
        assertEquals(0, tree.numChildren(seven));
        assertEquals(0, tree.numChildren(five));
        assertEquals(0, tree.numChildren(eight));
        assertEquals(0, tree.numChildren(nine));
    }

    /**
     * Test the output of the parent(p) behavior
     */   
    @Test
    public void testParent() {
        createTree();
        assertEquals(null, tree.parent(one));
        assertEquals(one, tree.parent(two));
        assertEquals(one, tree.parent(three));
        assertEquals(two, tree.parent(six));
        assertEquals(two, tree.parent(ten));
        assertEquals(three, tree.parent(four));
        assertEquals(ten, tree.parent(seven));
        assertEquals(ten, tree.parent(five));
        assertEquals(four, tree.parent(eight));
        assertEquals(four, tree.parent(nine));
    }

    /**
     * Test the output of the sibling behavior
     */     
    @Test
    public void testSibling() {
        createTree();
        assertEquals(three, tree.sibling(two));
        assertEquals(two, tree.sibling(three));
        assertEquals(ten, tree.sibling(six));
        assertEquals(six, tree.sibling(ten));
        assertEquals(null, tree.sibling(one));
        assertEquals(five, tree.sibling(seven));
        assertEquals(seven, tree.sibling(five));
        assertEquals(nine, tree.sibling(eight));
        assertEquals(eight, tree.sibling(nine));
    }

    /**
     * Test the output of the isInternal behavior
     */     
    @Test
    public void testIsInternal() {
        createTree();
        assertTrue(tree.isInternal(one));
        assertTrue(tree.isInternal(two));
        assertTrue(tree.isInternal(three));
        assertTrue(tree.isInternal(four));
        assertTrue(tree.isInternal(ten));
        assertFalse(tree.isInternal(six));
        assertFalse(tree.isInternal(seven));
        assertFalse(tree.isInternal(five));
        assertFalse(tree.isInternal(eight));
        assertFalse(tree.isInternal(nine));
    }

    /**
     * Test the output of the isLeaf behavior
     */     
    @Test
    public void isLeaf() {
        createTree();
        assertFalse(tree.isLeaf(one));
        assertFalse(tree.isLeaf(two));
        assertFalse(tree.isLeaf(three));
        assertFalse(tree.isLeaf(four));
        assertFalse(tree.isLeaf(ten));
        assertTrue(tree.isLeaf(six));
        assertTrue(tree.isLeaf(seven));
        assertTrue(tree.isLeaf(five));
        assertTrue(tree.isLeaf(eight));
        assertTrue(tree.isLeaf(nine));
    }

    /**
     * Test the output of the isRoot(p)
     */     
    @Test
    public void isRoot() {
        createTree();
        assertTrue(tree.isRoot(one));
        assertFalse(tree.isRoot(two));
        assertFalse(tree.isRoot(three));
        assertFalse(tree.isRoot(four));
        assertFalse(tree.isRoot(six));
        assertFalse(tree.isRoot(ten));
        assertFalse(tree.isRoot(seven));
        assertFalse(tree.isRoot(five));
        assertFalse(tree.isRoot(eight));
        assertFalse(tree.isRoot(nine));
    }
    
    /**
     * Test the output of the preOrder traversal behavior
     */     
    @Test
    public void testPreOrder() {
        createTree();
        Iterator<Position<String>> it = tree.preOrder().iterator();
        assertEquals("one", it.next().getElement());
        assertEquals("two", it.next().getElement());
        assertEquals("six", it.next().getElement());
        assertEquals("ten", it.next().getElement());
        assertEquals("seven", it.next().getElement());
        assertEquals("five", it.next().getElement());
        assertEquals("three", it.next().getElement());
        assertEquals("four", it.next().getElement());
        assertEquals("eight", it.next().getElement());
        assertEquals("nine", it.next().getElement());
    }

    /**
     * Test the output of the postOrder traversal behavior
     */     
    @Test
    public void testPostOrder() {
        createTree();
        Iterator<Position<String>> it = tree.postOrder().iterator();
        assertEquals("six", it.next().getElement());
        assertEquals("seven", it.next().getElement());
        assertEquals("five", it.next().getElement());
        assertEquals("ten", it.next().getElement());
        assertEquals("two", it.next().getElement());
        assertEquals("eight", it.next().getElement());
        assertEquals("nine", it.next().getElement());
        assertEquals("four", it.next().getElement());
        assertEquals("three", it.next().getElement());
        assertEquals("one", it.next().getElement());
    }
    
    /**
     * Test the output of the inOrder traversal behavior
     */     
    @Test
    public void testInOrder() {
        createTree();
        Iterator<Position<String>> it = tree.inOrder().iterator();
        assertEquals("six", it.next().getElement());
        assertEquals("two", it.next().getElement());
        assertEquals("seven", it.next().getElement());
        assertEquals("ten", it.next().getElement());
        assertEquals("five", it.next().getElement());
        assertEquals("one", it.next().getElement());
        assertEquals("eight", it.next().getElement());
        assertEquals("four", it.next().getElement());
        assertEquals("nine", it.next().getElement());
        assertEquals("three", it.next().getElement());
    }

    /**
     * Test the output of the Binary Tree ADT behaviors on an empty tree
     */     
    @Test
    public void testEmptyTree() {
    	assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertNull(tree.root());
    }
    
    /**
     * Test the output of the levelOrder traversal behavior
     */
    @Test
    public void testLevelOrder() {
        createTree();
        Iterator<Position<String>> it = tree.levelOrder().iterator();
        assertEquals("one", it.next().getElement());
        assertEquals("two", it.next().getElement());
        assertEquals("three", it.next().getElement());
        assertEquals("six", it.next().getElement());
        assertEquals("ten", it.next().getElement());
        assertEquals("four", it.next().getElement());
        assertEquals("seven", it.next().getElement());
        assertEquals("five", it.next().getElement());
        assertEquals("eight", it.next().getElement());
        assertEquals("nine", it.next().getElement());
    }

    /**
     * Test the output of the addLeft(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddLeft() {
    	createTree();
    	Position<String> newLeft = tree.addLeft(six, "newLeft");
        assertEquals("newLeft", newLeft.getElement());
        assertEquals(six, tree.parent(newLeft));
        assertEquals("newLeft", tree.left(six).getElement());
        
        assertThrows(IllegalArgumentException.class, () -> tree.addLeft(six, "anotherLeft"));
    }
    
    /**
     * Test the output of the addRight(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddRight() {
    	createTree();
        Position<String> newRight = tree.addRight(six, "newRight");
        assertEquals("newRight", newRight.getElement());
        assertEquals(six, tree.parent(newRight));
        assertEquals("newRight", tree.right(six).getElement());
        
        assertThrows(IllegalArgumentException.class, () -> tree.addRight(six, "anotherRight"));
    }   
    
    /**
     * Test the output of the remove(p) behavior, including expected exceptions
     */         
    @Test
    public void testRemove() {
        createTree();
        assertEquals("six", tree.remove(six));
        assertEquals(9, tree.size());
        assertNull(tree.left(two));
        
        assertEquals("two", tree.remove(two));
        assertEquals(8, tree.size());
        assertEquals("ten", tree.left(one).getElement());
        
        assertThrows(IllegalArgumentException.class, () -> tree.remove(ten));
        
        Iterator<Position<String>> it = tree.levelOrder().iterator();
      
        assertThrows(UnsupportedOperationException.class, () -> it.remove());
        
        assertEquals("nine", tree.remove(nine));
        assertEquals(7, tree.size());
        assertNull(tree.left(eight));
        
        assertEquals("four", tree.remove(four));
        assertEquals(6, tree.size());
        assertEquals("eight", tree.left(three).getElement());
    }
    
    /**
     * Test the output of the toString() behavior
     */
    @Test
    public void testToString() {
        createTree(); // Create the sample tree

        // Expected string representation of the tree
        String expected = "LinkedBinaryTree[\n" +
                          "one\n" +
                          " two\n" +
                          "  six\n" +
                          "  ten\n" +
                          "   seven\n" +
                          "   five\n" +
                          " three\n" +
                          "  four\n" +
                          "   eight\n" +
                          "   nine\n" +
                          "]";

        // Get the actual string representation of the tree
        String actual = tree.toString();

        // Compare the expected and actual strings
        assertEquals(expected, actual);
    }
    
    /**
     * Test the output of the addRoot()
     */     
    @Test
    public void testAddRoot() {
        createTree();
        assertThrows(IllegalArgumentException.class, () -> tree.addRoot("new root"));
    }
    
    /**
     * Test the output of the validate()
     */     
    @Test
    public void testValidate() {
        createTree();
        assertThrows(IllegalArgumentException.class, () -> tree.validate(null));
    }
    
    /**
     * Test the output of the setRoot()
     */     
    @Test
    public void testSetRoot() {
        createTree();
        Position<String> newRoot = new BinaryTreeNode<String>("newRoot");
        tree.setRoot(newRoot);
        
        assertEquals("newRoot", tree.root().getElement());
    }
    
    
}
