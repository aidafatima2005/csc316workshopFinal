package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for SearchTableMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a sorted array-based data structure that uses binary search to locate entries
 * based on the key of the entry
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class SkipListMapTest {

	/** A skip list based map with integer key and string value */
    private SkipListMap<Integer, String> map;
    
    /** A skip list map with student key and integer value */
    private SkipListMap<Student, Integer> studentMap;
    
    /**
     * Create a new instance of a search table map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new SkipListMap<Integer, String>();
        studentMap = new SkipListMap<Student, Integer>();
    }

    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("SkipListMap[3]", map.toString());
        assertEquals(1, map.size());
        
        //Test updating an existing key
        assertEquals("string3", map.put(3, "newString3"));
        assertEquals("SkipListMap[3]", map.toString());
        assertEquals(1, map.size());

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
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
        assertEquals("string5", map.get(5));
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
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
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
        // Test removing an existing key
        assertEquals("string2", map.remove(2));
        assertEquals("SkipListMap[1, 3, 4, 5]", map.toString());
        assertEquals(4, map.size());
        
        // Test removing a non-existent key
        assertNull(map.remove(10));
        assertEquals("SkipListMap[1, 3, 4, 5]", map.toString());
        assertEquals(4, map.size());
        
        // Test removing the first key
        assertEquals("string1", map.remove(1));
        assertEquals("SkipListMap[3, 4, 5]", map.toString());
        assertEquals(3, map.size());
        
     
        assertEquals("string5", map.remove(5));
        assertEquals("SkipListMap[3, 4]", map.toString());
        assertEquals(2, map.size());
    }
    
    /**
     * Tests Map abstract data type behaviors to ensure the behaviors work
     * as expected when using arbitrary objects as keys
     */
    @Test
    public void testStudentMap() {
        Student s1 = new Student("J", "K", 1, 0, 0, "jk");
        Student s2 = new Student("J", "S", 2, 0, 0, "js");
        Student s3 = new Student("S", "H", 3, 0, 0, "sh");
        Student s4 = new Student("J", "J", 4, 0, 0, "jj");
        Student s5 = new Student("L", "B", 5, 0, 0, "lb");
        
        // Test adding students to the map
        assertNull(studentMap.put(s1, 1));
        assertNull(studentMap.put(s2, 2));
        assertNull(studentMap.put(s3, 3));
        assertNull(studentMap.put(s4, 4));
        assertNull(studentMap.put(s5, 5));
        
        // Test the size of the map
        assertEquals(5, studentMap.size());

        // Test retrieving values using student keys
        assertEquals(1, (int) studentMap.get(s1));
        assertEquals(2, (int) studentMap.get(s2));
        assertEquals(3, (int) studentMap.get(s3));
        assertEquals(4, (int) studentMap.get(s4));
        assertEquals(5, (int) studentMap.get(s5));
        
        // Test updating an existing student key
        assertEquals(1, (int) studentMap.put(s1, 10));
        assertEquals(10, (int) studentMap.get(s1));

        // Test removing a student key
        assertEquals(2, (int) studentMap.remove(s2));
        assertNull(studentMap.get(s2));

        // Test the size after removal
        assertEquals(4, studentMap.size());

        // Test retrieving a non-existent student key
        assertNull(studentMap.get(new Student("A", "B", 6, 0, 0, "ab")));

        // Test the order of entries in the map (sorted by last name)
        Iterator<Map.Entry<Student, Integer>> it = studentMap.entrySet().iterator();
        assertTrue(it.hasNext());

        // Expected order by last name: B (s5), H (s3), J (s4), K (s1)
        Map.Entry<Student, Integer> entry = it.next();
        assertEquals(s5, entry.getKey()); // Last name: B
        assertEquals(5, (int) entry.getValue());

        entry = it.next();
        assertEquals(s3, entry.getKey()); // Last name: H
        assertEquals(3, (int) entry.getValue());

        entry = it.next();
        assertEquals(s4, entry.getKey()); // Last name: J
        assertEquals(4, (int) entry.getValue());

        entry = it.next();
        assertEquals(s1, entry.getKey()); // Last name: K
        assertEquals(10, (int) entry.getValue());

        // Ensure there are no more entries
        assertFalse(it.hasNext());


    }
    
    /**
     * Tests the functionality of the SkipListMap with a custom StudentIDComparator
     */
    @Test
    public void testStudentMapWithIDComparator() {
        // Initialize the SearchTableMap with StudentIDComparator
    	StudentIDComparator comparator = new StudentIDComparator();
    	SkipListMap<Student, Integer> studentMapID = new SkipListMap<Student, Integer>(comparator);

        Student s1 = new Student("J", "K", 1, 0, 0, "jk");
        Student s2 = new Student("J", "S", 2, 0, 0, "js");
        Student s3 = new Student("S", "H", 3, 0, 0, "sh");
        Student s4 = new Student("J", "J", 4, 0, 0, "jj");
        Student s5 = new Student("L", "B", 5, 0, 0, "lb");

        // Test adding students to the map
        assertNull(studentMapID.put(s1, 1));
        assertNull(studentMapID.put(s2, 2));
        assertNull(studentMapID.put(s3, 3));
        assertNull(studentMapID.put(s4, 4));
        assertNull(studentMapID.put(s5, 5));

        // Test the size of the map
        assertEquals(5, studentMapID.size());

        // Test retrieving values using student keys
        assertEquals(1, (int) studentMapID.get(s1));
        assertEquals(2, (int) studentMapID.get(s2));
        assertEquals(3, (int) studentMapID.get(s3));
        assertEquals(4, (int) studentMapID.get(s4));
        assertEquals(5, (int) studentMapID.get(s5));

        // Test the order of entries in the map (sorted by student ID)
        Iterator<Map.Entry<Student, Integer>> it = studentMapID.entrySet().iterator();
        assertTrue(it.hasNext());

        // Expected order by student ID: 1 (s1), 3 (s3), 4 (s4), 5 (s5)
        Map.Entry<Student, Integer> entry = it.next();
        assertEquals(s1, entry.getKey()); // ID: 1
        assertEquals(1, (int) entry.getValue());

        entry = it.next();
        assertEquals(s2, entry.getKey()); // ID: 2
        assertEquals(2, (int) entry.getValue());
        
        entry = it.next();
        assertEquals(s3, entry.getKey()); // ID: 3
        assertEquals(3, (int) entry.getValue());

        entry = it.next();
        assertEquals(s4, entry.getKey()); // ID: 4
        assertEquals(4, (int) entry.getValue());

        entry = it.next();
        assertEquals(s5, entry.getKey()); // ID: 5
        assertEquals(5, (int) entry.getValue());

        // Ensure there are no more entries
        assertFalse(it.hasNext());
    }
    
    /**
     * Tests the functionality of the SkipListMap with a custom StudentGPAComparator
     */
    @Test
    public void testStudentMapWithGPAComparator() {
        // Initialize the SearchTableMap with StudentGPAComparator
    	StudentGPAComparator comparator = new StudentGPAComparator();
    	SkipListMap<Student, Integer> studentMapGPA = new SkipListMap<>(comparator);

        Student s1 = new Student("J", "K", 1, 0, 3.5, "jk");  // GPA: 3.5
        Student s2 = new Student("J", "S", 2, 0, 3.8, "js");  // GPA: 3.8
        Student s3 = new Student("S", "H", 3, 0, 3.2, "sh");  // GPA: 3.2
        Student s4 = new Student("J", "J", 4, 0, 4.0, "jj");  // GPA: 4.0
        Student s5 = new Student("L", "B", 5, 0, 3.7, "lb");  // GPA: 3.7

        // Test adding students to the map
        assertNull(studentMapGPA.put(s1, 1));
        assertNull(studentMapGPA.put(s2, 2));
        assertNull(studentMapGPA.put(s3, 3));
        assertNull(studentMapGPA.put(s4, 4));
        assertNull(studentMapGPA.put(s5, 5));

        // Test the size of the map
        assertEquals(5, studentMapGPA.size());

        // Test retrieving values using student keys
        assertEquals(1, (int) studentMapGPA.get(s1));
        assertEquals(2, (int) studentMapGPA.get(s2));
        assertEquals(3, (int) studentMapGPA.get(s3));
        assertEquals(4, (int) studentMapGPA.get(s4));
        assertEquals(5, (int) studentMapGPA.get(s5));

        // Test updating an existing student key
        assertEquals(1, (int) studentMapGPA.put(s1, 10));
        assertEquals(10, (int) studentMapGPA.get(s1));

        // Test removing a student key
        assertEquals(2, (int) studentMapGPA.remove(s2));
        assertNull(studentMapGPA.get(s2));

        // Test the size after removal
        assertEquals(4, studentMapGPA.size());

        // Test retrieving a non-existent student key
        assertNull(studentMapGPA.get(new Student("A", "B", 6, 0, 3.9, "ab")));

        // Test the order of entries in the map (sorted by GPA in ascending order)
        Iterator<Map.Entry<Student, Integer>> it = studentMapGPA.entrySet().iterator();
        assertTrue(it.hasNext());

        // Expected order by GPA: 3.2 (s3), 3.5 (s1), 3.7 (s5), 4.0 (s4)
        Map.Entry<Student, Integer> entry = it.next();
        assertEquals(s4, entry.getKey()); // GPA: 4.0
        assertEquals(4, (int) entry.getValue());

        entry = it.next();
        assertEquals(s5, entry.getKey()); // GPA: 3.7
        assertEquals(5, (int) entry.getValue());

        entry = it.next();
        assertEquals(s1, entry.getKey()); // GPA: 3.5
        assertEquals(10, (int) entry.getValue());

        entry = it.next();
        assertEquals(s3, entry.getKey()); // GPA: 3.2
        assertEquals(3, (int) entry.getValue());

        // Ensure there are no more entries
        assertFalse(it.hasNext());
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
     * Test the output of the entrySet() behavior, including expected exceptions
     */     
    @Test
    public void testEntrySet() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertTrue(it.hasNext());
        Map.Entry<Integer, String> entry = it.next();
        assertEquals(1, (int)entry.getKey());
        assertEquals("string1", (String)entry.getValue());

        // Assert the rest of the entries
        assertTrue(it.hasNext());
        entry = it.next();
        assertEquals(2, (int) entry.getKey());
        assertEquals("string2", entry.getValue());

        assertTrue(it.hasNext());
        entry = it.next();
        assertEquals(3, (int) entry.getKey());
        assertEquals("string3", entry.getValue());

        assertTrue(it.hasNext());
        entry = it.next();
        assertEquals(4, (int) entry.getKey());
        assertEquals("string4", entry.getValue());

        assertTrue(it.hasNext());
        entry = it.next();
        assertEquals(5, (int) entry.getKey());
        assertEquals("string5", entry.getValue());

        // Ensure there are no more entries
        assertFalse(it.hasNext());
        

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
        
        Iterator<String> it = map.values().iterator();
        assertTrue(it.hasNext());
        
        // Test the order of values
        assertEquals("string1", it.next());
        assertEquals("string2", it.next());
        assertEquals("string3", it.next());
        assertEquals("string4", it.next());
        assertEquals("string5", it.next());
        
        assertFalse(it.hasNext());
    }
    
    /**
     * Tests the toFullString() method of the SkipListMap class.
     */
    @Test
    public void testToFullString() {
        // Insert some entries into the skip list
        map.put(3, "three");
        map.put(1, "one");
        map.put(5, "five");
        map.put(2, "two");
        map.put(4, "four");

        // Generate the full string representation of the skip list
        String fullString = map.toFullString();

        // Verify the structure dynamically
        String[] levels = fullString.split("\n"); // Split the string into lines (levels)
        assertTrue(levels.length >= 2); // At least one level (bottom level) and the closing bracket

        // Verify the bottom level (must contain all keys in sorted order)
        String bottomLevel = levels[levels.length - 2].trim(); // Second line is the bottom level
        assertTrue(bottomLevel.contains("-INF -> 1 -> 2 -> 3 -> 4 -> 5 -> +INF"));

        // Verify higher levels (if any)
        for (int i = 2; i < levels.length - 1; i++) {
            String level = levels[i].trim();
            // Ensure the level starts with -INF and ends with +INF
            assertTrue(level.startsWith("-INF ->"));
            assertTrue(level.endsWith("-> +INF"));

            // Ensure the keys in the level are a subset of the bottom level keys
            String[] keys = level.split(" -> ");
            for (int j = 1; j < keys.length - 1; j++) { // Skip -INF and +INF
                assertTrue(bottomLevel.contains(keys[j]));
            }
        }

        // Verify the closing bracket
        assertTrue(levels[levels.length - 1].trim().equals("]"));
    }
}
