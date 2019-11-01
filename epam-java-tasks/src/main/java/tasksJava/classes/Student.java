package tasksJava.classes;

import java.time.LocalDate;

public class Student extends Group {
	
	private int id;
	private String firstName;
	private String lastName;
	private String fathName;
	private LocalDate birthDate;
	private String address;
	private String phone;
	
	public Student() {
		
	}
	
	public Student(String faculty, int year, String group, int id, String firstName, String lastName,
			String fathName, LocalDate birthDate, String address, String phone) {
		super(faculty, year, group);
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fathName = fathName;
		this.birthDate = birthDate;
		this.address = address;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFathName() {
		return fathName;
	}
	public void setFathName(String fathName) {
		this.fathName = fathName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return id + " " + firstName + " " + fathName + " " + lastName + " " + birthDate + " " +
							" " + address + " " + phone + " " + getFaculty() + " " + getGroup() + " " + getYear();
	}

}
