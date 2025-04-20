package edu.ncsu.csc316.dsa.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
import edu.ncsu.csc316.dsa.sorter.InsertionSorter;
import edu.ncsu.csc316.dsa.sorter.Sorter;

/**
 * This class tests the StudentManager class. It includes test cases for the sort method,
 * as well as test cases for custom comparators used for sorting students.
 * 
 * @author Aida Fatima
 */
public class StudentManagerTest {
	
	/** Test variable */
	private StudentManager sm;
	
	/** Test variable */
	private StudentManager smByID;
	
	/** Test variable */
	private StudentManager smByGPA;
	
    /**
     * Sets up the test fixture before each test method.
     */
	@Before
	public void setUp() {
		sm = new StudentManager("input/student_ascendingID.csv");
		
		StudentIDComparator sample = new StudentIDComparator();
		Sorter<Student> s = new InsertionSorter<Student>(sample);
		smByID = new StudentManager("input/student_ascendingID.csv",  s);
		
		StudentGPAComparator sample1 = new StudentGPAComparator();
		Sorter<Student> s1 = new InsertionSorter<Student>(sample1);
		smByGPA = new StudentManager("input/student_ascendingID.csv",  s1);
		
	}
	
    /**
     * Tests the sort method of the {@link StudentManager} class. This method sorts the students by their student IDs
     * and asserts that the first 16 students are sorted correctly.
     */
	@Test
	public void testSort() {
		Student[] sorted = sm.sort();
		assertEquals("Tanner", sorted[0].getFirst());
		assertEquals("Roxann", sorted[1].getFirst());
		assertEquals("Shanti", sorted[2].getFirst());
		assertEquals("Dante", sorted[3].getFirst());
		assertEquals("Cristine", sorted[4].getFirst());
		assertEquals("Ara", sorted[5].getFirst());
		assertEquals("Lewis", sorted[6].getFirst());
		assertEquals("Charlene", sorted[7].getFirst());
		assertEquals("Amber", sorted[8].getFirst());
		assertEquals("Lacie", sorted[9].getFirst());
		assertEquals("Idalia", sorted[10].getFirst());
		assertEquals("Tyree", sorted[11].getFirst());
		assertEquals("Evelin", sorted[12].getFirst());
		assertEquals("Alicia", sorted[13].getFirst());
		assertEquals("Loise", sorted[14].getFirst());
		assertEquals("Nichole",  sorted[15].getFirst());
	}

    /**
     * Tests the sortByID method of the StudentManager class. This method uses a custom comparator
     * StudentIDComparator to sort the students by their student IDs and asserts that the first 16 students are sorted correctly.
     */
	@Test
	public void testSortByID() {
		Student[] sorted = smByID.sort();
		assertEquals("Amber", sorted[0].getFirst());
		assertEquals("Ara", sorted[1].getFirst());
		assertEquals("Lacie", sorted[2].getFirst());
		assertEquals("Idalia", sorted[3].getFirst());
		assertEquals("Evelin", sorted[4].getFirst());
		assertEquals("Lewis", sorted[5].getFirst());
		assertEquals("Alicia", sorted[6].getFirst());
		assertEquals("Tyree", sorted[7].getFirst());
		assertEquals("Loise", sorted[8].getFirst());
		assertEquals("Roxann", sorted[9].getFirst());
		assertEquals("Nichole", sorted[10].getFirst());
		assertEquals("Charlene", sorted[11].getFirst());
		assertEquals("Shanti", sorted[12].getFirst());
		assertEquals("Cristine", sorted[13].getFirst());
		assertEquals("Tanner", sorted[14].getFirst());
		assertEquals("Dante", sorted[15].getFirst());
	}
	
    /**
     * Tests the sortByGPA method of the StudentManager class. This method uses a custom comparator
     * StudentGPAComparator to sort the students by their GPA and asserts that the first 16 students are sorted correctly.
     */
	@Test
	public void testSortByGPA() {
		Student[] sorted = smByGPA.sort();
		assertEquals("Nichole", sorted[0].getFirst());
		assertEquals("Alicia", sorted[1].getFirst());
		assertEquals("Charlene", sorted[2].getFirst());
		assertEquals("Cristine", sorted[3].getFirst());
		assertEquals("Dante", sorted[4].getFirst());
		assertEquals("Lacie", sorted[5].getFirst());
		assertEquals("Idalia", sorted[6].getFirst());
		assertEquals("Ara", sorted[7].getFirst());
		assertEquals("Loise", sorted[8].getFirst());
		assertEquals("Tanner", sorted[9].getFirst());
		assertEquals("Amber", sorted[10].getFirst());
		assertEquals("Roxann", sorted[11].getFirst());
		assertEquals("Tyree", sorted[12].getFirst());
		assertEquals("Evelin", sorted[13].getFirst());
		assertEquals("Shanti", sorted[14].getFirst());
		assertEquals("Lewis", sorted[15].getFirst());
	}
}
