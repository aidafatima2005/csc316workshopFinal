package edu.ncsu.csc316.dsa.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * This class tests the StudentReader class.
 * 
 * @author Aida Fatima
 */
public class StudentReaderTest {
	
    /**
     * Tests the readInputAsArray method with a valid input file.
     * 
     * Verifies that the method correctly reads the data from the file 
     * and creates an array of Student objects with the expected first names.
     */
	@Test
	public void testReadFile() {
		Student[] contents = StudentReader.readInputAsArray("input/student_ascendingID.csv");
		assertEquals("Amber", contents[0].getFirst());
		assertEquals("Ara", contents[1].getFirst());
		assertEquals("Lacie", contents[2].getFirst());
		assertEquals("Idalia", contents[3].getFirst());
		assertEquals("Evelin", contents[4].getFirst());
		assertEquals("Lewis", contents[5].getFirst());
		assertEquals("Alicia", contents[6].getFirst());
		assertEquals("Tyree", contents[7].getFirst());
		assertEquals("Loise", contents[8].getFirst());
		assertEquals("Roxann", contents[9].getFirst());
		assertEquals("Nichole", contents[10].getFirst());
		assertEquals("Charlene", contents[11].getFirst());
		assertEquals("Shanti", contents[12].getFirst());
		assertEquals("Cristine", contents[13].getFirst());
		assertEquals("Tanner", contents[14].getFirst());
		assertEquals("Dante", contents[15].getFirst());
	}
	
    /**
     * Tests the readInputAsArray method with a valid input file.
     * 
     * Verifies that the method correctly reads the data from the file 
     * and creates an array of Student objects with the expected first names.
     */
	@Test
	public void testReadFileDescending() {
		Student[] contents = StudentReader.readInputAsArray("input/student_descendingID.csv");
		assertEquals("Amber", contents[15].getFirst());
		assertEquals("Ara", contents[14].getFirst());
		assertEquals("Lacie", contents[13].getFirst());
		assertEquals("Idalia", contents[12].getFirst());
		assertEquals("Evelin", contents[11].getFirst());
		assertEquals("Lewis", contents[10].getFirst());
		assertEquals("Alicia", contents[9].getFirst());
		assertEquals("Tyree", contents[8].getFirst());
		assertEquals("Loise", contents[7].getFirst());
		assertEquals("Roxann", contents[6].getFirst());
		assertEquals("Nichole", contents[5].getFirst());
		assertEquals("Charlene", contents[4].getFirst());
		assertEquals("Shanti", contents[3].getFirst());
		assertEquals("Cristine", contents[2].getFirst());
		assertEquals("Tanner", contents[1].getFirst());
		assertEquals("Dante", contents[0].getFirst());
	}
	
    /**
     * Tests the readInputAsArray method with a valid input file.
     * 
     * Verifies that the method correctly reads the data from the file 
     * and creates an array of Student objects with the expected first names.
     */
	@Test
	public void testReadFileRandom() {
		Student[] contents = StudentReader.readInputAsArray("input/student_randomOrder.csv");
		assertEquals("Amber", contents[14].getFirst());
		assertEquals("Ara", contents[10].getFirst());
		assertEquals("Lacie", contents[0].getFirst());
		assertEquals("Idalia", contents[3].getFirst());
		assertEquals("Evelin", contents[6].getFirst());
		assertEquals("Lewis", contents[15].getFirst());
		assertEquals("Alicia", contents[7].getFirst());
		assertEquals("Tyree", contents[1].getFirst());
		assertEquals("Loise", contents[2].getFirst());
		assertEquals("Roxann", contents[5].getFirst());
		assertEquals("Nichole", contents[9].getFirst());
		assertEquals("Charlene", contents[8].getFirst());
		assertEquals("Shanti", contents[4].getFirst());
		assertEquals("Cristine", contents[13].getFirst());
		assertEquals("Tanner", contents[12].getFirst());
		assertEquals("Dante", contents[11].getFirst());
	}

    /**
     * Tests the readInputAsArray method with an invalid input file.
     * 
     * Verifies that the method throws an IllegalArgumentException 
     * when an invalid file is provided as input.
     */
	@Test
	public void testReadFileInvalid() {		
		assertThrows(IllegalArgumentException.class,
				() -> StudentReader.readInputAsArray("input/invalid.csv"));
	}
	
}
