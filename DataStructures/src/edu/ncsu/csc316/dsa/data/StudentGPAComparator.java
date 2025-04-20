package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA
 * 
 * @author Dr. King
 * @author Aida Fatima
 *
 */
public class StudentGPAComparator implements Comparator<Student> {

	/**
	 * Compares two Student objects based on their GPA in descending order.
	 * 
	 * @param one the first Student object
	 * @param two the second Student object
	 * @return a negative integer if the first student's GPA is higher than the second student's GPA,
	 *         a positive integer if the first student's GPA is lower than the second student's GPA,
	 *         and 0 if the students have the same GPA.
	 */
	@Override
	public int compare(Student one, Student two) {
	
		return Double.compare(two.getGpa(), one.getGpa());
	}

}
