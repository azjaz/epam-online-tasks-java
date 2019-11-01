package tasksJava.fundamentals;

/*
 * task Java Fundamental Optional Task 1
 * # 1, 4, 5, 2
 * args == 4 53 2345 678 1234567
 */
public class OptionalTask1 {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Input arguments of int");
			return;
		}
		String min = args[0];
		String max = args[0];
		String temp = "";
		shortestAndLongestNumb(args, min, max);
		smallestNumbLiteral(args);
		EvenAndOdd(args);
		sortingNumbers(args, temp);
		

	}
	
	public static void shortestAndLongestNumb(String[] args, String min, String max) {
		for(int i = 0; i < args.length; i++) {
			if(args[i].length() < min.length())
				min = args[i];
			if(args[i].length() > max.length())
				max = args[i];
		}
		System.out.println("Max length " + Integer.valueOf(max) + " has length " + max.length());
		System.out.println("Min length " + Integer.valueOf(min) + " has length " + min.length());
	}
	
	public static void sortingNumbers(String[] args, String temp) {
		for(int i = 0; i < args.length; i++) {
			for(int j = i; j < args.length; j++ ) {
				if(args[i].length() > args[j].length()) {
					temp = args[i];
					args[i] = args[j];
					args[j] = temp;
				}
			}
		}
		for(int i = 0; i < args.length; i++) {
			System.out.print(Integer.valueOf(args[i]) + " ");
		}
		System.out.println();
	}
	
	public static void smallestNumbLiteral(String[] args) {
		int count = -1;
		int resCount;
		int min = args[0].length();
		int number = Integer.parseInt(args[0]);
		for(int k = 0; k < args.length; k++) {
			resCount = args[k].length();
		for(int i = 0; i < args[k].length(); i++) {
			for(int j = i; j < args[k].length(); j++) {
				if(args[k].charAt(i) == args[k].charAt(j)) {
					count++;
				}
				
					
			}
			if(count > 0) {
				resCount -= 1;
			}
			count = -1;
		}
		if(min > resCount) {
			min = resCount;
			number = Integer.parseInt(args[k]);
		}
	}
		System.out.println("The smallest number of literals contains " + number + " which has " + min + " numbers.");
	}
	
	public static void EvenAndOdd(String[] args) {
		int odds = 0;
		int evens = 0;
		int evenCount = 0;
		int equalCount = 0;
		for(int k = 0; k < args.length; k++) {
			
		for(int i = 0; i < args[k].length(); i++) {
			
				if((Integer.valueOf(args[k].charAt(i)))%2 == 0) {
					evens++;
				} 
				if((Integer.valueOf(args[k].charAt(i)))%2 != 0) {
					odds++;
				}
				
			}
		
		if(odds == 0) {
			evenCount++;
		}
		if(odds == evens) {
			equalCount++;
		}
		odds = 0;
		evens = 0;
	}
		System.out.println("Numbers with only evens - " + evenCount + " Numbers with even = odds - " + equalCount);
	}

}
