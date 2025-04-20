package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for LinearProbingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a linear probing hash map data structure 
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class LinearProbingHashMapTest {

    /** 'Testing' Map used (no randomization) to check placement of entries in the hash table */
    private Map<Integer, String> testMap;
    
    /** 'Production' Map (with randomization) to check correctness of ADT behaviors */
    private Map<Integer, String> prodMap;

    /**
     * Create a new instance of a linear probing hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are testing.
        // Remember that (when testing) alpha = 1, beta = 1, and prime = 7
        // based on our AbstractHashMap constructor.
        // That means you can draw the hash table by hand
        // if you use integer keys, since Integer.hashCode() = the integer value, itself
        // Finally, apply compression. For example:
        // for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
        // for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
        // for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
        // for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
        // for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
        // for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
        // etc.
        testMap = new LinearProbingHashMap<Integer, String>(7, true);
        prodMap = new LinearProbingHashMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, testMap.size());
        assertTrue(testMap.isEmpty());
       
        // Insert first entry
        assertNull(testMap.put(1, "string1"));
        assertEquals(1, testMap.size());
        assertFalse(testMap.isEmpty());
        
        // Insert second entry
        assertNull(testMap.put(2, "string2"));
        assertEquals(2, testMap.size());
        
        // Insert entry that causes a collision
        assertNull(testMap.put(8, "string8")); 
        assertEquals(3, testMap.size());
        
        // Update existing key
        assertEquals("string1", testMap.put(1, "newString1"));
        assertEquals(3, testMap.size());
        
        // Test prodMap with randomization
        assertNull(prodMap.put(1, "prod1"));
        assertNull(prodMap.put(2, "prod2"));
        assertEquals(2, prodMap.size());
        assertEquals("prod1", prodMap.get(1));
        assertEquals("prod2", prodMap.get(2));
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(testMap.isEmpty());
        assertNull(testMap.get(1));

        testMap.put(1, "string1");
        testMap.put(2, "string2");
        assertEquals("string1", testMap.get(1));
        assertEquals("string2", testMap.get(2));
        assertNull(testMap.get(3));

        // Test prodMap with randomization
        prodMap.put(1, "prod1");
        prodMap.put(2, "prod2");
        assertEquals("prod1", prodMap.get(1));
        assertEquals("prod2", prodMap.get(2));
        assertNull(prodMap.get(3));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        assertTrue(testMap.isEmpty());
        assertNull(testMap.remove(1));

        testMap.put(1, "string1");
        testMap.put(2, "string2");
        assertEquals("string1", testMap.remove(1));
        assertEquals(1, testMap.size());
        assertNull(testMap.get(1)); // Key should be removed
        assertEquals("string2", testMap.remove(2));
        assertTrue(testMap.isEmpty());

        // Test prodMap with randomization
        prodMap.put(1, "prod1");
        prodMap.put(2, "prod2");
        assertEquals("prod1", prodMap.remove(1));
        assertEquals(1, prodMap.size());
        assertNull(prodMap.get(1)); // Key should be removed
        assertEquals("prod2", prodMap.remove(2));
        assertTrue(prodMap.isEmpty());
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
    	testMap.put(1, "string1");
        testMap.put(2, "string2");
        testMap.put(3, "string3");
        
        Iterator<Integer> it = testMap.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, (int)it.next());
        assertTrue(it.hasNext());
        assertEquals(2, (int)it.next());
        assertTrue(it.hasNext());
        assertEquals(3, (int)it.next());
        assertFalse(it.hasNext());
        
        assertThrows(NoSuchElementException.class, () -> it.next());
    }
    
    /**
     * Test the output of the entrySet() behavior
     */     
    @Test
    public void testEntrySet() {
    	testMap.put(1, "string1");
        testMap.put(2, "string2");
        testMap.put(3, "string3");
        
        Iterator<Map.Entry<Integer, String>> it = testMap.entrySet().iterator();     
        assertTrue(it.hasNext());
        Map.Entry<Integer, String> entry = it.next();
        assertEquals(1, (int)entry.getKey());
        assertEquals("string1", entry.getValue());
        assertTrue(it.hasNext());
        entry = it.next();
        assertEquals(2, (int)entry.getKey());
        assertEquals("string2", entry.getValue());
        assertTrue(it.hasNext());
        entry = it.next();
        assertEquals(3, (int)entry.getKey());
        assertEquals("string3", entry.getValue());
        assertFalse(it.hasNext());
    }
    
    /**
     * Test the output of the values() behavior
     */  
    @Test
    public void testValues() {
    	testMap.put(1, "string1");
        testMap.put(2, "string2");
        testMap.put(3, "string3");
        
        Iterator<String> it = testMap.values().iterator();
        assertTrue(it.hasNext());
        assertEquals("string1", it.next());
        assertTrue(it.hasNext());
        assertEquals("string2", it.next());
        assertTrue(it.hasNext());
        assertEquals("string3", it.next());
        assertFalse(it.hasNext());
    }
    
    /**
     * Test resize in AbstractHashMap
     */
    @Test
    public void testResize() {
        LinearProbingHashMap<Integer, String> map = new LinearProbingHashMap<Integer, String>(4, true);

        map.put(1, "string1");
        map.put(2, "string2");
        map.put(3, "string3");

        assertEquals(3, map.size());
        assertTrue(map.capacity() > 4);

        assertEquals("string1", map.get(1));
        assertEquals("string2", map.get(2));
        assertEquals("string3", map.get(3));

        map.put(4, "string4");
        map.put(5, "string5");

        assertEquals(5, map.size());
        assertTrue(map.capacity() > 4);

        assertEquals("string1", map.get(1));
        assertEquals("string2", map.get(2));
        assertEquals("string3", map.get(3));
        assertEquals("string4", map.get(4));
        assertEquals("string5", map.get(5));
    }
}
