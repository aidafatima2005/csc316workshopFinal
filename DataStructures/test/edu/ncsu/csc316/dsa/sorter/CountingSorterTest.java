package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test class for CountingSorter.
 * 
 * @author Aida Fatima
 */
public class CountingSorterTest {
	
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
	
	/** Counting sorter variable for testing **/
	private CountingSorter<Student> sorter;

	 /**
     * Sets up the test data before each test case.
     */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
		
		sorter = new CountingSorter<Student>();
	}
	
    /**
     * Tests sorting an array of students in ascending order by GPA (existing test case).
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
	
    /**
     * Tests sorting an array of students in ascending order by GPA (existing test case).
     */
	@Test
	public void testSortStudentAlreadySorted() {
		Student[] original = { sOne, sTwo, sThree, sFour, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

}
