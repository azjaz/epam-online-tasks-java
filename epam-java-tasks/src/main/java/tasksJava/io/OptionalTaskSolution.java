package tasksJava.io;

// Optional tasks ## 2, 3, 4, 10

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OptionalTaskSolution {

	public static void main(String[] args) {
		String filePath = "..\\epam-java-tasks\\src\\main\\java\\tasksJava";
		try {
		File inputFile = new File(filePath + "\\collections\\optionalTask\\AdditionalTaskSolutions.java");
		Scanner wordReader = new Scanner(inputFile);
		
		changePublicToPrivate(wordReader, filePath);
		reverseStingsInFile(inputFile, filePath);
		changeLowerCaseToUpper(wordReader, filePath);
		changeFirstAndLastWord(inputFile, filePath);
		} catch(IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void changePublicToPrivate(Scanner wordReader, String filePath) throws IOException {
		String wordToChange = "";
		File outputFile = new File(filePath + "\\io\\changePublicToPrivate\\outputFile.java");
		outputFile.getParentFile().mkdir();
		outputFile.createNewFile();
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
		while(wordReader.hasNext()) {
			wordToChange = wordReader.next();
			
			if(!wordToChange.equals("public")) {
				writer.write(wordToChange);
				writer.write(' ');
			} else {
				writer.write("private");
				writer.write(' ');
			}
		}
		writer.close();
	}
	
	public static void reverseStingsInFile(File inputFile, String filePath) throws IOException {
		String lineToRead = "";
		File outputFile = new File(filePath +"\\io\\reverseStingsInFile\\outputFile.java");
		outputFile.getParentFile().mkdir();
		outputFile.createNewFile();
		List<String> reversedLine = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
		while(reader.ready()) {
			lineToRead = reader.readLine();
			reversedLine = Arrays.asList(lineToRead.split(" "));
			Collections.reverse(reversedLine);
			for(String singleWord : reversedLine) {
				writer.write(singleWord);
				writer.write(' ');
			}
			writer.println();
		}
		reader.close();
		writer.close();
	}
	
	public static void changeLowerCaseToUpper(Scanner wordReader, String filePath) throws IOException {
		String wordForChange = "";
		File outputFile = new File(filePath +"\\io\\changeLowerCaseToUpper\\outputFile.java");
		outputFile.getParentFile().mkdir();
		outputFile.createNewFile();
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
		while(wordReader.hasNext()) {
			wordForChange = wordReader.next();
			
			if(wordForChange.length() > 2) {
				writer.write(wordForChange.toUpperCase());
				writer.write(' ');
			} else {
				writer.write(wordForChange);
				writer.write(' ');
			}
		}
		writer.close();
	}
	
	public static void changeFirstAndLastWord(File inputFile, String filePath) throws IOException {
		String lineForReading = "";
		String temp;
		String[] splitedWord;
		File outputFile = new File(filePath +"\\io\\changeFirstAndLastWord\\outputFile.java");
		outputFile.getParentFile().mkdir();
		outputFile.createNewFile();
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
		while(reader.ready()) {
			lineForReading = reader.readLine();
			splitedWord = lineForReading.split(" ");
			temp = splitedWord[0];
			splitedWord[0] = splitedWord[splitedWord.length - 1];
			splitedWord[splitedWord.length - 1] = temp;
			writer.write(Arrays.stream(splitedWord).collect(Collectors.joining(" ")));
			writer.println();
		}
		reader.close();
		writer.close();
	}

}
