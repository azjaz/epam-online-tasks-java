package tasksJava.classes;

public class YearOfStudy extends Faculty {
	private int year;
	
	public YearOfStudy() {
		
	}

	public YearOfStudy(String faculty, int year) {
		super(faculty);
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}
