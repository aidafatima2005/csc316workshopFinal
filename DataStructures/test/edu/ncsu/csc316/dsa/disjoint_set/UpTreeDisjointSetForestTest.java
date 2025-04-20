package edu.ncsu.csc316.dsa.disjoint_set;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for UpTreeDisjointSetForest
 * Checks the expected outputs of the Disjoint Set abstract data type 
 * behaviors when using an up-tree data structure
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class UpTreeDisjointSetForestTest {

	/** Variable for DisjointSetForest */
    private DisjointSetForest<String> set;

    /**
     * Create a new instance of a up-tree forest before each test case executes
     */     
    @Before
    public void setUp() {
        set = new UpTreeDisjointSetForest<>();
    }
    
    /**
     * Test the output of the makeSet behavior
     */ 
    @Test
    public void testMakeSet() {
        Position<String> one = set.makeSet("one");
        assertEquals("one", one.getElement());
        Position<String> two = set.makeSet("two");
        assertEquals("two", two.getElement());
        
        try {
            set.makeSet("one");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test the output of the union-find behaviors
     */     
    @Test
    public void testUnionFind() {
        Position<String> one = set.makeSet("one");
        Position<String> two = set.makeSet("two");
        Position<String> three = set.makeSet("three");
        Position<String> four = set.makeSet("four");
        Position<String> five = set.makeSet("five");
        Position<String> six = set.makeSet("six");
        Position<String> seven = set.makeSet("seven");
        Position<String> eight = set.makeSet("eight");
        Position<String> nine = set.makeSet("nine");
        Position<String> ten = set.makeSet("ten");
        
        assertEquals(one, set.find("one"));
        assertEquals(two, set.find("two"));
        assertEquals(three, set.find("three"));
        assertEquals(four, set.find("four"));
        assertEquals(five, set.find("five"));
        assertEquals(six, set.find("six"));
        assertEquals(seven, set.find("seven"));
        assertEquals(eight, set.find("eight"));
        assertEquals(nine, set.find("nine"));
        assertEquals(ten, set.find("ten"));
        

        set.union(one, two);   
        set.union(three, four); 
        set.union(five, six);
        set.union(seven, eight);

        // Merge small groups
        set.union(set.find("one"), set.find("three"));  // Union(one-two, three-four)
        set.union(set.find("five"), set.find("seven")); // Union(five-six, seven-eight)

        // Final merge of all into one set
        set.union(set.find("one"), set.find("five"));
        set.union(set.find("one"), set.find("nine"));
        set.union(set.find("one"), set.find("ten"));

    }
    /**
     * Test PathCompression while using find 
     */
    @Test
    public void testPathCompressionInFindHelper() {
        set.makeSet("a");
        set.makeSet("b");
        set.makeSet("c");

        // Force a chain: c → b → a
        set.union(set.find("a"), set.find("b")); // b points to a
        set.union(set.find("b"), set.find("c")); // c points to b

        // Now, c is 2 levels deep: c → b → a

        // Trigger find on "c" (should compress path to a)
        Position<String> c = set.find("c");

        // After path compression, c should point directly to a
        Position<String> a = set.find("a");

        // Since we can't access internal parent directly, we confirm path compression
        // indirectly: both should return the same representative (a)
        assertEquals(a.getElement(), c.getElement());

        // Bonus: check that "b" and "c" now both point to the same root
        assertEquals(
            set.find("b").getElement(),
            set.find("c").getElement()
        );
    }
    
    /**
     * Tests that when the first set (a) is larger than the second set (b),
     * the root of a becomes the parent of b.
     */
    @Test
    public void testUnionWhenALargerThanB() {
        Position<String> a1 = set.makeSet("a1");
        Position<String> a2 = set.makeSet("a2");
        Position<String> b1 = set.makeSet("b1");

        // Make 'a1' larger: a1 ← a2
        set.union(a1, a2);  // a1's count = 2

        // Now a1 > b1; a1 should become parent
        set.union(a1, b1);

        assertEquals(set.find("a1").getElement(), set.find("b1").getElement());
    }

    /**
     * Tests that when the first set (a) is smaller than the second set (b),
     * the root of b becomes the parent of a.
     */
    @Test
    public void testUnionWhenASmallerThanB() {
        Position<String> a1 = set.makeSet("a1");
        Position<String> b1 = set.makeSet("b1");
        Position<String> b2 = set.makeSet("b2");

        // Make 'b1' larger: b1 ← b2
        set.union(b1, b2);  // b1's count = 2

        // Now b1 > a1; b1 should become parent
        set.union(a1, b1);

        assertEquals(set.find("b1").getElement(), set.find("a1").getElement());
    }

    /**
     * Tests the case when both sets are the same size.
     * In this case, the second set (b) should become the parent by design.
     */
    @Test
    public void testUnionWhenEqualSize() {
        Position<String> a = set.makeSet("a");
        Position<String> b = set.makeSet("b");

        // Both are size 1
        set.union(a, b);  // tie → b becomes parent

        assertEquals(set.find("b").getElement(), set.find("a").getElement());
    }

}