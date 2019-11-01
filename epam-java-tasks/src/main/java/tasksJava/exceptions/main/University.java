package tasksJava.exceptions.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;


import tasksJava.exceptions.exceptions.MarkOutOfBoundsException;
import tasksJava.exceptions.exceptions.StudentIsAbsentException;
import tasksJava.exceptions.exceptions.SubjectIsAbsentException;
import tasksJava.exceptions.subjects.Subjects;
import tasksJava.exceptions.university.Student;

public class University {
	
	private List<Student> students;
	
	public University(List<Student> students) {
		super();
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	
	public double getAverageMarkOfRandomStudent() throws MarkOutOfBoundsException, SubjectIsAbsentException {
		List<Student> students = getStudents();
		Random rand = new Random();
		int index = rand.nextInt(students.size() - 1);
		int sumOfMarks = 0;
		Student student = students.get(index);
		Map<Subjects, Integer> studRecord = student.getRecord();
		if(studRecord.isEmpty()) {
			throw new SubjectIsAbsentException("This student has not any subjects");
		}
		Collection<Integer> marks = studRecord.values();
		for(Integer mark : marks) {
			if(mark < 0 || mark > 10) {
				throw new MarkOutOfBoundsException("Mark " + mark + " is not appliable in University");
			}
			sumOfMarks += mark;
		}
		return sumOfMarks/marks.size();
	}
	
	public double getAverageMarkOnSubjectForFacultyGroup(Subjects subject) throws StudentIsAbsentException {
		List<Student> students = getStudents();
		String faculty = "Tech";
		int group = 101;
		List<Student> studentsGroup = new ArrayList<>();
		for(Student student : students) {
			if(student.getFacultyName().equals(faculty) && student.getGroupNumber() == 101) {
				studentsGroup.add(student);
			}
		}
		if(studentsGroup.size() == 0) {
			throw new StudentIsAbsentException("There is no students in group " + group);
		}
		int sumOfMarks = 0;
		int counterOfRecords = 0;
		for(Student student : studentsGroup)  {
			if(student.getRecord().containsKey(subject)) {
				sumOfMarks += student.getRecord().get(subject);
				counterOfRecords++;
			}
		}
		return sumOfMarks/counterOfRecords;
	}
	
	public double getAverageMarkOnSubjectForUniver(Subjects subject) {
		List<Student> students = getStudents();
		int sumOfMarks = 0;
		int counterOfRecords = 0;
		for(Student student : students)  {
			if(student.getRecord().containsKey(subject)) {
				sumOfMarks += student.getRecord().get(subject);
				counterOfRecords++;
			}
		}
		return sumOfMarks/counterOfRecords;
	}

}
