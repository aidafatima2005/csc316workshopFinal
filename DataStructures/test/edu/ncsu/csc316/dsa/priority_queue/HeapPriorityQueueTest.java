package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for HeapPriorityQueue
 * Checks the expected outputs of the Priorty Queue abstract data type behaviors when using
 * a min-heap data structure 
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class HeapPriorityQueueTest {

	/** PriorityQueue variable for test */
    private PriorityQueue<Integer, String> heap;
    
    /**
     * Create a new instance of a heap before each test case executes
     */     
    @Before
    public void setUp() {
        heap = new HeapPriorityQueue<Integer, String>();
    }
    
    /**
     * Test the output of the insert(k,v) behavior
     */     
    @Test
    public void testInsert() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        heap.insert(8, "eight");
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(8, (int)heap.min().getKey());
        
        heap.insert(3, "three");
        assertEquals(2, heap.size());
        assertEquals(3, (int)heap.min().getKey());
        
        heap.insert(5, "five");
        assertEquals(3, heap.size());
        assertEquals(3, (int)heap.min().getKey());
        
        heap.insert(1, "one");
        assertEquals(4, heap.size());
        assertEquals(1, (int)heap.min().getKey());
    }
    
    /**
     * Test the output of the min behavior
     */ 
    @Test
    public void testMin() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        assertNull(heap.min());
        
        heap.insert(8, "eight");
        assertEquals(8, (int)heap.min().getKey());
        
        heap.insert(3, "three");
        assertEquals(3, (int)heap.min().getKey());
        
        heap.insert(5, "five");
        assertEquals(3, (int)heap.min().getKey());
        
        heap.insert(1, "one");
        assertEquals(1, (int)heap.min().getKey());
    }
    
    /**
     * Test the output of the deleteMin behavior
     */     
    @Test 
    public void deleteMin() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        
        assertNull(heap.deleteMin());
        
        heap.insert(8, "eight");
        heap.insert(3, "three");
        heap.insert(5, "five");
        heap.insert(1, "one");
        
        assertEquals(1, (int)heap.deleteMin().getKey());
        assertEquals(3, heap.size());
        
        assertEquals(3, (int)heap.deleteMin().getKey());
        assertEquals(2, heap.size());
        
        assertEquals(5, (int)heap.deleteMin().getKey());
        assertEquals(1, heap.size());
        
        assertEquals(8, (int)heap.deleteMin().getKey());
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }
    
    /**
     * Test the output of the heap behavior when using arbitrary key objects to
     * represent priorities
     */ 
    @Test
    public void testStudentHeap() {
        PriorityQueue<Student, String> sHeap = new HeapPriorityQueue<Student, String>(new StudentIDComparator());
        Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
        Student s2 = new Student("J", "S", 2, 1, 2, "js2");
        Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
        Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
        Student s5 = new Student("L", "B", 5, 1, 5, "lb5");
        
        assertTrue(sHeap.isEmpty());
        assertEquals(0, sHeap.size());
        sHeap.insert(s1, "s1");
        assertEquals(1, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.insert(s2, "s2");
        assertEquals(2, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.insert(s3, "s3");
        assertEquals(3, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.insert(s4, "s4");
        assertEquals(4, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());
        
        sHeap.insert(s5, "s5");
        assertEquals(5, sHeap.size());
        assertEquals(s1, sHeap.min().getKey());
        
        assertEquals(s1, sHeap.deleteMin().getKey());
        assertEquals(4, sHeap.size());
        assertEquals(s2, sHeap.min().getKey());
        
        assertEquals(s2, sHeap.deleteMin().getKey());
        assertEquals(3, sHeap.size());
        assertEquals(s3, sHeap.min().getKey());
        
        assertEquals(s3, sHeap.deleteMin().getKey());
        assertEquals(2, sHeap.size());
        assertEquals(s4, sHeap.min().getKey());
        
        assertEquals(s4, sHeap.deleteMin().getKey());
        assertEquals(1, sHeap.size());
        assertEquals(s5, sHeap.min().getKey());
        
        assertEquals(s5, sHeap.deleteMin().getKey());
        assertEquals(0, sHeap.size());
        assertTrue(sHeap.isEmpty());
    }
}
