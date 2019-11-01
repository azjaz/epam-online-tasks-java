package tasksJava.exceptions.university;

import java.util.Objects;

public class Group extends Faculty {
	
	private int groupNumber;

	public Group(String facultyName, int groupNumber) {
		super(facultyName);
		this.groupNumber = groupNumber;
	}

	public int getGroupNumber() {
		return groupNumber;
	}


	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode() + groupNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof Group)) return false;
		Group group = (Group) obj;
		return (groupNumber == group.groupNumber);
			
	}

	@Override
	public String toString() {
		return super.toString().replace("]", ", groupNumber" + groupNumber + "]");
	}
	
	

}
