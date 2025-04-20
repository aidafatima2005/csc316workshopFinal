package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the Student class.
 * 
 * @author Aida Fatima
 * 
 */
public class StudentTest {

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
	
	/** Test variable as student 1 **/
	private Student s1;
	
	/** Test variable as student 2 **/
	private Student s2;

    /**
     * Sets up the test data before each test case.
     * Creates instances of the Student class with different values.
     */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
		
		s1 = new Student("OneFirst", "OneLast", 1, 11, 1.1, "1UnityID");
		s2 = new Student("2First", "TwoLast", 2, 2, 2.0, "twoUnityID");
	}

    /**
     * Tests the setFirst method of the Student class.
     * Verifies that the first name of the student is updated correctly.
     */
	@Test
	public void testSetFirst() {
		sThree.setFirst("newThree");
		assertEquals("newThree", sThree.getFirst());
	}

    /**
     * Tests the setLast method of the Student class.
     * Verifies that the last name of the student is updated correctly.
     */
	@Test
	public void testSetLast() {
		sFour.setLast("newFour");
		assertEquals("newFour", sFour.getLast());
	}

    /**
     * Tests the setId method of the Student class.
     * Verifies that the student ID is updated correctly.
     */
	@Test
	public void testSetId() {
		sFive.setId(100);
		assertEquals(100, sFive.getId());
	}

    /**
     * Tests the setGpa method of the Student class.
     * Verifies that the GPA of the student is updated correctly.
     */

	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}
	
    /**
     * Tests the setCreditHours method of the Student class.
     * Verifies that the credit hours of the student are updated correctly.
     */
	@Test
	public void testSetCreditHours() {
		sOne.setCreditHours(13);
		assertEquals(13, sOne.getCreditHours());
	}
	
    /**
     * Tests the setUnityID method of the Student class.
     * Verifies that the Unity ID of the student is updated correctly.
     */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}

    /**
     * Tests the compareTo method of the Student class.
     * Verifies that the compareTo method correctly compares students based on their natural ordering 
     * (presumably by student ID).
     */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOne) == 0);
		assertTrue(sTwo.compareTo(sTwo) == 0);
		assertTrue(sTwo.compareTo(s2) > 0);
	}
	
    /**
     * Tests the equals method of the Student class.
     * Verifies that the equals method correctly determines equality between Student objects.
     */
	@Test
	public void testEquals() {
		assertTrue(sOne.equals(s1));
		assertFalse(sOne.equals(sTwo));
	}
	
    /**
     * Tests the toString method of the Student class.
     * Verifies that the toString method returns a correct string representation of the Student object.
     */
	@Test
	public void testToString() {
		String expected = "Student [first=" + s1.getFirst() + ", last=" + s1.getLast() + ", id=" + s1.getId() + ", creditHours=" + s1.getCreditHours() + ", gpa="
				+ s1.getGpa() + ", unityID=" + s1.getUnityID() + "]";
		
		assertEquals(s1.toString(), expected);
	}
	
    /**
     * Tests the hashCode method of the Student class.
     * Verifies that the hashCode method generates consistent hash codes for equal Student objects.
     */
	@Test
	public void testHashCode() {
		assertEquals(sOne.hashCode(), s1.hashCode());
		assertNotEquals(sOne.hashCode(), sTwo.hashCode());
	}
}
