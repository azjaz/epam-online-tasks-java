package tasksJava.exceptions.main;

import java.util.List;

import tasksJava.exceptions.exceptions.MarkOutOfBoundsException;
import tasksJava.exceptions.exceptions.StudentIsAbsentException;
import tasksJava.exceptions.exceptions.SubjectIsAbsentException;
import tasksJava.exceptions.subjects.Subjects;
import tasksJava.exceptions.university.Student;

public class Launcher {
	public static List<Student> students = StudentMaker.createListOfStudents();

	public static void main(String[] args) {
		University university = new University(students);
		Subjects subject = Subjects.valueOf("ENGLISH");
		try {
		System.out.println("The average mark of random student is "
							+ university.getAverageMarkOfRandomStudent());
		System.out.println("The average mark on subject for define faculty is "
							+ university.getAverageMarkOnSubjectForFacultyGroup(subject));
		System.out.println("The average mark on subject for university is "
							+ university.getAverageMarkOnSubjectForUniver(subject));
		} catch(MarkOutOfBoundsException | SubjectIsAbsentException | StudentIsAbsentException ex) {
			System.err.println(ex);
		}

	}

}
