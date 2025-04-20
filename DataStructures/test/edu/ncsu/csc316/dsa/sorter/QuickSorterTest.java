package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for QuickSorter
 */
public class QuickSorterTest {

	/** An array of integers in ascending order. */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	
	/** An array of integers in descending order. */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	
	/** An array of integers in random order. */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };
	
	/** A SelectionSorter instance for sorting integers. */
	private QuickSorter<Integer> integerSorter;
	
	/** Student object representing the first student. */
	private Student sOne = new Student("A", "A", 3, 1, 4.0, "oneUnityID");
	
	/** Student object representing the second student. */
	private Student sTwo = new Student("B", "B", 4, 2, 5.0, "twoUnityID");
	
	/** Student object representing the third student. */
	private Student sThree = new Student("C", "C", 5, 3, 1.0, "threeUnityID");
	
	/** Student object representing the fourth student. */
	private Student sFour = new Student("D", "D", 1, 4, 2.0, "fourUnityID");
	
	/** Student object representing the fifth student. */
	private Student sFive = new Student("E", "E", 2, 5, 3.0, "fiveUnityID");
	
	/** An array of Student objects in ascending order based on their natural ordering. */
	private Student[] studentAscending = {sOne, sTwo, sThree, sFour, sFive};
	
	/** An array of Student objects in descending order based on their natural ordering. */
	private Student[] studentDescending = {sFive, sFour, sThree, sTwo, sOne};
	
	/** An array of Student objects in random order based on their natural ordering. */
	private Student[] studentRandom = {sThree, sOne, sFive, sFour, sTwo};
	
	/** A SelectionSorter instance for sorting Student objects. */
	private QuickSorter<Student> studentSorter;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the integer and student sorters, and creates Student objects.
     */
	@Before
	public void setUp() {
				
		integerSorter = new QuickSorter<Integer>();
		studentSorter = new QuickSorter<Student>();
	}

    /**
     * Tests the sorting of Integer arrays using Quick Sorter.
     * Verifies that arrays in ascending, descending, and random order are correctly sorted.
     */
	@Test
	public void testSortIntegers() {
		integerSorter.sort(dataAscending);
		assertTrue(1 == dataAscending[0]);
		assertTrue(2 == dataAscending[1]);
		assertTrue(3 == dataAscending[2]);
		assertTrue(4 == dataAscending[3]);
		assertTrue(5 == dataAscending[4]);

		integerSorter.sort(dataDescending);
		assertTrue(1 == dataDescending[0]);
		assertTrue(2 == dataDescending[1]);
		assertTrue(3 == dataDescending[2]);
		assertTrue(4 == dataDescending[3]);
		assertTrue(5 == dataDescending[4]);

		integerSorter.sort(dataRandom);
		assertTrue(1 == dataRandom[0]);
		assertTrue(2 == dataRandom[1]);
		assertTrue(3 == dataRandom[2]);
		assertTrue(4 == dataRandom[3]);
		assertTrue(5 == dataRandom[4]);

	}
	
    /**
     * Tests the sorting of Integer arrays using Quick Sorter with First Element Selector.
     * Verifies that arrays in ascending, descending, and random order are correctly sorted.
     */
	@Test
	public void testSortIntegersWithFirstElementSelector() {
		
		QuickSorter<Integer> sorter = new QuickSorter<Integer>(QuickSorter.FIRST_ELEMENT_SELECTOR);
		
		
		sorter.sort(dataAscending);
		assertTrue(1 == dataAscending[0]);
		assertTrue(2 == dataAscending[1]);
		assertTrue(3 == dataAscending[2]);
		assertTrue(4 == dataAscending[3]);
		assertTrue(5 == dataAscending[4]);

		sorter.sort(dataDescending);
		assertTrue(1 == dataDescending[0]);
		assertTrue(2 == dataDescending[1]);
		assertTrue(3 == dataDescending[2]);
		assertTrue(4 == dataDescending[3]);
		assertTrue(5 == dataDescending[4]);

		sorter.sort(dataRandom);
		assertTrue(1 == dataRandom[0]);
		assertTrue(2 == dataRandom[1]);
		assertTrue(3 == dataRandom[2]);
		assertTrue(4 == dataRandom[3]);
		assertTrue(5 == dataRandom[4]);

	}
	
	/**
     * Tests the sorting of Integer arrays using Quick Sorter with Last Element Selector.
     * Verifies that arrays in ascending, descending, and random order are correctly sorted.
     */
	@Test
	public void testSortIntegersWithLastElementSelector() {
		
		QuickSorter<Integer> sorter = new QuickSorter<Integer>(QuickSorter.LAST_ELEMENT_SELECTOR);
		
		
		sorter.sort(dataAscending);
		assertTrue(1 == dataAscending[0]);
		assertTrue(2 == dataAscending[1]);
		assertTrue(3 == dataAscending[2]);
		assertTrue(4 == dataAscending[3]);
		assertTrue(5 == dataAscending[4]);

		sorter.sort(dataDescending);
		assertTrue(1 == dataDescending[0]);
		assertTrue(2 == dataDescending[1]);
		assertTrue(3 == dataDescending[2]);
		assertTrue(4 == dataDescending[3]);
		assertTrue(5 == dataDescending[4]);

		sorter.sort(dataRandom);
		assertTrue(1 == dataRandom[0]);
		assertTrue(2 == dataRandom[1]);
		assertTrue(3 == dataRandom[2]);
		assertTrue(4 == dataRandom[3]);
		assertTrue(5 == dataRandom[4]);

	}
	
	/**
     * Tests the sorting of Integer arrays using Quick Sorter with Middle Element Selector.
     * Verifies that arrays in ascending, descending, and random order are correctly sorted.
     */
	@Test
	public void testSortIntegersWithMiddleElementSelector() {
		
		QuickSorter<Integer> sorter = new QuickSorter<Integer>(QuickSorter.MIDDLE_ELEMENT_SELECTOR);
		
		
		sorter.sort(dataAscending);
		assertTrue(1 == dataAscending[0]);
		assertTrue(2 == dataAscending[1]);
		assertTrue(3 == dataAscending[2]);
		assertTrue(4 == dataAscending[3]);
		assertTrue(5 == dataAscending[4]);

		sorter.sort(dataDescending);
		assertTrue(1 == dataDescending[0]);
		assertTrue(2 == dataDescending[1]);
		assertTrue(3 == dataDescending[2]);
		assertTrue(4 == dataDescending[3]);
		assertTrue(5 == dataDescending[4]);

		sorter.sort(dataRandom);
		assertTrue(1 == dataRandom[0]);
		assertTrue(2 == dataRandom[1]);
		assertTrue(3 == dataRandom[2]);
		assertTrue(4 == dataRandom[3]);
		assertTrue(5 == dataRandom[4]);

	}
	
	/**
     * Tests the sorting of Integer arrays using Quick Sorter with Middle Element Selector.
     * Verifies that arrays in ascending, descending, and random order are correctly sorted.
     */
	@Test
	public void testSortIntegersWithRandomElementSelector() {
		
		QuickSorter<Integer> sorter = new QuickSorter<Integer>(QuickSorter.RANDOM_ELEMENT_SELECTOR);
		
		
		sorter.sort(dataAscending);
		assertTrue(1 == dataAscending[0]);
		assertTrue(2 == dataAscending[1]);
		assertTrue(3 == dataAscending[2]);
		assertTrue(4 == dataAscending[3]);
		assertTrue(5 == dataAscending[4]);

		sorter.sort(dataDescending);
		assertTrue(1 == dataDescending[0]);
		assertTrue(2 == dataDescending[1]);
		assertTrue(3 == dataDescending[2]);
		assertTrue(4 == dataDescending[3]);
		assertTrue(5 == dataDescending[4]);

		sorter.sort(dataRandom);
		assertTrue(1 == dataRandom[0]);
		assertTrue(2 == dataRandom[1]);
		assertTrue(3 == dataRandom[2]);
		assertTrue(4 == dataRandom[3]);
		assertTrue(5 == dataRandom[4]);

	}

    /**
     * Tests the sorting of Student arrays using Quick Sorter.
     * Verifies that arrays of Student objects in ascending, descending, and random order are correctly sorted.
     */
	@Test
	public void testSortStudent() {
		
		studentSorter.sort(studentAscending);
		assertTrue(sOne.equals(studentAscending[0]));
		assertTrue(sTwo.equals(studentAscending[1]));
		assertTrue(sThree.equals(studentAscending[2]));
		assertTrue(sFour.equals(studentAscending[3]));
		assertTrue(sFive.equals(studentAscending[4]));
		
		studentSorter.sort(studentDescending);
		assertTrue(sOne.equals(studentDescending[0]));
		assertTrue(sTwo.equals(studentDescending[1]));
		assertTrue(sThree.equals(studentDescending[2]));
		assertTrue(sFour.equals(studentDescending[3]));
		assertTrue(sFive.equals(studentDescending[4]));
		
		studentSorter.sort(studentRandom);
		assertTrue(sOne.equals(studentRandom[0]));
		assertTrue(sTwo.equals(studentRandom[1]));
		assertTrue(sThree.equals(studentRandom[2]));
		assertTrue(sFour.equals(studentRandom[3]));
		assertTrue(sFive.equals(studentRandom[4]));
	}
	
	/**
     * Tests the sorting of Student arrays using Quick Sorter.
     * Verifies that arrays of Student objects in ascending, descending, and random order are correctly sorted.
     */
	@Test
	public void testSortStudentWithSelector() {
		
		QuickSorter<Student> sorter = new QuickSorter<Student>(QuickSorter.FIRST_ELEMENT_SELECTOR);
		
		sorter.sort(studentAscending);
		assertTrue(sOne.equals(studentAscending[0]));
		assertTrue(sTwo.equals(studentAscending[1]));
		assertTrue(sThree.equals(studentAscending[2]));
		assertTrue(sFour.equals(studentAscending[3]));
		assertTrue(sFive.equals(studentAscending[4]));
		
		sorter.sort(studentDescending);
		assertTrue(sOne.equals(studentDescending[0]));
		assertTrue(sTwo.equals(studentDescending[1]));
		assertTrue(sThree.equals(studentDescending[2]));
		assertTrue(sFour.equals(studentDescending[3]));
		assertTrue(sFive.equals(studentDescending[4]));
		
		sorter.sort(studentRandom);
		assertTrue(sOne.equals(studentRandom[0]));
		assertTrue(sTwo.equals(studentRandom[1]));
		assertTrue(sThree.equals(studentRandom[2]));
		assertTrue(sFour.equals(studentRandom[3]));
		assertTrue(sFive.equals(studentRandom[4]));
	}
	
    /**
     * Tests the sorting of Student arrays using Quick Sorter with a custom StudentIDComparator.
     * Verifies that arrays of Student objects are correctly sorted based on their ID.
     */
	@Test
	public void testSortStudentsByID() {
		
		StudentIDComparator comparator = new StudentIDComparator();
		QuickSorter<Student> sortStudentByID = new QuickSorter<Student>(comparator);
		
		sortStudentByID.sort(studentAscending);
		assertTrue(sFour.equals(studentAscending[0]));
		assertTrue(sFive.equals(studentAscending[1]));
		assertTrue(sOne.equals(studentAscending[2]));
		assertTrue(sTwo.equals(studentAscending[3]));
		assertTrue(sThree.equals(studentAscending[4]));
		
		sortStudentByID.sort(studentDescending);
		assertTrue(sFour.equals(studentDescending[0]));
		assertTrue(sFive.equals(studentDescending[1]));
		assertTrue(sOne.equals(studentDescending[2]));
		assertTrue(sTwo.equals(studentDescending[3]));
		assertTrue(sThree.equals(studentDescending[4]));
		
		sortStudentByID.sort(studentRandom);
		assertTrue(sFour.equals(studentRandom[0]));
		assertTrue(sFive.equals(studentRandom[1]));
		assertTrue(sOne.equals(studentRandom[2]));
		assertTrue(sTwo.equals(studentRandom[3]));
		assertTrue(sThree.equals(studentRandom[4]));

	}
	
	/**
     * Tests the sorting of Student arrays using QuickSorter with a custom StudentGPAComparator.
     * Verifies that arrays of Student objects are correctly sorted based on their GPA.
     */
	@Test
	public void testSortStudentsByGPA() {
		
		StudentGPAComparator sample = new StudentGPAComparator();
		QuickSorter<Student> sortStudentByGPA = new QuickSorter<Student>(sample);
		
		sortStudentByGPA.sort(studentAscending);
		assertTrue(sTwo.equals(studentAscending[0]));
		assertTrue(sOne.equals(studentAscending[1]));
		assertTrue(sFive.equals(studentAscending[2]));
		assertTrue(sFour.equals(studentAscending[3]));
		assertTrue(sThree.equals(studentAscending[4]));

		sortStudentByGPA.sort(studentDescending);
		assertTrue(sTwo.equals(studentDescending[0]));
		assertTrue(sOne.equals(studentDescending[1]));
		assertTrue(sFive.equals(studentDescending[2]));
		assertTrue(sFour.equals(studentDescending[3]));
		assertTrue(sThree.equals(studentDescending[4]));
		
		sortStudentByGPA.sort(studentRandom);
		assertTrue(sTwo.equals(studentRandom[0]));
		assertTrue(sOne.equals(studentRandom[1]));
		assertTrue(sFive.equals(studentRandom[2]));
		assertTrue(sFour.equals(studentRandom[3]));
		assertTrue(sThree.equals(studentRandom[4]));
	}
	
    /**
     * Tests the sorting of Student arrays using QuickSorter with a custom StudentIDComparator and FIRST_ELEMENT_SELECTOR.
     * Verifies that arrays of Student objects are correctly sorted based on their ID.
     */
	@Test
	public void testSortStudentsByIDAndSelector() {
		
		StudentIDComparator comparator = new StudentIDComparator();
		QuickSorter<Student> sortStudentByID = new QuickSorter<Student>(comparator, QuickSorter.FIRST_ELEMENT_SELECTOR);
		
		sortStudentByID.sort(studentAscending);
		assertTrue(sFour.equals(studentAscending[0]));
		assertTrue(sFive.equals(studentAscending[1]));
		assertTrue(sOne.equals(studentAscending[2]));
		assertTrue(sTwo.equals(studentAscending[3]));
		assertTrue(sThree.equals(studentAscending[4]));
		
		sortStudentByID.sort(studentDescending);
		assertTrue(sFour.equals(studentDescending[0]));
		assertTrue(sFive.equals(studentDescending[1]));
		assertTrue(sOne.equals(studentDescending[2]));
		assertTrue(sTwo.equals(studentDescending[3]));
		assertTrue(sThree.equals(studentDescending[4]));
		
		sortStudentByID.sort(studentRandom);
		assertTrue(sFour.equals(studentRandom[0]));
		assertTrue(sFive.equals(studentRandom[1]));
		assertTrue(sOne.equals(studentRandom[2]));
		assertTrue(sTwo.equals(studentRandom[3]));
		assertTrue(sThree.equals(studentRandom[4]));

	}

}
