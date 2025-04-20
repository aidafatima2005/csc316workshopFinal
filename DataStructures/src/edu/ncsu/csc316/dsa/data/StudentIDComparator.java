package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator to compare students based on id number
 * 
 * @author Dr. King
 * @author Aida Fatima
 *
 */
public class StudentIDComparator implements Comparator<Student> {

  	/**
  	 * Compares two Student objects based on their ID numbers in ascending order.
  	 * 
  	 * @param one the first Student object
  	 * @param two the second Student object
  	 * @return a negative integer if the first student's ID is less than the second student's ID,
  	 *         a positive integer if the first student's ID is greater than the second student's ID,
  	 *         and 0 if the students have the same ID.
  	 */
	@Override
	public int compare(Student one, Student two) {

		return Integer.compare(one.getId(), two.getId());
	}

}
