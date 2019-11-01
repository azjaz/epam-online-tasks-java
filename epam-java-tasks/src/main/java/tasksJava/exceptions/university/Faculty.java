package tasksJava.exceptions.university;

import java.util.Objects;

public class Faculty {
	
	private String facultyName;


	public Faculty(String facultyName) {
		super();
		this.facultyName = facultyName;
	}

	public String getFacultyName() {
		return facultyName;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(facultyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Faculty)) return false;
		Faculty faculty = (Faculty) obj;
		return facultyName.equals(faculty.facultyName);
	}

	@Override
	public String toString() {
		return " [facultyName=" + facultyName + "]";
	}

	
}
