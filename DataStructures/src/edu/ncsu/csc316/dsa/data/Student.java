package edu.ncsu.csc316.dsa.data;

import java.util.Objects;

/**
 * A student is comparable and identifiable.
 * Students have a first name, last name, id number, 
 * number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 * @author Aida Fatima
 *
 */
public class Student implements Comparable<Student>, Identifiable {
	
	/**
	 * The first name of the student.
	 */
	private String first;

	/**
	 * The last name of the student.
	 */
	private String last;

	/**
	 * The unique ID number of the student.
	 */
	private int id;

	/**
	 * The number of credit hours the student is enrolled in.
	 */
	private int creditHours;

	/**
	 * The student's Grade Point Average (GPA).
	 */
	private double gpa;

	/**
	 * The student's Unity ID.
	 */
	private String unityID;
	
	
	/**
	 * Constructs a new Student object with the given first name, last name, ID, credit hours, GPA, and Unity ID. 
	 * 
	 * @param first the first name
	 * @param last the last name
	 * @param id the student ID number
	 * @param creditHours the number of credit hours enrolled
	 * @param gpa the student's GPA
	 * @param unityID the student's unityID
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		this.first = first;
		this.last = last;
		this.id = id;
		this.creditHours = creditHours;
		this.gpa = gpa;
		this.unityID = unityID;
	}

	/**
	 * Gets the first name of the student.
	 * 
	 * @return the first name of the student
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the first name of the student.
	 * 
	 * @param first the new first name of the student
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Gets the last name of the student.
	 * 
	 * @return the last name of the student
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Sets the last name of the student.
	 * 
	 * @param last the new last name of the student
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Gets the unique ID number of the student.
	 * 
	 * @return the unique ID number of the student
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique ID number of the student.
	 * 
	 * @param id the new unique ID number of the student
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the number of credit hours the student is enrolled in.
	 * 
	 * @return the number of credit hours the student is enrolled in
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * Sets the number of credit hours the student is enrolled in.
	 * 
	 * @param creditHours the new number of credit hours the student is enrolled in
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	/**
	 * Gets the student's Grade Point Average (GPA).
	 * 
	 * @return the student's GPA
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * Sets the student's Grade Point Average (GPA).
	 * 
	 * @param gpa the new GPA of the student
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * Gets the student's Unity ID.
	 * 
	 * @return the student's Unity ID
	 */
	public String getUnityID() {
		return unityID;
	}

	/**
	 * Sets the student's Unity ID.
	 * 
	 * @param unityID the new Unity ID of the student
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}

	/**
	 * Generates a hash code for the Student object based on its first name, last name, and ID.
	 * 
	 * @return a hash code for the Student object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(first, last, id);
	}

	/**
	 * Checks if this Student object is equal to another object.
	 * Two Student objects are considered equal if they have the same first name, last name, and ID.
	 * 
	 * @param obj the object to compare to
	 * @return true if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Student other = (Student) obj;
		return first.equals(other.first) && last.equals(other.last) && id == other.id;
	}

	/**
	 * Returns a string representation of the Student object.
	 * 
	 * @return a string representation of the Student object
	 */
	@Override
	public String toString() {
		return "Student [first=" + first + ", last=" + last + ", id=" + id + ", creditHours=" + creditHours + ", gpa="
				+ gpa + ", unityID=" + unityID + "]";
	}

	/**
	 * Implements the `compareTo` method from the `Comparable` interface.
	 * This method defines the sorting order for `Student` objects.
	 * Students are compared first by last name, then by first name, 
	 * and lastly by their ID number.
	 * 
	 * @param other the `Student` object to be compared to
	 * @return a negative integer if this student comes before the other student,
	 *         a positive integer if this student comes after the other student,
	 *         and 0 if the students are equal.
	 */
	@Override
	public int compareTo(Student other) {
		
	    int lastNameComparison = this.last.compareTo(other.last);
	    if (lastNameComparison != 0) {
	        return lastNameComparison;
	    }  
	    
	    int firstNameComparison = this.first.compareTo(other.first);
	    if (firstNameComparison != 0) {
	        return firstNameComparison;
	    }

	    return Integer.compare(this.id, other.id);
	}
	
}
