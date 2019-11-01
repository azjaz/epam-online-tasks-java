package tasksJava.classes;

public class Group extends YearOfStudy {
	
	private String group;
	
	public Group() {
		
	}

	public Group(String faculty, int year, String group) {
		super(faculty, year);
		this.group = group;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	


}
