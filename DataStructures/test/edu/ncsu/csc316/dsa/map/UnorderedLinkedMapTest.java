package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for UnorderedLinkedMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an unordered link-based list data structure that uses the move-to-front heuristic for
 * self-organizing entries based on access frequency
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class UnorderedLinkedMapTest {

	/** a map with integer key and string value */
    private Map<Integer, String> map;
    
    /**
     * Create a new instance of an unordered link-based map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new UnorderedLinkedMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("UnorderedLinkedMap[3]", map.toString());
        assertEquals(1, map.size());

        // Test updating an existing key
        assertEquals("string3", map.put(3, "newString3"));
        assertEquals("UnorderedLinkedMap[3]", map.toString());
        assertEquals(1, map.size());

        // Test adding a new key-value pair
        assertNull(map.put(7, "string7"));
        assertEquals("UnorderedLinkedMap[7, 3]", map.toString());
        assertEquals(2, map.size());
    }

    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        // Test getting a non-existent key
        assertNull(map.get(10));
        
        // Test getting an existing key
        assertEquals("string5", map.get(5));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        // Test removing an existing key
        assertEquals("string2", map.remove(2));
        assertEquals("UnorderedLinkedMap[1, 4, 5, 3]", map.toString());
        assertEquals(4, map.size());
        
        // Test removing a non-existent key
        assertNull(map.remove(10));
        assertEquals("UnorderedLinkedMap[1, 4, 5, 3]", map.toString());
        assertEquals(4, map.size());
        
        // Test removing the first key
        assertEquals("string1", map.remove(1));
        assertEquals("UnorderedLinkedMap[4, 5, 3]", map.toString());
        assertEquals(3, map.size());
    }

    /**
     * Test the output of the iterator behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        assertTrue(iterator.hasNext());
        
        // Test iterator order
        Map.Entry<Integer, String> entry = iterator.next();
        assertEquals(1, (int) entry.getKey());
        assertEquals("string1", entry.getValue());
        
        entry = iterator.next();
        assertEquals(4, (int) entry.getKey());
        assertEquals("string4", entry.getValue());
        
        entry = iterator.next();
        assertEquals(2, (int) entry.getKey());
        assertEquals("string2", entry.getValue());
        
        entry = iterator.next();
        assertEquals(5, (int) entry.getKey());
        assertEquals("string5", entry.getValue());
        
        entry = iterator.next();
        assertEquals(3, (int) entry.getKey());
        assertEquals("string3", entry.getValue());
        
        assertFalse(iterator.hasNext());
        
        // Test exception when removing without calling next()
        assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
        
    }

    /**
     * Test the output of the entrySet() behavior, including expected exceptions
     */     
    @SuppressWarnings("unchecked")
	@Test
    public void testEntrySet() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        // Verify the contents of the entry set
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        assertTrue(iterator.hasNext());
        
        Map.Entry<Integer, String> entry = iterator.next();
        assertEquals(1, (int) entry.getKey());
        assertEquals("string1", entry.getValue());
        
        entry = iterator.next();
        assertEquals(4, (int) entry.getKey());
        assertEquals("string4", entry.getValue());
        
        entry = iterator.next();
        assertEquals(2, (int) entry.getKey());
        assertEquals("string2", entry.getValue());
        
        entry = iterator.next();
        assertEquals(5, (int) entry.getKey());
        assertEquals("string5", entry.getValue());
        
        entry = iterator.next();
        assertEquals(3, (int) entry.getKey());
        assertEquals("string3", entry.getValue());
        
        assertFalse(iterator.hasNext());
        
    }

    /**
     * Test the output of the values() behavior, including expected exceptions
     */     
    @Test
    public void testValues() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        // Verify the contents of the values collection
        Iterator<String> iterator = map.values().iterator();
        assertTrue(iterator.hasNext());
        
        assertEquals("string1", iterator.next());
        assertEquals("string4", iterator.next());
        assertEquals("string2", iterator.next());
        assertEquals("string5", iterator.next());
        assertEquals("string3", iterator.next());
        
        assertFalse(iterator.hasNext());
        
    }
    
    /**
     * Test the output of the keys() behavior, including expected exceptions
     */     
    @Test
    public void testKeys() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        // Verify the contents of the values collection
        Iterator<Integer> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        
        assertEquals(1, (int) iterator.next());
        assertEquals(4, (int) iterator.next());
        assertEquals(2, (int) iterator.next());
        assertEquals(5, (int) iterator.next());
        assertEquals(3, (int) iterator.next());
        
        assertFalse(iterator.hasNext());
        
        // Test exception when removing without calling next()
        assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
        
    }
}
