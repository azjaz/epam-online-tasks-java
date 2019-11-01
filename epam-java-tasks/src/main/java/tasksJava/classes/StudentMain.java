package tasksJava.classes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Comparator;
public class StudentMain {

	public static void main(String[] args) {
		Student[] students = new Student[3];
		int counter = 0;
		int incrementId = 0;
		fillArrayWithData(students, counter, incrementId);
		System.out.println("-----------------------------------");
		printStudOfFaculty(students, "faculty1");
		printYoungerThan(students, 1999);
		printGroupList(students, "f1y2");
		printStudOfFacultyAndGroup(students);

	}
	public static void fillArrayWithData(Student[] students, int counter, int incrementId) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			do  {
				System.out.println("Input  1 to start typing students information or 0 for exit");
				int choise = Integer.parseInt(br.readLine());
				if(choise != 1) {break;}
				Student student = new Student();
				student.setId(++incrementId);
				System.out.print("Input students name "); student.setFirstName(br.readLine());
				
					System.out.print("Input students surname "); student.setLastName(br.readLine());
						System.out.print("Input students fathers name "); student.setFathName(br.readLine());
							System.out.print("Input students birth Date as YYYY-MM-DD "); 
							try {
							student.setBirthDate(LocalDate.parse(br.readLine()));
							} catch(DateTimeParseException e) {e.printStackTrace();}
								System.out.print("Input students address "); student.setAddress(br.readLine());
								 System.out.print("Input students phone "); student.setPhone(br.readLine());
								  System.out.print("Input students faculty "); student.setFaculty(br.readLine());
								   System.out.print("Input students year of study "); student.setYear(Integer.parseInt(br.readLine()));
								    System.out.print("Input students group "); student.setGroup(br.readLine());
								    System.out.println();
							students[counter] = student;
							System.out.println(students[counter].toString());
							
				counter++;
			} while(counter < students.length);
			}catch(IOException e) {e.printStackTrace();}
	}
	
	public static void printStudOfFaculty(Student[] students, String faculty) {
		for(int i = 0; i < students.length; i++) {
		if(students[i].getFaculty().equals(faculty)) {
			System.out.println(students[i].toString());
		}
		}
		System.out.println("END of list");
	}
	
	public static void printStudOfFacultyAndGroup(Student[] students) {
		Arrays.sort(students, new Comparator<Student>(){
			@Override
			public int compare(Student ob1, Student ob2) {
				return ob1.getFaculty().compareTo(ob2.getFaculty());
			}
		});
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
		}
	}
	
	public static void printYoungerThan(Student[] students, int year) {
		for(int i = 0; i < students.length; i++) {
			if(students[i].getBirthDate().getYear() >= year) {
				System.out.println(students[i].toString());
			} 
		}
		System.out.println("END of list");
	}
	public static void printGroupList(Student[] students, String group) {
		for(int i = 0; i < students.length; i++) {
			if(students[i].getGroup().equals(group)) {
				System.out.println(students[i].toString());
			} 
		}
		System.out.println("END of list");
	}

}
