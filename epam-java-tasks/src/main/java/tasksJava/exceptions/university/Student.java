package tasksJava.exceptions.university;


import java.util.Map;
import java.util.Objects;

import tasksJava.exceptions.subjects.Subjects;

public class Student extends Group {
	
	private int id;
	private String lastName;
	private Map<Subjects, Integer> record;
	
	public Student(String facultyName, int groupNumber, int id, String lastName, Map<Subjects, Integer> record) {
		super(facultyName, groupNumber);
		this.id = id;
		this.lastName = lastName;
		this.record = record;
	}
	public int getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public Map<Subjects, Integer> getRecord() {
		return record;
	}
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode() + id + lastName + record);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof Student)) return false;
		Student student = (Student) obj;
		return id == student.id && lastName.equals(student.lastName) && record.equals(student.record);
	}
	@Override
	public String toString() {
		return super.toString().replace("]", ", id=" + id + ", lastName=" + lastName + ", record=" + record + "]");
	}
	
	

}
