package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * This class contains unit tests for the RadixSorter class.
 * It tests the sorting functionality for Student objects.
 * 
 * @author Aida Fatima
 * 
 */
public class RadixSorterTest {
	
	/** Student object representing the first student. */
	private Student sOne;
	
	/** Student object representing the second student. */
	private Student sTwo;
	
	/** Student object representing the third student. */
	private Student sThree;
	
	/** Student object representing the fourth student. */
	private Student sFour;
	
	/** Student object representing the fifth student. */
	private Student sFive;
	
	/** RadixSorter instance for sorting Student objects. */
	private RadixSorter<Student> sorter;
	
    /**
     * Sets up the test environment before each test method is executed.
     * Initializes Student objects and the RadixSorter.
     */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
		
		sorter = new RadixSorter<Student>();
	}
	
    /**
     * Tests the sorting of Student arrays using RadixSorter.
     * Verifies that an array of Student objects is correctly sorted.
     */
	@Test
	public void testSortStudent() {
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

}
