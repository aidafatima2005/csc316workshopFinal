package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the StudentGPAComparator class.
 * 
 * @author Aida Fatima
 *
 */
public class StudentGPAComparatorTest {

	/** Test variable as student one **/
	private Student sOne;
	
	/** Test variable as student two **/
	private Student sTwo;
	
	/** Test variable as student three **/
	private Student sThree;
	
	/** Test variable as student four **/
	private Student sFour;
	
	/** Test variable as student five **/
	private Student sFive;

    /**
     * An instance of the StudentGPAComparator class.
     */
	private StudentGPAComparator comparator;

    /**
     * Sets up the test data before each test case.
     *
     * This method creates five Student objects with different GPAs and an instance of the StudentGPAComparator class.
     */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		comparator = new StudentGPAComparator();
	}
	
	/**
     * Tests the compare method of the StudentGPAComparator class.
     *
     * This test case verifies that the compare method returns a negative value when the first student has a lower GPA than the second student.
     * It also verifies that the compare method returns a non-negative value when the first student has a higher GPA than the second student.
     *
     */
	@Test
	public void testCompare() {
		assertTrue(comparator.compare(sTwo, sOne) < 0);
		assertFalse(comparator.compare(sOne, sTwo) < 0);

		assertTrue(comparator.compare(sTwo, sThree) > 0);
		assertTrue(comparator.compare(sThree, sFour) > 0);
		assertTrue(comparator.compare(sFour, sFive) > 0);
	}

}
