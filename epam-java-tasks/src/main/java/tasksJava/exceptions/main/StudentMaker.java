package tasksJava.exceptions.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;


import tasksJava.exceptions.subjects.Subjects;
import tasksJava.exceptions.university.Student;

public class StudentMaker {
	
	public static List<Student> createListOfStudents() {
		String config = "..\\epam-java-tasks\\src\\main\\resources\\configException.properties";
		int idCount = 0;
		Random rand = new Random();
		List<Student> initList = new ArrayList<>();
		Properties properties = new Properties();
		Map<Subjects, Integer> techFaculty = new HashMap<>();
			techFaculty.put(Subjects.MATH, rand.nextInt(10));
			techFaculty.put(Subjects.ENGLISH, rand.nextInt(10));
			techFaculty.put(Subjects.PHYSICS, rand.nextInt(10));
		Map<Subjects, Integer> humFaculty = new HashMap<>();
			humFaculty.put(Subjects.ENGLISH, rand.nextInt(10));
			humFaculty.put(Subjects.HISTORY, rand.nextInt(10));
		try (FileInputStream inputStream = new FileInputStream(config)) {
			if(inputStream != null) {
				properties.load(inputStream);
			 
			initList.add(new Student(properties.getProperty("facultyName0"), 
					Integer.valueOf(properties.getProperty("groupNumber0")),
					++idCount,
					properties.getProperty("lastName0"),
					techFaculty));
			initList.add(new Student(properties.getProperty("facultyName1"), 
					Integer.valueOf(properties.getProperty("groupNumber1")),
					++idCount,
					properties.getProperty("lastName1"),
					techFaculty));
			initList.add(new Student(properties.getProperty("facultyName2"), 
					Integer.valueOf(properties.getProperty("groupNumber2")),
					++idCount,
					properties.getProperty("lastName2"),
					techFaculty));
			initList.add(new Student(properties.getProperty("facultyName3"), 
					Integer.valueOf(properties.getProperty("groupNumber3")),
					++idCount,
					properties.getProperty("lastName3"),
					humFaculty));
			initList.add(new Student(properties.getProperty("facultyName4"), 
					Integer.valueOf(properties.getProperty("groupNumber4")),
					++idCount,
					properties.getProperty("lastName4"),
					humFaculty));
			initList.add(new Student(properties.getProperty("facultyName5"), 
					Integer.valueOf(properties.getProperty("groupNumber5")),
					++idCount,
					properties.getProperty("lastName5"),
					humFaculty));
		}
		} catch(IOException e) {e.printStackTrace();
		}
		
		return initList;
	}
	}


