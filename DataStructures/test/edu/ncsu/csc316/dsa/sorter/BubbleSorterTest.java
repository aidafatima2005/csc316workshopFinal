package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * This class tests the BubbleSorter class.
 * 
 * @author Aida Fatima
 */
public class BubbleSorterTest {
	
	/** Test Student object */
	private Student sOne = new Student("A", "A", 3, 1, 4.0, "oneUnityID");
	
	/** Test Student object */
	private Student sTwo = new Student("B", "B", 4, 2, 5.0, "twoUnityID");
	
	/** Test Student object */
	private Student sThree = new Student("C", "C", 5, 3, 1.0, "threeUnityID");
	
	/** Test Student object */
	private Student sFour = new Student("D", "D", 1, 4, 2.0, "fourUnityID");
	
	/** Test Student object */
	private Student sFive = new Student("E", "E", 2, 5, 3.0, "fiveUnityID");
	
	/** Test Students in ascending order */
	private Student[] studentAscending = {sOne, sTwo, sThree, sFour, sFive};
	
	/** Test Student in descending order */
	private Student[] studentDescending = {sFive, sFour, sThree, sTwo, sOne};
	
	/** Test Student in random order */
	private Student[] studentRandom = {sThree, sOne, sFive, sFour, sTwo};
	
    /** An instance of the BubbleSorter class. */
	private BubbleSorter<Student> bubbleSorter;
	
    /**
     * Initializes the bubbleSorter field before each test.
     */
	@Before
	public void setUp() {
		bubbleSorter = new BubbleSorter<Student>();
	}

    /**
     * Tests the sort method of the BubbleSorter class.
     * 
     * Sorts the studentAscending, studentDescending, and studentRandom arrays in ascending order based on gpa.
     * Verifies that the sorting is correct by comparing the sorted arrays to the expected output.
     */
	@Test
	public void testSortStudent() {
		
		bubbleSorter.sort(studentAscending);
		assertTrue(sOne.equals(studentAscending[0]));
		assertTrue(sTwo.equals(studentAscending[1]));
		assertTrue(sThree.equals(studentAscending[2]));
		assertTrue(sFour.equals(studentAscending[3]));
		assertTrue(sFive.equals(studentAscending[4]));
		
		bubbleSorter.sort(studentDescending);
		assertTrue(sOne.equals(studentAscending[0]));
		assertTrue(sTwo.equals(studentAscending[1]));
		assertTrue(sThree.equals(studentAscending[2]));
		assertTrue(sFour.equals(studentAscending[3]));
		assertTrue(sFive.equals(studentAscending[4]));
		
		bubbleSorter.sort(studentRandom);
		assertTrue(sOne.equals(studentAscending[0]));
		assertTrue(sTwo.equals(studentAscending[1]));
		assertTrue(sThree.equals(studentAscending[2]));
		assertTrue(sFour.equals(studentAscending[3]));
		assertTrue(sFive.equals(studentAscending[4]));
	}
	
	
}
